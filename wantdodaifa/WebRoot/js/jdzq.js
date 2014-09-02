function daifaMode(b){
	//店名
	var shopName = $("#shopNameTip").children("a").text();
	shopName = shopName.substring(3,shopName.length);
	
	//当前日期
	Date.prototype.Format = function (fmt) { //author: meizz 
	    var o = {
	        "M+": this.getMonth() + 1, //月份 
	        "d+": this.getDate(), //日 
	        "h+": this.getHours(), //小时 
	        "m+": this.getMinutes(), //分 
	        "s+": this.getSeconds(), //秒 
	        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
	        "S": this.getMilliseconds() //毫秒 
	    };
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o)
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	    return fmt;
	}
	var myday = new Date();
	myday = myday.Format("yyyy-MM-dd");
	//前一天日期
	var   today=new   Date();            //月份为0-11
    var   yesterday_milliseconds=today.getTime()-1000*60*60*24;      
    var   yesterday=new   Date();      
    yesterday.setTime(yesterday_milliseconds);      
       
    var strYear=yesterday.getFullYear();   
    var strDay=yesterday.getDate();   
    var strMonth=yesterday.getMonth()+1;   
    if(strMonth<10)   
    {   
        strMonth="0"+strMonth;   
    }   
    if(strDay<10)   
    {   
    	strDay="0"+strDay;   
    }   
    var strYesterday=strYear+"-"+strMonth+"-"+strDay; 
