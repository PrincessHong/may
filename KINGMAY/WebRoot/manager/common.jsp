<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.kingmay.db.DBCon"%>
<%@ page language="java" import="com.kingmay.beans.*"%>

<div data-options="region:'north',split:true"
	class="northLayout">
	<h2>京美心理测量-管理员后台</h2>
	<%
		Admin admin = new Admin();
		admin = (Admin) session.getAttribute("admin");
	%>
	<div class="infoBar">
		欢迎您:<%=admin.getAname()%></div>
</div>

<div data-options="region:'west',split:true" title=""
	style="width:180px;">
	<div class="easyui-accordion" data-options="fit:false,border:false">
		<div class="jm-title" title="主试管理">
			<ul class="jm_menu">
				<li><a href="manager/peiAction.action">培训班列表</a>
				</li>
				<li><a href="manager/addpei.jsp">新建培训班</a>
				</li>
				<li><a href="manager/allUserAction.action">主试列表</a>
				</li>
				<li><a href="manager/adduser.jsp">新建主试</a>
				</li>
			</ul>
		</div>
		<div class="jm-title" title="网站管理">
			<ul class="jm_menu">
				<li><a href="manager/onlineUserAction">在线用户列表</a>
				</li>
				<li><a href="manager/showControlAction">用户操作列表</a>
				</li>
				<li><a href="manager/showMarkCountAction">用户记分数量历史</a>
				</li>
			</ul>
		</div>
		<%if (admin.getAauth().equals("0") ) {%>
		<div class="jm-title" title="报告管理">
			<ul class="jm_menu">
				<li><a href="manager/backChildAction">报告列表</a>
				</li>
			</ul>
		</div>
		<div class="jm-title" title="多数据处理">
			<ul class="jm_menu">
				<li><a href="manager/upload2.jsp">2:6-3:11</a>
				</li>
				<li><a href="manager/upload.jsp">4:0-6:11</a>
				</li>
			</ul>
		</div>
		<%} %>
		<div class="jm-title" title="系统管理">
			<ul class="jm_menu">
				<li><a href="manager/changepwd_a.jsp">修改密码</a>
				</li>
				<li><a href="manager/adminLogoutAction.action">安全退出</a>
				</li>
			</ul>
		</div>
	</div>
</div>