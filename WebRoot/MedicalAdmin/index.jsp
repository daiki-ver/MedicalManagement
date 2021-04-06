<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

	<!-- JS, Popper.js, and jQuery -->
	<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </head>
  	<script type="text/javascript">
  		$(document).ready(
			$(function() {
			$("html").scrollTop(1000)
			})
		);
  	</script>
	<body style="background-color: #fafbfe;height: 100%;">
		<!--不允许用户直接访问-->
		<c:if test="${sessionScope.userbean==null}">
 			<jsp:forward page="/login.jsp"/>
 		</c:if>
 		
		<style type="text/css">
			.photo_daiki {
				width: 40px;
				height: 40px;
				border-radius: 50%;
				overflow: hidden;
				float: left;
				margin-right: 10px;
			}
			
			.login_user {
				float: left;
				display: inline-block;
			}
			
			.work_space {
				width: 92%;
				margin-left: 4%;
				margin-top: 20px;
			}
			
			.user_table tr {
				height: 40px;
			}
			
			.aside a:hover{
				background-color:#b6d4f3;
				color:white;
			}
			
		</style>

		<div id="" style="width: 90%; margin-left: 10%; height: 100%; overflow-x: hidden">
			<div class="row" style="height: 100%;">
				<!--左侧导航-->
				<div class="" style=" width: 16%;height: 100%; margin-right: 0px;background-color: #e3f2fd; position: fixed; box-shadow:0px 0px 5px -1px #888888;">
					<div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
						<!--logo-->
						<div id="" style="width: 100%;padding-top: 20px;padding-left: 20px;padding-bottom: 20px;">
							<img src="img/logo.png" width="20%" />
							<font style="font-size: 20px;display: inline-block; margin-left: 20px;padding-top: 10px;">
								<a style="color: orange;">新芽</a>病例管理</font>
						</div>
						<!--导航文字-->
						<div class="aside">
							<a class="nav-link" href="TabChangeServlet?show=systemManager&currentPage=1">用户管理</a>
							<a class="nav-link" href="TabChangeServlet?show=patientManager&currentPage=1">患者管理</a>
							<a class="nav-link active" href="TabChangeServlet?show=medicalManager&currentPage=1">病历管理</a>
							<a class="nav-link" href="TabChangeServlet?show=doctorManager&currentPage=1">医护管理</a>
						</div>
					</div>
				</div>
				<!-- 头部导航 -->
				<div style="width: 64%;margin-left: 16%;position:fixed;z-index: 30; box-shadow: 0 5px 5px -5px #888888;">
					<nav class="navbar navbar-light" style="background-color: #e3f2fd;padding: 20px 20px 20px 20px;">
					<!--搜索框-->
					<form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
					</form>
						<!--用户状态显示-->
						<div class="btn-group" style="position: absolute; height: 100%;width: 200px; right: 20px;">
							<!--<button class="btn btn-secondary btn-lg dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">-->
							<button class="btn " style="background-color: #fafbfd; " type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							   <div class="photo_daiki">
							   		<img src="img/QQ图片20200701172050.jpg" width="40px" height="40px"/>
							   </div>
							   <div class="login_user">
							   		<font style="font-size: 20px; font-weight: 500; color: lightslategray;">${userbean.name}</font><br />
							   		<small style="color: lightslategray;">登录人</small>
							   </div>
							</button>
							<div class="dropdown-menu">
							   <a class="dropdown-item" href="EditServlet_User?email_edit=${userbean.email}">个人资料</a>
							   <a class="dropdown-item" href="LoginOutServlet">退出登录</a>
							   <div class="dropdown-divider"></div>
							   <a class="dropdown-item" href="#">欢迎使用新芽病历管理系统</a>
							</div>
						</div>
					</nav>
				</div>
				
				<!--展示部分-->
				<div class="" style="width: 68%;height: 100%; position: absolute;margin-top: 80px; margin-left: 15%;">
					<div class="tab-content" id="v-pills-tabContent">
					<!-- 用户户管理 -->
						<div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
							<jsp:include page="Medical.jsp" flush="true"></jsp:include>
							<%-- <c:import url="UserAdminServlet"></c:import> --%>
						</div>
						<div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab"></div>
						<div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab">...</div>
						<div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-settings-tab">...</div>
					</div>
				</div>
			</div>
		</div>

	</body>
</html>
