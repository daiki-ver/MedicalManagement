<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

  </head>
  
  <body style="background-color: #D9EDF7;">
		<div  style="width: 990px; margin: auto;">
			<h1 style="margin: auto; text-align: center;font-size: 50px; font-weight: 900;">创建您的账户注册</h1>
			<div style="margin: auto; width: 990px; padding-left: 100px; padding-right: 100px;">
	     		<!--注册表-->
				<form action="">
					<!--邮箱-->
					<div class="form-group">
						<label for="exampleInputEmail1" style="font-size: 20px; font-weight: 600;">Email address</label>
						<input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="email">
						<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
					</div>
					<!--第一次输入密码-->
					<div class="form-group">
						<label for="exampleInputPassword1" style="font-size: 20px; font-weight: 600;">Password</label>
						<input type="text" class="form-control" id="exampleInputPassword1" placeholder="password">
					</div>
					<!--再次输入密码-->
					<div class="form-group">
						<label for="exampleInputPassword1" style="font-size: 20px; font-weight: 600;">Again Password</label>
						<input type="text" class="form-control" id="exampleInputPassword1" placeholder="again password">
					</div>
					<!--姓名-->
					<div class="form-group">
						<label for="exampleInputPassword1" style="font-size: 20px; font-weight: 600;">name</label>
						<input type="text" class="form-control" id="exampleInputPassword1" placeholder="name">
					</div>
					<!--性别-->
					<div id="">
						<label for="exampleInputPassword1" style="font-size: 20px; font-weight: 600;">性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
						<!--男-->
						<input type="radio" name="sex" value="male">Male&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<!--女-->
						<input type="radio" name="sex" value="female">Female
					</div>
					<button type="submit" class="btn btn-primary" style="width: 790px;height: 80px;margin-top: 40px;"><font style="font-size: 30px; font-weight: 500;">Submit</font></button>
				</form>
			</div>
		</div>
		

		<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
	</body>
</html>
