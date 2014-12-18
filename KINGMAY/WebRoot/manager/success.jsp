<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<title>操作成功</title>
<jsp:include page="../end-libs.jsp"></jsp:include>
<script type="text/javascript">
	function countDown(secs, surl) {    
		var jumpTo = document.getElementById('jumpTo');
		jumpTo.innerHTML = secs;
		if (--secs > 0) {
			setTimeout("countDown(" + secs + ",'" + surl + "')", 1000);
		} else {
			location.href = surl;
		}
	}
</script>
<style>
.return {
	padding-top: 100px;
	padding-left: 100px;
}
</style>
</head>

<body class="easyui-layout">
	<jsp:include page="common.jsp"></jsp:include>
	<div data-options="region:'center',title:'',iconCls:'icon-ok'"
		class="centerLayout">
		<div class="return">
		  <span>操作成功，</span>
			<span id="jumpTo">5</span>秒后自动跳转到<a href="manager/superadmin.jsp">首页</a>
			<script type="text/javascript">
				countDown(5, 'manager/superadmin.jsp');
			</script>
		</div>
	</div>
</body>
</html>
