 <%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head lang="zh-CN">
<jsp:include page="../lib.jsp"></jsp:include>
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
				<li><a href="#">收藏</a>
				</li>
			</ul>
		</div>
	</div>
	<!-- /.navbar-collapse --> </nav>
	<div style="height:60px"></div>

	<div id="main-content">
		<div class="container">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-4">
					<section>
					<div style="height:180px"></div>
					<img src="../images/logo.jpg" class="img-rounded"> 
					<img src="../images/w-logo-ch.png" class="img-w-logo">
					</section>
					
				</div>
				<div class="col-md-1"></div>
				<div class="col-md-6">
					<div class="col-md-6">
						<div style="height:70px"></div>
						<div align="center">
							<h2>
								<b>管理员登录</b>
							</h2>
						</div>
						<div style="height:30px"></div>
						<%
							if(request.getAttribute("msg")!=null){
								out.println(request.getAttribute("msg"));
							}
						%>
						<form id="loginForm" action="userLoginAction.action" method = "post" role="form">
							<div class="form-group">
								<label for="name">账户</label> <input type="text"
									class="form-control" id="name" name="u.ulname" placeholder="账户" required>
							</div>
							<div class="form-group">
								<label for="password">密码</label> <input
									type="password" class="form-control" id="password" name="u.ulpwd"
									placeholder="密码" required>
							</div>
							<button type="submit" id="loginSubmit" class="btn btn-default">登录</button>
							<button type="reset" class="btn btn-default">重置</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div style="height:90px"></div>
	
	<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
   	<div style="height:10px"></div> 
    <div align="center" style="color:#ce7621">
    	<h4>珠海市京美心理测量技术开发有限公司</h4>
    	king-may Psychological Assessment Technology & Development LTD.粤ICP备11040763号
    </div>
    <div style="height:10px"></div> 
   </nav>
   <script>
   		$('#loginSubmit').click(function(){
   			if( $('#name').val()!="" ){
   				$('#loginForm').submit();
   			} else {
   				alert("dsf");
   			}
   		});
   </script>
</body>
</html>
