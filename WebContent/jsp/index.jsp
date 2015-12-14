<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>到账自动确认</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="js/fomvalidator4.0/jquery_last.js" type="text/javascript"></script>
<script defer="defer" src="js/fomvalidator4.0/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script src="js/fomvalidator4.0/formValidator.js" type="text/javascript"
	charset="UTF-8"></script>
<script src="js/fomvalidator4.0/formValidatorRegex.js"
	type="text/javascript" charset="UTF-8"></script>
<script language="javascript" src="js/fomvalidator4.0/DateTimeMask.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$.formValidator.initConfig({
			formid : "form1",
			debug : false,
			submitonce : true,
			onerror : function(msg, obj, errorlist) {
				return false;
			},
			onsuccess : function() {
				form.submit;
			}
		});

		$("#reportType").formValidator({
			onshow : "请选择账单来源",
			onfocus : "账单来源必须选择",
			oncorrect : "账单来源选择正确",
		}).inputValidator({
			min : 1,
			onerror : "账单来源不能为空,请确认!"
		});

		$("#reportFile").formValidator({
			onshow : "请选择账单Excel文件",
			onfocus : "账单Excel文件必须选择",
			oncorrect : "账单Excel文件选择正确",
		}).inputValidator({
			min : 1,
			onerror : "账单Excel文件不能为空,请确认!"
		});
	});

	function login() {
		alert(12)
		window.location.href = 'login1User.jsp';
		alert(dd)
	}
</script>
<style type="text/css" media="all">
body, div {
	font-size: 12px;
	margin: 0 auto;
}
#content{
   padding-top: 40px;
   width: 650px;
   
}
</style>
<link type="text/css" rel="stylesheet"
	href="js/fomvalidator4.0/style/validator.css"></link>
</head>

<body>
   <div id="content">
	<form action="excelRead/readExcel.do" method="post" name="form1" id="form1" enctype="multipart/form-data">
		<table border="0px" style="font-size: 12px" width="630px">
			<thead>
				<tr><td colspan="3" align="center"><h2>自动对账</h2></td></tr>
			</thead>
			<tbody>
			<tr>
				<td align="right">账单文件:</td>
				<td><input type="file" name="file" id="reportFile" style="width: 200px">
				</td>
				<td><div id="reportFileTip" style="width: 250px"></div></td>
			</tr>
			<tr height="20px"></tr>
			<tr>
				<td colspan="3" align="center">
				   <input type="submit" name="button" id="button" value="开始确认" />&nbsp;&nbsp;
				   <input type="button" name="button" id="button" value="重置" />
				 </td>
			</tr>
			</tbody>			
		</table>
	</form>
   </div>
</body>
</html>
