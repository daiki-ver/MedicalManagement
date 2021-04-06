<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 删除时进行弹窗提醒 -->
<script type="text/javascript">
	$(document).ready(function(){
		$(".delete").on("click",function(){
			var id=$(this).attr("date");
			console.log(id);
			$("#sure").val(id);
		})
	}	
	)
</script>
	<div class="layui-fluid ll" style="margin-left:1px">				 
    
    <form action="EditServlet_Patient_Sure?pid_edit=${patient_person.pid}" method="post" id="huanzhe">
    	
    
        <div class="layui-card"  >
        	<div class="layui-card-header" style="margin-bottom:10px"></div>
          <div class="layui-card-header" style="margin-bottom:30px"><h2>设置患者资料:</h2></div>
          <div class="layui-card-body"  pad15>
            
            <div class="layui-form" lay-filter="">
           
              <div class="kk"  style="width:480px">
                <label class="layui-form-label"style="width:110px">姓名:</label>
                <div class="layui-input-inline" style="margin-top: 7px;">
				<span style="width: 300px; " id="hid">${patient_person.pname}</span>
                  <input type="text" name="pname_edit" style="width:300px; display:none ;"  id="show" value="${patient_person.pname}" class="layui-input" >
                </div>
              </div>
              <div class="kk" style="width:480px">
                <label class="layui-form-label" style="width:110px">邮箱:</label>
                <div class="layui-input-inline" style="margin-top: 7px;">
					<span style="width: 300px;" id="hid1">${patient_person.pemail}</span>
                  <input type="email" name="pemail_edit"  style="width:300px; display:none ;" id="show1" value="${patient_person.pemail}"  class="layui-input">
                </div>
              </div>
                <div class="kk" style="width:480px">
                <label class="layui-form-label" style="width:110px">用户名:</label>
                <div class="layui-input-inline" style="margin-top: 7px;">
					<span style="width: 300px;" id="hid2">${patient_person.pusername}</span>
                  <input type="text" name="pusername_edit" style="width:300px; display:none ;" id="show2" value="${patient_person.pusername}" class="layui-input">
                </div>
              </div>
                <div class="kk" style="width:480px">
                <label class="layui-form-label" style="width:110px">年龄:</label>
                <div class="layui-input-inline" style="margin-top: 7px;">
					<span style="width: 300px;" id="hid3">${patient_person.page}</span>
                  <input type="text" name="page_edit" style="width:300px; display:none ;" id="show3" value="${patient_person.page}"  class="layui-input">
                </div>
              </div>
              
                <div class="kk" style="width:480px">
                <label class="layui-form-label" style="width:110px">职位:</label>
                <div class="layui-input-inline" style="margin-top: 7px;">
					<span style="width: 300px;" id="hid4">${patient_person.pjob}</span>
                  <input type="text" name="pjob_edit" style="width:300px; display:none ;" id="show4" value="${patient_person.pjob}" class="layui-input">
                </div>
              </div>
            
                <div class="kk" style="width:480px">
                <label class="layui-form-label" style="width:110px">民族:</label>
                <div class="layui-input-inline" style="margin-top: 7px;">
					<span style="width: 300px;" id="hid5">${patient_person.pnation}</span>
                  <input type="text" name="pnation_edit"  style="width:300px; display:none ;" id="show5" value="${patient_person.pnation}" class="layui-input">
                </div>
              </div>
                <div class="kk" style="width:480px">
                <label class="layui-form-label" style="width:110px">籍贯:</label>
                <div class="layui-input-inline" style="margin-top: 7px;">
					<span style="width: 300px;" id="hid6">${patient_person.pnatplace}</span>
                  <input type="text" name="pnatplace_edit" style="width:300px; display:none ;" id="show6" value="${patient_person.pnatplace}" class="layui-input">
                </div>
              </div>
                <div class="kk" style="width:480px">
                <label class="layui-form-label" style="width:110px">现住址:</label>
                <div class="layui-input-inline" style="margin-top: 7px;">
					<span style="width: 300px;"id="hid7" >${patient_person.paddress}</span>
                  <input type="text" name="paddress_edit" style="width:300px; display:none ;" id="show7" value="${patient_person.paddress}" class="layui-input">
                </div>
              </div>
               <div class="kk" style="width:480px"> 
                <label class="layui-form-label" style="width:110px">联系电话:</label>
                <div class="layui-input-inline" style="margin-top: 7px;">
					<span style="width: 300px;" id="hid8">${patient_person.pphone}</span>
                  <input type="text" name="pphone_edit"  style="width:300px; display:none ;" id="show8" value="${patient_person.pphone}" class="layui-input">
                </div>
              </div>
                <div class="kk" style="width:480px">
                <label class="layui-form-label" style="width:110px">过敏史:</label>
                <div class="layui-input-inline" style="margin-top: 7px;">
					<span style="width: 300px;" id="hid9">${patient_person.allergy}</span>
                  <input type="text" name="allergy_edit"  style="width:300px; display:none ;" id="show9" value="${patient_person.allergy}" class="layui-input">
                </div>
              </div>
                <div class="kk" style="width:480px">
                <label class="layui-form-label" style="width:110px">身份证号:</label>
                <div class="layui-input-inline" style="margin-top: 7px;">
					<span style="width: 300px;" id="hid10">${patient_person.pid_card}</span>
                  <input type="text" name="pid_card_edit" style="width:300px; display:none ;" id="show10"  value="${patient_person.pid_card}" class="layui-input">
                </div>
              </div>
                <div class="kk" style="width:480px">
                <label class="layui-form-label" style="width:110px">重要疾病:</label>
                <div class="layui-input-inline" style="margin-top: 7px;">
					<span style="width: 300px;" id="hid11">${patient_person.pdiseases}</span>
                  <input type="text" name="pdiseases_edit" style="width:300px; display:none ;" id="show11" value="${patient_person.pdiseases}" class="layui-input">
                </div>
              </div>
			<div class="kk" style="width:480px ;">
			           <label class="layui-form-label" style="width:110px">婚姻:</label>
			           <div class="layui-input-inline" style="margin-top: 7px;">
						    <span style="width: 300px;" id="hid12">${patient_person.pmarriage}</span>
			             <input id="show12" type="text" name="pmarriage_edit" style="width:300px; display: none;" value="${patient_person.pmarriage}"  autocomplete="off" placeholder="请输入婚姻" class="layui-input">
			           </div>
			         </div>
			        <div class="kk" style="width:480px">
			           <label class="layui-form-label" style="width:110px">性别:</label>
			           <div class="layui-input-inline "style="margin-top: 7px;">
						   <span style="width: 300px;" id="hid13">${patient_person.psex}</span>
			             <input id="show13" type="text" name="psex_edit" style="width:300px; display: none;" value="${patient_person.psex}" class="layui-input">
			           </div>
			         </div>
			         <div class="layui-form-item layui-form-text" style="width:890px">
			           <label class="layui-form-label" style="width:110px">描述:</label>
			           <div class="layui-input-block " style="margin-top: 7px;">
						   <p id="hid14">${patient_person.pdescribe}</p>
			             <textarea id="show14" name="pdescribe_edit" style="display: none;"  class="layui-textarea">${patient_person.pdescribe}</textarea>
			           </div>
			         </div>
			         <div class="kk" style="width:480px">
			           <label class="layui-form-label" style="width:110px">角色:</label>
			           <div class="layui-input-inline "style="margin-top: 7px;">
						 <span style="width: 300px;" id="hid15">${patient_person.role}</span>
			             <input id="show15" type="text" name="role_edit" style="width:300px; display: none;" value="${patient_person.role}" class="layui-input">
			           </div>
			         </div>	
              <div class="layui-form-item">
                <div class="layui-input-block">
                  <a class="layui-btn" lay-submit lay-filter="setmyinfo" id="key" href="javascript:divShow();">修改</a>
                  <input type="hidden" name="pid_edit" value="${patient_person.pid}">
                  <a class="layui-btn" lay-submit lay-filter="setmyinfo" style="display: none; width: 140px; " href="javascript:tijiao();" id="key2">确认修改</a>
                </div>
              </div>
			  </form>
            </div>
