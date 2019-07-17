package com.chinasoft.dao;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import jdk.nashorn.internal.runtime.regexp.joni.Config;

public class MyTest {
	
	private Logger logger = Logger.getLogger(MyTest.class);

	@Test
	public void test() {
		System.out.println("test");
	}
	
	@Test
	public void mysqlTest(){
		String resource = "mybatis-config.xml";
		SqlSession sqlSession = null;
		int count = 0;
		
		//1.通过流的方式，先加载mybatis-Config.xml配置文件
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			//2.SqlSessionFactory读取配置文件，进行解析
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			//3.通过2，会创建SqlSession，目的是执行SQL语句
			sqlSession = factory.openSession();
			//4.调用mapper文件，来具体执行某一条SQL语句  namespace+id
			count = sqlSession.selectOne("com.chinasoft.dao.User.count");
			
			//System.out.println(count);
			
			logger.debug("统计结果为："+count);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
