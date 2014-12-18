<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用户激活</title>

  <script type="text/javascript" src="js/libs/jquery-1.11.1.js"></script>
  </head>
  
  <body>
  	<s:form action="userValidateAction" method="post">
  		<s:textfield name="u.ulname" id="userName" label="登录名"/>
	  	<button onclick="checkUserName()" type="button">检查用户名是否操作</button>
	  	<s:textfield name="u.uid" label="主试编号"/>
	  	<s:textfield name="u.uname" label="姓名"/>
	  	<s:textfield name="u.uiden" label="身份证"/>
	  	<s:textfield name="u.uemail" label="email"/>
	  	<s:textfield name="u.ulpwd" label="密码"/>
	  	<s:textfield name="regpwd" label="确认密码"/>
	  	<s:textfield name="u.uque" label="问题"/>
	  	<s:textfield name="u.uans" label="答案"/>
	  	<s:submit value="提交"/>
	  	<s:reset value="重置"/>
  	</s:form>
  </body>
  
  <script type="text/javascript">
	
		function checkUserName(){
				var userName=$("#userName").val();
		
					var parms = {
						"userName" :userName
					};
					var url ="checkUserNameAction";
					$.post(url, parms, function(data) {
						if (data) {
							if(data=="true"){
								alert("用户名存在");
							}else{
								alert("用户名不存在");
							}
						}
					});
		}
	
	</script>
</html>
