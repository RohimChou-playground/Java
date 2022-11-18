package com.rohim.consoleapp;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class App {
    public static void main(String[] args) throws IOException {
        // Read Mybatis config from aaa.xml
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("aaa.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
        // Properties properties = new Properties();
        // properties.load(inputStream);
        // System.out.println(properties);
        
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpModel emp = sqlSession.selectOne("findByCn", "Z00014054");
        System.out.println(emp.getFull_name());
        sqlSession.close();
    }
}
