function daifaMode(b){
	//当前日期
	Date.prototype.Format = function (fmt) { 
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
	myday = myday.Format("yyyy-MM-dd hh:mm:ss.S");
	
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
    
    //版本号
    var version = "1.0";
//    alert(window.location.hostname);
    
    //京东*********************************************************************************
	if(window.location.hostname=="pop.jd.com"){
		var shopName = $("#shopNameTip").children("a").text().toString().trim();
		shopName = shopName.substring(3,shopName.length);
//		alert(shopName);
		
		//京东页面==========================================================================
		if(window.location.pathname=="/model/shopOverview/opermodel.jsp"){
			"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
			$("#shopNameTip");
//		店名
		var shopName = $("#shopNameTip").children("a").text().toString().trim();
		shopName = shopName.substring(3,shopName.length);
		
			var sales=$("div:contains(下单金额)").children("strong").html();
			sales = sales.replace(",","");
			sales = sales.replace("￥","");
			var clientPrice=$("div:contains(客单价)").children("strong").html();
			clientPrice = clientPrice.replace(",","");
			clientPrice = clientPrice.replace("￥","");
			var orderClientNum=$("div:contains(下单客户数)").children("strong").html();
			orderClientNum = orderClientNum.replace(",","");
			orderClientNum = orderClientNum.replace("￥","");
			var orderQuantity=$("div:contains(下单单量)").children("strong").html();
			orderQuantity = orderQuantity.replace(",","");
			orderQuantity = orderQuantity.replace("￥","");
			var orderGoodsNum=$("div:contains(下单商品件数)").children("strong").html();
			orderGoodsNum = orderGoodsNum.replace(",","");
			orderGoodsNum = orderGoodsNum.replace("￥","");
			var xiaoliang = "";
			xiaoliang+="[{\"sales\":\"" + sales+"\",";
			xiaoliang+="\"clientPrice\":\"" + clientPrice+"\",";
			xiaoliang+="\"orderClientNum\":\"" + orderClientNum+"\",";
			xiaoliang+="\"orderQuantity\":\"" + orderQuantity+"\",";
			xiaoliang+="\"orderGoodsNum\":\"" + orderGoodsNum+"\",";
			xiaoliang+="\"saleTime\":\"" + strYesterday+"\",";
			xiaoliang+="\"nowTime\":\"" + myday+"\",";
			xiaoliang+="\"shopName\":\"" + shopName+"\",";
			xiaoliang+="\"platform\":\"" + "京东"+"\",";	
			xiaoliang+="\"version\":\"" + version+"\"}]";	
			alert(xiaoliang);
			
			var goodsVolume=$("div:contains(商品关注量)").children("strong").html();
			goodsVolume = goodsVolume.replace(",","");
			goodsVolume = goodsVolume.replace("￥","");
			var shopVolume=$("div:contains(店铺关注量)").children("strong").html();
			shopVolume = shopVolume.replace(",","");
			shopVolume = shopVolume.replace("￥","");
			var shopDealRate=$("div:contains(店铺成交转化率)").children("strong").html();
			shopDealRate = shopDealRate.replace(",","");
			shopDealRate = shopDealRate.replace("￥","");
			var firstPaymentRate=$("div:contains(先款付款率)").children("strong").html();
			firstPaymentRate = firstPaymentRate.replace(",","");
			firstPaymentRate = firstPaymentRate.replace("￥","");
			var thirtyCustomerRetention=$("div:contains(30日客户回头率)").children("strong").html();
			thirtyCustomerRetention = thirtyCustomerRetention.replace(",","");
			thirtyCustomerRetention = thirtyCustomerRetention.replace("￥","");
			var thirtyRepeatPurchaseRate=$("div:contains(30日重复购买率)").children("strong").html();
			thirtyRepeatPurchaseRate = thirtyRepeatPurchaseRate.replace(",","");
			thirtyRepeatPurchaseRate = thirtyRepeatPurchaseRate.replace("￥","");
			var liuliang = "";
			liuliang+="[{\"goodsVolume\":\"" + goodsVolume+"\",";
			liuliang+="\"shopVolume\":\"" + shopVolume+"\",";
			
			liuliang+="\"shopDealRate\":\"" + shopDealRate+"\",";
			liuliang+="\"firstPaymentRate\":\"" + firstPaymentRate+"\",";
			
			liuliang+="\"thirtyCustomerRetention\":\"" + thirtyCustomerRetention+"\",";
			liuliang+="\"thirtyRepeatPurchaseRate\":\"" + thirtyRepeatPurchaseRate+"\",";
			
			liuliang+="\"flowTime\":\"" + strYesterday+"\",";
			liuliang+="\"nowTime\":\"" + myday+"\",";
			liuliang+="\"shopName\":\"" + shopName+"\",";
			liuliang+="\"platform\":\"" + "京东"+"\",";
			liuliang+="\"version\":\"" + version+"\"}]";
			liuliang = liuliang.replace(/%/g, "*");
//			alert(liuliang);
			var spu=$("div:contains(上架商品数量(SPU))").children("strong").html();
			spu = spu.replace(",","");
			spu = spu.replace("￥","");
			var sku=$("div:contains(上架商品数量(SKU))").children("strong").html();
			sku = sku.replace(",","");
			sku = sku.replace("￥","");
			var shangjia = "";
			shangjia+="[{\"spu\":\"" + spu+"\",";
			shangjia+="\"sku\":\"" + sku+"\",";
			shangjia+="\"goodsTime\":\"" + strYesterday+"\",";
			shangjia+="\"nowTime\":\"" + myday+"\",";
			shangjia+="\"shopName\":\"" + shopName+"\",";
			shangjia+="\"platform\":\"" + "京东"+"\",";	
			shangjia+="\"version\":\"" + version+"\"}]";	
//			alert(shangjia);
			
			
			var zhibiao = "[";
		    for(var i=0;i<24;i++){
		    	var detail = new Array();
		    	var j=i+1;
		    	var z=0;
		    	if(i<10){
		    		$("td:contains(0"+i+":00 -- 0"+j+":00)").parents("tr").children("td").each(function(){
		    			detail[z] = $(this).text().toString().trim();
		    			detail[z] =detail[z].replace(",","");
		    			detail[z] =detail[z].replace("￥","");
		    			z++;
		    		});
		    	}
		    	if(i>8){
		    		$("td:contains("+i+":00 -- "+j+":00)").parents("tr").children("td").each(function(){
		    			detail[z] = $(this).text().toString().trim();
		    			detail[z] =detail[z].replace(",","");
		    			detail[z] =detail[z].replace("￥","");
		    			z++;
		    		});
		    	}
		    	
		    	zhibiao+="{\"times\":\"" + detail[0]+"\",";
		    	zhibiao+="\"pageviews\":\"" + detail[1]+"\",";
		    	zhibiao+="\"visitors\":\"" + detail[2]+"\",";
		    	zhibiao+="\"sales\":\"" + detail[3]+"\",";
		    	zhibiao+="\"orderClientNum\":\"" + detail[4]+"\",";
		    	zhibiao+="\"orderQuantity\":\"" + detail[5]+"\",";
		    	zhibiao+="\"orderGoodsNum\":\"" + detail[6]+"\",";
		    	zhibiao+="\"saleTime\":\"" + strYesterday+"\",";
		    	zhibiao+="\"nowTime\":\"" + myday+"\",";
		    	zhibiao+="\"shopName\":\"" + shopName+"\",";
		    	zhibiao+="\"platform\":\"" + "京东"+"\",";	
		    	zhibiao+="\"version\":\"" + version+"\"},";	
		    	
		    }
		    zhibiao=zhibiao.substring(0, zhibiao.length-1)+"]";
//		    alert(zhibiao);
		    $("span:contains(经营报告)").after("<form  id='salespost' method='post' action='"+b+"/ZQAction.action'></form>");
		    $("#salespost").append("<input type='hidden' name='xiaoliang' value='"+xiaoliang+"' />");
		    $("#salespost").append("<input type='hidden' name='liuliang' value='"+liuliang+"' />");
		    $("#salespost").append("<input type='hidden' name='shangjia' value='"+shangjia+"' />");
		    $("#salespost").append("<input type='hidden' name='zhibiao' value='"+zhibiao+"' />");
		    $("#salespost").append("<input type='hidden' name='variable' id='variable' value='jdsalespost' />");

//		    window.open($("span:contains(按天流量分析)").parents("a"). attr("href"),"_blank");
//		    window.open($("span:contains(流量来源分析)").parents("a"). attr("href"),"_blank");
		    $("#salespost").submit();
			
			
		}
		
		//京东页面=====================================================================
		else if(window.location.pathname=="/model/viewFlow/viewFlow.jsp"){
			"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
			$("#viewFlowDetailTab").children("thead");
			var laiyuan = "";
			var row = new Array();
			var z = 0;
			$("#viewFlowDetailTab").children("tbody").children("tr").each(function(){
				row[z] = $(this).attr("id");
				z++;
			});
			
			
				for(var j=0;j<z;j++){
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
						var id = row[j];
						$("#"+id).children("td").each(function(){
							a[i] = $(this).text().toString().trim();
							i++;
						});
					}
					 laiyuan+="{\"flowSource\":\"" + a[0]+"\",";
					 laiyuan+="\"landPageView\":\"" + a[1]+"\",";
					 laiyuan+="\"landPageViewAccounted\":\"" + a[2]+"\",";
					 laiyuan+="\"pageView\":\"" + a[3]+"\",";
					 laiyuan+="\"pageViewAccounted\":\"" + a[4]+"\",";
					 laiyuan+="\"flowSourceTime\":\"" + strYesterday+"\",";
					 laiyuan+="\"nowTime\":\"" + myday+"\",";
					 laiyuan+="\"shopName\":\"" + shopName+"\",";
					 laiyuan+="\"platform\":\"" + "京东"+"\",";
					 laiyuan+="\"version\":\"" + version+"\"},";
				}
				laiyuan = laiyuan.substring(0, laiyuan.length-1);
				laiyuan = "["+laiyuan.replace(/%/g, "*")+"]";
				alert(laiyuan);
				$("span:contains(浏览量占比)").after("<form  id='flowSourcepost' method='post' action='"+b+"/ZQAction.action'></form>");
			    $("#flowSourcepost").append("<input type='hidden' name='laiyuan' value='"+laiyuan+"' />");
			    $("#flowSourcepost").append("<input type='hidden' name='variable' id='variable' value='jdflowSourcepost' />");
			    $("#flowSourcepost").submit();
				   
		}
		
		//京东页面====================================================================
		else if(window.location.pathname=="/model/viewFlowForDay/viewFlowForDay.jsp"){
			"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
			window.setInterval(function laiyuan(){
		    var flowInfo = "";
	//	    alert(strYesterday);
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
		    flowInfo+="\"shopName\":\"" + shopName+"\",";
		    flowInfo+="\"version\":\"" + version+"\"}]";
		   
		    flowInfo = flowInfo.replace(/%/g, "*");
		    
		    alert(flowInfo);
		    $("span:contains(按天流量分析)").after("<form class='flow' id='flowpost' method='post' action='"+b+"/ZQAction.action'></form>");
		    $("#flowpost").append("<input type='hidden' name='flowInfo' value='"+flowInfo+"' />");
		    $("#flowpost").append("<input type='hidden' name='variable' id='variable' value='jdflowpost' />");
		    $("#flowpost").submit();
		},2000);
		}
	}
	//当当****************************************************************************
	if(window.location.hostname=="report.dangdang.com"){
		//店名
		var shopName = $(".bd_title").children("div").children("b").text();
//		shopName = shopName.substring(shopName.indexOf("("),shopName.length-8);
		shopName = shopName.substring(0,shopName.length-8);
//		shopName = shopName.replace(/(//g, "*");
//		alert(shopName);
		//当当页面=======================================================================
	if(window.location.pathname=="/shop-s"){
			alert(window.location.pathname);
			$("#banner_searchInfo").after('<a id="capture"  style="" href="#">抓取数据</a>');
			$("#capture").click(function() {
				 window.open($("#banner_shopInfo"). attr("href"),"_blank");
				 window.open($("#banner_flowInfo"). attr("href"),"_blank");
			});
		}
		//当当页面=======================================================================
	if(window.location.pathname=="/shop-info"){
		"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
		$("#shop_left");
//		window.setInterval(function shopinfo(){
		var head = new Array();
		var j = 0;
		var body = new Array();
		var z = 0;
		$("#shop_right_head").children("tr").children("td").each(function(){
			head[j] = $(this).children("div").children("span").text().toString().trim();
			alert(head[j]);
			if("PV,UV,收订订单数,销售金额,购买转化率,平均访问页数,客单价,平均跳出率".contains(head[j])){
				body[z] = j;
				alert(body[z]);
				z++;
			}
	    	j++;
		});
		
		var detail = new Array();
	    var i = 0;
		$("#shop_detail_right").children("tr").children("td").each(function(){
			detail[i] = $(this).text().toString().trim();
	    	i++;
		});
		var xiaoliang = "";
		xiaoliang+="[{\"sales\":\"" + detail[body[3]]+"\",";
		xiaoliang+="\"clientPrice\":\"" + detail[body[6]]+"\",";
		xiaoliang+="\"orderQuantity\":\"" + detail[body[2]]+"\",";
		xiaoliang+="\"saleTime\":\"" + strYesterday+"\",";
		xiaoliang+="\"nowTime\":\"" + myday+"\",";
		xiaoliang+="\"shopName\":\"" + shopName+"\",";
		xiaoliang+="\"platform\":\"" + "dangdang"+"\",";	
		xiaoliang+="\"version\":\"" + version+"\"}]";	
		alert(xiaoliang);

		var liuliang = "";
		liuliang+="[{\"pageviews\":\"" + detail[body[0]]+"\",";
		liuliang+="\"visitors\":\"" + detail[body[1]]+"\",";
		liuliang+="\"shopDealRate\":\"" + detail[body[4]]+"\",";
		liuliang+="\"avgVisitDepth\":\"" + detail[body[5]]+"\",";
		liuliang+="\"bounceRate\":\"" + detail[body[7]]+"\",";
		liuliang+="\"flowTime\":\"" + strYesterday+"\",";
		liuliang+="\"nowTime\":\"" + myday+"\",";
		liuliang+="\"shopName\":\"" + shopName+"\",";
		liuliang+="\"platform\":\"" + "dangdang"+"\",";
		liuliang+="\"version\":\"" + version+"\"}]";
		
		liuliang = liuliang.replace(/%/g, "*");
		alert(liuliang);
		
		$.post(b + "/ZQAction",{xiaoliang:xiaoliang,liuliang:liuliang,variable:"ddsalespost"},function(){});
//		$("#charts").after("<form  id='salespost' method='post' action='"+b+"/ZQAction.action'></form>");
//	    $("#salespost").append("<input type='hidden' name='xiaoliang' value='"+xiaoliang+"' />");
//	    $("#salespost").append("<input type='hidden' name='liuliang' value='"+liuliang+"' />");
//	    $("#salespost").append("<input type='hidden' name='variable' id='variable' value='ddsalespost' />");
//	    $("#salespost").submit();
		
//		},2000);
		}
	
	//当当页面==================================================================
	else if(window.location.pathname=="/shop-flow-source"){
		"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
		$("td:contains(流量来源)");
//		window.setInterval(function shopflowsource(){
		var n = "";
		$("td:contains(流量来源)").parents("table").children("tbody").find("td").each(function(){
			var date = $(this).text();
			n += date +",";
		});	
		var f = n.substring(0,n.length-1);
		var head = $("td:contains(流量来源)").parents("table").children("tbody").children("tr");
		var k = f.split(",");
		var ddllly1="";
		var ddllly2="";
//		var ddllly3="";
		for(var i=0;i<head.length;i++){
			for(var j=i+9*i;j<(i+1)*10;j=j+10){				
					var num1 = k[j];
//					var num2 = k[j+1];
					var num3 = k[j+2];
//					var num4 = k[j+3];
//					var num5 = k[j+4];
//					var num6 = k[j+5];
//					var num7 = k[j+6];
//					var num8 = k[j+7];
//					var num9 = k[j+8];
//					var num10 = k[j+9];		
			}
			var ddllly = "{\"flowSource\":\""+ num1 +"\",";
			ddllly+="\"pageView\":\"" + num3+"\",";
			ddllly+="\"flowSourceTime\":\"" + strYesterday+"\",";
			ddllly+="\"nowTime\":\"" + myday+"\",";
			ddllly+="\"shopName\":\"" + shopName+"\",";
			ddllly+="\"platform\":\"" + "dangdang"+"\",";
			ddllly+="\"version\":\"" + version+"\"},";
			ddllly1 += ddllly;
		}
		ddllly2 = ddllly1.substring(0, ddllly1.length-1);
		var laiyuan = "["+ddllly2+"]";
		alert(laiyuan);

//		$.post(b + "/ZQAction",{laiyuan:laiyuan,variable:"ddflowSourcepost"},function(){});
//		$(".bd_title").children("div").children("b").after("<form  id='flowSourcepost' method='post' action='"+b+"/ZQAction.action'></form>");
//	    $("#flowSourcepost").append("<input type='hidden' name='laiyuan' value='"+laiyuan+"' />");
//	    $("#flowSourcepost").append("<input type='hidden' name='variable' id='variable' value='ddflowSourcepost' />");
//	    $("#flowSourcepost").submit();

//		},2000);
//		window.open($("a:contains(流量概览)"). attr("href"),"_blank");
	    
	}
	
	//当当页面=========================================================================
	else if(window.location.pathname=="/shop-flow-entire"){
		"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
		$(".bd_title");
//		window.setInterval(function shopflowentire(){
		var zhibiao = "[";
	    for(var i=1;i<25;i++){
	    	var detail = new Array();
	    	var j=0;
	    	if(i<10){
	    		$("td:contains(0"+i+":00:00)").parents("tr").children("td").each(function(){
	    			detail[j] = $(this).text().toString().trim();
	    			j++;
	    		});
	    	}
	    	if(i>8){
	    		$("td:contains("+i+":00:00)").parents("tr").children("td").each(function(){
	    			detail[j] = $(this).text().toString().trim();
	    			j++;
	    		});
	    	}
	    	
	    	zhibiao+="{\"times\":\"" + detail[0]+"\",";
	    	zhibiao+="\"pageviews\":\"" + detail[1]+"\",";
	    	zhibiao+="\"visitors\":\"" + detail[2]+"\",";
	    	zhibiao+="\"orderClientNum\":\"" + detail[3]+"\",";
	    	zhibiao+="\"saleTime\":\"" + strYesterday+"\",";
	    	zhibiao+="\"nowTime\":\"" + myday+"\",";
	    	zhibiao+="\"shopName\":\"" + shopName+"\",";
	    	zhibiao+="\"platform\":\"" + "dangdang"+"\",";	
	    	zhibiao+="\"version\":\"" + version+"\"},";	
	    	
	    }
	    zhibiao=zhibiao.substring(0, zhibiao.length-1)+"]";
//	    alert(zhibiao);
	    $.post(b + "/ZQAction",{zhibiao:zhibiao,variable:"ddsales"},function(data){
	    	alert(data);
	    });
//	    $(".bd_title").children("div").children("b").after("<form  id='salespost' method='post' action='"+b+"/ZQAction.action'></form>");
//	    $("#salespost").append("<input type='hidden' name='zhibiao' value='"+zhibiao+"' />");
//	    $("#salespost").append("<input type='hidden' name='variable' id='variable' value='ddsales' />");
//	    $("#salespost").submit();
//		},2000);
	}
	
	}
	
	//淘宝************************************************************************************
	if(window.location.hostname=="lz.taobao.com"){
			//店名
			var shopName = $("#usr_name_all").children("a").text();
		//淘宝页面==========================================================
			alert(window.location.hash);
		if(window.location.hash=="#!/diagnose/lznewhealthyreport/~"){
			$("#st_time_submit").after('<a class="date_d_viewBtn" id="capture"  href="#">抓取数据</a>');
			$("#capture").click(function() {
				 window.open($("#J_ms_mid__15"). attr("href"),"_blank");
				 window.open($("#J_ms_mid__1"). attr("href"),"_blank");
			});
		}
		//淘宝页面==========================================================
		else if(window.location.hash=="#selldetail/~"){
			window.setTimeout(function selldetail(){
				var detail = new Array();
				var i=0;
				$(".right-container").children("table").children("tbody").children("tr").children("td").each(function(){
					detail[i] = $(this).html();
			    	i++;
			    	if(i>26){
			    		return false;
			    	}
				});
				var xiaoliang = "";
				xiaoliang+="[{\"sales\":\"" + detail[8]+"\",";
				xiaoliang+="\"clientPrice\":\"" + detail[21]+"\",";
				xiaoliang+="\"orderClientNum\":\"" + detail[9]+"\",";
				xiaoliang+="\"orderQuantity\":\"" + detail[7]+"\",";
				xiaoliang+="\"orderGoodsNum\":\"" + detail[5]+"\",";
				xiaoliang+="\"saleTime\":\"" + strYesterday+"\",";
				xiaoliang+="\"nowTime\":\"" + myday+"\",";
				xiaoliang+="\"shopName\":\"" + shopName+"\",";
				xiaoliang+="\"platform\":\"" + "淘宝"+"\",";	
				xiaoliang+="\"version\":\"" + version+"\"}]";	
//				alert(xiaoliang);
				
				var liuliang = "";
				liuliang+="[{\"pageviews\":\"" + detail[0]+"\",";
				liuliang+="\"visitors\":\"" + detail[1]+"\",";
				liuliang+="\"avgVisitDepth\":\"" + detail[4]+"\",";
				liuliang+="\"backVisitorsRate\":\"" + detail[3]+"\",";
				
				liuliang+="\"shopDealRate\":\"" + detail[25]+"\",";
				
				liuliang+="\"flowTime\":\"" + strYesterday+"\",";
				liuliang+="\"nowTime\":\"" + myday+"\",";
				liuliang+="\"shopName\":\"" + shopName+"\",";
				liuliang+="\"platform\":\"" + "淘宝"+"\",";
				liuliang+="\"version\":\"" + version+"\"}]";
				
				liuliang = liuliang.replace(/%/g, "*");
		//		alert(liuliang);
				$("#limain1").after("<form  id='salespost' method='post' action='"+b+"/ZQAction.action'></form>");
			    $("#salespost").append("<input type='hidden' name='xiaoliang' value='"+xiaoliang+"' />");
			    $("#salespost").append("<input type='hidden' name='liuliang' value='"+liuliang+"' />");
			    $("#salespost").append("<input type='hidden' name='variable' id='variable' value='tbsalespost' />");
			    $("#salespost").submit();
			},5000);
		}
		//淘宝页面==========================================================
		else if(window.location.hash=="#shopsummary/~"){
			window.setInterval(function shopsummary(){
			var flow = new Array();
		    var i = 0;
			$("td:contains(昨日)").parents("tr").children("td").each(function(){
				flow[i] = $(this).text().toString().trim();
		    	i++;
			});
			var flowInfo = "";
			flowInfo+="[{\"flowTime\":\"" + strYesterday+"\",";
		    flowInfo+="\"avgPaceTime\":\"" + flow[4]+"\",";
		    flowInfo+="\"shopName\":\"" + shopName+"\",";
		    flowInfo+="\"version\":\"" + version+"\"}]";
			   
			flowInfo = flowInfo.replace(/%/g, "*");
			$("a:contains(查看实时成交 )").after("<form class='flow' id='flowpost' method='post' action='"+b+"/ZQAction.action'></form>");
		    $("#flowpost").append("<input type='hidden' name='flowInfo' value='"+flowInfo+"' />");
		    $("#flowpost").append("<input type='hidden' name='variable' id='variable' value='tbflowpost' />");
		    $("#flowpost").submit();
			},2000);
		}
	}
	
	//凡客*************************************************************************************
	if(window.location.hostname=="win.vjia.com"){
		//店名
		var shopName = $("div.fl").text().toString().trim();
		shopName = shopName.substring(shopName.indexOf("("),shopName.length-17);
		//前一天日期1
		var   today=new   Date();            //月份为0-11
	    var   yesterday_milliseconds=today.getTime()-1000*60*60*24;      
	    var   yesterday=new   Date();      
	    yesterday.setTime(yesterday_milliseconds);      
	       
	    var strYear=yesterday.getFullYear();   
	    var strDay=yesterday.getDate();   
	    var strMonth=yesterday.getMonth()+1;   
	    var strYesterdayTwo=strYear+"-"+strMonth+"-"+strDay; 
	  //前一天日期2
		var   today=new   Date();            //月份为0-11
	    var   yesterday_milliseconds=today.getTime()-1000*60*60*24;      
	    var   yesterday=new   Date();      
	    yesterday.setTime(yesterday_milliseconds);      
	       
	    var strYear=yesterday.getFullYear();   
	    var strDay=yesterday.getDate();   
	    var strMonth=yesterday.getMonth()+1;   
	    var strYesterday1=strYear+"/"+strMonth+"/"+strDay; 
	    //前一天日期3
	    var   today=new   Date();            //月份为0-11
	    var   yesterday_milliseconds=today.getTime()-1000*60*60*24;      
	    var   yesterday=new   Date();      
	    yesterday.setTime(yesterday_milliseconds);      
	    
	    var strYear=yesterday.getFullYear();   
	    var strDay=yesterday.getDate();   
	    var strMonth=yesterday.getMonth()+1;   
	    var strYesterday2=strYear+"-"+strMonth+"-"+strDay; 

//		alert(strYesterday);
	    
	    //凡客页面==========================================================
	    if(window.location.pathname=="/SelfShip/AllOrder.aspx"){
	    	$("#affiche_scroll").after('<a id="capture" style="cursor: pointer;display: inline-block;height: 25px;line-height: 25px;text-align: center;width: 100px;color: blue;" href="#">抓取数据</a>');
	    	$("#capture").click(function() {
				 window.open($("a:contains(销售分析)"). attr("href"),"_blank");
				 window.open($("a:contains(流量分析)"). attr("href"),"_blank");
			});
//	    	$("#d5221").val(strYesterday);
//	    	$("#d5222").val(strYesterday);
//	    	$("#btnSearch").click();
//	    	if($("a:contains(下一页)").text()=="下一页"){
//	    		window.open($("a:contains(下一页)"). attr("href"),"_blank");
//	    	}
	    	$(".order_list").children("tbody").children("tr.order-hd").each(function(){
	    		window.open($(this).children("td").children("div").children("span:contains(订单编号：)").children("a"). attr("href"),"_blank");
	    	});
//	    	window.open($("span:contains(订单编号：)").children("a"). attr("href"),"_blank");
	    }
	    if(window.location.pathname=="/SelfShip/orderdetails.aspx"){
			"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
	    	$("li:contains(收 货 人：)").text();
			var wantdoName = clientName = $("li:contains(收 货 人：)").text().toString().trim();
			wantdoName = wantdoName.substring(4,9);
			if(wantdoName.indexOf("W")<0){
				var clientName = $("li:contains(收 货 人：)").text().toString().trim();
				clientName = clientName.substring(clientName.indexOf("：")+1,clientName.length);
				var orderPrice = $("li:contains(商品总金额：)").text().toString().trim();
				orderPrice = orderPrice.substring(orderPrice.indexOf("：")+2,orderPrice.length);
				var goodsNum = $("li:contains(商品数量总计：)").text();
				goodsNum = goodsNum.substring(goodsNum.indexOf("：")+1,goodsNum.indexOf("优"));
				goodsNum = goodsNum.trim();
				var saleJson = "[{";
				saleJson += "\"sales\":\"" + orderPrice+"\",";
				saleJson += "\"goodsNum\":\"" + goodsNum+"\",";
				saleJson += "\"clientName\":\"" + clientName+"\",";
				saleJson+="\"saleTime\":\"" + strYesterday+"\",";
				saleJson+="\"shopName\":\"" + shopName+"\"}]";	
				$("a:contains(商品信息管理)").after("<form  id='salespost' method='post' action='"+b+"/OrderSaleAction.action'></form>");
			    $("#salespost").append("<input type='hidden' name='saleJson' value='"+saleJson+"' />");
			    $("#salespost").append("<input type='hidden' name='variable' id='variable' value='fkordersalespost' />");
			    $("#salespost").submit();
			}
	    }
	    //凡客页面==========================================================
	    if(window.location.pathname=="/SalesUI/todayobserve.aspx"){
	    	window.open($("a:contains(销售明细)"). attr("href"),"_blank");
	    	
	    }
	    //凡客页面==========================================================
	    else if(window.location.pathname=="/SalesUI/SalesDetails.aspx"){
			"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
			$("div:contains("+strYesterdayTwo+")");
			var detail = new Array();
		    var i = 0;
			$("div:contains("+strYesterdayTwo+")").parents("td").parents("tr").children("td").each(function(){
				detail[i] = $(this).text().toString().trim();
		    	i++;
			});
			var xiaoliang = "";
			xiaoliang+="[{\"sales\":\"" + detail[13]+"\",";
			xiaoliang+="\"saleTime\":\"" + strYesterday+"\",";
			xiaoliang+="\"nowTime\":\"" + myday+"\",";
			xiaoliang+="\"shopName\":\"" + shopName+"\",";
			xiaoliang+="\"platform\":\"" + "凡客"+"\",";	
			xiaoliang+="\"version\":\"" + version+"\"}]";	
//			alert(xiaoliang);
			$("#ctl00_ContentPlaceHolder1_ReportViewer1_ctl04_ctl00").after("<form  id='salespost' method='post' action='"+b+"/ZQAction.action'></form>");
		    $("#salespost").append("<input type='hidden' name='xiaoliang' value='"+xiaoliang+"' />");
		    $("#salespost").append("<input type='hidden' name='variable' id='variable' value='fksales1' />");
		    $("#salespost").submit();
		}
		//凡客页面==========================================================
		if(window.location.pathname=="/PVUI/MallPVShopAndProduct.aspx"){
			"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
			$("div:contains("+strYesterday2+")");
			var detail = new Array();
		    var i = 0;
			$("div:contains("+strYesterday2+")").parents("td").parents("tr").children("td").each(function(){
				detail[i] = $(this).text().toString().trim();
		    	i++;
			});
			var liuliang = "";
			liuliang+="[{\"pageviews\":\"" + detail[12]+"\",";
			liuliang+="\"visitors\":\"" + detail[13]+"\",";
			liuliang+="\"shopDealRate\":\"" + detail[15]+"\",";
			liuliang+="\"flowTime\":\"" + strYesterday+"\",";
			liuliang+="\"nowTime\":\"" + myday+"\",";
			liuliang+="\"shopName\":\"" + shopName+"\",";
			liuliang+="\"platform\":\"" + "凡客"+"\",";
			liuliang+="\"version\":\"" + version+"\"}]";
			
			liuliang = liuliang.replace(/%/g, "*");
//			alert(liuliang);
			$("#ctl00_ContentPlaceHolder1_ReportViewer1_ctl04_ctl00").after("<form  id='salespost' method='post' action='"+b+"/ZQAction.action'></form>");
		    $("#salespost").append("<input type='hidden' name='liuliang' value='"+liuliang+"' />");
		    $("#salespost").append("<input type='hidden' name='variable' id='variable' value='fksales3' />");
		    $("#salespost").submit();
		}
	    //凡客页面==========================================================
		if(window.location.pathname=="/PVUI/MallPVHouseData.aspx"){
			"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
			$("#ctl00_ContentPlaceHolder1_ReportViewer1_ctl04_ctl03_txtValue").val(strYesterday1+" 0:00:00");
			var a = $("td:contains( 0:00)").children("div:contains( 0:00)").text().toString().trim();
			a = a.substring(a.indexOf("2"),a.indexOf(" "));
			if(a == strYesterday1){
				var zhibiao = "[";
				for(var i=0;i<24;i++){
					var j=0;
					var detail = new Array();
					$("td:contains("+strYesterday1+" "+i+":00)").parent("tr").children("td").children("div").each(function(){
						detail[j] = $(this).text().toString().trim();
						j++;
					});
					zhibiao+="{\"times\":\"" + detail[3]+"\",";
					zhibiao+="\"pageviews\":\"" + detail[4]+"\",";
					zhibiao+="\"visitors\":\"" + detail[5]+"\",";
					zhibiao+="\"saleTime\":\"" + strYesterday1+"\",";
					zhibiao+="\"nowTime\":\"" + myday+"\",";
					zhibiao+="\"shopName\":\"" + shopName+"\",";
					zhibiao+="\"platform\":\"" + "凡客"+"\",";	
					zhibiao+="\"version\":\"" + version+"\"},";	
				}
				zhibiao=zhibiao.substring(0, zhibiao.length-1)+"]";
				zhibiao = zhibiao.replace("\\s*|\t|\r|\n", "");
//				alert(zhibiao);
				$("#ctl00_ContentPlaceHolder1_ReportViewer1_ctl04_ctl00").after("<form  id='salespost' method='post' action='"+b+"/ZQAction.action'></form>");
				$("#salespost").append("<input type='hidden' name='zhibiao' value='"+zhibiao+"' />");
				$("#salespost").append("<input type='hidden' name='variable' id='variable' value='fksales2' />");
				$("#salespost").submit();
			}
		}
	}
	
	//亚马逊***************************************************************
	if(window.location.hostname=="mai.amazon.cn"){
		//店名
		var shopName = $("#merchant-name").text().toString().trim();

		//亚马逊页面==========================================================
		if(window.location.pathname=="/gp/homepage.html"){
			$(".sc-mkt-switcher-flag").before('<a id="capture" style="cursor: pointer;display: inline-block;height: 25px;line-height: 25px;text-align: center;width: 100px;color: blue;" href="#">抓取数据</a>');
			$("#capture").click(function() {
				window.open($("a:contains(业务报告)"). attr("href"),"_blank");
			});
			
		}
//		alert(window.location.pathname=="/gp/site-metrics/report.html" && window.location.hash.substring(0, window.location.hash.indexOf("="))=="#&cols");
//		alert(window.location.pathname);
	    //亚马逊页面==========================================================
		if(window.location.pathname=="/gp/site-metrics/report.html" && window.location.hash.substring(0, window.location.hash.indexOf("="))=="#&cols"){
			"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
			$("a:contains(业务报告)");
//			window.open($("#report_SalesTrafficTimeSeries"). attr("href"),"_blank");
//			if($("#reportTitle").text()=="销售"){
			
			var detail = new Array();
		    var i = 0;
			$("td:contains("+strYesterday+")").parents("tr").children("td").each(function(){
				detail[i] = $(this).text().toString().trim();
		    	i++;
			});
			var xiaoliang = "";
			xiaoliang+="[{\"sales\":\"" + detail[2]+"\",";
			xiaoliang+="\"orderQuantity\":\"" + detail[4]+"\",";
			xiaoliang+="\"orderGoodsNum\":\"" + detail[3]+"\",";
			xiaoliang+="\"saleTime\":\"" + strYesterday+"\",";
			xiaoliang+="\"nowTime\":\"" + myday+"\",";
			xiaoliang+="\"shopName\":\"" + shopName+"\",";
			xiaoliang+="\"platform\":\"" + "亚马逊"+"\",";	
			xiaoliang+="\"version\":\"" + version+"\"}]";	
			alert(xiaoliang);
			$("#reportTitle").after("<form  id='salespost' method='post' action='"+b+"/ZQAction.action'></form>");
		    $("#salespost").append("<input type='hidden' name='xiaoliang' value='"+xiaoliang+"' />");
		    $("#salespost").append("<input type='hidden' name='variable' id='variable' value='ymxsalespost' />");
//		    $("#salespost").submit();
			
//			}
		}
	}
//	//亚马逊***************************************************************
//	if(window.location.hostname=="mai.amazon.cn"){
//		//店名
//		var shopName = $("#merchant-name").text().toString().trim();
//		//亚马逊页面==========================================================
//		if(window.location.pathname=="/gp/homepage.html" ){
//				$(".sc-mkt-switcher-flag").before('<a id="capture" style="cursor: pointer;display: inline-block;height: 25px;line-height: 25px;text-align: center;width: 100px;color: blue;" href="#">抓取数据</a>');
//			$("#capture").click(function() {
//				window.open($("a:contains(业务报告)"). attr("href"),"_parent");
//				});
//		}
//	    //亚马逊页面==========================================================
//		if(window.location.pathname=="/gp/site-metrics/report.html" ){
//			window.setInterval(function report(){
//			if(window.location.hash.substring(0, window.location.hash.indexOf("="))=="#&reportID"){
//				window.open($("#report_SalesTrafficTimeSeries"). attr("href"),$("#report_SalesTrafficTimeSeries").attr("target"));
//				}
//			if(window.location.hash.substring(0, window.location.hash.indexOf("="))=="#&cols"){
//			var detail = new Array();
//		    var i = 0;
//			$("td:contains("+strYesterday+")").parents("tr").children("td").each(function(){
//				detail[i] = $(this).text().toString().trim();
//		    	i++;
//			});
//			var xiaoliang = "";
//			xiaoliang+="[{\"sales\":\"" + detail[2]+"\",";
//			xiaoliang+="\"orderQuantity\":\"" + detail[4]+"\",";
//			xiaoliang+="\"orderGoodsNum\":\"" + detail[3]+"\",";
//			xiaoliang+="\"saleTime\":\"" + strYesterday+"\",";
//			xiaoliang+="\"nowTime\":\"" + myday+"\",";
//			xiaoliang+="\"shopName\":\"" + shopName+"\",";
//			xiaoliang+="\"platform\":\"" + "亚马逊"+"\",";	
//			xiaoliang+="\"version\":\"" + version+"\"}]";	
////			alert(xiaoliang);
//			$("#reportTitle").after("<form  id='salespost' method='post' action='"+b+"/ZQAction.action'></form>");
//		    $("#salespost").append("<input type='hidden' name='xiaoliang' value='"+xiaoliang+"' />");
//		    $("#salespost").append("<input type='hidden' name='variable' id='variable' value='ymxsalespost' />");
//		    $("#salespost").submit();
//			
//		}
//		},5000);
//		}
//	}
	
//	alert(window.location.hostname);
	//当当订单****************************************************************************
	if(window.location.hostname=="mt.dangdang.com"){
		"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
		$("a:contains(管理首页)");
		//日期1
		var   today=new   Date();            //月份为0-11
		var   yesterday_milliseconds=today.getTime()-1000*60*60*24;      
		var   day1=new   Date();      
		day1.setTime(yesterday_milliseconds); 
		
		var strYear=day1.getFullYear();   
		var strDay=day1.getDate();   
		var strMonth=day1.getMonth()+1;   
		if(strMonth<10)   
		{   
			strMonth="0"+strMonth;   
		}   
		if(strDay<10)   
		{   
			strDay="0"+strDay;   
		}   
		var strday1=strYear+"-"+strMonth+"-"+strDay+" 00:00:00"; 
		
		//日期2
		var   today=new   Date();            //月份为0-11
		var   yesterday_milliseconds=today.getTime();      
		var   day2=new   Date();      
		day2.setTime(yesterday_milliseconds); 
		
		var strYear=day2.getFullYear();   
		var strDay=day2.getDate();   
		var strMonth=day2.getMonth()+1;   
		if(strMonth<10)   
		{   
			strMonth="0"+strMonth;   
		}   
		if(strDay<10)   
		{   
			strDay="0"+strDay;   
		}   
		var strday2=strYear+"-"+strMonth+"-"+strDay+" 00:00:00"; 
		
		//店名
		var shopName = $("a:contains(帮助中心)").next().next().next().next().next().text().toString().trim();
		if(window.location.pathname=="/order/list/index"){
//			alert(window.location.pathname);
			$("#create_date_begin").val(strday1);
			$("#create_date_end").val(strday2);
			 window.setTimeout(function a(){$("#search").click();},100);
			 window.setTimeout(function b(){window.location.reload();},1000);
			
		}
		if(window.location.pathname=="/order/list/search"){
			$("#PageNumsForSelect").val("30");
			window.setTimeout(function b(){window.location.reload();},1000);
			window.setTimeout(function a(){
				$(".down").click();
//				window.open($(".down"). attr("href"),"_blank")
				},2000);
			var s=0
			$("table").children("tbody").children("tr").children("td").children("i.mark").parents("td").each(function(){
				order = $(this).text().toString().trim();
//				alert($($(this)+":contains('取消')").text());
				if(order !="取消" && order !="等待到款"){
						window.setTimeout(function a(){window.open($(this).parent("tr").children("td.tx_l_block").find("a:contains(详情)"). attr("href"))},s);
						s = s + 1000;
				}
			});
			
		}
		
	}
	//京东订单****************************************************************************
	if(window.location.hostname=="order.shop.jd.com"){
		
	}
//	alert("111");
	//亚马逊订单****************************************************************************
	if(window.location.hostname=="mai.amazon.cn"){
		var   today=new   Date();            //月份为0-11
	    var   yesterday_milliseconds=today.getTime()-1000*60*60*24;      
	    var   yesterday=new   Date();      
	    yesterday.setTime(yesterday_milliseconds);      
	       
	    var strYear=yesterday.getFullYear();   
	    var strDay=yesterday.getDate();   
	    var strMonth=yesterday.getMonth()+1;   
	    var strYesterday1=strYear+"-"+strMonth+"-"+strDay; 
		if(window.location.pathname=="/gp/orders-v2/list/ref=pt_myo_dnav_myo_"){
			$("#_myoLO_preSelectedRangeSelect").val("1");
			$("#SearchID").click();
			window.setTimeout(function a(){
				$('select[name="itemsPerPage"]').val("100");
			$('select[name="itemsPerPage"]').parent("td").next().next().children("input").click();
//			var n = $('select[name="itemsPerPage"]').val();
		},1000);
//			window.setTimeout(function b(){
			var n = 0
//		},2000);
			var i=0;
			window.setTimeout(function c(){$(".data-display").children("tbody").children("tr").each(function(){

			n = $('select[name="itemsPerPage"]').val();
				if(i>n+2){
					return false;
					}
				if(i>2){
//					alert($(this).find("td:contains("+strYesterday1+")").next().children("a"). attr("href"));
//					window.open($(this).find("td:contains("+strYesterday1+")").next().children("a"). attr("href"),"_blank");
				}
				if(i==3){
					alert($(this).find("td:contains("+strYesterday1+")").next().children("a"). attr("href"));
					}
					if(i==4){
					alert($(this).find("td:contains("+strYesterday1+")").next().children("a"). attr("href"));
					}
					if(i==n+1){
						alert($(this).find("td:contains("+strYesterday1+")").next().children("a"). attr("href"));
						}
						if(i==n){
						alert($(this).find("td:contains("+strYesterday1+")").next().children("a"). attr("href"));
						}
					
				i++;
			});
			},2000);
		}
		else if(window.location.pathname=="/gp/orders-v2/details/ref=pt_orddet_cont_myo"){
			"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
			$("#sc_footer_merchant");
			var wantdoName = $("strong:contains(配送地址)").parent("td").text().toString().trim();
			wantdoName = wantdoName.substring(4,9);
			if(wantdoName.indexOf("W")<0){
				var shopName = $("#sc_footer_merchant").text().toString().trim();
				var orderPrice = $(".myo-row-payment-summary").children("td:contains(￥)").text().toString().trim();
				orderPrice =orderPrice.replace(",","");
				orderPrice =orderPrice.replace("￥","");
				var goodsNum = 0;
				var i=0;
				$("td:contains(订购数量)").parent("tr").parent("tbody").children("tr").each(function(){
					i++;
				});
				var j = i-3;
				if(j==1){
					var x=0
					$("td:contains(订购数量)").parent("tr").next("tr").children("td").each(function(){
						if(x==2){
							goodsNum = $(this).text().toString().trim();
						}
						x++;
					});
				}else{
					var y=0;
					$("td:contains(订购数量)").parent("tr").parent("tbody").children("tr").each(function(){
						var z=0;
						if(y>1){
							$(this).children("td").each(function(){
								if(z==2){
									goodsNum +=Number($(this).text());
								}
								z++;
							});
						}
						y++;
					});
				}
				var clientName = $("td:contains(联系买家:)").next().children("a").text().toString().trim();
				var saleJson = "[{";
				saleJson += "\"sales\":\"" + orderPrice+"\",";
				saleJson += "\"goodsNum\":\"" + goodsNum+"\",";
				saleJson += "\"clientName\":\"" + clientName+"\",";
				saleJson+="\"saleTime\":\"" + strYesterday+"\",";
				saleJson+="\"shopName\":\"" + shopName+"\"}]";	
				alert(saleJson);
				$("#sc_logo_top_image").after("<form  id='salespost' method='post' action='"+b+"/OrderSaleAction.action'></form>");
			    $("#salespost").append("<input type='hidden' name='saleJson' value='"+saleJson+"' />");
			    $("#salespost").append("<input type='hidden' name='variable' id='variable' value='ymxordersalespost' />");
	//		    $("#salespost").submit();
			}
		}
	}
	
	
}
var h,s=document.createElement("script");s.src="http://code.jquery.com/jquery-1.4.1.min.js",
	h=document.getElementsByTagName("head")[0],
	h.insertBefore(s,h.firstChild),
	setTimeout("daifaMode(durl);",50);
	