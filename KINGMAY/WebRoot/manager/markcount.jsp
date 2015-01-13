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
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">
<title>主试</title>

<jsp:include page="../end-libs.jsp"></jsp:include>
</head>
<body class="easyui-layout">
	<jsp:include page="common.jsp"></jsp:include>
	<div data-options="region:'center',title:'',iconCls:'icon-ok'">
		<table class="table table-hover">
			<tr>
				<th>编号</th>
				<th>操作描述</th>
				<th>操作时间</th>
				<th>登录IP</th>
			</tr>
			<s:iterator value="markCountList" id="mk" status="st">
				<tr>
					<td>${mk.uid}</td>
					<td>${mk.mcontent}</td>
					<td>${mk.mtime}</td>
					<td>${mk.mip}</td>
				</tr>
			</s:iterator>
		</table>

		<nav>
			<ul class="pager">
				<li><a href="manager/showMarkCountAction.action?pageNomk=1">首页</a>
				</li>
				<c:choose>
					<c:when test="${currentPagemk>1}">
						<li><a
							href="manager/showMarkCountAction.action?pageNomk=${currentPagemk-1}">上一页</a>
						</li>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${currentPagemk<totalPagemk}">
						<li><a
							href="manager/showMarkCountAction.action?pageNomk=${currentPagemk+1}">下一页</a>
						</li>
					</c:when>
				</c:choose>
				<li><a
					href="manager/showMarkCountAction.action?pageNomk=${totalPagemk}">尾页</a>
				</li>
			</ul>
		</nav>
	</div>
</body>
</html>
