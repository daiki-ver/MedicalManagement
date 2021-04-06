<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<div class="b">
	<div class="one">
		<img class="one1_1" src="img/QQ图片20200701172050.jpg" />
		<p class="one1">${userEdit.username}</p>
		<img class="one3_1" src="img/QQ截图20201208010109.png" />
		<p class="one2">${userEdit.role}</p>
	</div>
	<div class="two">
		 <a  href="javascript:divShow();" class="one3" type="button" id="key" >编辑</a>
		 <a href="javascript:tijiao();" class="one3" style="display: none;" type="button" id="key2" >提交</a>
		<!--<a class="one3" href="#">保存</a>-->
	</div>
		<form action="EditSetServlet_User_Sure?email_edit=${userEdit.email}" method="post" class="three" id="loginForm">
		<div id="app">
			<div class="main view">
				<div class="app-main_ appMain" style="min-height: calc(-308px + 100vh);">
					<div class="mineWrap" data-v-616fe2b1="">
						<div class="mineBox" data-v-616fe2b1="">
							<div class="mineInner" data-v-616fe2b1="">
								<div class="personalDataWrap" data-v-616fe2b1="">
									<div class="loginingBox" style="display: none;">
										<img src="https://storagecdn.xuetangx.com/public_assets/xuetangx/xuetangX2018/7f0a03259697d168b92e4d9d9208116f.loadingbg.gif">
									</div>
									<div class="personalInfo">
										<div class="personalTip">
											<span>个人信息</span>
										</div>
										<div class="personalBox">
											<div class="boxLeft left1">
												<ul class="infoList">
													<li class="infoLi nameInp">
														<span class="span1">姓名</span>
														<div class="el-input el-input--medium">
															<span id="hid">${userEdit.name}</span>
															<input class="el-input__inner" id="show" style="display: none;" type="text" value="${userEdit.name}" name="name_edit">
														</div>
													</li>
													<li class="infoLi"><span class="span1">邮箱</span>
														<div class="el-select el-select--medium">
															<div class="el-input el-input--medium el-input--suffix is-focus">
																<span id="hid1">${userEdit.email}</span>
																<input class="el-input__inner" id="show1" style="display: none;" type="email" value="${userEdit.email}" name="email_edit">
															</div>
													</li>
													<li class="infoLi">
														<span class="span1">职业</span>

														<div class="el-input el-input--medium">
															<span  id="hid2">${userEdit.job}</span>
															<input class="el-input__inner" id="show2" style="display: none;" type="text" value="${userEdit.job}" name="job_edit">
														</div>
													</li>
													<li class="infoLi birthdayInp">
														<span class="span1">生日</span>

														<div class="el-date-editor el-input el-input--medium el-input--prefix el-input--suffix el-date-editor--date">
															<span id="hid3">${userEdit.birthday}</span>
															<input class="el-input__inner" id="show3" style="display: none;"  type="date" value="${userEdit.birthday}" name="birthday_edit">
															<span class="el-input__prefix">
																<i class="el-input__icon el-icon-date"></i>
															</span>
															<span class="el-input__suffix">
																<span class="el-input__suffix-inner">
																	<i class="el-input__icon"></i>
																</span>
															</span>
														</div>
													</li>
												</ul>
												</div>
												<div class="boxRight right1">
													<ul class="infoList">
														<li class="infoLi"><span class="span1" for="validationCustom05">性别</span>
															<div class="el-select el-select--medium">
																<div class="el-input el-input--medium el-input--suffix">
																	<span id="hid4">${userEdit.sex}</span>
																	<select class="el-input__inner " id="show4" style="display: none;" id="validationCustom05" name="sex_edit">
																		<option>男</option>
																		<option>女</option>
																	</select>
																</div>
														</li>
														<li class="infoLi"><span class="span1">号码</span>
															<div class="el-input el-input--medium">
																<span id="hid5">${userEdit.phone}</span>
																<!----><input class="el-input__inner" id="show5" style="display: none;" type="text" value="${userEdit.phone}" name="phone_edit">
															</div>
														</li>
														<li class="infoLi"><span class="span1">角色</span>
															<!---->
															<!---->

															<div class="el-input el-input--medium">
																<span id="hid6">${userEdit.role}</span>
																<!----><input class="el-input__inner" id="show6" style="display: none;" type="text" value="${userEdit.role}" name="role_edit">
															</div>
														</li>
														<li class="infoLi"><span class="span1">地址</span>
															<!---->
															<!---->

															<div class="el-cascader el-cascader--medium">
																<div class="el-input el-input--medium el-input--suffix">
																	<span id="hid7">${userEdit.address}</span>
																	<!----><input class="el-input__inner" id="show7" style="display: none;" type="text" readonly="readonly" value="${userEdit.address}" name="address_edit">
																	<!----><span class="el-input__suffix"><span class="el-input__suffix-inner"><i class="el-input__icon el-icon-arrow-down"></i><!----><!----><!----><!----></span>
																	</span>
																</div>
														</li>
													</ul>
													</div>
													</div>
													<div class="four" style="width: 740px; height: 78px;">
														描述<br />
														<p style="color: #000000;margin-top: 3px;" id="hid8">本人的描述</p>
														<textarea cols="60" rows="8" style="display: none;" id="show8">${userEdit.describe}</textarea>
													</div>
												</div>
												<div class="accountInfo">
													<div class="accountTip"><span>账号信息</span></div>
													<div class="accountBox">
														<ul style="width: 340px;" class="left1">
															<li><span class="span1">账号</span><span class="span2">${userEdit.email}</span></li>
															<li><span class="span1">当前登录</span><span class="span2">邮箱</span></li>
															<li><span class="span1">密码</span> <span class="span2 spanPassword">${userEdit.password}</span>
																<a class="span3" href="修改密码.html">修改密码</a>
															</li>
															<li><span class="span1">实名认证</span> <span class="span2">未认证</span> <span class="span3">去认证</span></li>
														</ul>
														<ul style="width: 300px;" class="right1">
															<li><span class="span1" style="margin-left: 10px;">手机号码</span> <span class="span2"></span>
																<a class="span3" href="绑定手机号.html">绑定手机号</a> <span class="span5 span4" style="color: rgb(153, 153, 153);">未绑定</span></li>
															<li><span class="span1" style="margin-left: 10px;">邮箱</span> <span class="span2">${userEdit.email}</span> <span class="span3">更换</span>
															</li>
															<li>
																<span class="span1" style="margin-left: 10px;">第三方账号</span> 
																<img class="loginWei" src="https://storagecdn.xuetangx.com/public_assets/xuetangx/xuetangX2018/ed7e95873ed622ce9ba4268973fba2b2.weixin.png"> 
																<img class="notLoginWei" style="display: none;" src="https://storagecdn.xuetangx.com/public_assets/xuetangx/xuetangX2018/91b01aaef250827a3806246a90e128d8.weixin2.png"> 
																<span class="span3" style="display: none;">去绑定</span>
															</li>
															<li><span class="span1" style="margin-left: 10px;">账号注销</span>
																<a class="span3 span4" href="申请注销.html" target="_self">申请注销</a>
															</li>
														</ul>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
		</form>
</div>			
							