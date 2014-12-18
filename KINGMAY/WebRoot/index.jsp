<%@ page language="java" import="java.util.*" pageEncoding="Utf-8"%>
<%@ page language="java" import="com.kingmay.beans.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head lang="zh-CN">
<jsp:include page="lib.jsp"></jsp:include>
</head>

<body>
	<%
		User user = new User();
		user = (User) session.getAttribute("user");
		if (user == null) {
	%>
	<h2>
		您还没登录，请<a href="login.jsp">登录</a>
	</h2>
	<%
		} else {
	%>

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
					<li class="active"><a href="getThisChildAction.action">记分首页</a>
					</li>
					<li class="dropdown"><a href="child.jsp"
						class="dropdown-toggle" data-toggle="dropdown">数据录入 <span
							class="caret"></span> </a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="child.jsp">2:6-3:11</a></li>
							<li class="divider">el</li>
							<li><a href="child4.jsp">4:0-6:11</a></li>
						</ul></li>
					<li><a href="goChangeInfoAction">信息维护</a></li>
					<li><a href="userLogoutAction.action">退出</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div style="height:30px"></div>

	<div id="main-content">
		<div class="container">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-5">
					<div class="info">
						<div class="panel panel-warning">

							<div class="panel-heading">账号信息</div>
							<div class="panel-body">
								<div style="padding:20px;font-size:17px">
									<div>
										<span>主试编号：</span><label><%=user.getUid()%></label>
									</div>
									<div>
										<span>可用记分服务数：</span><label><%=user.getUcanuse()%>份</label>
									</div>
									<div>
										<span>已用记分服务数：</span><label><%=user.getUused()%>份</label>
									</div>
									<div>
										<span>报告结果：</span><label><%=user.getUused()%></label>
									</div>
									<div>
										<span>上次登录：</span><label><%=user.getUlast()%></label>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-5"></div>
			</div>
			<div style="height:5px"></div>

			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10">

					<div class="panel panel-warning">
						<div class="panel-heading">已提交记分数据列表</div>
						<div class="panel-body">
							<table class="table table-striped">
								<tr>
									<th scope="col">编号</th>
									<th scope="col">儿童姓名</th>
									<th scope="col">编辑</th>
									<th scope="col">下载</th>
									<th scope="col">时间</th>
								</tr>

								<s:iterator value="childs" status="st" id="c">
									<tr>
										<td>${c.cid }</td>
										<td>${c.cname}</td>
										<td>
										 <c:choose>
								<c:when test="${c.canchange == 0}">
									<a href="goChangeDataAction.action?cid=${c.cid }">修改</a>  
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${c.canchange == 1}">
									<p>修改</p>
								</c:when>
							</c:choose>
										</td>
										<td><a href="download.action?path=${c.curl }">下载</a></td>
										<td>${c.cctime}</td>
									</tr>
								</s:iterator>
							</table>
							[<a href="getThisChildAction.action?pageN=1">首页</a>]
							<c:choose>
								<c:when test="${currentPag>1}">
					[<a href="getThisChildAction.action?pageN=${currentPag-1}">上一页</a>]
				</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${currentPag<totalPag}">
					[<a href="getThisChildAction.action?pageN=${currentPag+1}">下一页</a>]
				</c:when>
							</c:choose>
							[<a href="getThisChildAction.action?pageN=${totalPag}">尾页</a>]
						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
	</div>
	<div style="height:30px"></div>
	<jsp:include page="footer.jsp"></jsp:include>
	<%
		}
	%>


</body>
</html>
