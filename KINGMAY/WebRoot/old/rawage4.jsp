<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>4~7.3周岁成绩录入</title>
  </head>
  
  <body>
  	<s:form action="" method="post">
  	 <s:textfield name="age4.bd" label="积木"/>
  	 <s:textfield name="age4.inf" label="常识"/>
  	 <s:textfield name="age4.mr" label="矩阵推理"/>
  	 <s:textfield name="age4.bs" label="找虫"/>
  	 <s:textfield name="age4.pm" label="图片记忆"/>
  	 <s:textfield name="age4.si" label="类同"/>
  	 <s:textfield name="age4.pc" label="图片概念"/>
  	 <s:textfield name="age4.ca" label="划消"/>
  	 <s:textfield name="age4.zl" label="动物家园"/>
  	 <s:textfield name="age4.oa" label="拼图"/>
  	 <s:textfield name="age4.ac" label="动物译码"/>
  	 <s:textfield name="age4.rv" label="指认图片"/>
  	 <s:textfield name="age4.pn" label="图片命名"/>
  	 <s:textfield name="age4.car" label="随机划消"/>
  	 <s:textfield name="age4.cas" label="有序划消"/>
  	 <s:radio name="age4.sp" list="%{#{'0':'0.9','1':'0.95'}}"  label="置信区间"/>
  	 <s:radio name="age4.ssp" list="%{#{'0':'0.01','1':'0.05','2':'0.10','1':'0.15','1':'0.05'}}"  label="统计显著性差异"/>
  	 <s:radio name="age4.bjjc" list="%{#{'0':'全样本'}}"  label="比较基础"/>
  	 <s:radio name="age4.jsff" list="%{#{'0':'替代分测试','1':'比例估算法'}}"  label="计算方法"/>
  	 <s:radio name="age4.qsjsff" list="%{#{'0':'划消','1':'动物演绎'}}"  label="缺失计算方法"/>
  	</s:form>
  </body>
</html>
