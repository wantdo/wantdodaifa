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
    
    <title>数据显示</title>
    
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
		window.open("http://192.168.6.211/:8080/wantdodaifa/");
	  }
     function timeDownload(){
			var startTime=document.getElementById("startTime").value.replace(/\-/g,"");
	    	var endTime=document.getElementById("endTime").value.replace(/\-/g,"");
			var dataType = document.getElementById("dataType").value;
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
  </script>
  </head>
  
  <body onload="closepage()">
	  <div id="header" class="alert alert-warning" style="font-size:large; padding: 20px">&nbsp;
		<div class="timeSub" style="float:left;margin-left:20px;">
			<button type="button" class="btn btn-primary timeSubmit btn-sm"  value="主页" onclick="timeQuery()">主页</button>
		</div>
		<div class="timeSub" style="float:right;margin-left:20px;">
			<button type="button" class="btn btn-primary timeSubmit btn-sm"  value="下载" onclick="timeDownload()">下载</button>
			<input type=hidden id='startTime'  value="<s:property value='startTime' />" />
			<input type=hidden id='endTime'  value="<s:property value='endTime'/>" />
		</div>
	  </div>
  <s:if test="saleMap != null">
  <div style="padding: 20px">
	<table class="table table-bordered">
		<caption align="top" style="font-size: x-large;">销量表</caption>  
		<thead><tr style="background-color:highlight;"><td>店铺名称</td><td>平台</td><td>销售额</td><td>下单数量</td><td>下单商品数</td><td>下单客户数</td><td>客单价</td><td>数据日期</td></tr></thead>
  <s:iterator value="saleMap" id="list">
 	 	<s:iterator value="#list.value" id="saleList" >
	 		<tr  style="background-color:threedface;">
	 			<td><s:property value="#saleList.platform"/></td>
	 			<td><s:property value="#saleList.shopName"/></td>
	 			<td><s:property value="#saleList.sales"/></td>
	 			<td><s:property value="#saleList.orderQuantity"/></td>
	 			<td><s:property value="#saleList.orderGoodsNum"/></td>
	 			<td><s:property value="#saleList.orderClientNum"/></td>
	 			<td><s:property value="#saleList.clientPrice"/></td>
	 			<td><s:property value="#saleList.version"/></td>
	 		</tr>
		</s:iterator>
  </s:iterator> 	
	</table>
	<input type=hidden id='dataType'  value="sale" />
  </div>
  </s:if>
  <s:if test="flowMap != null">
  <div style="padding: 20px">
	<table class="table table-bordered">
		<caption align="top" style="font-size: x-large;">流量表</caption>  	
		<thead><tr style="background-color:lime;"><td>店铺名称</td><td>平台</td><td>商品关注量</td><td>店铺关注量</td><td>店铺成交转化率</td><td>先款付款率</td><td>30日客户回头率</td><td>30日重复购买率</td><td>浏览量</td><td>访客数</td><td>平均访问深度</td><td>平均停留时间</td><td>跳失率</td><td>7日回访率</td><td>数据日期</td><td>操作时间</td></tr></thead>
  <s:iterator value="flowMap" id="list">
 	 	<s:iterator value="#list.value" id="flowList" >
	 		<tr  style="background-color:threedface;">
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
  </s:iterator> 	
	</table>
	<input type=hidden id='dataType'  value="flow" />
  </div>
  </s:if>
  <s:if test="flowSourceMap != null">
  <div style="padding: 20px">
	<table class="table table-bordered">
		<caption align="top" style="font-size: x-large;">流量来源表</caption>  
		<thead><tr style="background-color:yellow;"><td>店铺名称</td><td>平台</td><td>流量来源</td><td>到达页浏览量</td><td>到达页浏览量占比</td><td>浏览量</td><td>浏览量占比</td><td>数据日期</td><td>操作时间</td></tr></thead>
  <s:iterator value="flowSourceMap" id="list">
 	 	<s:iterator value="#list.value" id="flowSourceList" >
	 		<tr style="background-color:threedface;">
	 			<td><s:property value="#flowSourceList.shopName"/></td>
	 			<td><s:property value="#flowSourceList.platform"/></td>
	 			<td><s:property value="#flowSourceList.flowSource"/></td>
	 			<td><s:property value="#flowSourceList.landPageView"/></td>
	 			<td><s:property value="#flowSourceList.landPageViewAccounted"/></td>
	 			<td><s:property value="#flowSourceList.pageView"/></td>
	 			<td><s:property value="#flowSourceList.pageViewAccounted"/></td>
	 			<td><s:property value="#flowSourceList.remark"/></td>
	 			<td><s:property value="#flowSourceList.nowTime"/></td>
	 		</tr>
		</s:iterator>
  </s:iterator> 	
	</table>
	<input type=hidden id='dataType'  value="flowSource" />
  </div>
  </s:if>
  <s:if test="goodsMap != null">
  <div style="padding: 20px">
	<table class="table table-bordered">
		<caption align="top" style="font-size: x-large;">上架表</caption>  
		<thead><tr style="background-color:orange;"><td>店铺名称</td><td>平台</td><td>上架商品数(SPU)</td><td>上架商品数(SKU)</td><td>数据日期</td><td>操作时间</td></tr></thead>
  <s:iterator value="goodsMap" id="list">
 	 	<s:iterator value="#list.value" id="goodsList" >
	 		<tr style="background-color:threedface;">
	 			<td><s:property value="#goodsList.shopName"/></td>
	 			<td><s:property value="#goodsList.platform"/></td>
	 			<td><s:property value="#goodsList.spu"/></td>
	 			<td><s:property value="#goodsList.sku"/></td>
	 			<td><s:property value="#goodsList.goodsTime"/></td>
	 			<td><s:property value="#goodsList.nowTime"/></td>
	 		</tr>
		</s:iterator>
  </s:iterator> 	
	</table>
	<input type=hidden id='dataType'  value="goods" />
  </div>
  </s:if>
  <s:if test="timeSaleMap != null">
  <div style="padding: 20px">
	<table class="table table-bordered">
		<caption align="top" style="font-size: x-large;">实时销量表</caption>  
		<thead><tr style="background-color:aqua;"><td>店铺名称</td><td>平台</td><td>时间段</td><td>浏览量</td><td>访客数</td><td>下单金额</td><td>下单客户数</td><td>下单单量</td><td>下单商品数</td><td>数据日期</td><td>操作时间</td></tr></thead>
   <s:iterator value="timeSaleMap" id="list">
 	 	<s:iterator value="#list.value" id="timeSaleList" >
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
  </s:iterator> 
	</table>
	<input type=hidden id='dataType'  value="timeSale" />
  </div>
  </s:if>
  <s:if test="saleDayMap != null">
  <div style="padding: 20px">
	<table class="table table-bordered">
		<caption align="top" style="font-size: x-large;">销量日报表</caption>  
		<thead><tr style="background-color:highlight;"><td>日期</td><td>店铺名称</td><td>店铺编号</td><td>负责人</td><td>销售额</td><td>客单价</td><td>转化率</td><td>毛利率</td><td>当日退货金额</td><td>当日实际发货金额</td><td>当日店铺罚款金额</td></tr></thead>
  <s:iterator value="saleDayMap" id="list">
 	 	<s:iterator value="#list.value" id="saleList" >
	 		<tr  style="background-color:threedface;">
	 			<td><s:property value="#saleList.saleTime"/></td>
	 			<td><s:property value="#saleList.shopName"/></td>
	 			<td></td>
	 			<td></td>
	 			<td><s:property value="#saleList.sales"/></td>
	 			<td><s:property value="#saleList.clientPrice"/></td>
	 			<td><s:property value="#saleList.shopDealRate"/></td>
	 			<td></td>
	 			<td></td>
	 			<td></td>
	 			<td></td>
	 		</tr>
		</s:iterator>
  </s:iterator> 	
	</table>
	<input type=hidden id='dataType'  value="saleDay" />
  </div>
  </s:if>
  </body>
</html>
