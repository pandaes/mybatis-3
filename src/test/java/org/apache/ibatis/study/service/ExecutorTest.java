package org.apache.ibatis.study.service;

import org.apache.ibatis.executor.BatchExecutor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.study.entity.UserInfo;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

/**
 * @author liupiao
 * @date 2022/7/15 15:02
 * @description
 */

public class ExecutorTest {

    @Test
    public void simpleExecutorTest(){

    }

    @Test
    public void batchExecutorTest() throws IOException {

    }

    @Test
    public void reuseExecutorTest(){

    }
}
