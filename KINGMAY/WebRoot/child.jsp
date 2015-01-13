<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head lang="zh-CN">
<jsp:include page="lib.jsp"></jsp:include>
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">aToggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">京美心理测评</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="getThisChildAction.action">记分首页</a></li>
					<li class="dropdown active"><a href="child.jsp"
						class="dropdown-toggle" data-toggle="dropdown">数据录入 <span
							class="caret"></span> </a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="child.jsp">2:6-3:11</a></li>
							<li class="divider">el</li>
							<li><a href="child4.jsp">4:0-6:11</a></li>
						</ul></li>
					<li><a href="goChangeInfoAction">信息维护</a></li>
					<li><a href="userLogoutAction.action">退出</a></li>
				</ul>
			</div>
		</div>
	</nav>


	<div id="data-content">
		<div class="row">
			<form id="childInfoForm" action="addChildAction.action" method="post"
				class="form-horizontal" role="form">
				<div id="basic-info" class="row">
					<div class="edition">
						<img class="w-logo-ch" src="images/w-logo-ch.png" alt="logo">
						<h1>2:6-3:11</h1>
						<ul class="nav nav-tabs line pull-right" role="tablist">
							<li role="presentation" class="active"><a href="child.jsp">儿童资料</a>
							</li>
							<li role="presentation"><a href="data.jsp">原始分数</a></li>
						</ul>
					</div>
					<h4>
						<b>儿童基本信息</b>
					</h4>
					<input type="hidden" id="type" name="type" value="1">
					<div class="col-md-6">
						<div class="form-group">
							<label class="col-sm-4 control-label">编号</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="cId" name="c.cid"
									placeholder="" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">儿童姓名</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="cName"
									name="c.cname" placeholder="例：王小平" required>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">主试姓名</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="cTestName"
									name="c.ctestname" placeholder="例：王小平" required>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">儿童性别</label>
							<div class="col-sm-8 ">
								<div class="radio pull-left">
									<label> <input type="radio" name="c.csex"
										id="optionsRadios1" value="男" checked> 男 </label>
								</div>
								<div class="radio pull-left">
									<label> <input type="radio" name="c.csex"
										id="optionsRadios2" value="女"> 女 </label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">所在年级</label>
							<div class="col-sm-8 ">
								<div class="btn-group">
									<select id="cClass" name="c.cclass" class="form-control"
										required>
										<option></option>
										<option value="幼儿园以下">幼儿园以下</option>
										<option value="幼儿园小班">幼儿园小班</option>
										<option value="幼儿园大班">幼儿园大班</option>
										<option value="小学一年级">小学一年级</option>
									</select>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label class="col-sm-4 control-label">用手习惯</label>
							<div class="col-sm-8 ">
								<div class="btn-group">
									<select id="cHand" name="c.chand" class="form-control">
										<option value="右手">右手</option>
										<option value="左手">左手</option>
										<option value="不确定">不确定</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">测试日期</label>
							<div class="col-sm-8">
								<input type="text" class="form-control date" id="cTYear"
									name="c.ctyear" required>年 <input type="text"
									class="form-control date" id="cTMonth" name="c.ctmonth"
									required>月 <input type="text" class="form-control date"
									id="cTDay" name="c.ctday" required>日
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">出生日期</label>
							<div class="col-sm-8">
								<input type="text" class="form-control date" id="cBYear"
									name="c.cbyear" required>年 <input type="text"
									class="form-control date" id="cBMonth" name="c.cbmonth"
									required>月 <input type="text" class="form-control date"
									id="cBDay" name="c.cbday" required>日
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">实际年龄</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="hideAgeResult"
									name="cClass" disabled placeholder="">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">家长教育程度</label>
							<div class="col-sm-8">
								<div class="btn-group">
									<select id="cCultrue" name="c.cculture" class="form-control"
										required>
										<option></option>
										<option value="小学">小学</option>
										<option value="初中">初中</option>
										<option value="高中">高中</option>
										<option value="大学">大学</option>
										<option value="硕士">硕士</option>
										<option value="博士">博士</option>
									</select>
								</div>
							</div>
						</div>
					</div>

					<h4>
						<b>家长联系信息</b>
					</h4>

					<div class="col-md-6">
						<div class="form-group">
							<label class="col-sm-4 control-label">电话号码</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" id="cPtel"
									name="c.cptel">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">电子邮件</label>
							<div class="col-sm-8">
								<input type="email" class="form-control" id="cPEmail"
									name="c.cpemail" placeholder="***@**.com">
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label class="col-sm-4 control-label">联系地址</label>

							<div class="col-sm-8">
								<input type="text" class="form-control" id="cPadd"
									name="c.cpadd">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">备注说明</label>

							<div class="col-sm-8">
								<input type="text" class="form-control" id="cStm" name="c.cstm">
							</div>
						</div>

					</div>
				</div>
				<div class="row" style="height:20px"></div>
				<div class="pull-right">
					<button type="submit" id="submitbutton" class="btn btn-primary">提交</button>
					<button type="reset" id="resetbutton" class="btn btn-warning">重置</button>
				</div>
			</form>
		</div>
	</div>
	<div style="height:60px"></div>


	<jsp:include page="footer.jsp"></jsp:include>
	<script src="js/checkdate.js"></script>
</body>
</html>
