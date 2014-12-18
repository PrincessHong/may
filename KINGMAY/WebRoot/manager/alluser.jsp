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
<title>主试列表</title>

<jsp:include page="../end-libs.jsp"></jsp:include>
</head>
<body class="easyui-layout">
	<jsp:include page="common.jsp"></jsp:include>
	<div data-options="region:'center',title:'',iconCls:'icon-ok'"
		class="centerLayout">
		<div class="userinfo">
			<div style="height:10px"></div>
			<div class="toolbar">
				<a href="manager/allUserAction.action" class="btn btn-info "
					role="button">刷新列表</a>
			</div>
			<div style="height:10px"></div>
			<table class="table table-striped  table-hover">
				<tr>
					<th>主试编号</th>
					<th>主试姓名</th>
					<th>登录名</th>
					<th>总记分册</th>
					<th>已用记分册</th>
					<th>剩余记分册</th>
					<th>激活状态</th>
					<th>操作</th>
				</tr>
				<s:iterator value="userlist" id="user" status="st">
					<tr>
						<td align="left" style="width:120px; height: 21px;"
							valign="middle">${user.uid}</td>
						<td>${user.uname }</td>
						<td>${user.ulname}</td>
						<td>${user.ucanuse }</td>
						<td>${user.uused }</td>
						<td>${user.ucanuse- user.uused}</td>
						<td>${user.uren }</td>
						<td width="120px">
							<button type="button" class="btn btn-primary btn-xs"
								onclick="goadminuser('${user.uid }')">编辑</button>
							<button type="button" class="btn btn-primary btn-xs"
								onclick="deluser('${user.uid}')">删除</button>
						</td>
					</tr>
				</s:iterator>
			</table>
			<div class="page">
				[<a href="manager/allUserAction.action?pageNo=1">首页</a>]
				<c:choose>
					<c:when test="${currentPage>1}">
					[<a href="manager/allUserAction.action?pageNo=${currentPage-1}">上一页</a>]
				</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${currentPage<totalPage}">
					[<a href="manager/allUserAction.action?pageNo=${currentPage+1}">下一页</a>]
				</c:when>
				</c:choose>
				[<a href="manager/allUserAction.action?pageNo=${totalPage}">尾页</a>]
			</div>
		</div>

	</div>
</body>

</html>