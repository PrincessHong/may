<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>培训班信息</title>
		<script type="text/javascript" src="js/js.js" charset="GB2312"></script>
	</head>
	<body>
		<div id="div1" align="center">
			<table border="1" width="40%"  border="0"  bgcolor="#CBD8AC">
				<tr>
					<th>培训班名</th>
				</tr>
				<s:iterator value="peilist" status="st" var="pei">
				<tr align="center" >
					<td><s:property value="#pei.pname"/></td>
					<td width="120px">
						<button type="button" onclick="goadminpei('<s:property value="#pei.pname"/>')">编辑</button>
						<button type="button" onclick="delpei('<s:property value="#pei.pname"/>')">删除</button>
					</td>
				</tr>
				</s:iterator>
			</table>
		</div>
	</body>
</html>
