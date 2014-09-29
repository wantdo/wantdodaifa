<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>抓取成功</title>
    
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
  /*  function closepage(){
       window.opener=null;
       window.open("","_self");
       setTimeout("self.close()",2000);
     } */
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
				}
			}
	    }
  </script>
  <style type="text/css">
	.dt{width:150px;height:30px;font:16px 'Microsoft YaHei',微软雅黑,Verdana,arial,sans-serif;}
  </style>
  </head>
  
  <body onload="closepage()">
  <div class="alert alert-success" style="font-size:x-large;">  恭喜您，抓取数据成功！ <br>
</div>
<s:if test="orderSaleList == null">
  <div class="alert alert-warning" style="font-size:large;"> &nbsp;
  <div class="time" style="float:left;">
 请选择数据 
<select id='list'  class="dt">
    <option value='sale'>销量</option>
    <option value='flow'>流量</option>
    <option value='timeSale'>实时销量</option>
    <option value='flowSource'>流量来源</option>
    <option value='goods'>上架商品</option>
</select>
</div>
  <div class="time_menu" style="float:left;margin-left:20px;">
		从&nbsp;<input id="startTime"  class="dt"  type="text"/>
		<img onclick="WdatePicker({el:'startTime'})" src="<%=request.getContextPath()%>/js/My97DatePicker/skin/datePicker.gif" 
			width="14" height="24" align="absmiddle">
	</div>
	<div class="time_menu" style="float:left;margin-left:20px;">
		到&nbsp;<input id="endTime" class="dt"  type="text"/>
		<img onclick="WdatePicker({el:'endTime'})" src="<%=request.getContextPath()%>/js/My97DatePicker/skin/datePicker.gif" 
			width="12" height="24" align="absmiddle">
	</div>
<div class="timeSub" style="float:left;margin-left:20px;">
	<button type="button" class="btn btn-primary timeSubmit btn-sm"  value="查询" onclick="timeQuery()">查询</button>
	<button type="button" class="btn btn-primary timeSubmit btn-sm"  value="下载" onclick="timeDownload()">下载</button>
