<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>后台登录</title>
  </head>
  
  <body>
     <s:form action="adminLoginAction" method = "post">
     	<input name="aa.aname" type="text"/>
     	<input name="aa.apwd" type="password"/>
    	<s:reset value="重置"/> 
    	<s:submit value="登录"></s:submit>
     </s:form>
  </body>
</html>
