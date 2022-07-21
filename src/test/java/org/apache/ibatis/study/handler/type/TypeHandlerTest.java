package org.apache.ibatis.study.handler.type;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.study.entity.UserInfo;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author liupiao
 * @date 2022/7/21 8:25
 * @description
 */
@Slf4j
public class TypeHandlerTest {

    @Test
    public void typeHandlerTest() throws IOException {
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

}
