<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%-- <h1>Request方式</h1>
<%
	String username = request.getParameter("username");
%>
<h1>
欢迎<%=username %>进入本系统
</h1> --%>

<h1>Session方式</h1>
<%
	String currUser = (String)session.getAttribute("loginUser");
	if(currUser == null){
		response.sendRedirect("login.jsp");
		return;
	}
%>
session欢迎<%=currUser %>
</body>
</html>