<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.kingmay.db.DBCon" %>
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

<title>添加培训班</title>

<jsp:include page="../end-libs.jsp"></jsp:include>
</head>
<body class="easyui-layout">
	<jsp:include page="common.jsp"></jsp:include>
	<div data-options="region:'center',title:'',iconCls:'icon-ok'" class="centerLayout">
		<div class="user col-sm-4">
		<div style="height:30px"></div>
		<form action="manager/addPeiAction" method="post" class="form-horizontal"
			role="form">
			<div class="form-group">
				<label class="col-sm-4 control-label" for="pname">培训班名称</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="pname" name="p.pname"
						 required>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label" for="pstm">描述</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="pstm" name="p.pstm"
						placeholder="">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">父类</label>
				<div class="col-sm-8">
					<div class="btn-group">
						<select id="pparent" name="p.pparent" class="form-control"
							required>
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
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">类型</label>
				<div class="col-sm-8">
					<div class="btn-group">
						<select id="ptype" name="p.ptype" class="form-control" required>
							<option value="">请选择</option>
							<option value="0">省份</option>
							<option value="1">城市</option>
							<option value="2">培训班</option>
						</select>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">使用状态</label>
				<div class="col-sm-8">
					<div class="btn-group">
						<select id="pstate" name="p.pstate" class="form-control">
							<option value="">请选择</option>
							<option value="0">使用中</option>
							<option value="1">停用</option>
						</select>
					</div>
				</div>
			</div>
			<div class="form-group">
					<label class="col-sm-4 control-label">公告</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="pnotify"
							placeholder="" name="p.pnotify">
					</div>
				</div>
			<button class="btn btn-primary">提交</button>
		</form>
	</div>
	</div>
</body>

</html>
