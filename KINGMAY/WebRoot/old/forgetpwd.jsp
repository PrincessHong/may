<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>忘记密码</title>
  </head>
  
  <body>
  	 <s:action name="getThisUserAction" executeResult="false"></s:action>
     <s:form action="forgetpwdAction" method = "post">
     	<s:textfield name="#request.que" label="问题" readonly="true"  />
     	<s:textfield name="ans" label="答案"/>
     	<s:reset value="重置"/> 
    	<s:submit value="确认"></s:submit>
     </s:form>
  </body>
</html>
