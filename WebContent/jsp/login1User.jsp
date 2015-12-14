<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<script type="text/javascript">
		function regester(){
			alert(12);
			window.location.href = "index.jsp"
		}
	</script>
  </head>
  
  <body>
  	<s:if test="#request.userName != null">
  	<h2><s:property value="#request.userName"/>注册成功！</h2>
  	</s:if>
  	
  	<form action="User_login2.action" method="post">
  	<table>
  		<tr>
  			<td>用户名:</td>
  			<td><input type="text" name="userName"></td>
  		</tr>
  		<tr>
  			<td>密码:</td>
  			<td><input type="password" name="password"></td>
  		</tr>
  		<tr>
  			<td><input type="submit" value="登陆" ></td>
  			<td><input type="button" value="注册" onclick="regester()" ></td>
  		</tr>
  	</table>
  	</form>
  </body>
</html>
