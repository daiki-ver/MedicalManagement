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
	<form action="PatientSearchServlet" method="post" class="needs-validation" novalidate>
		<div class="form-row">
			<div class="col-md-6 mb-3">
				<label for="validationCustom01">number</label>
				<input type="text" class="form-control" id="validationCustom01" name="id_search" placeholder="请输入患者编号">
			</div>
			<div class="col-md-6 mb-3">
				<label for="validationCustom02">Native place</label>
				<input type="text" class="form-control" id="validationCustom02" name="natplace_search" placeholder="请输入患者籍贯">
			</div>
		</div>
		<div class="form-row">
			<div class="col-md-6 mb-3">
				<label for="validationCustom03">Name</label>
				<input type="text" class="form-control" id="validationCustom03" name="name_search" placeholder="请输入患者姓名">
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
					<form action="PatientAddServlet" method="post" class="needs-validation" novalidate>
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="inputEmail4">Name</label>
								<input type="text" class="form-control" id="inputEmail4" name="name_add" required>
							</div>
							<div class="form-group col-md-6">
								<label for="inputEmail4">Email</label>
								<input type="email" class="form-control" id="inputEmail4" name="email_add" required>
							</div>
							<div class="form-group col-md-6">
								<label for="inputPassword4">Password</label>
								<input type="password" class="form-control" id="inputPassword4" name="password_add" required>
							</div>
							<div class="form-group col-md-6">
								<label for="inputZip">nation</label>
								<select id="inputState" class="form-control" name="nation_add">
									<option>汉族 </option>
									<option>满族 </option>
									<option>蒙古族 </option>
									<option>回族 </option>
									<option>藏族 </option>
									<option>维吾尔族 </option>
									<option>苗族 </option>
									<option>彝族 </option>
									<option>壮族 </option>
									<option>布依族 </option>
									<option>侗族 </option>
									<option>瑶族 </option>
									<option>白族 </option>
									<option>土家族 </option>
								</select>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-4">
								<label for="inputCity">Age</label>
								<input type="text" class="form-control" id="inputCity" name="age_add" required>
							</div>
							<div class="form-group col-md-4">
								<label for="inputZip">Sex</label>
								<select id="inputState" class="form-control" name="sex_add">
									<option>男 </option>
									<option>女 </option>
								</select>
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
	