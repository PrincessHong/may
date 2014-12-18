<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>信息维护</title>
  </head>
  <body>
  <div id="div1" align="center">
  	<s:form action = "changeInfoAction" method="post">
		<table border="1" width="40%"  border="0"  bgcolor="#CBD8AC">
			<tr>
				<th>个人资料</th>
			</tr>
			<tr align="center" >
				<td>主试姓名</td><td><s:property value="u.uname"/></td>
				<td>身份证号码</td><td><s:property value="u.uiden"/></td>
			</tr>
			<tr align="center" >
				<td>主试编号</td><td><s:property value="u.uid"/></td>
				<td>记分系统登录名</td><td><s:property value="u.ulname"/></td>
			</tr>
			<tr align="center" >
				<td>可用记分服务数</td><td><s:property value="u.ucanuse"/></td>
				<td>已用记分服务数</td><td><s:property value="u.uused"/></td>
			</tr>
			<tr align="center" >
				<td>E-mail地址</td><td><s:textfield name="u.uemail"/></td>
				<td>联系电话</td><td><s:textfield name="u.utel"/></td>
			</tr>
			<tr align="center" >
				<td>公司主页</td><td><s:textfield name="u.ucom"/></td>
				<td>单位名称</td><td><s:property value="u.ucomadd"/></td>
			</tr>
			<tr align="center" >
				<td><s:submit value="保存"/></td>
			</tr>
		</table>
	  </s:form>
	</div>
  </body>
</html>
