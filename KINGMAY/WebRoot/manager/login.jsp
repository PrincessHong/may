<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page language="java" import="com.kingmay.utils.ValidataCode"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>京美心理测量管理员登录</title>
<base href="<%=basePath%>">
<jsp:include page="../end-libs.jsp"></jsp:include>
<style>
.img-w-logo {
	width: 288px;
	height: 92px;
	padding-top: 10px;
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
	<div style="height:60px"></div>

	<div id="main-content">
		<div class="login-container">
			<div class="login-left pull-left">
				<section>
					<div style="height:180px"></div>
					<img src="images/logo.jpg" class="img-rounded"> <img
						src="images/w-logo-ch.png" class="img-w-logo">
				</section>
			</div>
			<div class="login-right pull-right">
				<div style="height:70px"></div>
				<div align="center">
					<h2>
						<b>管理员登录</b>
					</h2>
				</div>
				<div style="height:25px"></div>
				<div class="row wronginfo">
					<div id="adminWrongShow" class="col-sm-9 pull-right">
						<%
							if (request.getAttribute("msg") != null) {
								out.println(request.getAttribute("msg"));
							}
						%>
					</div>
				</div>
				<form action="manager/adminLoginAction" method="post" role="form"
					class="form-horizontal">
					<div class="form-group">
						<label for="managerName" class="col-sm-3">账户:</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="aa.aname"
								id="managerName" required placeholder="请输入账户">
						</div>
					</div>

					<div class="form-group">
						<label for="manPwd" class="col-sm-3">密码:</label>
						<div class="col-sm-9">
							<input type="password" class="form-control col-sm-9"
								name="aa.apwd" id="manPwd" placeholder="请输入密码" required>
						</div>
					</div>
					<div class="form-group">
						<label for="manPwd" class="col-sm-3">验证码:</label>
						<div class="col-sm-5">
							<input type="text" placeholder="请输入验证码" name="validataCode"
								id="validataCode" class="form-control" />
						</div>
						<div class="col-sm-4">
							<a href="javascript:void(0)" title="点击刷新验证码"
								onclick="refreshCode()" id="validataCode"> <img
								style="width:90px; height: 30px;border:1px silver solid;"
								src="randomCode"> </a>
						</div>
					</div>
					<div class="form-group">
						<div class="pull-right">
							<button type="submit" class="btn btn-default">登录</button>
							<button type="reset" class="btn btn-default">重置</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div style="height:90px"></div>

	<nav class="navbar navbar-default navbar-fixed-bottom"
		role="navigation">
		<div style="height:10px"></div>
		<div align="center" style="color:#ce7621">
			<h4>珠海市京美心理测量技术开发有限公司</h4>
			king-may Psychological Assessment Technology & Development
			LTD.粤ICP备11040763号
		</div>
		<div style="height:10px"></div>
	</nav>
	<script src="js/common.js"></script>

</body>
</html>
