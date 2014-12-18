<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>修改密码</title>
    

  </head>
  
  <body>
  <%
			if(request.getAttribute("msg_a")!=null){
				out.println(request.getAttribute("msg_a"));
			}
	%>
	  <s:form action="goAdminChangePwdAction" method="post">
		  	<s:textfield name="oldpwd"/>
		  	<s:textfield name="newpwd"/>
		  	<s:textfield name="regpwd"/>
		  	<s:submit value="提交"></s:submit>
		  	<s:reset value="重置"></s:reset>
	  </s:form>
  </body>
</html>
