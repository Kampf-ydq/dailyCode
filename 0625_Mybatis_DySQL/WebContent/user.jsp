<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.chinasoft.pojo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width,initial-scale=1"></meta>
<title>User List</title>
<!--BOOT核心文件css-->
<link href="static/css/bootstrap.min.css" rel="stylesheet" />

<!--主题文件（可选项）-->
<link href="static/css/bootstrap-theme.min.css" rel="stylesheet" />

<link rel="stylesheet" href="static/css/style.css">
<link rel="stylesheet" href="static/js/jquery-ui/jquery-ui.min.css">

<!--引入jquery开发环境 要在bootstrap.min.js之前引入-->
<script src="static/js/jquery-3.3.1.js"></script>
<script src="static/js/jquery.serializejson.min.js"></script>
<script src="static/js/jquery-ui/jquery-ui.min.js"></script>

<!--引入boot核心js文件-->
<script src="static/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				面板标题 <a href="#" class="panel-title pull-right">更多</a>

			</div>
			<div class="panel-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>id</th>
							<th>userCode</th>
							<th>userName</th>
							<th>phone</th>
							<th>gender</th>
							<th>userRole</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<User> userList = (ArrayList<User>)request.getAttribute("user");
							for(User user : userList){
								/* out.println(user.getId()+"---"); */
						%>
						<tr>
							<td><%=user.getId() %></td>
							<td><%=user.getUserCode() %></td>
							<td><%=user.getUserName() %></td>
							<td><%=user.getPhone() %></td>
							<td><%=user.getGender() %></td>
							<td><%=user.getUserRole() %></td>
							<td><a>[删除]</a></td>
							<td><a onclick="update(this)">[修改]</a></td>
						</tr>
						<%} %>
					</tbody>
				</table>
				<nav>
				<ul class="pager">
					<li><a>上一页</a></li>
					<li><a>1</a></li>
					<li><a>2</a></li>
					<li><a>3</a></li>
					<li><a>4</a></li>
					<li><a>下一页</a></li>
				</ul>
				</nav>
			</div>

		</div>

		<!-- 更新用户模态框 -->
		<div id="update-user-modal" title="更新用户" style="display: none;">
			<form id="update-user-form">
				<table class="modal-tbl">
					<tr style="display: none">
						<td>ID</td>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<td>userCode</td>
						<td><input type="text" name="userCode"></td>
					</tr>
					<tr>
						<td>userName</td>
						<td><input type="text" name="userName"></td>
					</tr>
					<tr>
						<td>phone</td>
						<td><input type="text" name="phone"></td>
					</tr>
					<tr>
						<td>gender</td>
						<td><input type="text" name="gender"></td>
					</tr>
					<tr>
						<td>userRole</td>
						<td><input type="text" name="userRole"></td>
					</tr>
				</table>
			</form>
		</div>


		<!-- 提示信息模态框 -->
		<div id="msg-modal" title="" style="display: none">
			<p></p>
		</div>
	</div>

<script type="text/javascript">

function update(item){
	var tr = item.parentNode.parentNode;
	var id = tr.getElementsByTagName("td")[0].innerHTML;
	//console.log(id);
	/* // 将id封装为JSON格式数据
    var data = {};
    data.id = id;
    var dataStr = JSON.stringify(data); */
	$.ajax({
	      type: "GET",
	      url: "UserServlet?id="+id,
	      success: function(data) {
	        var obj = JSON.parse(data);
	        var user = obj.user;
	        //console.log(obj.user.userName);
	        showUpdateUserModal(user);
	      },
	      error: function() {
	        console.log("ajax error");
	      }
	 });
}

//显示更新用户模态框
function showUpdateUserModal(user) {
  $("#update-user-form")[0].reset();  // 每次载入前先清空表单，防止显示之前的信息
  // 表单赋值
  $("#update-user-form input[name='id']").val(user.id);
  $("#update-user-form input[name='userCode']").val(user.userCode);
  $("#update-user-form input[name='userName']").val(user.userName);
  $("#update-user-form input[name='phone']").val(user.phone);
  $("#update-user-form input[name='gender']").val(user.gender);
  $("#update-user-form input[name='userRole']").val(user.userRole);
  
  $("#update-user-modal").dialog({
    resizable: false,
    modal: true,
    buttons: {
      "提交": function() {
        updateUser();
      },
      "取消": function() {
        $(this).dialog("close");
      },
    },
  });
}

// 更新用户
function updateUser() {
  // 获取序列化表单信息
  var user = $("#update-user-form").serializeJSON();
  var userStr = JSON.stringify(user);
  
  $.ajax({
    type: "POST",
    url: "UserServlet",
    data: userStr,
    contentType: 'application/json;charset=utf-8',
    dataType: "json",
    success: function(data) {
      if (data.isSuccess) {
        $("#update-user-modal").dialog("close");
        showMsg('更新成功！');
        //listAllUser();
      } else {
        $("#update-user-modal").dialog("close");
        showMsg('更新失败！');
        //listAllUser();
      }
    },
    error: function() {
      console.log("ajax error");
    },
  });
}

//显示提示信息
function showMsg(text) {
  $("#msg-modal p").text(''); // 每次载入前先清空显示区域，防止显示之前的信息
  $("#msg-modal p").text(text);
  $("#msg-modal").dialog({
    modal: true,
  });
  // 2s后消失
  setTimeout(function() {
    $("#msg-modal").dialog("close")
  },2000);
}
</script>
</body>
</html>


