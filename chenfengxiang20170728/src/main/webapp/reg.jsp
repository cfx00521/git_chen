<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'reg.jsp' starting page</title>
<link rel="stylesheet" type="text/css"
	href="static\bootstrap-3.3.7-dist\css\bootstrap.min.css">
<script type="text/javascript" src="static\jquery-1.7.2.js"></script>
<script type="text/javascript"
	src="static\bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>

</head>

<body>
	<div class="container">
		<h1>登录页面</h1>
		<h4 style="color:red">${msg }</h4>
		<form class="form-horizontal" role="form" action="emp/reg">
			<div class="form-group">
					<label for="firstname" class="col-sm-2 control-label">名字</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" name="ename" id="ename"
							placeholder="请输入名字">
					</div>
				</div>
				<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" name="password"
							id="lastname" placeholder="密码">
					</div>
				</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">登录</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
