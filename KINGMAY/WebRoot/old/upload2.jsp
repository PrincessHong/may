<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>文件上传</title>
  </head>
  
  <body>
    <s:form action="upload2Action" method="post" enctype="multipart/form-data">
   		 请上传文件：<s:file name="upload"/>
   		 <s:submit value="确认"/>
    </s:form>
    
  </body>
</html>
