
//删除培训班
function delpei(pname){
	if(confirm("您确定要删除该培训班吗？")){
		location.href = "delPeiAction.action?pname="+encodeURI(encodeURI(pname));
	}
}

//修改培训班信息
function goadminpei(pname){
	location.href = "goAdminPeiAction.action?pname="+encodeURI(encodeURI(pname));
}

//修改主试信息
function goadminuser(uid){
	location.href = "goAdminUserAction.action?uid="+encodeURI(encodeURI(uid));
}

//删除主试信息
function deluser(uid){
	if(confirm("您确定要删除该主试吗？")){
		location.href = "delUserAction.action?uid="+encodeURI(encodeURI(uid));
	}
}

//通过姓名id模糊查询儿童
function SearchChildById_Name(){
	var search_id=$("#search_id").val();
	var search_name=$("#search_name").val();
//	alert(encodeURI(search_id));
//	location.href = "delUserAction.action?uid="+encodeURI(encodeURI(uid));
}