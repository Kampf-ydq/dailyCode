package com.chinasoft.dao.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.chinasoft.pojo.User;
import com.chinasoft.utils.JSONUtil;
import com.chinasoft.utils.MybatisUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		//获取前台id
		int id = Integer.parseInt(request.getParameter("id"));
		
		//System.out.println("id=========>>>"+id);
		
		SqlSession sqlSession = null;
		User user = null;
		//通过getMapper的方式执行sql语句
		try {
			sqlSession = MybatisUtil.createSqlSession();
			user = sqlSession.getMapper(UserMapper.class).selectUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisUtil.closeSqlSession(sqlSession);
		}

		//System.out.println(user.getUserName());

		JSONObject jsonObjOut = new JSONObject();
		jsonObjOut.put("user", user);
		JSONUtil.returnJSON(request, response, jsonObjOut);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jsonObjIn = JSONUtil.getJSON(request, response);

		User user = new User();
		user.setId(jsonObjIn.getInt("id"));
		user.setUserCode(jsonObjIn.getString("userCode"));
		user.setUserName(jsonObjIn.getString("userName"));
		user.setPhone(jsonObjIn.getString("phone"));
		user.setGender(jsonObjIn.getInt("gender"));
		user.setUserRole(jsonObjIn.getInt("userRole"));

		SqlSession sqlSession = null;
		int count = 0;

		try {
			sqlSession = MybatisUtil.createSqlSession();
			//list = sqlSession.getMapper(StudentMapper.class).getStuList();
			count = sqlSession.getMapper(UserMapper.class).modify(user);
			
			//手动提交
			sqlSession.commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			//插入异常，回滚
			sqlSession.rollback();
			
		} finally {
			MybatisUtil.closeSqlSession(sqlSession);
		}
		

		JSONObject jsonObjOut = new JSONObject();
		jsonObjOut.put("isSuccess", count);
		JSONUtil.returnJSON(request, response, jsonObjOut);
	}
	
}
