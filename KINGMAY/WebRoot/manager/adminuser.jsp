<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.kingmay.db.DBCon"%>
<%@ page language="java" import="com.kingmay.beans.*"%>

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

		<div class="user col-sm-10">
			<div style="height:30px"></div>
			<form id="adminUserForm" action="manager/adminUserAction"
				method="post" class="form-horizontal" role="form">
				<table class="table table-bordered table-condensed">
					<tr>
						<th style="width:100px">名称</th>
						<th style="width:300px">输入</th>
						<th style="width:100px">名称</th>
						<th style="width:300px">输入</th>
					</tr>
					<tr>
						<td>登录名</td>
						<td><input type="text" class="form-control" name="u.ulname"
							value="${u.ulname }" autocomplete="off" required></td>
						<td>密码</td>
						<td><input type="text" class="form-control" id="ulpwd"
							name="u.ulpwd" autocomplete="off"> <input type="hidden"
							id="oldPwd" name="oldPwd" value="${u.ulpwd }"></td>
					</tr>
					<tr>
						<td>主试ID</td>
						<td><input type="text" class="form-control" id="uid"
							name="u.uid" value="${u.uid }" required></td>
						<td>主试姓名</td>
						<td><input type="text" class="form-control" id="uname"
							name="u.uname" value="${u.uname }" required></td>
					</tr>
					<tr>
						<td>提示问题</td>
						<td><input type="text" class="form-control" id="uQue"
							name="u.uque" value="${u.uque }" required></td>
						<td>答案</td>
						<td><input type="text" class="form-control" id="uAns"
							name="u.uans" value="${u.uans }" required></td>
					</tr>
					<tr class="success">
						<td>身份证号码</td>
						<td><input type="text" class="form-control" id="uiden"
							name="u.uiden" value="${u.uiden }" required></td>
						<td>培训班</td>
						<td><div class="btn-group">
								<select id="disabledSelect" name="u.upei" class="form-control">
									<option value="${u.upei }">${u.upei }</option>
									<option value="无">无</option>
									<%
										List<Map<String, String>> l = DBCon.queryallpei();
																	if (l == null) {
																		l = new ArrayList<Map<String, String>>();
																	}
																	for (Map<String, String> s : l) {
																		String ss = s.get("name");
																		if (s.get("type").toString().equals("1")) {
									%>
									<option value=<%=ss%>>
										-<%=ss%></option>
									<%
										} else if (s.get("type").toString().equals("2")) {
									%>
									<option value=<%=ss%>>
										--<%=ss%></option>
									<%
										} else {
									%>
									<option value=<%=ss%>><%=ss%></option>
									<%
										}
																	}
									%>
								</select>

							</div>
						</td>
					</tr>
					<tr>
						<td>原版记分服务总数</td>
						<td class="original"><input type="number"
							class="form-control" name="u.ucanuse" id="ucanuse"
							style="width:88px" value="${u.ucanuse }" disabled> <span>增加</span>
							<input type="number" class="form-control" id="adduse"
							style="width:88px" name="adduse" value="0" required> <span>减少</span>
							<input type="number" class="form-control" name="u.uused"
							id="uused" style="width:95px" value="${u.uused }" disabled>
						</td>
						<td>备注</td>
						<td><textarea rows="2" class="form-control" id="ubei"
								name="u.ubei">${u.ubei }</textarea></td>
					</tr>
					<tr class="success">
						<td>E-mail地址</td>
						<td><input type="email" class="form-control" id="email"
							name="u.uemail" value="${u.uemail }"></td>
						<td>联系电话</td>
						<td><input type="tel" class="form-control" id="tel"
							name="u.utel" value="${u.utel }"></td>
					</tr>
					<tr class="success">
						<td>公司主页</td>
						<td><input type="text" class="form-control" id="ucom"
							name="u.ucom" type="text" value="${u.ucom }"></td>
						<td>单位名称</td>
						<td><input type="text" class="form-control" id="ucomadd"
							name="u.ucomadd" value="${u.ucomadd }"></td>
					</tr>
					<tr class="success">
						<td>性别</td>
						<td><select id="sex" name="u.usex" class="form-control"
							required>
								<option value="${u.usex }">${u.usex }</option>
								<option>无</option>
								<option value="男">男</option>
								<option value="女">女</option>
						</select>
						</td>
						<td>QQ</td>
						<td><input type="text" class="form-control" name="u.uqq"
							value="${u.uqq }"></td>
					</tr>
					<tr class="success">
						<td>认证</td>
						<td><select id="uren" name="u.uren" class="form-control"
							required>
								<option value="${u.uren }">${u.uren }</option>
								<option>无</option>
								<option value="未认证">未认证</option>
								<option value="已认证">已认证</option>
						</select>
						</td>
						<td>权限</td>
						<td><input type="text" class="form-control" name="u.uquan"
							value="${u.uquan }"></td>
					</tr>
					<tr class="success">
						<td>用户生日</td>
						<td><input type="number" class="form-control" name="u.ubir"
							placeholder="例：19991110" value="${u.ubir }"></td>
						<td>MSN</td>
						<td><input type="text" class="form-control" name="u.umsn"
							value="${u.umsn }" placeholder=""></td>
					</tr>
					<tr class="success">
						<td>IP</td>
						<td><input type="text" class="form-control" name="u.uip"
							value="${u.uip }"></td>
						<td>ICQ</td>
						<td><input type="text" class="form-control" name="u.uicq"
							value="${u.uicq }"></td>
					</tr>
					<tr class="success">
						<td>个人说明</td>
						<td colspan="3"><textarea class="form-control" name="u.ustm"
								type="text" rows="3">${u.ustm }</textarea></td>
					</tr>
					<tr>
						<td colspan="4">
							<button type="submit" class="btn btn-primary">保存</button>
							<button type="reset" class="btn btn-primary">重置</button></td>
					</tr>
				</table>
				<s:hidden name="u.ucanuse"/>
			</form>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$('#ulpwd').focus(function() {
				$('#ulpwd').attr("type", "password");
			});
			$('#adminUserForm').submit(function() {
				if ($('#ulpwd').val() === null || $('#ulpwd').val() === "") {
				  $('#ulpwd').attr('type','password');
					$('#ulpwd').attr('value',$('#oldPwd').val());
				};
				if ($('#uiden').val().length < 15) {
					alert("请输入格式正确的身份证号码");
					return false;
				}
			});
		});
	</script>
</body>

</html>