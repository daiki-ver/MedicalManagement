<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


	<div class="layui-fluid ll" style="margin-left:1px">				 
    
    	<form action="EditServlet_Medical_Sure?mid_edit=${medical_person.mid}" method="post" id="bingli">
    	
    
	        <div class="layui-card"  style="height:800px">
	        <div class="layui-card-header" style="margin-bottom:30px"></div>
	          <div class="layui-card-header" style="margin-bottom:30px;padding-left:50px"><h2>设置病历资料:</h2></div>
	          <div class="layui-card-body"  pad15>
	            
	            <div class="layui-form" lay-filter="">
	           
	              <div class="kk"  style="width:460px;padding-left:50px">
	                <label class="layui-form-label"style="width:110px">病历编号:</label>
	                <div class="layui-input-inline" style="margin-top: 7px;">
					<span style="width: 300px; " id="hid">${medical_person.mid}</span>
	                  <input type="text" name="mid_edit" style="width:300px; display:none ;"  id="show" value="${medical_person.mid}" class="layui-input">
	                </div>
	              </div>
	              <div class="kk" style="width:480px;padding-left:50px">
	                <label class="layui-form-label" style="width:130px">身份证号:</label>
	                <div class="layui-input-inline" style="margin-top: 7px;">
						<span style="width: 300px;" id="hid1">${medical_person.pid_card}</span>
	                  <input type="email" name="pid_card_edit"  style="width:300px; display:none ;" id="show1" value="${medical_person.pid_card}"  class="layui-input">
	                </div>
	              </div>
	                <div class="kk" style="width:480px;padding-left:50px">
	                <label class="layui-form-label" style="width:110px">医护姓名:</label>
	                <div class="layui-input-inline" style="margin-top: 7px;">
						<span style="width: 300px;" id="hid2">${medical_person.dname}</span>
	                  <input type="text" name="dname_edit" style="width:300px; display:none ;" id="show2" value="${medical_person.dname}" class="layui-input">
	                </div>
	              </div>
	                <div class="kk" style="width:480px;padding-left:50px">
	                <label class="layui-form-label" style="width:110px">医生id:</label>
	                <div class="layui-input-inline" style="margin-top: 7px;">
						<span style="width: 300px;" id="hid3">${medical_person.id}</span>
	                  <input type="text" name="id_edit" style="width:300px; display:none ;" id="show3" value="${medical_person.id}" class="layui-input">
	                </div>
	              </div>
	              
	                <div class="kk" style="width:480px;padding-left:50px">
	                <label class="layui-form-label" style="width:110px">住院日期:</label>
	                <div class="layui-input-inline" style="margin-top: 7px;">
						<span style="width: 300px;" id="hid4">2020-12-10</span>
	                  <input type="date" name="indate_edit" style="width:300px; display:none ;" id="show4" value="2020-12-10" class="layui-input">
	                </div>
	              </div>
	            
	                <div class="kk" style="width:480px;padding-left:50px">
	                <label class="layui-form-label" style="width:110px">出院日期:</label>
	                <div class="layui-input-inline" style="margin-top: 7px;">
						<span style="width: 300px;" id="hid5">2021-1-1</span>
	                  <input type="date" name="outdate_edit"  style="width:300px; display:none ;" id="show5" value="2021-1-1" class="layui-input">
	                </div>
	              </div>
	                <div class="kk" style="width:480px;padding-left:50px">
	                <label class="layui-form-label" style="width:110px">诊断结果:</label>
	                <div class="layui-input-inline" style="margin-top: 7px;">
						<span style="width: 300px;" id="hid6">${medical_person.diagnosis}</span>
	                  <input type="text" name="diagnosis_edit" style="width:300px; display:none ;" id="show6" value="${medical_person.diagnosis}" class="layui-input">
	                </div>
	              </div>
	                <div class="kk" style="width:480px;padding-left:50px">
	                <label class="layui-form-label" style="width:110px">出院结果:</label>
	                <div class="layui-input-inline" style="margin-top: 7px;">
						<span style="width: 300px;"id="hid7" >${medical_person.outresult}</span>
	                  <input type="text" name="outresult_edit" style="width:300px; display:none ;" id="show7" value="${medical_person.outresult}"  autocomplete="off" placeholder="请输入出院结果" class="layui-input">
	                </div>
	              </div>
	               <div class="kk" style="width:480px;padding-left:50px"> 
	                <label class="layui-form-label" style="width:110px">住院号:</label>
	                <div class="layui-input-inline" style="margin-top: 7px;">
						<span style="width: 300px;" id="hid8">${medical_person.hnum}</span>
	                  <input type="text" name="hnum_edit"  style="width:300px; display:none ;" id="show8" value="${medical_person.hnum}" class="layui-input">
	                </div>
	              </div>
	                <div class="kk" style="width:480px;padding-left:50px">
	                <label class="layui-form-label" style="width:110px">病床号:</label>
	                <div class="layui-input-inline" style="margin-top: 7px;">
						<span style="width: 300px;" id="hid9">${medical_person.bnum}</span>
	                  <input type="text" name="bnum_edit"  style="width:300px; display:none ;" id="show9" value="${medical_person.hnum}" class="layui-input">
	                </div>
	              </div>
	                <div class="kk" style="width:480px;padding-left:50px">
	                <label class="layui-form-label" style="width:110px">治疗经过:</label>
	                <div class="layui-input-inline" style="margin-top: 7px;">
						<span style="width: 300px;" id="hid10">${medical_person.curepass}</span>
	                  <input type="text" name="curepass_edit" style="width:300px; display:none ;" id="show10"  value="${medical_person.curepass}" class="layui-input">
	                </div>
	              </div>
	                <div class="kk" style="width:480px;padding-left:50px">
	                <label class="layui-form-label" style="width:110px">主诉:</label>
	                <div class="layui-input-inline" style="margin-top: 7px;">
						<span style="width: 300px;" id="hid11">${medical_person.suit}</span>
	                  <input type="text" name="suit_edit" style="width:300px; display:none ;" id="show11" value="${medical_person.suit}" class="layui-input">
	                </div>
	              </div>
				<div class="kk" style="width:480px;padding-left:50px">
				           <label class="layui-form-label" style="width:110px">现病史:</label>
				           <div class="layui-input-inline" style="margin-top: 7px;">
							    <span style="width: 300px;" id="hid12">${medical_person.nowill}</span>
				             <input id="show12" type="text" name="nowill_edit" style="width:300px; display: none;" value="${medical_person.nowill}" class="layui-input">
				           </div>
				         </div>
				        <div class="kk" style="width:480px;padding-left:50px">
				           <label class="layui-form-label" style="width:110px">既往史:</label>
				           <div class="layui-input-inline "style="margin-top: 7px;">
							   <span style="width: 300px;" id="hid13">${medical_person.oldill}</span>
				             <input id="show13" type="text" name="oldill_edit" style="width:300px; display: none;" value="${medical_person.oldill}" class="layui-input">
				           </div>
				         </div>
				         <div class="kk" style="width:480px;padding-left:50px">
				           <label class="layui-form-label" style="width:110px">婚姻史:</label>
				           <div class="layui-input-inline "style="margin-top: 7px;">
							   <span style="width: 300px;" id="hid14">${medical_person.marriagehis}</span>
				             <input id="show14" type="text" name="marriagehis_edit" style="width:300px; display: none;" value="${medical_person.marriagehis}" class="layui-input">
				           </div>
				         </div>
				         <div class="kk" style="width:480px;padding-left:50px">
				           <label class="layui-form-label" style="width:110px">体格检查:</label>
				           <div class="layui-input-inline "style="margin-top: 7px;">
							   <span style="width: 300px;" id="hid15">${medical_person.bodycheck}</span>
				             <input id="show15" type="text" name="bodycheck_edit" style="width:300px; display: none;" value="${medical_person.bodycheck}" class="layui-input">
				           </div>
				         </div>
				         <div class="kk" style="width:480px;padding-left:50px">
				           <label class="layui-form-label" style="width:110px">辅助检查:</label>
				           <div class="layui-input-inline "style="margin-top: 7px;">
							   <span style="width: 300px;" id="hid16">${medical_person.othercheck}</span>
				             <input id="show16" type="text" name="othercheck_edit" style="width:300px; display: none;" value="${medical_person.othercheck}" class="layui-input">
				           </div>
				         </div>
				         <div class="layui-form-item layui-form-text" style="width:890px;padding-top:6px;padding-left:50px">
				           <label class="layui-form-label" style="width:110px">医护描述:</label>
				           <div class="layui-input-block " style="margin-top: 7px;">
							   <p id="hid17">${medical_person.describe}</p>
				             <textarea id="show17" name="describe_edit" style="display: none;"class="layui-textarea">${medical_person.describe}</textarea>
				           </div>
				         </div>
				        
	              
	              
	                
	              <div class="layui-form-item">
	                <div class="layui-input-block">
	                  <a class="layui-btn" lay-submit lay-filter="setmyinfo" id="key" href="javascript:divShow();" style="width: 140px; margin-left:50px">修改</a>
	                  <a class="layui-btn" lay-submit lay-filter="setmyinfo" style="display: none; width: 140px; margin-left:50px" href="javascript:tijiao();" id="key2">确认修改</a>
	                </div>
	              </div>
			  </form>
    </div>
           