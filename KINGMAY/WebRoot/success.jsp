<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<htm llang="zh-CN">
<head>
<jsp:include page="lib.jsp"></jsp:include>
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
	padding-top: 150px;
	padding-bottom: 270px;
	text-align: center;
	font-size: 25px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">aToggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">京美心理测评</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="getThisChildAction.action">记分首页</a>
					</li>
					<li class="dropdown"><a href="child.jsp"
						class="dropdown-toggle" data-toggle="dropdown">数据录入 <span
							class="caret"></span> </a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="child.jsp">2:6-3:11</a>
							</li>
							<li class="divider">el</li>
							<li><a href="child4.jsp">4:0-6:11</a>
							</li>
						</ul>
					</li>
					<li><a href="goChangeInfoAction">信息维护</a>
					</li>
					<li><a href="userLogoutAction.action">退出</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="return">
	<span>操作成功，</span>
	<span id="jumpTo">5</span>秒后自动跳转到
	<a href="getThisChildAction.action">首页</a>
	</div>
	<script type="text/javascript">
		countDown(5, 'getThisChildAction.action');
	</script>

	<jsp:include page="footer.jsp"></jsp:include>
	<script src="js/checkdate.js"></script>
</body>
</html>
