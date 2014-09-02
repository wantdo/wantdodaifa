<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
   <head>
    <base href="<%=basePath%>">
    
    <title>代发</title>
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
  <div class="jumbotron">
    <div class="jumbotron">
    	<div class="alert alert-success" role="alert">请拖动以下"淘宝代发"到收藏栏<br>
		<a id="collectbtn-drag" class="collectbtn" href="javascript:void((function(){var%20d=document,e=d.createElement('script');e.setAttribute('charset','utf-8');e.setAttribute('src','http://localhost:8080/wantdodaifa/js/tbd.js');d.body.appendChild(e);})());">淘宝代发</a>
		</div>
		<div class="alert alert-success" role="alert">请拖动以下"京东代发"到收藏栏<br>
		<a id="collectbtn-drag" class="collectbtn" href="javascript:void((function(){var%20d=document,e=d.createElement('script');e.setAttribute('charset','utf-8');e.setAttribute('src','http://localhost:8080/wantdodaifa/js/jdd.js');d.body.appendChild(e);})());">京东代发</a>
		</div>
		<div class="alert alert-success" role="alert">请拖动以下"当当抓取"到收藏栏<br>
		<a id="collectbtn-drag" class="collectbtn" href="javascript:void((function(){var%20d=document,e=d.createElement('script');e.setAttribute('charset','utf-8');e.setAttribute('src','http://localhost:8080/wantdodaifa/js/ddz.js');d.body.appendChild(e);})());">当当抓取</a>
		</div>
		<div class="alert alert-success" role="alert">请拖动以下"京东抓取"到收藏栏<br>
		<a id="collectbtn-drag" class="collectbtn" href="javascript:void((function(){var%20d=document,e=d.createElement('script');e.setAttribute('charset','utf-8');e.setAttribute('src','http://localhost:8080/wantdodaifa/js/jdz.js');d.body.appendChild(e);})());">京东抓取</a>
		</div>
		<div class="alert alert-success" role="alert">请拖动以下"淘宝抓取"到收藏栏<br>
		<a id="collectbtn-drag" class="collectbtn" href="javascript:void((function(){var%20d=document,e=d.createElement('script');e.setAttribute('charset','utf-8');e.setAttribute('src','http://localhost:8080/wantdodaifa/js/tbz.js');d.body.appendChild(e);})());">淘宝抓取</a>
		</div>
	</div>
		<hr>
		<div class="alert alert-info" role="alert">
		<p>温馨提示：如果您用的是360安全浏览器，请按照以下操作：</p>
		<p>1，在收藏栏中找一个不用的标签，或者重新收藏任意一个网页。</p>
		<p>2，右键1中的标签，选择“编辑”。</p>
		<p>3，将网页标题改为“一键代发”，复制一下代码到网页地址，点击确定即可。</p>
		<div class="alert alert-warning" role="alert">
		javascript:void((function(){var%20d=document,e=d.createElement('script');e.setAttribute('charset','utf-8');e.setAttribute('src','http://localhost:8080/wantdodaifa/js/d.js');d.body.appendChild(e);})());
		</div>
		</div>
		
	</div>
	
  </body>
</html>
