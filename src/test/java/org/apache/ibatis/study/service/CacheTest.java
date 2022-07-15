package org.apache.ibatis.study.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.study.entity.UserInfo;
import org.apache.ibatis.study.mapper.UserInfoMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author liupiao
 * @date 2022/7/12 17:43
 * @description
 */
@Slf4j
public class CacheTest {

    @Test
    public void testFirstCache() throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserInfo userInfo = sqlSession.selectOne("org.apache.ibatis.study.mapper.UserInfoMapper.selectUser", 1);
        log.info(userInfo.toString());
        UserInfo userInfo2 = sqlSession.selectOne("org.apache.ibatis.study.mapper.UserInfoMapper.selectUser", 1);
        log.info(userInfo2.toString());
        log.info("{}", userInfo == userInfo2);
    }

    @Test
    public void testSecondCache() throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // >>org.apache.ibatis.session.SqlSessionFactoryBuilder#build()

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // >>org.apache.ibatis.session.defaults.DefaultSqlSessionFactory#openSession()

        UserInfo userInfo = sqlSession.selectOne("org.apache.ibatis.study.mapper.UserInfoMapper.selectUser", 1);
        // >>org.apache.ibatis.session.defaults.DefaultSqlSession#selectOne()

        log.info(userInfo.toString());
        sqlSession.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserInfo userInfo2 = sqlSession2.selectOne("org.apache.ibatis.study.mapper.UserInfoMapper.selectUser", 1);
        log.info("{}", userInfo2);
        sqlSession2.close();

        log.info("{}", userInfo == userInfo2);
    }
}
