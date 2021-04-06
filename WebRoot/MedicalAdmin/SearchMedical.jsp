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
	<form action="MedicalSearchServlet" method="post" class="needs-validation" novalidate>
		<div class="form-row">
			<div class="col-md-6 mb-3">
				<label for="validationCustom01">number</label>
				<input type="text" class="form-control" id="validationCustom01" name="mid_search" placeholder="请输入病历编号">
			</div>
			<div class="col-md-6 mb-3">
				<label for="validationCustom02">patient name</label>
				<input type="text" class="form-control" id="validationCustom02" name="pname_search" placeholder="请输入患者姓名">
			</div>
		</div>
		<div class="form-row">
			<div class="col-md-6 mb-3">
				<label for="validationCustom03">doctor name</label>
				<input type="text" class="form-control" id="validationCustom03" name="dname_search" placeholder="请输入主治医生姓名">
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
					<form action="MedicalAddServlet" method="post" class="needs-validation" novalidate>
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="inputEmail4">mid</label>
								<input type="text" class="form-control" id="inputEmail4" name="mid_add" required>
							</div>
							<div class="form-group col-md-6">
								<label for="inputEmail4">pid</label>
								<input type="text" class="form-control" id="inputEmail4" name="pid_add" required>
							</div>
							<div class="form-group col-md-6">
								<label for="inputPassword4">pname</label>
								<input type="text" class="form-control" id="inputPassword4" name="pname_add" required>
							</div>
							<div class="form-group col-md-6">
								<label for="inputPassword4">did</label>
								<input type="text" class="form-control" id="inputPassword4" name="did_add" required>
							</div>
							<div class="form-group col-md-6">
								<label for="inputPassword4">dname</label>
								<input type="text" class="form-control" id="inputPassword4" name="dname_add" required>
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
	