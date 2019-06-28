<%@page import="com.mysql.jdbc.ResultSet,Utils.*,java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<%
	request.setCharacterEncoding("utf-8");
	String username = request.getParameter("username");
	String pwd = request.getParameter("password");
	
	if(username == null){
		response.sendRedirect("login.jsp");
		return;
	}
	
	//连接数据库获取用户名和密码
	ResultSet rs = ConnectionMySQL.getResult(username);
	String dbUser = null;
	String dbPwd = null;
	
	//是否存在该用户
	if(rs == null){
		response.sendRedirect("error.jsp");
		return;
	}
	
	while(rs.next()){
		dbUser = rs.getString("username");
		dbPwd = rs.getString("password");
	}
	
	
	if(dbUser.equals(username) && dbPwd.equals(pwd)){
		
		//创建Session,保存用户信息
		session.setAttribute("loginUser", username);
		
		//设置失效时间
		session.setMaxInactiveInterval(20);
		
		request.getRequestDispatcher("main.jsp").forward(request, response);  //容器内跳转
	}else{
		
		//重定向：数据带不过去，相当于重新输入一个url地址
		response.sendRedirect("error.jsp");  //容器外跳转
	}

%>

</body>
</html>