<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'onlineuser.jsp' starting page</title>
    

  </head>
  
  <body>
  	<table class="table table-striped  table-hover">
				<tr>
					<th>登录名</th>
					<th>主试姓名</th>
					<th>时间</th>
					<th>所在页面</th>
				</tr>
				<s:iterator value="onlineUserList" id="user" status="st">
					<tr>
						
						<td>${user.ulName }</td>
						<td>${user.uName}</td>
						<td>${user.loginTime }</td>
						<td> </td>
					</tr>
				</s:iterator>
			</table>
  </body>
</html>