<div class="layui-card-header" style="margin:70px 0px 30px 0px"><h2>管理病历:</h2></div>
       <div class="container">
		<table class="table table-hover" style="margin-top: 20px;">
			<thead>
				<tr align="center">
					<th scope="col">病历编号</th>
					<th scope="col">医护姓名</th>
					<th scope="col">医护编号</th>
					<th scope="col">住院日期</th>
					<th scope="col">出院日期</th>
					<th scope="col">诊断结果</th>
					<th scope="col">住院号</th>
					<th scope="col">病床号</th>
					<th >操作</th>
				</tr>
			</thead>
			
		<c:forEach items="${requestScope.medicalList}" var="medicalItem" varStatus="varstatus">
			<tbody>
				<tr align="center">
				    <td align="center">${medicalItem.mid}</td>
					<td align="center">${medicalItem.dname}</td>
					<td align="center">${medicalItem.id}</td>
					<td align="center">2001-2-20</td>
					<td align="center">2001-2-23</td>
					<td align="center">${medicalItem.diagnosis}</td>		
					<td align="center">${medicalItem.hnum}</td>	
					<td align="center">${medicalItem.bnum}</td>											
					<td align="center">
						<a class="btn btn-primary btn-sm mr-1" style="" href="EditServlet_Medical?mid_edit=${medicalItem.mid}">编辑</a>
						<a class="btn btn-primary btn-sm ml-1 delete" data-toggle="modal" data-target="#DeleteWorring" style="color: white;" date="${medicalItem.mid}">删除</a>
						<!-- 删除时的警告信息
						     点击确认时进行调用删除servlet 平时处于隐藏状态 -->
						<div class="modal fade" id="DeleteWorring" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title">Worring：</h5>
										<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								          <span aria-hidden="true">&times;</span>
								        </button>
									</div>
									<div class="modal-body">
										<p>您确定要删除该记录吗？</p>
									</div>
									<div class="modal-footer">
										<form action="DeleteServlet_Medical" method="post">
											<input type="hidden" id="sure" value=id name="id_worring"/>
											<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
											<button type="submit" class="btn btn-primary">I'm Sure</button>
										</form>
									</div>
								</div>
							</div>
						</div>
					
					</td>
				</tr>
			</tbody>
		</c:forEach>
		</table>
	</div>
  
  <div>
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<li class="page-item  jj">
				<a class="btn btn-primary btn-sm ml-1" style="width:105px" href="MedicalAddServlet?pid=${patient_person.pid}">添加病历</a>
			</li>
		</ul>
	</nav>
	
</div>
