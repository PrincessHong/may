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
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">
<title>主试</title>

<jsp:include page="../end-libs.jsp"></jsp:include>
<script>
	$(document).ready(function() {
		$('#ulpwd').focus(function() {
			$('#ulpwd').attr("type", "password");
		});
		$('#addUserForm').submit(function() {
			if ($('#uiden').val().length < 15) {
				alert("请输入格式正确的身份证号码");
				return false;
			}
		});
	});
</script>
</head>
<body class="easyui-layout">
	<jsp:include page="common.jsp"></jsp:include>
	<div data-options="region:'center',title:'',iconCls:'icon-ok'">

		<div class="user col-sm-10">
			<div style="height:30px"></div>
			<form id="addUserForm" action="manager/addUserAction.action"
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
							autocomplete="off"></td>
						<td>密码</td>
						<td><input type="text" class="form-control" id="ulpwd"
							name="u.ulpwd" autocomplete="off"></td>
					</tr>
					<tr>
						<td>主试ID</td>
						<td><input type="text" class="form-control" id="uid"
							name="u.uid" required></td>
						<td>主试姓名</td>
						<td><input type="text" class="form-control" id="uname"
							name="u.uname" required></td>
					</tr>
					<tr>
						<td>提示问题</td>
						<td><input type="text" class="form-control" id="uQue"
							name="u.uque" ></td>
						<td>答案</td>
						<td><input class="form-control" id="uAns"
							name="u.uans" ></td>
					</tr>
					<tr class="success">
						<td>身份证号码</td>
						<td><input type="text" class="form-control" id="uiden"
							name="u.uiden" ></td>
						<td>培训班</td>
						<td><div class="btn-group">
								<select id="disabledSelect" name="u.upei" class="form-control">
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
						<td rowspan="2" style="vertical-align:middle;text-align: center;">2:6-3:11岁记分服务总数</td>
						<td class="original"><span>可用</span> <input type="number"
							class="form-control" name="u.ucanuse" id="ucanuse"
							style="width:80px" required></td>
						<td rowspan="2" style="vertical-align:middle;text-align: center;">4:0-6:11岁记分服务总数</td>
						<td class="original"><span>可用</span> <input type="number"
							class="form-control" name="u.ucanuse4" id="ucanuse4"
							style="width:80px" required> </td>
					</tr>
					<tr>
					<td class="original">
					<span>增加</span> <input
							type="number" class="form-control" id="adduse" style="width:80px"
							name="adduse" value="0" disabled> <span>减少</span> <input
							type="number" class="form-control" name="reduce" id="reduce"
							style="width:80px" value="0" disabled>
					</td>
					<td class="original">
					<span>增加</span> <input
							type="number" class="form-control" id="adduse4"
							style="width:80px" name="adduse4" value="0" disabled> <span>减少</span>
							<input type="number" class="form-control" name="reduce4"
							id="reduce4" style="width:80px" value="0" disabled>
					</td>
					</tr>
					<tr>
						<td>备注</td>
						<td colspan="3"><textarea rows="3" class="form-control"
								id="ubei" name="u.ubei"></textarea></td>
					</tr>
					<tr class="success">
						<td>E-mail地址</td>
						<td><input type="email" class="form-control" id="email"
							name="u.uemail"></td>
						<td>联系电话</td>
						<td><input type="tel" class="form-control" id="tel"
							name="u.utel"></td>
					</tr>
					<tr class="success">
						<td>公司主页</td>
						<td><input type="text" class="form-control" id="ucom"
							name="u.ucom" type="text"></td>
						<td>单位名称</td>
						<td><input type="text" class="form-control" id="ucomadd"
							name="u.ucomadd"></td>
					</tr>
					<tr class="success">
						<td>性别</td>
						<td><select id="sex" name="u.usex" class="form-control"
							required>

								<option>无</option>
								<option value="男">男</option>
								<option value="女">女</option>
						</select>
						</td>
						<td>QQ</td>
						<td><input type="text" class="form-control" name="u.uqq">
						</td>
					</tr>
					<tr class="success">
						<td>认证</td>
						<td><select id="uren" name="u.uren" class="form-control"
							required>
								<option>无</option>
								<option value="未认证">未认证</option>
								<option value="已认证">已认证</option>
						</select>
						</td>
						<td>权限</td>
						<td><input type="text" class="form-control" name="u.uquan">
						</td>
					</tr>
					<tr class="success">
						<td>用户生日</td>
						<td><input type="number" class="form-control" name="u.ubir"
							placeholder="例：19991110"></td>
						<td>MSN</td>
						<td><input type="text" class="form-control" name="u.umsn"
							placeholder=""></td>
					</tr>
					<tr class="success">
						<td>IP</td>
						<td><input type="text" class="form-control" name="u.uip">
						</td>
						<td>ICQ</td>
						<td><input type="text" class="form-control" name="u.uicq">
						</td>
					</tr>
					<tr class="success">
						<td>个人说明</td>
						<td colspan="3"><textarea class="form-control" name="u.ustm"
								type="text" rows="3"></textarea></td>
					</tr>
					<tr>
						<td colspan="4">
							<button type="submit" class="btn btn-primary">保存</button>
							<button type="reset" class="btn btn-primary">重置</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>

</html>