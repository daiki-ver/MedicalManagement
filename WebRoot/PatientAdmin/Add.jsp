<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="layui-fluid ll" style="margin-left:1px">				 
    
    <form action="MedicalAddServlet_Sure?pid=${medical_person.pid}" method="post" >
    	
    
        <div class="layui-card"  style="height:800px">
        <div class="layui-card-header" style="margin-bottom:30px"></div>
          <div class="layui-card-header" style="margin-bottom:30px;padding-left:50px"><h2>设置病历资料:</h2></div>
          <div class="layui-card-body"  pad15>
            
            <div class="layui-form" lay-filter="">
           
              <div class="kk"  style="width:460px;padding-left:50px">
                <label class="layui-form-label"style="width:110px">患者姓名:</label>
                <div class="layui-input-inline" style="margin-top: 7px;">
                  <span style="width: 300px; " id="hid">${medical_person.pname}</span>
                </div>
              </div>
              <div class="kk" style="width:480px;padding-left:50px">
                <label class="layui-form-label" style="width:130px">患者身份证号:</label>
                <div class="layui-input-inline" style="margin-top: 7px;">	
                <span style="width: 300px; " id="hid">${medical_person.pid_card}</span>
                </div>
              </div>
              <div class="kk" style="width:480px;padding-left:50px">
	                <label class="layui-form-label" style="width:110px">医护姓名:</label>
	                <div class="layui-input-inline" style="margin-top: 7px;">
					
	                  <input type="text" name="dname_edit" style="width:300px;" id="show2" value="" class="layui-input">
	                </div>
              </div>
              <div class="kk" style="width:480px;padding-left:50px">
                <label class="layui-form-label" style="width:110px">医生id:</label>
                <div class="layui-input-inline" style="margin-top: 7px;">
					
                  <input type="text" name="id_edit" style="width:300px;" id="show3" value="" class="layui-input">
                </div>
              </div>
              
              <div class="kk" style="width:480px;padding-left:50px">
                <label class="layui-form-label" style="width:110px">住院日期:</label>
                <div class="layui-input-inline" style="margin-top: 7px;">
					
                  <input type="date" name="indate_edit" style="width:300px;" id="show4" value="" class="layui-input">
                </div>
              </div>
            
              <div class="kk" style="width:480px;padding-left:50px">
                <label class="layui-form-label" style="width:110px">出院日期:</label>
                <div class="layui-input-inline" style="margin-top: 7px;">
					
	               <input type="date" name="outdate_edit"  style="width:300px;" id="show5" value="" class="layui-input">
                </div>
              </div>
              
                <div class="kk" style="width:480px;padding-left:50px">
                <label class="layui-form-label" style="width:110px">诊断结果:</label>
                <div class="layui-input-inline" style="margin-top: 7px;">
					
	                  <input type="text" name="diagnosis_edit" style="width:300px;" id="show6" value="" class="layui-input">
                </div>
              </div>
                <div class="kk" style="width:480px;padding-left:50px">
                <label class="layui-form-label" style="width:110px">出院结果:</label>
                <div class="layui-input-inline" style="margin-top: 7px;">
					
	                  <input type="text" name="outresult_edit" style="width:300px;" id="show7" value="" class="layui-input">
                </div>
              </div>
               <div class="kk" style="width:480px;padding-left:50px"> 
                <label class="layui-form-label" style="width:110px">住院号:</label>
                <div class="layui-input-inline" style="margin-top: 7px;">
					
	                  <input type="text" name="hnum_edit"  style="width:300px;" id="show8" value="" class="layui-input">
                </div>
              </div>
                <div class="kk" style="width:480px;padding-left:50px">
                <label class="layui-form-label" style="width:110px">病床号:</label>
                <div class="layui-input-inline" style="margin-top: 7px;">
					
	                  <input type="text" name="bnum_edit"  style="width:300px;" id="show9" value="" class="layui-input">
                </div>
              </div>
                <div class="kk" style="width:480px;padding-left:50px">
                <label class="layui-form-label" style="width:110px">治疗经过:</label>
                <div class="layui-input-inline" style="margin-top: 7px;">
					
	                  <input type="text" name="curepass_edit" style="width:300px;" id="show10"  value="" class="layui-input">
                </div>
              </div>
                <div class="kk" style="width:480px;padding-left:50px">
                <label class="layui-form-label" style="width:110px">主诉:</label>
                <div class="layui-input-inline" style="margin-top: 7px;">
					
	                  <input type="text" name="suit_edit" style="width:300px; " id="show11" value="" class="layui-input">
                </div>
              </div>
			<div class="kk" style="width:480px;padding-left:50px">
			           <label class="layui-form-label" style="width:110px">现病史:</label>
			           <div class="layui-input-inline" style="margin-top: 7px;">
						
				             <input id="show12" type="text" name="nowill_edit" style="width:300px;" value="" class="layui-input">
			           </div>
			</div>
			        <div class="kk" style="width:480px;padding-left:50px">
			           <label class="layui-form-label" style="width:110px">既往史:</label>
			           <div class="layui-input-inline "style="margin-top: 7px;">
						
				             <input id="show13" type="text" name="oldill_edit" style="width:300px;" value="" class="layui-input">
			           </div>
			         </div>
			         <div class="kk" style="width:480px;padding-left:50px">
			           <label class="layui-form-label" style="width:110px">婚姻史:</label>
			           <div class="layui-input-inline "style="margin-top: 7px;">
						  
				             <input id="show14" type="text" name="marriagehis_edit" style="width:300px;" class="layui-input">
			           </div>
			         </div>
			         <div class="kk" style="width:480px;padding-left:50px">
			           <label class="layui-form-label" style="width:110px">体格检查:</label>
			           <div class="layui-input-inline "style="margin-top: 7px;">
						 
				             <input id="show15" type="text" name="bodycheck_edit" style="width:300px;" class="layui-input">
			           </div>
			         </div>
			         <div class="kk" style="width:480px;padding-left:50px">
			           <label class="layui-form-label" style="width:110px">辅助检查:</label>
			           <div class="layui-input-inline "style="margin-top: 7px;">
						  
				             <input id="show16" type="text" name="othercheck_edit" style="width:300px;" class="layui-input">
			           </div>
			         </div>
			         <div class="layui-form-item layui-form-text" style="width:890px;padding-top:6px;padding-left:50px">
			           <label class="layui-form-label" style="width:110px">医护描述:</label>
			           <div class="layui-input-block " style="margin-top: 7px;">
						  
				             <textarea id="show17" name="describe_edit" style="" class="layui-textarea"></textarea>
			           </div>
			         </div>
			        
              
              
                
              <div class="layui-form-item">
                <div class="layui-input-block">
                	<button type="submit" class="layui-btn" lay-submit lay-filter="setmyinfo" style="width: 140px; margin-left:50px">修改</button>
                  <a class="layui-btn" lay-submit lay-filter="setmyinfo" style="width: 140px; margin-left:50px">返回</a>
                </div>
              </div>
			  
			</div>
			</div>
			</div> 
	  </form>
          </div>
