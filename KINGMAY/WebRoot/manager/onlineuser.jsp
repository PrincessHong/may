<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
				<th>#</th>
				<th>登录名</th>
				<th>主试姓名</th>
				<th>时间</th>
				<th>所在页面</th>
			</tr>
			<%
				int id = 0;
			%>
			<s:iterator value="onlineUserList" id="user" status="st">
				<tr>
					<td>
						<%
							out.print(++id);
						%>
					</td>
					<td>${user.ulName }</td>
					<td>${user.uName}</td>
					<td>${user.loginTime }</td>
					<td></td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>
