function daifaMode(b){
	if(window.location.pathname=="/shop-flow-real"){
		"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
		//$(".first").after("<input type='button' class='daifa' value='页面数据获得'>");
		$(".first").after();
		var n = "";
		$("td:contains(PV)").parents("table").children("tbody").find("td").each(function(){
			//var m = $("td:contains(PV)").parents("table").children("tbody").children("tr");
			var date = $(this).text();
			//n +="{"+ date+"}" + ",";
			n += date +",";
		});
		var f = n.substring(0, n.length-1);
		var k = f.split(",");
		var num1 = k[0];
		var num2 = k[1];
		var num3 = k[2];
		var num4 = k[3];
		var num5 = k[4];
		var num6 = k[5];
		var ddll = "[{\"pageviews\":\""+ num1 + "\",\"visitors\":\""+ num2 + "\",\"pageviews\":\""+ num3 + "\",\"pageviews\":\""+ num4 + "\",\"pageviews\":\""+ num5 + "\",\"pageviews\":\""+ num6 + "\",}]" ;
		alert(ddll);	
		$("td:contains(COD订单数)").parents("table").children("tbody").find("td").each(function(){
			//alert($(this).html());
		});
	}
	else if(window.location.pathname=="/shop-flow-source"){
		"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
		$(".first").after();
		var n = "";
		$("td:contains(流量来源)").parents("table").children("tbody").find("td").each(function(){
			//alert($(this).text());
			var date = $(this).text();
			n += date +",";
		});	
		var f = n.substring(0,n.length-1);
		var head = $("td:contains(流量来源)").parents("table").children("tbody").children("tr");
		var k = f.split(",");
		var ddllly1="";
		var ddllly2="";
		var ddllly3="";
		for(var i=0;i<head.length;i++){
			for(var j=i+9*i;j<(i+1)*10;j=j+10){				
					var num1 = k[j];
					var num2 = k[j+1];
					var num3 = k[j+2];
					var num4 = k[j+3];
					var num5 = k[j+4];
					var num6 = k[j+5];
					var num7 = k[j+6];
					var num8 = k[j+7];
					var num9 = k[j+8];
					var num10 = k[j+9];		
					//alert(111);
			}
			var ddllly = "{\"pageviews\":\""+ num1 + "\",\"visitors\":\""+ num2 + "\",\"pageviews\":\""+ num3 + "\",\"pageviews\":\""+ num4 + "\",\"pageviews\":\""+ num5 + "\",\"pageviews\":\""+ num6 + "\",\"pageviews\":\""+ num7 + "\",\"pageviews\":\""+ num8 + "\",\"pageviews\":\""+ num9 + "\",\"pageviews\":\""+ num10 + "\"},";
			ddllly1 += ddllly;
		}
		ddllly2 = ddllly1.substring(0, ddllly1.length-1);
		ddllly3 = "["+ddllly2+"]";
		alert(ddllly3);
	}
	else if(window.location.pathname=="/shop-flow-home"){
		"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
		$("#page_table").find("td").each(function(){
			alert($(this).text());
		});
	}
	else if(window.location.pathname=="/shop-flow-entire"){
		"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
		$(".first").after();
		var n = "";
		var body = "";
		var head = "";
		$("#flow_status_table").find("td").each(function(){
			var date = $(this).text();						
		    n += date + ",";	    
		});
		var f = n.substring(0, n.length-1);
		head = $("#flow_status_table").children("tr");
		body = $("#flow_status_table").children("tr").children("td");
		var k = f.split(",");
		var ddll1="";
		var ddll2="";
		var ddll3="";
		for(var i=0;i<head.length;i++){
			for(var j=i+4*i;j<(i+1)*5;j=j+5){	
				var num1 = k[j];
				var num2 = k[j+1];
				var num3 = k[j+2];
				var num4 = k[j+3];
				var num5 = k[j+4];
			}
			var ddll = "{\"pageviews\":\""+ num1 + "\",\"visitors\":\""+ num2 + "\",\"pageviews\":\""+ num3 + "\",\"pageviews\":\""+ num4 + "\",\"pageviews\":\""+ num5 + "\"}," ;
			ddll1 += ddll;
		}
		 ddll2 = ddll1.substring(0, ddll1.length-1);
		 ddll3 = "["+ddll2+"]";
		alert(ddll3);
	}
	else if(window.location.pathname=="/gp/site-metrics/report.html"){
		"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
		$(".first").after();
		var n = "";
		$("#dataTable").children("tbody").find("td").each(function(){			
			var date = $(this).text();
			n += date +";";	
			//alert($(this).text());
		});
		var f = n.substring(1,n.length-1);
		var head = $("#dataTable").children("tbody").children("tr");
		var body = $("#dataTable").children("tbody").children("tr").children("td");
		var k = f.split(";");
		var h = head.length;
		var b = body.length;
		var length = b/h;
		alert(head.length);
		alert(body.length);
		alert(length);
		var ymxxs1="";
		var ymxxs2="";
		var ymxxs3="";
		for(var i=0;i<head.length;i++){
			for(var j=i+(length-1)*i;j<(i+1)*length;j=j+length){
				if(length == 11){				
					var num1 = k[j];
					var num2 = k[j+1];
					var num3 = k[j+2];
					var num4 = k[j+3];
					var num5 = k[j+4];
					var num6 = k[j+5];
					var num7 = k[j+6];
					var num8 = k[j+7];
					var num9 = k[j+8];
					var num10 = k[j+9];			
					var ymxxs = "{\"pageviews\":\""+ num1 + "\",\"visitors\":\""+ num2 + "\",\"pageviews\":\""+ num3 + "\",\"pageviews\":\""+ num4 + "\",\"pageviews\":\""+ num5 + "\",\"pageviews\":\""+ num6 + "\",\"pageviews\":\""+ num7 + "\",\"pageviews\":\""+ num8 + "\",\"pageviews\":\""+ num9 + "\",\"pageviews\":\""+ num10 + "\"},";
					ymxxs1 += ymxxs;
				}
				else if(length == 8){
					var num1 = k[j];
					var num2 = k[j+1];
					var num3 = k[j+2];
					var num4 = k[j+3];
					var num5 = k[j+4];
					var num6 = k[j+5];
					var num7 = k[j+6];		
					var ymxxs = "{\"pageviews\":\""+ num1 + "\",\"visitors\":\""+ num2 + "\",\"pageviews\":\""+ num3 + "\",\"pageviews\":\""+ num4 + "\",\"pageviews\":\""+ num5 + "\",\"pageviews\":\""+ num6 + "\",\"pageviews\":\""+ num7 + "\"},";
					ymxxs1 += ymxxs;
				}
			}
		}
		ymxxs2 = ymxxs1.substring(0, ymxxs1.length-1);
		ymxxs3 = "["+ymxxs2+"]";
		alert(ymxxs3);
	}
	else{
		"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
		$("td:contains(日期)").parents("tbody").children("tr").find("td").each(function(){
			alert($(this).text());
		});
	} 
}
var h,s=document.createElement("script");s.src="http://code.jquery.com/jquery-1.4.1.min.js",
	h=document.getElementsByTagName("head")[0],
	h.insertBefore(s,h.firstChild),
	setTimeout("daifaMode(durl);",50);


//function daifaMode(b){
//	if(window.location.pathname=="/shop-info"){
//		"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
//		$("#shop_status_right").children("tr").each(function(){
//			var n="";
//			var body = $(this).children("td");
//			var head = $("#shop_status_head").children("tr").children("td");
//			for(var i=0;i<head.length;i++){
//				for(var j=0;j<body.length;j++){
//					if(i == j){
//						n+=head.eq(i).text().toString().trim()+":";
//						if(j!=body.length-1){
//							n+=body.eq(j).text().toString().trim()+",";
//						}
//						else{
//							n+=body.eq(j).text().toString().trim();
//						}
//					}
//				}
//			}
//			
//			alert(n);
////			shop_detail_right
//		});
//	}else if(window.location.pathname=="/shop-order-entire"){
//		
//	}
//	}
//	var h,s=document.createElement("script");s.src="http://code.jquery.com/jquery-1.4.1.min.js",
//		h=document.getElementsByTagName("head")[0],
//		h.insertBefore(s,h.firstChild),
//		setTimeout("daifaMode(durl);",50);
