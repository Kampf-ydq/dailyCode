<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//乱码处理
	request.setCharacterEncoding("utf-8");
	//内置对象
	String username = request.getParameter("username");
	String pwd = request.getParameter("password");
	
	String[] like = request.getParameterValues("userck");
%>

<%=username %><br>
<%=pwd %><br>
<%
	if(like != null){
		for(String li : like){
			out.print(li+"&nbsp");
		}
	}
%>

</body>
</html>