<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>主试列表</title>
    <script type="text/javascript" src="js/js.js" charset="GB2312"></script>
  </head>
  
  <body>
	  <div id="div1" align="center">
		<table border="1" width="40%"  border="0"  bgcolor="#CBD8AC">
			<tr>
				<th>主试编号</th>
				<th>主试姓名</th>
				<th>登录名</th>
				<th>总记分册</th>
				<th>已用记分册</th>
				<th>剩余记分册</th>
				<th>激活状态</th>
				<th>操作</th>
			</tr>
			<s:iterator value="userlist" status="st" var="user">
			<tr align="center" >
			<td><s:property value="#user.uid"/></td>
				<td><s:property value="#user.uname"/></td>
				<td><s:property value="#user.ulname"/></td>
				<td><s:property value="#user.ucanuse"/></td>
				<td><s:property value="#user.uused"/></td>
				<td><s:property value="#user.ucanuse-#user.uused"/></td>
				<td><s:property value="#user.uren"/></td>
				<td width="120px">
					<button type="button" onclick="goadminuser('<s:property value="#user.uid"/>')">编辑</button>
					<button type="button" onclick="deluser('<s:property value="#user.uid"/>')">删除</button>
				</td>
			</tr>
			</s:iterator>
		</table>
			[<a href="allUserAction.action?pageNo=1">首页</a>]
			<c:choose>
				<c:when test="${currentPage>1}">
					[<a href="allUserAction.action?pageNo=${currentPage-1}">上一页</a>]
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage<totalPage}">
					[<a href="allUserAction.action?pageNo=${currentPage+1}">下一页</a>]
				</c:when>
			</c:choose>
		    [<a href="allUserAction.action?pageNo=${totalPage}">尾页</a>]
	</div>
  </body>
</html>
