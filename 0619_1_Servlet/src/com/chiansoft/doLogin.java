package com.chiansoft;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chiansoft.utils.ConnectionMySQL;

public class doLogin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//设定字符集
		req.setCharacterEncoding("utf-8");
		
		//获取前台数据
		String username = req.getParameter("username");
		String pwd = req.getParameter("password");
		
		//查询数据库
		ResultSet rs = ConnectionMySQL.getResult(username);
		
		String dbUser = null;
		String dbPwd = null;
		
		try {
			while(rs.next()){
				dbUser = rs.getString("username");
				dbPwd = rs.getString("password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("name:=====>>>"+dbUser+","+dbPwd);
		
		if (username.equals(dbUser) && pwd.equals(dbPwd)) {
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", dbUser);
			req.getRequestDispatcher("main.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("error.jsp");
			System.out.println("登录失败");
		}
		
	}
}
