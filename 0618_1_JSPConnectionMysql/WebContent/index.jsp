<%@page import="com.mysql.jdbc.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Utils.*,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">连接数据库MySQL</h1>
<table width="500" align="center" border="1" cellpading="0" cellspacing="0">
	<tr align="center">
		<td>编号</td>
		<td>姓名</td>
		<td>年龄</td>
	</tr>

<%
	//得到结果集
	ResultSet rs = ConnectionMySQL.getResult();
	
	String name = null;
	int age = 0;
	int id = 0;
	while(rs.next()){
		id = rs.getInt("id");  //或者rs.getInt(1);
		name = rs.getString("name");
		age = rs.getInt("age");
%>
	<tr align="center">
		<td>
			<%
				out.print(id);
			%>
		</td>
		<td>
			<%
				out.print(name);
			%>
		</td>
		<td>
			<%
				out.print(age);
			%>
		</td>
	</tr>
<% } %>
</table>



<h1 align="center">页面传值</h1>

<div align="center">
	<form action="reginfo.jsp" method="post">
		<table border="1">
			<tr><td>用户名</td><td><input type="text" name="username"></td></tr>
			<tr><td>密码</td><td><input type="text" name="password"></td></tr>
			<tr>
				<td>爱好</td>
				<td>
					<input type="checkbox" name="userck" value="java">JAVA<br/>
					<input type="checkbox" name="userck" value="js">JS<br/>
					<input type="checkbox" name="userck" value="css">CSS<br/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="提交">
					<input type="reset" value="重置">
				</td>			
			</tr>
		</table>
	</form>

</div>

</body>
</html>