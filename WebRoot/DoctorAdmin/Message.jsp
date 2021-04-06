<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--工作域-->
<div class="work_space">
	<div class="one" style="width: 95%; margin-left: 30px; ">
		<img class="one1_1" src="img/QQ图片20200701172050.jpg" />
		<p class="one1">${doctor_person.dusername}</p>
		<img class="one3_1" src="img/QQ截图20201208010109.png" />
		<p class="one2">${doctor_person.role}</p>
	
	</div>
	<div style="width: 95%; margin-left: 30px; height: 350px; margin-top: 35px; background-color: #e3f2fd;">
<form action="EditServlet_Doctor_Sure?id=${doctor_person.id}" method="post">
	<div style="width: 95%; height: 80px;margin-left: 10px; padding-top: 20px; margin-left: 30px;">
		<span style="font-size: 20px; ">医护个人信息</span>
		<span style="float: right; font-size: 10px; color: royalblue;" id="key"><img src="img/编辑.png" width="15px"height="15px" ><a href="javascript:divShow();"  >编辑</a></span>
	</div>
	
		<div  style="float: left;  width: 35%; height: 250px; margin-left: 50px; "> 
		
			<table class="table_yh">
				<tr>
					<td>姓名</td>
					<td class="yh_right" id="hid">${doctor_person.dname}</td>
					<td class="yh_form"  style="display: none; width: 20%;" id="show"><input type="text" name="dname_edit" id="" value="${doctor_person.dname}" /></td>
				</tr>
				
				<tr>
					<td>职位</td>
					<td class="yh_right" id="hid1">${doctor_person.djob}</td>
					<td class="yh_form" style="display: none; width: 20%;" id="show1"><input type="text" name="djob_edit" id="" value="${doctor_person.djob}"  /></td>
				</tr>
				<tr>
					<td>生日</td>
					<td class="yh_right" id="hid2" >${doctor_person_birthday}</td>
					<td class="yh_form" style="display: none; width: 20%;" id="show2"> <input type="text" name="" id="" value="${doctor_person_birthday}"  /></td>
				</tr>
				<tr>
					<td>联系电话</td>
					<td class="yh_right" id="hid3" >${doctor_person.dphone}</td>
					<td class="yh_form" style="display: none; width: 20%; " id="show3"><input type="text" name="dphone_edit" id="" value="${doctor_person.dphone}"  /></td>
				</tr>
				
			</table>
		</div>
		<div style="float: right;  width: 50%; height: 250px;margin-right: 50px;">
			<table class="table_yh">
			<tr>
				<td>性别</td>
				<td class="yh_right" id="hid4" >${doctor_person.dsex}</td>
				<td class="yh_form" style="display: none;" id="show4"><input type="text" name="dsex_edit" id="" value="${doctor_person.dsex}"   /></td>
			</tr>
			<tr>
				<td>住址</td>
				<td class="yh_right" id="hid5" >${doctor_person.daddress}</td>
				<td class="yh_form" style="display: none;" id="show5"><input type="text" name="daddress_edit" id="" value="${doctor_person.daddress}"   /></td>
			</tr>
			<tr>
				<td>科室</td>
				<td class="yh_right"  id="hid6" >${doctor_person.droom}</td>
				<td class="yh_form" style="display: none;" id="show6"><input type="text" name="droom_edit" id="" value="${doctor_person.droom}"  /></td>
			</tr>
			<tr>
				<td>身份证号</td>
				<td class="yh_right" id="hid7" >${doctor_person.did_card}</td>
				<td class="yh_form" style="display: none;" id="show7"><input type="text" name="did_card_edit" id="" value="${doctor_person.did_card}"   /></td>
			</tr>
			<button type="submit" id="key2"  style="float: right;margin-top: 230px; display: none;margin-right:100px;" >保存</button>
			
			</table>
		</div>
		</form>
	</div>
	
	<div style="float: left;  width: 95%; height: 300px; margin-left: 30px; background-color: #e3f2fd; margin-top: 50px; ">
		<div style="width: 95%; height: 80px;  margin-left: 30px;margin-top: 8px; ">
			<span style="font-size: 20px;">医护账号信息</span>
			
		</div>
		<table class="table_yh" style="margin-left: 50px;">
			<tr>
				<td>用户名</td>
				<td class="yh_right">${doctor_person.dusername}</td>
			</tr>
			<tr>
				<td>密码</td>
				<td class="yh_right">${doctor_person.dpassword}</td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td class="yh_right">${doctor_person.demail}</td>
			</tr>
			<tr>
				<td>角色</td>
				<td class="yh_right">${doctor_person.role}</td>
			</tr>
		</table>
	</div>
		
</div>
