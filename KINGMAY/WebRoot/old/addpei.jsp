<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ page import="com.kingmay.db.DBCon" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>添加培训班</title>

  </head>
  
  <body>
   	<s:form action="addPeiAction" method = "post">
   		名称：<input name="p.pname" type="text"/><br>
   		描述：<input name="p.pstm" type="text"/><br>
   		培训班公告：<input name="p.pnotify" type="text"/><br>
   		显示顺序：<input name="p.pshunxu" type="text"/><br>
   		父类：<select name="p.pparent">
			<option value="无">无</option>
			<%
			List<Map<String,String>> l = DBCon.queryallpei();
			if(l == null){
				l = new ArrayList<Map<String,String>>();
			}
			for(Map<String,String> s : l)
			{
				String ss = s.get("name");
				if(s.get("type").toString().equals("1")){
				%>
					<option value=<%=ss%>>-<%=ss%></option>
				<%
				}else if(s.get("type").toString().equals("2")){
				%>
					<option value=<%=ss%>>--<%=ss%></option>
				<%
				}else{
			 %>	 
	            <option value=<%=ss%>><%=ss%></option>
	          <%	 }	
	          }
	          %>
			 </select><br>
			 类型：<select name="p.ptype">
				  <option value="4">请选择</option>
				  <option value="0">省份</option>
				  <option value="1">城市</option>
				  <option value="2">培训班</option>
				  </select><br>
			使用状态：类型：<select name="p.pstate">
				  <option value="3">请选择</option>
				  <option value="0">使用中</option>
				  <option value="1">停用</option>
				  </select><br>
   		<s:reset value="重置"></s:reset>
   		<s:submit value="保存"></s:submit>
   	</s:form>
  </body>
</html>
