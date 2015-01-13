<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
<title>主试</title>

<jsp:include page="../end-libs.jsp"></jsp:include>
</head>
<body class="easyui-layout">
	<jsp:include page="common.jsp"></jsp:include>
	<div data-options="region:'center',title:'',iconCls:'icon-ok'">

		<div class="col-md-4">

			<h3 class="center">修改密码</h3>
			<br />
			<div class="row wronginfo">
				<div id="adminWrongShow" class="col-sm-8 pull-right">
					<p> <%
				 	if (request.getAttribute("msg_a") != null) {
 						out.println(request.getAttribute("msg_a"));
 					}
				 %> </p>
				</div>
			</div>
			<form action="manager/goAdminChangePwdAction" method="post"
				class="form-horizontal" role="form" id="adminChangePassword">
				<div id="formAdminOldpwd" class="form-group">
					<label class="col-sm-4 control-label" for="oldpwd">旧密码</label>
					<div class="col-sm-8">
						<input type="password" class="form-control" id="oldpwd"
							name="oldpwd" required>
					</div>
				</div>
				<div id="formAdminNewpwd" class="form-group">
					<label class="col-sm-4 control-label" for="newpwd">新密码</label>
					<div class="col-sm-8">
						<input type="password" class="form-control" id="newpwd"
							name="newpwd" onchange="javascript:EvalPwd(this.value);"
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
				<div id="formAdminRegpwd" class="form-group">
					<label class="col-sm-4 control-label" for="regpwd">确认密码</label>
					<div class="col-sm-8">
						<input type="password" class=" form-control" id="regpwd"
							name="regpwd" required>
					</div>
				</div>
				<div class="pull-right clearfix">
					<button type="submit" class="btn btn-primary">提交</button>
					<button type="reset" class="btn btn-primary">重置</button>
				</div>
			</form>
		</div>
	</div>
	<script src="js/checkpwd.js"></script>
	<script>
	  
		$("#adminChangePassword").submit(function() {
			var isWrong = false;
			if ($('#newpwd').val().length < 6) {
			  alert("密码长度不得小于 6");
				isWrong = true;
			} else if ($('#newpwd').val().length > 16) {
				alert("密码长度不得大于 16");
				$('#newpwd').attr('value', '');
				isWrong = true;
			}
			if (!($('#newpwd').val() === $('#regpwd').val())) {
				alert("两次密码输入不同");
				isWrong = true;
			}
			
			if (isWrong) {
				$('#newpwd').addClass('wrong');
			  $('#regpwd').addClass('wrong');
				return false;
			} else {
				return true;
			}
			return true;
		});
	</script>
</body>
</html>
