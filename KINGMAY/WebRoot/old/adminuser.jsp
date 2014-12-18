<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ page import="com.kingmay.db.DBCon" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>添加主试</title>
	</head>
	<body>
		<s:form action="adminUserAction" method = "post">
			主试姓名：<input name="u.uname" type="text" value="${u.uname }"/>
			身份号码：<input name="u.uiden" type="text" value="${u.uiden }"/><br>
			主试ID：<input name="u.uid" type="text" value="${u.uid }" readonly="readonly"/>
			<select name="u.upei">
			<option value="${u.upei }">${u.upei }</option>
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
			 原始记分服务总数<input name="u.ucanuse" type="text" value="${u.ucanuse }" readonly="readonly"/>
			 增加：<input name="adduse" type="text" value="0"/> 减少：<input name="u.uused" type="text" value="${u.uused }" readonly="readonly"/>
			 备注：<input name="u.ubei" type="text" value="${u.ubei }"/><br>
			 电子邮件：<input name="u.email" type="text" value="${u.uemail }"/>
			 联系电话：<input name="u.tel" type="text" value="${u.utel }"/><br>
			 公司主页：<input name="u.ucom" type="text" value="${u.ucom }"/>
			 单位名称：<input name="u.ucomadd" type="text" value="${u.ucomadd }"/><br>
			 <s:radio name="u.usex" list="%{#{'男':'男','女':'女'}}"  label="性别"/>
			 QQ：<input name="u.uqq" type="text" value="${u.uqq }"/><br>
			 <s:radio name="u.uren" list="%{#{'未认证':'未认证','已认证':'已认证'}}"  label="认证"/>
			 权限：<input name="u.uquan" type="text" value="${u.uquan }"/><br>
			 用户生日：(例：19991110)<input name="u.ubir" type="text" value="${u.ubir }"/> 
			 MSN:<input name="u.umsn" type="text" value="${u.umsn }"/><br>
			 IP:<input name="u.uip" type="text" value="${u.uip }"/>
			 ICQ:<input name="u.uicq" type="text" value="${u.uicq }"/><br>
			 个人说明：<input name="ustm" type="text" value="${u.ustm }"/><br>
			 <s:reset value="重置"></s:reset>
			 <s:submit value="保存"></s:submit>
		 </s:form>
	</body>
</html>