if(window.location.pathname=="/model/shopOverview/opermodel.jsp"){
	"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
	$("#div_daily_visitSumZBsVisit").children("h3");
		
	var xiaoliang = "";
	xiaoliang+="[{\"sales\":\"" + $("div:contains(下单金额)").children("strong").html()+"\",";
	xiaoliang+="\"clientPrice\":\"" + $("div:contains(客单价)").children("strong").html()+"\",";
	xiaoliang+="\"orderClientNum\":\"" + $("div:contains(下单客户数)").children("strong").html()+"\",";
	xiaoliang+="\"orderQuantity\":\"" + $("div:contains(下单单量)").children("strong").html()+"\",";
	xiaoliang+="\"orderGoodsNum\":\"" + $("div:contains(下单商品件数)").children("strong").html()+"\",";
	xiaoliang+="\"saleTime\":\"" + strYesterday+"\",";
	xiaoliang+="\"nowTime\":\"" + myday+"\",";
	xiaoliang+="\"shopName\":\"" + shopName+"\",";
	xiaoliang+="\"platform\":\"" + "京东"+"\"}]";	
//	alert(xiaoliang);
	
	var liuliang = "";
	liuliang+="[{\"goodsVolume\":\"" + $("div:contains(商品关注量)").children("strong").html()+"\",";
	liuliang+="\"shopVolume\":\"" + $("div:contains(店铺关注量)").children("strong").html()+"\",";
	liuliang+="\"visits\":\"" + $("div:contains(访问次数)").children("strong").html()+"\",";
	
	liuliang+="\"shopDealRate\":\"" + $("div:contains(店铺成交转化率)").children("strong").html()+"\",";
	liuliang+="\"firstPaymentRate\":\"" + $("div:contains(先款付款率)").children("strong").html()+"\",";
	
	shangjia+="\"flowTime\":\"" + strYesterday+"\",";
	shangjia+="\"shopName\":\"" + shopName+"\",";
	
	liuliang+="\"thirtyCustomerRetention\":\"" + $("div:contains(30日客户回头率)").children("strong").html()+"\",";
	liuliang+="\"thirtyRepeatPurchaseRate\":\"" + $("div:contains(30日重复购买率)").children("strong").html()+"\"}]";
	liuliang = liuliang.replace(/%/g, "*");
	alert(liuliang);
	
	var shangjia = "";
	shangjia+="[{\"spu\":\"" + $("div:contains(上架商品数量(SPU))").children("strong").html()+"\",";
	shangjia+="\"sku\":\"" + $("div:contains(上架商品数量(SKU))").children("strong").html()+"\",";
	shangjia+="\"goodsTime\":\"" + strYesterday+"\",";
	shangjia+="\"nowTime\":\"" + myday+"\",";
	shangjia+="\"shopName\":\"" + shopName+"\",";
	shangjia+="\"platform\":\"" + "京东"+"\"}]";	
	alert(shangjia);
	
//	$.post(b + "/JDdaifaServlet",{xiaoliang:xiaoliang,liuliang:liuliang,shangjia:shangjia},function(){});
//	$("span:contains(访问次数)").append("<a href='JDZQAction.action?variable=xiaoliang'>a</a>");
	setTimeout("location.href='"+b+"/JDZQAction.action?xiaoliang="+xiaoliang+"&&liuliang="+liuliang+"&&shangjia="+shangjia+"'",200);
//	alert(shangjia);
	
//	var zhibiao = new Array(new Array(),new Array());
//    var i = 0;
//    
//	$("#dailyResultTable").children("thead").children("tr").each(function(){
//		var j = 0;
//		$("#dailyResultTable").children("tbody").children("tr").children("td").each(function(){
//			zhibiao[i][j] = $(this).text().toString().trim();
//			j++;
//		});
//		i++;
//	});
////	alert(zhibiao[0][8]);
//	for(var i=0;i<5;i++){
//		var goods = "{";
//		for(var j=0;j<8;j++){
//			if(j==0){
//				goods+="\"flowTime\":\"";
//			}
//			if(j==1){
//				goods+="\"pageviews\":\"";
//			}
//			if(j==2){
//				goods+="\"visitors\":\"";
//			}
//			if(j==3){
//				goods+="\"visits\":\"";
//			}
//			if(j==4){
//				goods+="\"sales\":\"";
//			}
//			if(j==5){
//				goods+="\"orderClientNum\":\"";
//			}
//			if(j==6){
//				goods+="\"orderQuantity\":\"";
//			}
//			if(j==7){
//				goods+="\"orderGoodsNum\":\"";
//			}
//			goods+=zhibiao[i][j]+"\",";
//		}
//		goods = goods.substring(0, goods.length-1)+"}";
////		alert(goods);
//	}
	
}else if(window.location.pathname=="/shop-flow-real"){
	"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
	$("td:contains(PV)").parents("table");
	 
	$("td:contains(PV)").parents("table").children("tbody").find("td").each(function(){
		alert($(this).html());
	});
	
}else if(window.location.pathname=="/model/viewFlow/viewFlow.jsp"){
	"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
	$("#viewFlowDetailTab").children("thead");
		var laiyuan = "";
		for(var j=0;j<25;j++){
			if(j==0){
				var i = 0;
				var a = new Array();
				$("label:contains(总计)").parents("td").parents("tr").children("td").each(function(){
					a[i] = $(this).text().toString().trim();
					i++;
				});
			}else{
				var i = 0;
				var a = new Array();
				var id = "";
				if(j==1){id="#41"}
				if(j==2){id="#50Lev2"}
				if(j==3){id="#51Lev2"}
				if(j==4){id="#54Lev2"}
				if(j==5){id="#89Lev2"}
				if(j==6){id="#42"}
				if(j==7){id="#60Lev2"}
				if(j==8){id="#61Lev2"}
				if(j==9){id="#64Lev2"}
				if(j==10){id="#72Lev2"}
				if(j==11){id="#88Lev2"}
				if(j==12){id="#67Lev2"}
				if(j==13){id="#70Lev2"}
				if(j==14){id="#76Lev2"}
				if(j==15){id="#81Lev2"}
				if(j==16){id="#87Lev2"}
				if(j==17){id="#80Lev2"}
				if(j==18){id="#43"}
				if(j==19){id="#73Lev2"}
				if(j==20){id="#11Lev2"}
				if(j==21){id="#44"}
				if(j==22){id="#147Lev2"}
				if(j==23){id="#148Lev2"}
				if(j==24){id="#150Lev2"}
				$(id).children("td").each(function(){
					a[i] = $(this).text().toString().trim();
					i++;
				});
			}
			 laiyuan+="[{\"flowSource\":\"" + a[0]+"\",";
			 laiyuan+="\"landPageView\":\"" + a[1]+"\",";
			 laiyuan+="\"landPageViewAccounted\":\"" + a[2]+"\",";
			 laiyuan+="\"pageView\":\"" + a[3]+"\",";
			 laiyuan+="\"pageViewAccounted\":\"" + a[4]+"\",";
			 laiyuan+="\"flowSourceTime\":\"" + strYesterday+"\",";
			 laiyuan+="\"nowTime\":\"" + myday+"\",";
			 laiyuan+="\"shopName\":\"" + shopName+"\",";
			 laiyuan+="\"platform\":\"" + "京东"+"\"}]";
		}
		laiyuan = laiyuan.substring(0, laiyuan.length-1);
		setTimeout("location.href='"+b+"/JDZQAction.action?laiyuan="+laiyuan+"'",200);
//		$.post(b + "/JDdaifaServlet",{laiyuan:laiyuan},function(){});
}else if(window.location.pathname=="/model/viewFlowForDay/viewFlowForDay.jsp"){
	"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
	$("#table1Tbl").children("tbody");
    var flowInfo = "";
//    alert(strYesterday);
    //流量信息
    var flow = new Array();
    var i = 0;
    $("td:contains("+strYesterday+")").parents("tr").children("td").each(function(){
    	flow[i] = $(this).html();
    	i++;
    });
    flowInfo+="[{\"flowTime\":\"" + flow[0]+"\",";
    flowInfo+="\"pageviews\":\"" + flow[1]+"\",";
    flowInfo+="\"visitors\":\"" + flow[2]+"\",";
    flowInfo+="\"avgVisitDepth\":\"" + flow[3]+"\",";
    flowInfo+="\"avgPaceTime\":\"" + flow[4]+"\",";
    flowInfo+="\"bounceRate\":\"" + flow[5]+"\",";
    flowInfo+="\"backVisitorsRate\":\"" + flow[6]+"\",";
    flowInfo+="\"nowTime\":\"" + myday+"\",";
    flowInfo+="\"shopName\":\"" + shopName+"\",";
    flowInfo+="\"platform\":\"" + "京东"+"\"}]";
    flowInfo = flowInfo.replace(/%/g, "*");
    alert(flowInfo);
    setTimeout("location.href='"+b+"/JDZQAction.action?flowInfo="+flowInfo+"'",200);
//    $.post(b + "/JDdaifaServlet",{flowInfo:flowInfo},function(){});
}
}
var h,s=document.createElement("script");s.src="http://code.jquery.com/jquery-1.4.1.min.js",
	h=document.getElementsByTagName("head")[0],
	h.insertBefore(s,h.firstChild),
	setTimeout("daifaMode(durl);",50);
	