</div></div>
</s:if>
  <s:if test="saleList != null">
  <div style="padding: 20px">
	<table class="table table-bordered">
		<caption align="top" style="font-size: x-large;">销量表</caption>  
		<thead><tr style="background-color:highlight;"><td>店铺名称</td><td>平台</td><td>销售额</td><td>下单数量</td><td>下单商品数</td><td>下单客户数</td><td>客单价</td><td>数据日期</td><td>操作时间</td></tr></thead>
 	 	<s:iterator value="saleList" id="saleList" >
	 		<tr style="background-color:threedface;"">
	 			<td><s:property value="#saleList.shopName"/></td>
	 			<td><s:property value="#saleList.platform"/></td>
	 			<td><s:property value="#saleList.sales"/></td>
	 			<td><s:property value="#saleList.orderQuantity"/></td>
	 			<td><s:property value="#saleList.orderGoodsNum"/></td>
	 			<td><s:property value="#saleList.orderClientNum"/></td>
	 			<td><s:property value="#saleList.clientPrice"/></td>
	 			<td><s:property value="#saleList.saleTime"/></td>
	 			<td><s:property value="#saleList.nowTime"/></td>
	 		</tr>
		</s:iterator>
	</table>
  </div>
  </s:if>
  <s:if test="flowList != null">
  <div style="padding: 20px">
	<table class="table table-bordered">
		<caption align="top" style="font-size: x-large;">流量表</caption>  	
		<thead><tr style="background-color:lime;"><td>店铺名称</td><td>平台</td><td>商品关注量</td><td>店铺关注量</td><td>店铺成交转化率</td><td>先款付款率</td><td>30日客户回头率</td><td>30日重复购买率</td><td>浏览量</td><td>访客数</td><td>平均访问深度</td><td>平均停留时间</td><td>跳失率</td><td>7日回访率</td><td>数据日期</td><td>操作时间</td></tr></thead>
 	 	<s:iterator value="flowList" id="flowList" >
	 		<tr style="background-color:threedface;">
	 			<td><s:property value="#flowList.shopName"/></td>
	 			<td><s:property value="#flowList.platform"/></td>
	 			<td><s:property value="#flowList.goodsVolume"/></td>
	 			<td><s:property value="#flowList.shopVolume"/></td>
	 			<td><s:property value="#flowList.shopDealRate"/></td>
	 			<td><s:property value="#flowList.firstPaymentRate"/></td>
	 			<td><s:property value="#flowList.thirtyCustomerRetention"/></td>
	 			<td><s:property value="#flowList.thirtyRepeatPurchaseRate"/></td>
	 			<td><s:property value="#flowList.pageviews"/></td>
	 			<td><s:property value="#flowList.visitors"/></td>
	 			<td><s:property value="#flowList.avgVisitDepth"/></td>
	 			<td><s:property value="#flowList.avgPaceTime"/></td>
	 			<td><s:property value="#flowList.bounceRate"/></td>
	 			<td><s:property value="#flowList.backVisitorsRate"/></td>
	 			<td><s:property value="#flowList.flowTime"/></td>
	 			<td><s:property value="#flowList.nowTime"/></td>
	 		</tr>
		</s:iterator>
	</table>
  </div>
  </s:if>
  <s:if test="flowSourceList != null">
  <div style="padding: 20px">
	<table class="table table-bordered">
		<caption align="top" style="font-size: x-large;">流量来源表</caption>  
		<thead><tr style="background-color:yellow;"><td>店铺名称</td><td>平台</td><td>流量来源</td><td>到达页浏览量</td><td>到达页浏览量占比</td><td>浏览量</td><td>浏览量占比</td><td>数据日期</td><td>操作时间</td></tr></thead>
 	 	<s:iterator value="flowSourceList" id="flowSourceList" >
	 		<tr style="background-color:threedface;">
	 			<td><s:property value="#flowSourceList.shopName"/></td>
	 			<td><s:property value="#flowSourceList.platform"/></td>
	 			<td><s:property value="#flowSourceList.flowSource"/></td>
	 			<td><s:property value="#flowSourceList.landPageView"/></td>
	 			<td><s:property value="#flowSourceList.landPageViewAccounted"/></td>
	 			<td><s:property value="#flowSourceList.pageView"/></td>
	 			<td><s:property value="#flowSourceList.pageViewAccounted"/></td>
	 			<td><s:property value="#flowSourceList.flowSourceTime"/></td>
	 			<td><s:property value="#flowSourceList.nowTime"/></td>
	 		</tr>
		</s:iterator>
	</table>
  </div>
  </s:if>
  <s:if test="goodsList != null">
  <div style="padding: 20px">
	<table class="table table-bordered">
		<caption align="top" style="font-size: x-large;">上架表</caption>  
		<thead><tr style="background-color:orange;"><td>店铺名称</td><td>平台</td><td>上架商品数(SPU)</td><td>上架商品数(SKU)</td><td>数据日期</td><td>操作时间</td></tr></thead>
 	 	<s:iterator value="goodsList" id="goodsList" >
	 		<tr style="background-color:threedface;">
	 			<td><s:property value="#goodsList.shopName"/></td>
	 			<td><s:property value="#goodsList.platform"/></td>
	 			<td><s:property value="#goodsList.spu"/></td>
	 			<td><s:property value="#goodsList.sku"/></td>
	 			<td><s:property value="#goodsList.goodsTime"/></td>
	 			<td><s:property value="#goodsList.nowTime"/></td>
	 		</tr>
		</s:iterator>
	</table>
  </div>
  </s:if>
  <s:if test="timeSaleList != null">
  <div style="padding: 20px">
	<table class="table table-bordered">
		<caption align="top" style="font-size: x-large;">实时销量表</caption>  
		<thead><tr style="background-color:aqua;"><td>店铺名称</td><td>平台</td><td>时间段</td><td>浏览量</td><td>访客数</td><td>下单金额</td><td>下单客户数</td><td>下单单量</td><td>下单商品数</td><td>数据日期</td><td>操作时间</td></tr></thead>
 	 	<s:iterator value="timeSaleList" id="timeSaleList" >
	 		<tr style="background-color:threedface;">
	 			<td><s:property value="#timeSaleList.shopName"/></td>
	 			<td><s:property value="#timeSaleList.platform"/></td>
	 			<td><s:property value="#timeSaleList.times"/></td>
	 			<td><s:property value="#timeSaleList.pageviews"/></td>
	 			<td><s:property value="#timeSaleList.visitors"/></td>
	 			<td><s:property value="#timeSaleList.sales"/></td>
	 			<td><s:property value="#timeSaleList.orderClientNum"/></td>
	 			<td><s:property value="#timeSaleList.orderQuantity"/></td>
	 			<td><s:property value="#timeSaleList.orderGoodsNum"/></td>
	 			<td><s:property value="#timeSaleList.saleTime"/></td>
	 			<td><s:property value="#timeSaleList.nowTime"/></td>
	 		</tr>
		</s:iterator>
	</table>
  </div>
  </s:if>
  <s:if test="orderSaleList != null">
  <div style="padding: 20px">
	<table class="table table-bordered">
		<caption align="top" style="font-size: x-large;">订单金额表</caption>  
		<thead><tr style="background-color:aqua;"><td>店铺名称</td><td>总金额</td><td>商品数</td><td>客户名</td><td>数据日期</td></tr></thead>
 	 	<s:iterator value="orderSaleList" id="orderSaleList" >
	 		<tr style="background-color:threedface;">
	 			<td><s:property value="#orderSaleList.shopName"/></td>
	 			<td><s:property value="#orderSaleList.sales"/></td>
	 			<td><s:property value="#orderSaleList.goodsNum"/></td>
	 			<td><s:property value="#orderSaleList.clientName"/></td>
	 			<td><s:property value="#orderSaleList.saleTime"/></td>
	 		</tr>
		</s:iterator>
	</table>
  </div>
  </s:if>
  </body>
</html>
