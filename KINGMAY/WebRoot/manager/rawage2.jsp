<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>

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
<title>京美心理测量-管理员后台</title>
<jsp:include page="../end-libs.jsp"></jsp:include>
</head>

<body class="easyui-layout">
	<jsp:include page="common.jsp"></jsp:include>
	<div data-options="region:'center',title:'',iconCls:'icon-ok'" class="centerLayout">	
		<s:form action="" method="post">
  	 <s:textfield name="age2.rv" label="指认图片"/>
  	 <s:textfield name="age2.bd" label="积木"/>
  	 <s:textfield name="age2.pm" label="图片记忆"/>
  	 <s:textfield name="age2.inf" label="常识"/>
  	 <s:textfield name="age2.oa" label="拼图"/>
  	 <s:textfield name="age2.zl" label="动物家园"/>
  	 <s:textfield name="age2.pn" label="图片命名"/>
  	 <s:radio name="age2.sp" list="%{#{'0':'0.9','1':'0.95'}}"  label="置信区间"/>
  	 <s:radio name="age2.ssp" list="%{#{'0':'0.01','1':'0.05','2':'0.10','3':'0.15'}}"  label="统计显著性水平"/>
  	 <s:radio name="age2.bjjc" list="%{#{'0':'全样本','1':'能力水平样本'}}"  label="比较基础"/>
  	 <s:radio name="age2.jsff" list="%{#{'0':'替代分测试','1':'比例估算法'}}"  label="计算方法"/>
  	</s:form>
	</div>
	<script src="${pageContext.request.contextPath}/js/rawage.js"></script>
</body>
</html>
