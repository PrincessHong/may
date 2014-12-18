<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>2.6~3.11周岁成绩录入</title>
  </head>
  
  <body>
  	<s:form action="age2Action" method="post">
  	 <s:textfield name="age.rv" label="指认图片"/>
  	 <s:textfield name="age.bd" label="积木"/>
  	 <s:textfield name="age.pm" label="图片记忆"/>
  	 <s:textfield name="age.inf" label="常识"/>
  	 <s:textfield name="age.oa" label="拼图"/>
  	 <s:textfield name="age.zl" label="动物家园"/>
  	 <s:textfield name="age.pn" label="图片命名"/>
  	 <s:radio name="age.sp" list="%{#{'0':'0.9','1':'0.95'}}"  label="置信区间"/>
  	 <s:radio name="age.ssp" list="%{#{'0':'0.01','1':'0.05','2':'0.10','1':'0.15','1':'0.05'}}"  label="统计显著性差异"/>
  	 <s:radio name="age.bjjc" list="%{#{'0':'全样本'}}"  label="比较基础"/>
  	 <s:radio name="age.jsff" list="%{#{'0':'替代分测试','1':'比例估算法'}}"  label="计算方法"/>
  	 <s:reset value="重新输入"/>
  	 <s:submit value="生成报告"/>
  	</s:form>
  </body>
</html>
