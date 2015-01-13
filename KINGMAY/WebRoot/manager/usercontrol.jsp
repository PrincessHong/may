<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head lang="zh-CN">
<base href="<%=basePath%>">
<title>主试</title>

<jsp:include page="../end-libs.jsp"></jsp:include>
</head>
<body class="easyui-layout">
	<jsp:include page="common.jsp"></jsp:include>
	<div data-options="region:'center',title:'',iconCls:'icon-ok'">
		<table class="table table-hover">
			<tr>
				<th>操作分类</th>
				<th>操作描述</th>
				<th>操作时间</th>
				<th>登录IP</th>
			</tr>
			<s:iterator value="userControlList" id="uc" status="st">
				<tr>
					<td>${uc.ccontrol }</td>
					<td>${uc.ccontent}</td>
					<td>${uc.ctime }</td>
					<td>${uc.cip }</td>
				</tr>
			</s:iterator>
		</table>
		<div class="center">
			[<a href="manager/showControlAction.action?pageNouc=1">首页</a>]
			<c:choose>
				<c:when test="${currentPageuc>1}">
					[<a
						href="manager/showControlAction.action?pageNouc=${currentPageuc-1}">上一页</a>]
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${currentPageuc<totalPageuc}">
					[<a
						href="manager/showControlAction.action?pageNouc=${currentPageuc+1}">下一页</a>]
				</c:when>
			</c:choose>
			[<a href="manager/showControlAction.action?pageNouc=${totalPageuc}">尾页</a>]
		</div>
	</div>
</body>
</html>
