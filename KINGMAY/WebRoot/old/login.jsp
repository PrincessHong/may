<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户登录</title>
  </head>
  
  <body>
     <s:form action="userLoginAction" method = "post">
     	<input name="u.ulname" type="text"/>
     	<input name="u.ulpwd" type="password"/>
    	<s:reset value="重置"/> 
    	<s:submit value="登录"></s:submit>
     </s:form>
  </body>
</html>
