<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用户主页</title>

  </head>
  
  <body>
  	<s:textfield name="u.uid" label="主试编号"/>
  	<s:textfield name="u.ucanuse" label="可用记分服务次数"/>
	<s:textfield name="u.uused" label="报告结果"/>  	
  	<s:textfield name="u.ulast" label="上次登录时间"/>
  	
  	<div id="div1" align="center">
		<table border="1" width="40%"  border="0"  bgcolor="#CBD8AC">
			<tr>
				<th>编号</th>
				<th>儿童姓名</th>
				<th>编辑</th>
				<th>下载</th>
				<th>时间</th>
			</tr>
			<s:iterator value="childs" status="st" var="c">
			<tr align="center" >
			<td><s:property value="#c.cid"/></td>
				<td><s:property value="#c.cname"/></td>
				<td>修改</td>
				<td><a href="download.action?path=<s:property value="#c.curl"/>">下载</a></td>
				<td><s:property value="#c.cctime"/></td>
			</tr>
			</s:iterator>
		</table>
			[<a href="getThisChildAction.action?pageN=1">首页</a>]
			<c:choose>
				<c:when test="${currentPag>1}">
					[<a href="getThisChildAction.action?pageN=${currentPag-1}">上一页</a>]
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${currentPag<totalPag}">
					[<a href="getThisChildAction.action?pageN=${currentPag+1}">下一页</a>]
				</c:when>
			</c:choose>
		    [<a href="getThisChildAction.action?pageN=${totalPag}">尾页</a>]
	</div>
  	
  </body>
</html>
