<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  </head>
  
  <body>
		<div style="width:550px;margin: auto;">
			<div style="width: 100px;height: 100px;margin: auto;margin-top:60px;">
				<img src="img/logo.png"  width="100px"/>
			</div>
			<div style="width: 400px; height: 50px; margin: auto;">
				<label style="text-align: center;display: block;font-size: 40px;font-weight: 500;">登录到新芽</label>
			</div>
		</div>
		<div style="width: 550px;height: 400px;margin: auto; background-color:#D0E9C6;margin-top: 10px;border-radius:25px;">
			<div style="width: 550px;height: 80px;background-color: #41cac0;margin: auto;margin-bottom: 40px;border:2px solid #C4E3F3;border-top-left-radius:25px;border-top-right-radius: 25px;">
				<font style="display: block;text-align: left;color: white;font-size: 40px;font-weight: 400; margin-top: 10px;">&nbsp;&nbsp;&nbsp;请输入登录信息</font>
			</div>
			<div style="width: 400px;height: 300px;margin: auto;">
				<form action="loginServlet" method="post">
					<div class="form-group">
						<label for="exampleInputEmail1">Email address</label>
						<input type="email" name="email" class="form-control" id="exampleInputEmail1" placeholder="Email" value="${user.email}">
						<span style="color: red">${userNull}</span>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label>
						<input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
						<span style="color: red">${passwordWrong}</span>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="checkbox">
								<label>
				          <input type="checkbox"> Remember me
				        </label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default" style="background-color: #5BC0DE;display: block;width: 200px;margin-top: 20px;margin-left: 0px">Sign in</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
