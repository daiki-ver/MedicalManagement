<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--请输入查询信息-->
<nav style="">
	<a style="display: inline-block;font-size: 25px;font-weight: 700;color: dodgerblue;z-index: 10;">
		请输入查询信息：
	</a>
</nav>

<!--功能框-->
<div style="z-index: 20; margin-bottom: 30px; padding-right: 20px;">
	<form  action="UserSearchServlet" method="post" class="needs-validation" novalidate>
		<div class="form-row">
			<div class="col-md-6 mb-3">
				<label for="validationCustom01">Email</label>
				<input type="text" class="form-control" id="validationCustom01" name="email_search">
			</div>
			<div class="col-md-6 mb-3">
				<label for="validationCustom02">Name</label>
				<input type="text" class="form-control" id="validationCustom02" name="name_search">
			</div>
		</div>
		<div class="form-row">
			<div class="col-md-6 mb-3">
				<label for="validationCustom03">User Neme</label>
				<input type="text" class="form-control" id="validationCustom03" name="username_search">
			</div>
			<div class="col-md-3 mb-3">
				<label for="validationCustom04">Job</label>
				<select class="custom-select" id="validationCustom04" name="job_search">
					<option></option>
					<option>医师</option>
					<option>医生</option>
					<option>护师</option>
					<option>护士</option>
				</select>
			</div>
			<div class="col-md-3 mb-3">
				<label for="validationCustom05">Sex</label>
				<select class="custom-select" id="validationCustom05" name="sex_search">
					<option></option>
					<option>男</option>
					<option>女</option>
				</select>
			</div>
		</div>
		
		<!--提交表单中的搜索信息-->
		<button class="btn btn-primary" type="submit">Submit form</button>
	</form>

	<!-- 添加用户的用户信息填写表 -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" data-backdrop="static" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">添加用户：</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
				</div>
				<!--提交表单-->
				<div class="modal-body">
					<form action="UserAddServlet" method="post" class="needs-validation" novalidate>
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="inputEmail4">Name</label>
								<input type="text" class="form-control" id="inputEmail4" name="name_add" required>
							</div>
							<div class="form-group col-md-6">
								<label for="inputPassword4">Username</label>
								<input type="text" class="form-control" id="inputPassword4" name="username_add" required>
							</div>
							<div class="form-group col-md-6">
								<label for="inputEmail4">Email</label>
								<input type="email" class="form-control" id="inputEmail4" name="email_add" required>
							</div>
							<div class="form-group col-md-6">
								<label for="inputPassword4">Password</label>
								<input type="password" class="form-control" id="inputPassword4" name="password_add" required>
							</div>
						</div>
						<div class="form-group">
							<label for="inputAddress">Address</label>
							<input type="text" class="form-control" id="inputAddress" placeholder="Please set address" name="address_add" required>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="inputCity">Phone</label>
								<input type="" class="form-control" id="inputCity" name="phone_add" required>
							</div>
							<div class="form-group col-md-3">
								<label for="inputState">Job</label>
								<select id="inputState" class="form-control" name="job_add">
									<option>医师</option>
									<option>医生</option>
									<option>护士</option>
									<option>护师</option>
									
								</select>
							</div>
							<div class="form-group col-md-3">
								<label for="inputZip">Sex</label>
								<select id="inputState" class="form-control" name="sex_add">
									<option>男 </option>
									<option>女 </option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label>用户身份：</label>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="role_add" id="inlineRadio1" value="user" required>
								<label class="form-check-label" for="inlineRadio1">User</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="role_add" id="inlineRadio2" value="admin" required>
								<label class="form-check-label" for="inlineRadio2">Admin</label>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary" >Save</button>
						</div>
					</form>
				</div>
				
			</div>
		</div>
	</div>

</div>
								
								
								