package test;

import static org.junit.Assert.*;


import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.chinasoft.dao.user.UserMapper;
import com.chinasoft.pojo.User;
import com.chinasoft.utils.MybatisUtil;


public class Test {

	private static final Logger logger = Logger.getLogger(Test.class);
	
	@org.junit.Test
	public void testSelectUserById() {
		SqlSession sqlSession = null;
		User user = null;
		//通过getMapper的方式执行sql语句
		try {
			sqlSession = MybatisUtil.createSqlSession();
			//list = sqlSession.getMapper(StudentMapper.class).getStuList();
			user = sqlSession.getMapper(UserMapper.class).selectUserById(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MybatisUtil.closeSqlSession(sqlSession);
		}
		logger.info("【姓名】"+user.getUserName());
	}
	
	@org.junit.Test
	public void testModify() {
		SqlSession sqlSession = null;
		int count = 0;
		User user = new User();
		user.setId(6);
		user.setUserCode("MrHua");
		//通过getMapper的方式执行sql语句
		try {
			sqlSession = MybatisUtil.createSqlSession();
			//list = sqlSession.getMapper(StudentMapper.class).getStuList();
			count = sqlSession.getMapper(UserMapper.class).modify(user);
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			MybatisUtil.closeSqlSession(sqlSession);
		}
		logger.info("【Modify is OK】"+count);
	}

}
