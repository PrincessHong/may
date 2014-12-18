<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>2.6~3.11周岁成绩录入</title>

  </head>
  
  <body>
  	<s:form action="addChildAction" method="post">
  		<s:textfield name="c.cid" label="参考编号"/>
  		<s:textfield name="c.cname" label="儿童姓名"/>
  		<s:textfield name="c.ctestname" label="主试姓名"/>
  		<s:radio name="c.csex" list="%{#{'男':'男','女':'女'}}"  label="儿童性别"/>
  		<s:textfield name="c.ctyear" label="测试日期："/> 
  		<s:textfield name="c.ctmonth" label="月"/> 
  		<s:textfield name="c.ctday" label="日"/> 
  		<s:textfield name="c.cbyear" label="出生日期："/> 
  		<s:textfield name="c.cbmonth" label="月"/> 
  		<s:textfield name="c.cbday" label="日"/> 
  		所在年级：<select name="c.cclass">
  			<option value=""></option>
  			<option value="幼儿园小班">幼儿园小班</option>
  			<option value="幼儿园大班">幼儿园大班</option>
  		</select>
  		家长教育程度：<select name="c.cculture" >
  			<option value=""></option>
  			<option value="小学">小学</option>
  			<option value="初中">初中</option>
  			<option value="高中">高中</option>
  			<option value="大学">大学</option>
  			<option value="硕士">硕士</option>
  			<option value="博士">博士</option>
  		</select>
  		用手习惯：<select name="c.chand">
  			<option value="右手">右手</option>
  			<option value="左手">左手</option>
  			<option value="不确定">不确定</option>
  		</select>
  		<s:textfield name="c.cptel" label="电话号码"/> 
  		<s:textfield name="c.cpemail" label="电子邮件"/> 
  		<s:textfield name="c.cpadd" label="联系地址"/> 
  		<s:textfield name="c.cstm" label="备注资料"/> 
  		<s:reset value="重置"/>
  		<s:submit value="保存"/>
  	</s:form>
  </body>
</html>
