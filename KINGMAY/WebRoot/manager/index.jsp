<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<title>京美心理测量-管理员后台</title>
<jsp:include page="../end-libs.jsp"></jsp:include>
</head>

<body class="easyui-layout">
	<jsp:include page="common.jsp"></jsp:include>
	<div data-options="region:'center',title:'',iconCls:'icon-ok'" class="centerLayout">	
		<div style="padding-left:100px;padding-top:100px">
			<h1>京美心理测量-管理员后台</h1>
		</div>
	</div>
</body>
</html>
