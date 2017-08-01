<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>My JSP 'index.jsp' starting page</title>

<link rel="stylesheet" type="text/css"
	href="static\bootstrap-3.3.7-dist\css\bootstrap.min.css">
<script type="text/javascript" src="static\jquery-1.7.2.js"></script>
<script type="text/javascript"
	src="static\bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#ename").blur(
				function() {
					$.get("emp/isExits", {
						name : $("#ename").val()
					}, function(data) {
						if (data == 1) {
							data = "财务部";
						}
						if (data == 2) {
							data = "运营部";
						}

						$("span").empty();
						if (data != 'ok') {
							$("#ename").after(
									$("<span style='color:red'>用户名已存在 (" + data
											+ ")</span>"));
						} else {
							$("#ename").after($("<span> ✔ </span>"));
						}
					});
				});

	});
</script>

</head>

<body>
	<div class="container">
		<div>
			<h1>注册页面</h1>
		</div>
		<div>
			<form class="form-horizontal" action="emp/add" method="post">
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
					<label for="lastname" class="col-sm-2 control-label">入职时间</label>
					<div class="col-sm-5">
						<input type="date" class="form-control" name="sta"
							placeholder="请输入入职时间">
					</div>
				</div>
				<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label">离职时间</label>
					<div class="col-sm-5">
						<input type="date" class="form-control" name="end"
							placeholder="请输入离职时间">
					</div>
				</div>
				<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label">工资</label>
					<div class="col-sm-5">
						<input type="number" class="form-control" name="salary"
							placeholder="请输入工资">
					</div>
				</div>
				<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label">部门</label>
					<div class="col-sm-5">
						<select name="d_id">
							<c:forEach items="${list }" var="de">
								<option value="${de.did }">${de.dname }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">登录</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
