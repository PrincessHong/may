<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head lang="zh-CN">
<jsp:include page="lib.jsp"></jsp:include>
<title>京美心理测量忘记密码</title>
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
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">京美心理测量</a>
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

</body>
</html>
