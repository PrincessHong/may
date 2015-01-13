<%@ page language="java" import="java.util.*" pageEncoding="Utf-8"%>
<%@ page language="java" import="com.kingmay.beans.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	User u = new User();
	u = (User) session.getAttribute("user");
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<jsp:include page="lib.jsp"></jsp:include>
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
							<li><a href="child.jsp">2:6-3:11</a></li>
							<li class="divider">el</li>
							<li><a href="child4.jsp">4:0-6:11</a></li>
						</ul></li>
					<li class="active"><a href="goChangeInfoAction">信息维护</a>
					</li>
					<li><a href="userLogoutAction.action">退出</a>
					</li>
				</ul>
			</div>
		</div>

	</nav>
	<div style="height:70px"></div>

	<div id="main-content">
		<div class="container">

			<a href="goChangeInfoAction" class="btn btn-link " id="btn_info">个人资料</a> \
			<a href="changepwd.jsp" class="btn btn-link" id="btn_chpwd">修改密码</a>

			<div class="row" id="chpwd">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<div align="center">
						<h3>
							<b>修改密码</b><br />
						</h3>
					</div>
					<br />
					<div class="row wronginfo">
						<div class="col-sm-7 pull-right">
							<s:fielderror>
								<s:param>pwd</s:param>
								<s:param>pwd1 </s:param>
								<s:param>pwd2 </s:param>
							</s:fielderror>
						</div>
					</div>
					<form class="form-horizontal" role="form"
						action="userChangePwdAction.action" method="post"
						id="changePassword">
						<div class="form-group">
							<label class="col-sm-5 control-label" for="oldPwd">旧密码</label>
							<div class="col-sm-7">
								<input type="password" class="form-control" id="oldPwd"
									name="pwd" placeholder="旧密码" required>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label" for="newPwd">新密码</label>
							<div class="col-sm-7">
								<input type="password" class="form-control " id="newPwd"
									name="pwd1" maxlength="16"
									onchange="javascript:EvalPwd(this.value);"
									onkeyup="javascript:EvalPwd(this.value);"
									placeholder="(密码长度应在6~16间)" required>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-7 pull-right">
								<table cellpadding="0" cellspacing="0" border="0" id="pwdpower">
									<tr>
										<td id="pweak" style="">弱</td>
										<td id="pmedium" style="">中</td>
										<td id="pstrong" style="">强</td>
									</tr>
								</table>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label" for="exampleInputPassword3">确认密码</label>
							<div class="col-sm-7">
								<input type="password" class="form-control" id="rePwd"
									name="pwd2" placeholder="确认密码" required>
							</div>
						</div>
						<div align="right">
							<button type="submit" class="btn btn-primary">确认修改</button>
						</div>
					</form>
					<br />
					<div class="row wronginfo">
						<div class="col-sm-7 pull-right">
							<s:fielderror>
								<s:param>ans</s:param>
								<s:param>ans1 </s:param>
								<s:param>que </s:param>
							</s:fielderror>
						</div>
					</div>
					<form class="form-horizontal" id="changeQue" role="form"
						action="userChangeQueAction.action" method="post">
						<div class="form-group">
							<label class="col-sm-5 control-label">问题</label>
							<div class="col-sm-7">
								<p class="form-control-static"><%=u.getUque()%></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label" for="ans">答案</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="ans" name="ans"
									placeholder="请输入旧提示问题答案" required>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label" for="que">新问题</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="que" name="que"
									placeholder="新问题" required>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label" for="ans1">新答案</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="ans1" name="ans1"
									placeholder="请输入新答案" required>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label" for="reAns">确认答案</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="reAns" name="reAns"
									placeholder="请再次输入问题答案" required>
							</div>
						</div>
						<div align="right">
							<button type="submit" class="btn btn-primary">确认修改</button>
						</div>
					</form>
				</div>
				<div class="col-md-3"></div>
			</div>
			<div style="height:5px"></div>
		</div>
	</div>
	<div style="height:30px"></div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script src="js/checkpwd.js"></script>
	<script>
		$("#changePassword").submit(function() {

			if ($('#newPwd').val().length < 6) {
				alert("密码长度不改小于6");
				return false;
			}
			if ($('#newPwd').val() === $('#rePwd').val()) {
				return true;
			} else {
				alert("两次密码输入不同");
				return false;
			}
		});

		$("#changeQue").submit(function() {
			if ($('#ans1').val() === $('#reAns').val()) {
				return true;
			} else {
				console.log($('#ans1').val() + " " + $('#reAns').val());
				alert('两次答案输入不同');
				return false;
			}
		});
	</script>
</body>
</html>
