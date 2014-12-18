<%@page import="com.kingmay.beans.Pei"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head lang="zh-CN">
<title>培训班列表</title>
<base href="<%=basePath%>">
<jsp:include page="../end-libs.jsp"></jsp:include>
</head>

<script type="text/javascript">
	$(function() {
		$('tr.parent1').click(function() {
			$(this).toggleClass("selected");		  
			$(this).siblings('.child' + this.id).toggle();
		}).click();
		$('.parent').css('background', '#BCDEE9');
	});
	
</script>

<style type="text/css">
.parent1 {
	background: #E3F3F9
}

.parent1.selected {
	background: #65A3E0
}
</style>
<body class="easyui-layout">
	<jsp:include page="common.jsp"></jsp:include>
	<div data-options="region:'center',title:'',iconCls:'icon-ok'"
		class="centerLayout">
		<br>
		<div class="userinfo">
			<div style="height:10px"></div>
			<div class="toolbar">
				<a href="manager/peiAction.action" class="btn btn-info "
					role="button">刷新列表</a>
			</div>
			<div style="height:10px"></div>
			<table class="table table-hover">
				<tr>
					<th style="width:150px; height: 21px;" scope="col">培训班地区</th>
					<th style="width:200px; height: 21px;" scope="col">操作</th>
				</tr>
				<% int child=0; %>
				<c:forEach items="${peilist}" var="pei">
					<c:choose>
						<c:when test="${pei.ptype == 1}">
							<tr class="parent1" id=<%=++child %>>
								<td>--${pei.pname }</td>
								<td width="120px">
									<button type="button" class="btn btn-warning btn-xs" onclick="goadminpei('${pei.pname }')">编辑</button>
									<button type="button" class="btn btn-warning btn-xs" onclick="delpei('${pei.pname}')">删除</button>
								</td>
							</tr>
						</c:when>
						<c:when test="${pei.ptype == 2}">
							<tr class="child<%=child %>" >
								<td>----${pei.pname }</td>
								<td width="120px">
									<button type="button" class="btn btn-default btn-xs" onclick="goadminpei('${pei.pname }')">编辑</button>
									<button type="button" class="btn btn-default btn-xs" onclick="delpei('${pei.pname}')">删除</button>
								</td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr class="parent">
								<td>${pei.pname }</td>
								<td width="120px">
									<button type="button" class="btn btn-primary btn-xs" onclick="goadminpei('${pei.pname }')">编辑</button>
									<button type="button" class="btn btn-primary btn-xs" onclick="delpei('${pei.pname}')">删除</button>
								</td>
							</tr>
  					</c:otherwise>
					</c:choose>

				</c:forEach>

			</table>
		</div>
	</div>
</body>
</html>
