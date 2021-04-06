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
<!--工作域-->
<div class="work_space">
	
	<jsp:include page="SearchMedical.jsp" flush="true"></jsp:include>
		
	<!--小标题-->
	<nav style="padding-bottom: 10px;">
		<a style="display: inline-block;font-size: 25px;font-weight: 700;color: dodgerblue;z-index: 10;">
			患者信息：
		</a>
		<!-- 添加按钮  -->
		<button type="button" class="btn btn-outline-primary float-right mr-3" data-toggle="modal" data-target="#exampleModal">
		  添加病历
		</button>
	</nav>
	<!--表格-->
	<div class="container">
		<table class="table table-hover" style="margin-top: 20px;">
			<thead>
				<tr align="center">
					<th scope="col">病历号</th>
					<th scope="col">患者编号</th>
					<th scope="col">患者姓名</th>
					<th scope="col">主治医生</th>
					<th scope="col">医生编号</th>
					<th scope="col">科室</th>
					<th scope="col">Operation</th>
				</tr>
			</thead>
				
			<c:forEach items="${requestScope.medicalList}" var="userItem" varStatus="varstatus">
				<tbody>
					<tr align="center">
					    <td align="center">${userItem.mid}</td>
						<td align="center">${userItem.pid}</td>
						<td align="center">${userItem.pname}</td>
						<td align="center">${userItem.dname}</td>
						<td align="center">${userItem.id}</td>
						<td align="center">${userItem.droom}</td>													
						<td class="d-flex ">
						<a class="btn btn-primary btn-sm mr-1" href="EditServlet_Medical?mid_edit=${userItem.mid}">编辑</a>
						<a class="btn btn-primary btn-sm ml-1 mr-0 delete" data-toggle="modal" data-target="#DeleteWorring" style="color: white;" date="${userItem.mid}">删除</a>
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
			<!--上一页  -->
				<c:if test="${page.currentPage > 1 }">
			    <li class="page-item">
					<a class="page-link" href="<c:url value='/TabChangeServlet?show=medicalManager&currentPage=${page.currentPage - 1 }'/>">Previous</a>
				</li>	
				</c:if>
			<!--  中间页-->
				<c:choose>
			        <c:when test="${page.totalPage <= 10 }">
			            <c:set var="begin" value="1"/>
			            <c:set var="end" value="${page.totalPage }"/>
			        </c:when>
			        <c:otherwise>
			            <c:set var="begin" value="${page.currentPage-4 }"/>
			            <c:set var="end" value="${page.currentPage+5 }"/>
			            <c:choose>
			                <c:when test="${begin < 1 }">
			                    <c:set var="begin" value="1"/>
			                    <c:set var="end" value="10"/>
			                </c:when>
			                <c:when test="${end > page.totalPage }">
			                    <c:set var="begin" value="${page.totalPage-9 }"/>
			                    <c:set var="end" value="${page.totalPage }"/>
			                </c:when>
			            </c:choose>
			        </c:otherwise>
			    </c:choose>
			    
			    <c:forEach begin="${begin}" end="${end}" var="i">
			        <c:choose>
			
			            <c:when test="${i == page.currentPage}"><a class="page-link">${i}</a></c:when>
			
			            <c:otherwise>
			                    <li class="page-item">
									<a class="page-link" href="<c:url value='/TabChangeServlet?show=medicalManager&currentPage=${i}'/>">${i}</a>
								</li>										
			            </c:otherwise>
			        </c:choose>
			    </c:forEach>
			    
			    <c:if test="${page.currentPage < page.totalPage }">
			    	<li class="page-item">
						<a class="page-link" href="<c:url value='/TabChangeServlet?show=medicalManager&currentPage=${page.currentPage + 1 }'/>">Next</a>
					</li>
			    </c:if>
			</ul>
		</nav>
	</div>
</div>
