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
	<form action="DoctorSearchServlet" method="post" class="needs-validation" novalidate>
		<div class="form-row">
			<div class="col-md-6 mb-3">
				<label for="validationCustom01">number</label>
				<input type="text" class="form-control" id="validationCustom01" name="id_search" placeholder="请输入医生编号">
			</div>
			<div class="col-md-6 mb-3">
				<label for="validationCustom02">name</label>
				<input type="text" class="form-control" id="validationCustom02" name="name_search" placeholder="请输入医生姓名">
			</div>
		</div>
		<div class="form-row">
			<div class="col-md-6 mb-3">
				<label for="validationCustom03">room</label>
				<input type="text" class="form-control" id="validationCustom03" name="room_search" placeholder="请输入医生科室">
			</div>
			<div class="col-md-3 mb-3">
				<label for="validationCustom05">job</label>
				<select class="custom-select" id="validationCustom05" name="job_search">
				    <option></option>
					<option>医师</option>
					<option>医生</option>
					<option>护师</option>
					<option>护士</option>
				</select>
			</div>
		</div>
		
		<!--提交表单中的搜索信息-->
		<button class="btn btn-primary" type="submit">Submit form</button>
	</form>

	<!-- 添加用户的用户信息填写表 -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">添加医生：</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
				</div>
				<!--提交表单-->
				<div class="modal-body">
					<form action="DoctorAddServlet" method="post" class="needs-validation" novalidate>
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="inputEmail4">email</label>
								<input type="email" class="form-control" id="inputEmail4" name="email_add" required placeholder="请输入医生邮箱">
							</div>
							<div class="form-group col-md-6">
								<label for="inputPassword4">password</label>
								<input type="password" class="form-control" id="inputPassword4" name="password_add" required placeholder="请输入密码">
							</div>
							<div class="form-group col-md-6">
								<label for="inputEmail4">name</label>
								<input type="text" class="form-control" id="inputEmail4" name="name_add" required placeholder="请输入医生姓名">
							</div>
							<div class="form-group col-md-6">
								<label for="inputEmail4">room</label>
								<input type="text" class="form-control" id="inputEmail4" name="room_add" required placeholder="请输入医生科室">
							</div>
							<div class="form-group col-md-6">
								<label for="inputEmail4">phone</label>
								<input type="text" class="form-control" id="inputEmail4" name="phone_add" required placeholder="请输入医生电话">
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-3">
								<label for="inputZip">job</label>
								<select id="inputState" class="form-control" name="job_add">
									<option>医师</option>
									<option>医生</option>
									<option>护师</option>
									<option>护士</option>
								</select>
							</div>
							<div class="form-group col-md-3">
								<label for="inputZip">Sex</label>
								<select id="inputState" class="form-control" name="sex_add">
									<option>男 </option>
									<option>女 </option>
								</select>
							</div>
							<div class="form-group col-md-3">
								<label for="inputEmail4">Age</label>
								<input type="text" class="form-control" id="inputEmail4" name="age_add" required placeholder="请输入年龄">
							</div>
						</div>
						<div class="form-group">
							<label for="inputAddress">Address</label>
							<input type="text" class="form-control" id="inputAddress" placeholder="Please set address" name="address_add" required>
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
	
		