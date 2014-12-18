<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ page import="com.kingmay.db.DBCon" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改培训班信息</title>
  </head>
  
  <body>
  <s:form action="adminPeiAction" method = "post">
   		名称：<input name="p.pname" type="text" value="${p.pname }" readonly="readonly"/><br>
   		描述：<input name="p.pstm" type="text" value="${p.pstm }"/><br>
   		培训班公告：<input name="p.pnotify" type="text" value="${p.pnotify }"/><br>
   		显示顺序：<input name="p.pshunxu" type="text" value="${p.pshunxu }"/><br>
   		父类：<select name="p.pparent" >
   			<option value="${p.pparent}">${p.pparent }</option>
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
			 类型：<select name="p.ptype" ">
				 <option value="${p.ptype }">请选择</option>
				  <option value="0">省份</option>
				  <option value="1">城市</option>
				  <option value="2">培训班</option>
				  </select><br>
			使用状态：类型：<select name="p.pstate" >
				  <option value="${p.pstate }">请选择</option>
				  <option value="0">使用中</option>
				  <option value="1">停用</option>
				  </select><br>
   		<s:reset value="重置"></s:reset>
   		<s:submit value="保存"></s:submit>
   		<s:hidden name="p.pid"/>
   		</s:form>
  </body>
</html>
