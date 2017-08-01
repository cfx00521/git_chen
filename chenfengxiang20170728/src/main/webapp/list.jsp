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

<title>My JSP 'list.jsp' starting page</title>
<link rel="stylesheet" type="text/css"
	href="static\bootstrap-3.3.7-dist\css\bootstrap.min.css">
<script type="text/javascript" src="static\jquery-1.7.2.js"></script>
<script type="text/javascript"
	src="static\bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#sel").change(function(){
				
				var a = $("select :selected").val();	
				alert(a);	
				window.location.href="emp/getall?id="+a;	
			});
		});
		
	</script>
</head>

<body>
	<div class="container">
		<h1>${msg }</h1>
		<div>
		<select id="sel">
			<option value="0">---请选择---</option>
			<option value="2">运营</option>
			<option value="1">财务</option>
		</select> 
		选择部门  查询   工资大于3800的员工
		</div>
		<table class="table">
			<tr>
				<td>姓名</td>
				<td>密码</td>
				<td>入职时间</td>
				<td>离职时间</td>
				<td>工资</td>
			</tr>
			<c:forEach items="${list }" var="em">
				<tr>
					<td>${em.ename }</td>
					<td>${em.password }</td>
					<td>${em.starttime }</td>
					<td>${em.endtime }</td>
					<td>${em.salary }</td>
					<td>${em.dept.dname }</td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>
