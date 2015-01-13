<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML>
<html>
<head lang="zh-CN">
    <base href="<%=basePath%>">
    <title>报告列表</title>

    <jsp:include page="../end-libs.jsp"></jsp:include>
</head>
<body class="easyui-layout">
<jsp:include page="common.jsp"></jsp:include>
<div data-options="region:'center',title:'',iconCls:'icon-ok'"
     class="centerLayout">
    <table class="table table-striped  table-hover">
        <tr>
            <th scope="col">记分册编号</th>
            <th scope="col">主试姓名</th>
            <th scope="col">儿童姓名</th>
            <th scope="col">录入时间</th>
            <th scope="col">操作</th>
        </tr>
        <s:iterator value="childs" status="st" id="c">
            <tr>
                <td>${c.cid }
                </td>
                <td>${c.ctestname }</td>
                <td>${c.cname }</td>
                <td>${c.cctime }</td>
                <td><a href="manager/download.action?path=${c.curl}"
                       class="btn btn-primary btn-xs">下载</a> <a class="btn btn-primary btn-xs"
                                                                href="manager/rawScoreAction.action?cid=<s:property value="#c.cid"/>">查看</a>
                </td>
            </tr>
        </s:iterator>
    </table>


    <ul class="pager">

        <li><a href="manager/backChildAction.action?page=1">首页</a></li>
        <c:choose>
            <c:when test="${currentPa>1}">
                <li><a href="manager/backChildAction.action?page=${currentPa-1}">上一页</a></li>
            </c:when>
        </c:choose>
        <c:choose>
            <c:when test="${currentPa<totalPa}">
                <li><a href="manager/backChildAction.action?page=${currentPa+1}">下一页</a></li>
            </c:when>
        </c:choose>
        <li><a href="manager/backChildAction.action?page=${totalPa}">尾页</a></li>
        <div style="height:10px"></div>
        <form action="manager/outCurScoreAction" meth="post" role="form">
            <button type="submit" class="btn btn-primary">导出当前页的原始分数</button>
        </form>
    </ul>
    </nav>
    <div style="text-align: center;">
儿童姓名：<input type="text" name="search_name" id="search_name"> 报告编号：<input type="text" name="search_id" id="search_id"> 
<input type="button" value="查询" onclick="SearchChildByIdAndName()">
    </div>
</div>

</body>
</html>
