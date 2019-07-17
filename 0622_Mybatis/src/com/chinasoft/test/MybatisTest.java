package com.chinasoft.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.chinasoft.dao.StudentMapper;
import com.chinasoft.pojo.Student;
import com.chinasoft.utils.MybatisUtil;

public class MybatisTest {

	private Logger logger = Logger.getLogger(MybatisTest.class);
	
	@Test
	public void testStuList() {
		SqlSession sqlSession = null;
		List<Student> list = new ArrayList<Student>();
		Student stu = new Student();
		stu.setS_class("二");
		//通过getMapper的方式执行sql语句
		try {
			sqlSession = MybatisUtil.createSqlSession();
			//list = sqlSession.getMapper(StudentMapper.class).getStuList();
			list = sqlSession.getMapper(StudentMapper.class).getStuByClass(stu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MybatisUtil.closeSqlSession(sqlSession);
		}
		
		for (Student student : list) {
			logger.debug(student.getS_name()+"---"+student.getS_class());
		}
	}
	
	//两表联查
	@Test
	public void testStuListTwoTab() {
		SqlSession sqlSession = null;
		List<Student> list = new ArrayList<Student>();
		Student stu = new Student();
		stu.setS_name("赵柳");
		//通过getMapper的方式执行sql语句
		try {
			sqlSession = MybatisUtil.createSqlSession();
			//list = sqlSession.getMapper(StudentMapper.class).getStuList();
			list = sqlSession.getMapper(StudentMapper.class).getStuByTwoTable(stu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MybatisUtil.closeSqlSession(sqlSession);
		}
		
		for (Student student : list) {
			logger.debug(student.getS_name()+"---"+student.getRole().getR_name()+"---"+student.getRole().getR_score());
		}
	}

}
