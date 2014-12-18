<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户登录</title>
  </head>
  
  <body>
     <s:form action="userChangePwdAction" method = "post">
     	<s:password name="pwd" label="原密码"/>
     	<s:password name="pwd1" label="新密码"/>
     	<s:password name="pwd2" label="确认密码"/>
     	<s:reset value="重置"/> 
    	<s:submit value="确认"></s:submit>
     </s:form>
  	 <s:action name="getThisUserAction" executeResult="false"></s:action>
     <s:form action="userChangeQueAction" method = "post">
     	<s:textfield name="#request.que" label="问题" readonly="true"  />
     	<s:textfield name="ans" label="答案"/>
     	<s:textfield name="que" label="新问题"/>
     	<s:textfield name="ans1" label="新答案"/>
     	<s:reset value="重置"/> 
    	<s:submit value="确认"></s:submit>
     </s:form>
  </body>
</html>
