<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ page import="com.kingmay.db.DBCon" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>test</title>
	</head>
	<body>
		<select>
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
		 </select>
	</body>
</html>
