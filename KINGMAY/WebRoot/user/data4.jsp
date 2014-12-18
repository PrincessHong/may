<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="../lib.jsp"></jsp:include>
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
			<div class="col-md-3">
				<div class="bs-docs-sidebar sidebar">
					<ul class="nav nav-list bs-docs-sidenav affix-top">
						<li class="active"><a href="child4.jsp"><i
								class="icon-chevron-right"></i> 基本资料</a>
						</li>
						<li class=""><a href="data4.jsp"><i
								class="icon-chevron-right"></i> 原始分数</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="col-md-8">
				<form id="rawScoreForm" action="age4_Action" method="post"  class="form-horizontal" role="form">
					<div id="basic-info" class="row">
						<div class="edition">
							<img class="w-logo-ch" src="../images/w-logo-ch.png" alt="logo">
							<h1>4:0-6:11</h1>
						</div>
						<div id="score" class="row">
						<div class="col-md-6">
							<h4>
								<b>原始分数</b>
							</h4>
							<div class="form-group">
								<label for="bd" class="col-sm-4 control-label">积木</label>
								<div class="col-sm-8">
									<input type="number" class="form-control" id="bd" name="age.bd"
										placeholder="0-34">
								</div>
							</div>
							<div class="form-group">
								<label for="bd" class="col-sm-4 control-label">常识</label>
								<div class="col-sm-8">
									<input type="number" class="form-control" id="inf" name="age.inf"
										placeholder="0-29">
								</div>
							</div>
							<div class="form-group">
								<label for="bd" class="col-sm-4 control-label">矩阵推理</label>
								<div class="col-sm-8">
									<input type="number" class="form-control" id="mr" name="age.mr"
										placeholder="0-26">
								</div>
							</div>
							<div class="form-group">
								<label for="bd" class="col-sm-4 control-label">找虫</label>
								<div class="col-sm-8">
									<input type="number" class="form-control" id="bs" name="age.bs"
										placeholder="0-66">
								</div>
							</div>
							<div class="form-group">
								<label for="bd" class="col-sm-4 control-label">图片记忆</label>
								<div class="col-sm-8">
									<input type="number" class="form-control" id="pm" name="age.pm"
										placeholder="0-35">
								</div>
							</div>
							<div class="form-group">
								<label for="bd" class="col-sm-4 control-label">类同</label>
								<div class="col-sm-8">
									<input type="number" class="form-control" id="si" name="age.si"
										placeholder="0-40" required>
								</div>
							</div>
							<div class="form-group">
								<label for="bd" class="col-sm-4 control-label">图画概念</label>
								<div class="col-sm-8">
									<input type="number" class="form-control" id="pc" name="age.pc"
										placeholder="0-27" required>
								</div>
							</div>
							<div class="form-group">
								<label for="bd" class="col-sm-4 control-label">划消</label>
								<div class="col-sm-8">
									<input type="number" class="form-control" id="ca" name="age.ca"
										placeholder="0-96" required>
								</div>
							</div>
							<div class="form-group">
								<label for="bd" class="col-sm-4 control-label">动物家园</label>
								<div class="col-sm-8">
									<input type="number" class="form-control" id="zl" name="age.zl"
										placeholder="0-20" required>
								</div>
							</div>
							<div class="form-group">
								<label for="bd" class="col-sm-4 control-label">拼图</label>
								<div class="col-sm-8">
									<input type="number" class="form-control" id="oa" name="age.oa"
										placeholder="0-32" required>
								</div>
							</div>
							<div class="form-group">
								<label for="bd" class="col-sm-4 control-label">动物译码</label>
								<div class="col-sm-8">
									<input type="number" class="form-control" id="ac" name="age.ac"
										placeholder="0-72" required>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">指认图片</label>
								<div class="col-sm-8">
									<input type="number" class="form-control" id="rv" name="age.rv"
										placeholder="0-31" required>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">图片命名</label>
								<div class="col-sm-8">
									<input type="number" class="form-control span2" id="pn"
										name="age.pn" placeholder="0-24" required>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">随机划消</label>

								<div class="col-sm-8">
									<input type="number" class="form-control span2" id="car"
										name="age.car" placeholder="0-48" required>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-4 control-label">有序划消</label>

								<div class="col-sm-8">
									<input type="number" class="form-control span2" id="cas"
										name="age.cas" placeholder="0-48" required>
								</div>
							</div>
						</div>

						<div id="compare" class="col-md-6">
							<h4>
								<b>比较选择</b>
							</h4>
							<div class="form-group">
								<label class="col-sm-4 control-label">置信区间</label>

								<div class="col-sm-8">
									<div class="btn-group">
										<select id="disabledSelect" name="age.sp"  class="form-control">
											<option value=1>90%</option>
											<option value=2>95%</option>
										</select>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">统计显著性水平</label>
								<div class="col-sm-8 ">
									<div class="btn-group">
										<select id="disabledSelect" name="age.ssp" class="form-control">
											<option value=1>0.01</option>
											<option value=2>0.05</option>
											<option value=3>0.10</option>
											<option value=4>0.15</option>
										</select>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-4 control-label">比较基础</label>
								<div class="col-sm-8 ">
									<div class="btn-group">
										<select id="disabledSelect" name="age.bjjc" class="form-control">
											<option value=0>全样本</option>
											<option value=1>能力水平样本</option>
										</select>
									</div>
								</div>
							</div>

							<h4 id="invalid">
								<b>存在无效的原始分数时</b>
							</h4>

							<label class="col-sm-4 control-label">计算方法</label>

							<div class="col-sm-8 ">
								<div class="btn-group">
									<select id="disabledSelect" name="age.jsff" class="form-control">
										<option value=0>替代分测验</option>
										<option value=1>比例估算法</option>
									</select>
								</div>
							</div>
							<h4 id="replace">
								<b>当找虫缺失时，选择以下补充分测验以作为替代分测验</b>
							</h4>
							<div class="form-group">
								<label class="col-sm-4 control-label">计算方法</label>
								<div class="col-sm-8 ">
									<div class="btn-group">
										<select id="disabledSelect" name="age.qsjsff" class="form-control">
											<option value=0>划消</option>
											<option value=1>动物译码</option>
										</select>
									</div>
								</div>
							</div>
							
						</div>
					</div>
					</div>
					<div class="row" style="height:20px"></div>
					<div class="pull-right">
						<button type="submit" id="submitbutton" class="btn btn-primary">生成报告</button>
						<button type="reset" id="resetbutton" class="btn btn-warning">重置</button>
					</div>
				</form>
			</div>
		</div>
		<div style="height:60px"></div>
		<jsp:include page="footer.jsp"></jsp:include>
		<script src="js/checkscore4.js"></script>
</body>
</html>
