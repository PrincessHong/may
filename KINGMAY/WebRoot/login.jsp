
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head lang="zh-CN">
<jsp:include page="lib.jsp"></jsp:include>
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
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="uservalidate.jsp">新主试激活</a></li>
				</ul>
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
						<b>用户登录</b>
					</h2>
				</div>
				<div style="height:25px"></div>
				<div class="row wronginfo">
					<div id="adminWrongShow" class="col-sm-8 pull-right">

						<%
					if (request.getAttribute("msg") != null) {
						out.println(request.getAttribute("msg"));
					}
				%>
					</div>
				</div>
				<form id="loginForm" action="userLoginAction.action" method="post"
					role="form" class="form-horizontal">
					<div class="form-group">
						<label for="name" class="col-sm-3">账户：</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="name" name="u.ulname"
								placeholder="请输入账户" required>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-3">密码：</label>
						<div class="col-sm-9">
							<input type="password" class="form-control" id="password"
								name="u.ulpwd" placeholder="请输入密码" required>
						</div>
					</div>
					<div class="form-group">
						<label for="validateCode" class="col-sm-3">验证码：</label>
						<div class=" col-sm-5 ">
							<input type="text" class="form-control"
								id="validateCode" name="validataCode" placeholder="请输入验证码" required>
						</div>
						<div class="col-sm-4">
							<a href="javascript:void(0)" title="点击刷新验证码"
								onclick="refreshCode()" id="validataCode" class="pull-right"><img
								style="width:90px; height: 30px;border:1px silver solid;"
								src="randomCode"> </a>
						</div>
					</div>
					<div class="form-group">
					  <div class="col-md-3"></div>
						<div class="col-md-6">
							<button type="submit" id="loginSubmit" class="btn btn-default">登录</button>
							<a href="goforget.jsp">忘记密码</a>
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
