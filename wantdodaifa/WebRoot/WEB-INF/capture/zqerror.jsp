<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>抓取失败</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="<%=basePath %>css/bootstrap.min.css">
	<script src="<%=basePath %>js/jquery-1.11.0.js"></script>
	<script src="<%=basePath %>js/bootstrap.min.js"></script>

  </head>
  
  <body>
    	<div class="alert alert-danger"  style="font-size:x-large;"> 操作失败，请重新操作。 <br></div>
  </body>
</html>
