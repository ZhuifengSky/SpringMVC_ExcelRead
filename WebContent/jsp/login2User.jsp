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

  </head>
  
  <body>
  	<table border="1px">
  	<thead>
  		<tr>
  			<td>姓名</td>
  			<td>性别</td>
  			<td>出生日期</td>
  		</tr>
  	</thead>
  	<tbody>
    <s:iterator value="#request.users" var="user">
    	<tr>
    		<td><s:property value="userName"/></td>
    		<td>
    		<s:if test="sex == 1">
    			男
    		</s:if>
    		<s:else>
    			女
    		</s:else>
    		</td>
    		<td><s:property value="birthday"/></td>
    	</tr>  	
    </s:iterator>
    </tbody>	
    </table>   
  </body>
</html>
