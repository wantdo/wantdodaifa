<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
   <head>
    <base href="<%=basePath%>">
    
    <title>数据查看</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="<%=basePath %>css/bootstrap.min.css">
	<script src="<%=basePath %>js/jquery-1.11.0.js"></script>
	<script src="<%=basePath %>js/bootstrap.min.js"></script>
 	<script src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"  type="text/javascript"></script>
 	<script language="JavaScript">
     function timeQuery(){
	    	if (document.getElementById("startTime").value==""||document.getElementById("endTime").value=="") {
				alert("请选择日期后查询");
			}else {
				var startTime=document.getElementById("startTime").value.replace(/\-/g,"");
		    	var endTime=document.getElementById("endTime").value.replace(/\-/g,"");
		    	if (parseInt(startTime)>parseInt(endTime)) {
					alert("开始日期必须小于或等于结束日期");
				}else {
					var dataType = $("#list option:selected").val();
					if(dataType == "sale"){
					window.open("<%=basePath%>SProcessedAction.action?startTime="+startTime+
			    			"&endTime="+endTime);
					}
					if(dataType == "flow"){
					window.open("<%=basePath%>FProcessedAction.action?startTime="+startTime+
			    			"&endTime="+endTime);
					}
					if(dataType == "flowSource"){
					window.open("<%=basePath%>FsProcessedAction.action?startTime="+startTime+
			    			"&endTime="+endTime);
					}
					if(dataType == "goods"){
					window.open("<%=basePath%>GProcessedAction.action?startTime="+startTime+
			    			"&endTime="+endTime);
					}
					if(dataType == "timeSale"){
					window.open("<%=basePath%>TsProcessedAction.action?startTime="+startTime+
			    			"&endTime="+endTime);
					}
					if(dataType == "saleDay"){
					window.open("<%=basePath%>SdProcessedAction.action?startTime="+startTime+
			    			"&endTime="+endTime);
					}
				}
			}
	    	
	    }
		
		function timeDownload(){
			if (document.getElementById("startTime").value==""||document.getElementById("endTime").value=="") {
				alert("请选择日期后下载");
			}else {
				var startTime=document.getElementById("startTime").value.replace(/\-/g,"");
		    	var endTime=document.getElementById("endTime").value.replace(/\-/g,"");
		    	if (parseInt(startTime)>parseInt(endTime)) {
					alert("开始日期必须小于或等于结束日期");
				}else {
				var dataType = $("#list option:selected").val();
					if(dataType == "sale"){
					window.open("<%=basePath%>SDownloadAction.action?startTime="+startTime+
			    			"&endTime="+endTime);
					}
					if(dataType == "flow"){
					window.open("<%=basePath%>FDownloadAction.action?startTime="+startTime+
			    			"&endTime="+endTime);
					}
					if(dataType == "flowSource"){
					window.open("<%=basePath%>FsDownloadAction.action?startTime="+startTime+
			    			"&endTime="+endTime);
					}
					if(dataType == "goods"){
					window.open("<%=basePath%>GDownloadAction.action?startTime="+startTime+
			    			"&endTime="+endTime);
					}
					if(dataType == "timeSale"){
					window.open("<%=basePath%>TsDownloadAction.action?startTime="+startTime+
			    			"&endTime="+endTime);
					}
					if(dataType == "saleDay"){
					window.open("<%=basePath%>SdDownloadAction.action?startTime="+startTime+
			    			"&endTime="+endTime);
					}
				}
			}
	    }
  </script>
  <style type="text/css">
	.dt{width:150px;height:30px;font:16px 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;}
  </style>
  </head>
  
  <body>
  <div class="well well-lg">
<div class="alert alert-info" style="font-size:large;">
 <div class="time" style="margin:10px;">
 请选择数据 
<select id='list'  class="dt">
    <option value='sale'>销量</option>
    <option value='flow'>流量</option>
    <option value='timeSale'>实时销量</option>
    <option value='flowSource'>流量来源</option>
    <option value='goods'>上架商品</option>
    <option value='saleDay'>销量日报</option>
</select>
</div>
  <div class="time_menu" style="margin:10px;">
		从&nbsp;<input id="startTime"  class="dt"  type="text"/>
		<img onclick="WdatePicker({el:'startTime'})" src="<%=request.getContextPath()%>/js/My97DatePicker/skin/datePicker.gif" 
			width="14" height="24" align="absmiddle">
	</div>
	<div class="time_menu" style="margin:10px;">
		到&nbsp;<input id="endTime" class="dt"  type="text"/>
		<img onclick="WdatePicker({el:'endTime'})" src="<%=request.getContextPath()%>/js/My97DatePicker/skin/datePicker.gif" 
			width="12" height="24" align="absmiddle">
	</div>
<div class="timeSub" style="margin:10px;">
	<button type="button" class="btn btn-primary timeSubmit btn-sm"  value="查询" onclick="timeQuery()">查询</button>&nbsp;&nbsp;
	<button type="button" class="btn btn-primary timeSubmit btn-sm"  value="下载" onclick="timeDownload()">下载</button>
</div>
</div>
 </div> 
<!--  <div class="alert alert-success" role="alert">请拖动以下"淘宝代发"到收藏栏<br>
		<a id="collectbtn-drag" class="collectbtn" href="javascript:void((function(){var%20d=document,e=d.createElement('script');e.setAttribute('charset','utf-8');e.setAttribute('src','http://localhost:8080/wantdodaifa/js/d.js');d.body.appendChild(e);})());">一键抓取</a>
		</div> -->
	<div class="alert alert-success" role="alert">
		<a id="collectbtn-drag" class="collectbtn" href="<%=basePath%>ShopNameManageAction.action?variable=init">店铺名称管理</a>
	</div>
  </body>
</html>
