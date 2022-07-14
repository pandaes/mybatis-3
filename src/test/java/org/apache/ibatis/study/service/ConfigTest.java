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
 * @date 2022/7/12 16:31
 * @description
 */
@Slf4j
public class ConfigTest {

    @Test
    public void testXml() throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserInfo userInfo = sqlSession.selectOne("org.apache.ibatis.study.mapper.UserInfoMapper.selectUser", 1);
        log.info(userInfo.toString());
    }

    @Test
    public void testAnnotation() throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserInfoMapper userMapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfo userInfo = userMapper.selectUser1(1);
        log.info(userInfo.toString());
    }

}
