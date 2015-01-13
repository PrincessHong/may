<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<jsp:include page="lib.jsp"></jsp:include>
<title>京美心理测量新主试激活</title>
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

	<div style="height:70px"></div>

	<div id="data-content">
		<div class="row">

			<h2 class="center">新主试激活</h2>
			<div class="col-md-2"></div>
			<div class="col-md-6">
				<form class="form-horizontal" role="form"
					action="userValidateAction" method="post" id="userValidate">
					<div class="form-group">
						<label class="col-sm-5 control-label" for="userName">登录名</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="u.ulname"
								id="userName" required>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-8">
							<button type="button" onclick="checkUserName()"
								class="btn btn-danger pull-right">检测用户名</button>
						</div>
						<div class="col-sm-4">
							<label id="usernameSucceed" class="success control-label hide">用户名检测成功！</label>
							<label id="usernameError" class="error control-label hide">用户名已存在！</label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label" for="uid">主试编号</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="u.uid" id="uid"
								required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label" for="uname">姓名</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="u.uname" id="uname"
								required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label" for="uiden">身份证</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="u.uiden" id="uiden"
								required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label" for="uemail">邮箱</label>
						<div class="col-sm-7">
							<input type="email" class="form-control" name="u.uemail"
								id="uemail" required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label" for="ulpwd">密码</label>
						<div class="col-sm-7">
							<input type="password" class="form-control " id="ulpwd"
								name="u.ulpwd" maxlength="16" required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label" for="regpwd">确认密码</label>
						<div class="col-sm-7">
							<input type="password" class="form-control" id="regpwd"
								name="regpwd" required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label" for="uque">问题</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="u.uque" id="uque"
								required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label" for="uans">答案</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="u.uans" id="uans"
								required>
						</div>
					</div>
					<div align="right">
						<button type="submit" class="btn btn-primary">提交</button>
						<button type="reset" class="btn btn-primary">重置</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<div style="height:45px"></div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">
		function checkUserName() {
			var userName = $("#userName").val();
			var parms = {
				"userName" : userName
			};
			var url = "checkUserNameAction";
			$.post(url, parms, function(data) {
				if (data) {
					if (data == "true") {
						$("#userName").addClass("wrong");
						$('#usernameError').removeClass('hide');
						$('#usernameSucceed').addClass('hide');
						return false;
					} else {
						$("#userName").removeClass("wrong");
						$('#usernameSucceed').removeClass('hide');
						$('#usernameError').addClass('hide');
					}
				}
			});
		}
		$('#userValidate').submit(function() {
			var isWrong = false;
			if (!($('#ulpwd').val() === $('#regpwd').val())) {
				alert("两次密码输入不同");
				isWrong = true;
			}
			if (isWrong) {
				$('#ulpwd').addClass('wrong');
				$('#regpwd').addClass('wrong');
				return false;
			} else if($('#usernameError').hasClass('hide')){
				return true;
			} else {
			  alert("请重新填写用户名！");
		    return false;
		  }
		});
	</script>
</body>


</html>
