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
		
		//1.ͨ�����ķ�ʽ���ȼ���mybatis-Config.xml�����ļ�
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			//2.SqlSessionFactory��ȡ�����ļ������н���
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			//3.ͨ��2���ᴴ��SqlSession��Ŀ����ִ��SQL���
			sqlSession = factory.openSession();
			//4.����mapper�ļ���������ִ��ĳһ��SQL���  namespace+id
			count = sqlSession.selectOne("com.chinasoft.dao.User.count");
			
			//System.out.println(count);
			
			logger.debug("ͳ�ƽ��Ϊ��"+count);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
