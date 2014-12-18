<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
<head lang="zh-CN">
<base href="<%=basePath%>">
<title>多数据处理</title>
<jsp:include page="../end-libs.jsp"></jsp:include>
</head>
<script type="text/javascript">
	function showpage(url) {
		$('#content').load(url);
	}
</script>

<body class="easyui-layout">
<jsp:include page="common.jsp"></jsp:include>
	<div data-options="region:'center',title:'',iconCls:'icon-ok'" class="centerLayout">
		<header id="header" class="page-header">
			<div class="container">
				<h1>2:6-3:11多数据处理</h1>

			</div>
		</header>
		<div class="container">
			<div class="row">
				<ul class="list-group clearfix"></ul>
				<form action="manager/upload2Action" method="post" enctype="multipart/form-data" name="upload">
					<a href="#" id="selectbtn" class="btn btn-primary">选择文件</a> <input
						name="upload" type="file"  enctype="multipart/form-data" style="display:none">
					<button type="submit" class="btn btn-primary ">数据处理</button>
				</form>
				<%
							if(request.getAttribute("up2msg")!=null){
								out.println(request.getAttribute("up2msg"));
							}
				%>
			</div>
		</div>
	</div>

		<script type="text/javascript">
		$(function() { // 立即执行函数，避免命名冲突

			var listGroup = document.querySelector('.list-group'), upload = document.forms['upload']['upload'], selectBtn = document
					.getElementById('selectbtn');

			selectBtn.addEventListener('click', function(event) {
				upload.click();
				event.preventDefault();
			}, false);

			// 监听 选择文件 表单元素的 change 事件
			upload.addEventListener('change', displayFileInfo, false);

			function displayFileInfo(event) {
				// console.log(event);
				listGroup.innerHTML = '';
				event.stopPropagation();
				event.preventDefault();

				var file = event.target.files || event.dataTransfer.files;
				for (i = 0; i < file.length; i++) {
					var li = document.createElement('li');
					li.classList.add('list-group-item');
					var content = document.createTextNode(file[i].name + ' '
							+ file[i].type + ' '
							+ Math.round(file[i].size / 1024 / 1024 * 100)
							/ 100 + ' ' + 'MB' + ' '
							+ file[i].lastModifiedDate.toLocaleDateString());
					li.appendChild(content);
					listGroup.appendChild(li);
				}
			}

			// 提示内容
			listGroup.innerHTML = '<p class="hint">请点击选择文件</p>';

			// 监听 drop 与 dragover 事件
			listGroup.addEventListener('drop', displayFileInfo, false);
			listGroup.addEventListener('dragover', onDragOver, false);

			function onDragOver(event) {
				event.stopPropagation();
				event.preventDefault();
			}

		});
	</script>
</body>

</html>
