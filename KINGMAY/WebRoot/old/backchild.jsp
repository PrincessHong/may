<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用户主页</title>
  </head>
  
  <body>
  	
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
				<td><a href="rawScoreAction.action?cid=<s:property value="#c.cid"/>">查看</a></td>
				<td><a href="download.action?path=<s:property value="#c.curl"/>">下载</a></td>
				<td><s:property value="#c.cctime"/></td>
			</tr>
			</s:iterator>
		</table>
			[<a href="backChildAction.action?page=1">首页</a>]
			<c:choose>
				<c:when test="${currentPa>1}">
					[<a href="backChildAction.action?page=${currentPa-1}">上一页</a>]
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${currentPa<totalPa}">
					[<a href="backChildAction.action?page=${currentPa+1}">下一页</a>]
				</c:when>
			</c:choose>
		    [<a href="backChildAction.action?page=${totalPa}">尾页</a>]
		    <s:form action="outCurScoreAction" method="post">
		    	<s:submit value="导出当前页的原始分数"/>
		    </s:form>
	</div>
  	
  </body>
</html>
