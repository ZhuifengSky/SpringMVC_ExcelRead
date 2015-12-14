<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login1-User.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script type="text/javascript">
	function regester(ope) {
		if (ope == 'add') {
			$("#form").attr("action", "user/addUser.do");
			$("#form").submit();
		} else {
			$("#form").attr("action", "user/updateUser.do");
			$("#form").submit();
		}
	}
	
	 function onFileUploadimg(bt, columnname) {
		var url = "user/uploadimg.do";
		$.ajaxFileUpload({
			url : url,
			type: 'post',
			secureuri : false,
			fileElementId : bt.id,
			dataType : 'json',
			data : {},
			success : function(result, status) {

				if (result.resultCode == '1001') {
					alert("请选择图片!");
					return false;
				} else if(result.resultCode == '1002'){
					alert("图片格式不正确，请确认!");
					return false;
				}
				else{
					alert("上传成功");
				}
				uploadCallback(result, columnname);

			},
			error : function(result, status, e) {
				alert(e);
			}
		});
		return false;

	}
	function uploadCallback(data, id) {
		document.getElementById(id).value = data.path;
		var url = data.path;
		//$("#androidImageUrl_show").hide();
		$('#' + id + '_file')
				.after(
						$('<a id="'
								+ id
								+ '_show" href="javascript:;" onclick="javascript:showImage(\''
								+ data.path + '\')">预览图片</a>'));
	}

	function showImage(url) {
		$.blockUI({
			css : {
				top : '20%',
				left : '30%',
				cursor : null
			},
			message : ' <img  src="'+url+'"/>',
			onOverlayClick : $.unblockUI
		});

	}
</script>
</head>

<body>
	<c:if test="${s.id ne null}">
		<h2>学生编辑</h2>
	</c:if>
	<c:if test="${s.id eq null}">
		<h2>学生新增</h2>
	</c:if>
	<form method="post" id="form">
		<table>
			<tr>
				<td>学生姓名:</td>
				<td><input type="text" name="studentName"
					value="${s.studentName}"><c:if test="${s.id ne null}">
						<input type="hidden" value="${s.id}" name="id">
					</c:if>
					<input type="hidden" value="${s.imageUrl}" name="imageUrl">
					</td>
			</tr>
			<tr>
				<td>年龄:</td>
				<td>
				<input type="text" name="age" value="${s.age}">
				</td>
			</tr>
			<tr>
				<td>头像:</td>
				<td width="300"><input id="imageUrl_file" type="file"
						name="file" onchange="return onFileUploadimg(this,'imageUrl');" />
						<c:if test="${s.imageUrl ne null}">
							<a id="imageUrl_show" href="#" onclick="javascript:showImage('${s.imageUrl}')">预览图片</a>
						</c:if>
				</td>
			</tr>
			<tr>
				<c:if test="${s.id ne null}">
					<td><input type="button" value="修改" onclick="regester('edit')"></td>
				</c:if>
				<c:if test="${s.id eq null}">
					<td><input type="button" value="新增" onclick="regester('add')"></td>
				</c:if>				
		   </tr>
		</table>
	</form>
</body>
</html>
