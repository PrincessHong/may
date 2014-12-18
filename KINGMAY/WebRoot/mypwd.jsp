<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head lang="zh-CN">
<jsp:include page="lib.jsp"></jsp:include>
<title>京美心理测量忘记密码</title>
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

	<div class="container">
		<div class="forget-form">
			<h2>忘记密码</h2>
			<strong> 
 		</strong>
			<form id="forUpdatePwd" action="fgetChangePwdAction" method="post" role="form">
				<div class="form-group">
					<label for="name">新密码</label> <input type="password"
						class="form-control" id="newPwd" name="newPwd" required>
				</div>
				<div class="form-group">
					<label for="name">确认密码</label> <input type="password"
						class="form-control" id="rePwd" name="" required>
				</div>
				<s:hidden name="u.ulname"/>
				<button type="submit" id="loginSubmit" class="btn btn-default">提交</button>
				<button type="reset" class="btn btn-default">重置</button>
			</form>
			<div class="other-way">
				<p>如果您希望通过客服人员修复密码，请您和京美客户服务中心联系：</p>
				<p>
					<strong>密码重设专线：</strong>0756-3396889
				</p>
				<p style="color:red">温馨提醒:要通过密码提示问题重设密码,请确保您的电子邮箱之前已经正确填写！</p>
			</div>
		</div>
	</div>
	<script>
		$(document).ready (function() {
			$('#forUpdatePwd').submit (function() {
				if ($('#newPwd').val() === $('#rePwd').val()) {
					return true;
				} else {
					alert("两次密码输入不同");
					return false;
				}
			});
		});
	</script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
