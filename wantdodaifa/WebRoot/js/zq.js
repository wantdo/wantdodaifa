function daifaMode(b) {
	// 当前日期
	Date.prototype.Format = function(fmt) {
		var o = {
			"M+" : this.getMonth() + 1, // 月份
			"d+" : this.getDate(), // 日
			"h+" : this.getHours(), // 小时
			"m+" : this.getMinutes(), // 分
			"s+" : this.getSeconds(), // 秒
			"q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
			"S" : this.getMilliseconds()
		// 毫秒
		};
		if (/(y+)/.test(fmt))
			fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
					.substr(4 - RegExp.$1.length));
		for ( var k in o)
			if (new RegExp("(" + k + ")").test(fmt))
				fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
						: (("00" + o[k]).substr(("" + o[k]).length)));
		return fmt;
	}
	var myday = new Date();
	myday = myday.Format("yyyy-MM-dd hh:mm:ss.S");

	// 前一天日期
	var today = new Date(); // 月份为0-11
	var yesterday_milliseconds = today.getTime() - 1000 * 60 * 60 * 24;
	var yesterday = new Date();
	yesterday.setTime(yesterday_milliseconds);

	var strYear = yesterday.getFullYear();
	var strDay = yesterday.getDate();
	var strMonth = yesterday.getMonth() + 1;
	if (strMonth < 10) {
		strMonth = "0" + strMonth;
	}
	if (strDay < 10) {
		strDay = "0" + strDay;
	}
	var strYesterday = strYear + "-" + strMonth + "-" + strDay;

	// 版本号
	var version = "1.0";
	// alert(window.location.hostname);

	// 京东*********************************************************************************
	if (window.location.hostname == "pop.jd.com") {
		var shopName = $("#shopNameTip").children("a").text().toString().trim();
		shopName = shopName.substring(3, shopName.length);
		// alert(shopName);

		// 京东页面==========================================================================
		if (window.location.pathname == "/model/shopOverview/opermodel.jsp") {
			"undefined" == typeof jQuery && setTimeout("daifaMode(durl);", 50),
					$("#shopNameTip");
			// 店名
			var shopName = $("#shopNameTip").children("a").text().toString()
					.trim();
			shopName = shopName.substring(3, shopName.length);

			var sales = $("div:contains(下单金额)").children("strong").html();
			sales = sales.replace(",", "");
			sales = sales.replace("￥", "");
			var clientPrice = $("div:contains(客单价)").children("strong").html();
			clientPrice = clientPrice.replace(",", "");
			clientPrice = clientPrice.replace("￥", "");
			var orderClientNum = $("div:contains(下单客户数)").children("strong")
					.html();
			orderClientNum = orderClientNum.replace(",", "");
			orderClientNum = orderClientNum.replace("￥", "");
			var orderQuantity = $("div:contains(下单单量)").children("strong")
					.html();
			orderQuantity = orderQuantity.replace(",", "");
			orderQuantity = orderQuantity.replace("￥", "");
			var orderGoodsNum = $("div:contains(下单商品件数)").children("strong")
					.html();
			orderGoodsNum = orderGoodsNum.replace(",", "");
			orderGoodsNum = orderGoodsNum.replace("￥", "");
//			var dataDate = $("#CurDate").val("2014-10-07");
//			alert(dataDate);
			var xiaoliang = "";
			xiaoliang += "[{\"sales\":\"" + sales + "\",";
			xiaoliang += "\"clientPrice\":\"" + clientPrice + "\",";
			xiaoliang += "\"orderClientNum\":\"" + orderClientNum + "\",";
			xiaoliang += "\"orderQuantity\":\"" + orderQuantity + "\",";
			xiaoliang += "\"orderGoodsNum\":\"" + orderGoodsNum + "\",";
			xiaoliang += "\"saleTime\":\"" + strYesterday + "\",";
			xiaoliang += "\"nowTime\":\"" + myday + "\",";
			xiaoliang += "\"shopName\":\"" + shopName + "\",";
			xiaoliang += "\"platform\":\"" + "京东" + "\",";
			xiaoliang += "\"version\":\"" + version + "\"}]";
//			alert(xiaoliang);

			var goodsVolume = $("div:contains(商品关注量)").children("strong")
					.html();
			goodsVolume = goodsVolume.replace(",", "");
			goodsVolume = goodsVolume.replace("￥", "");
			var shopVolume = $("div:contains(店铺关注量)").children("strong").html();
			shopVolume = shopVolume.replace(",", "");
			shopVolume = shopVolume.replace("￥", "");
			var shopDealRate = $("div:contains(店铺成交转化率)").children("strong")
					.html();
			shopDealRate = shopDealRate.replace(",", "");
			shopDealRate = shopDealRate.replace("￥", "");
			var firstPaymentRate = $("div:contains(先款付款率)").children("strong")
					.html();
			firstPaymentRate = firstPaymentRate.replace(",", "");
			firstPaymentRate = firstPaymentRate.replace("￥", "");
			var thirtyCustomerRetention = $("div:contains(30日客户回头率)").children(
					"strong").html();
			thirtyCustomerRetention = thirtyCustomerRetention.replace(",", "");
			thirtyCustomerRetention = thirtyCustomerRetention.replace("￥", "");
			var thirtyRepeatPurchaseRate = $("div:contains(30日重复购买率)")
					.children("strong").html();
			thirtyRepeatPurchaseRate = thirtyRepeatPurchaseRate
					.replace(",", "");
			thirtyRepeatPurchaseRate = thirtyRepeatPurchaseRate
					.replace("￥", "");
			var liuliang = "";
			liuliang += "[{\"goodsVolume\":\"" + goodsVolume + "\",";
			liuliang += "\"shopVolume\":\"" + shopVolume + "\",";

			liuliang += "\"shopDealRate\":\"" + shopDealRate + "\",";
			liuliang += "\"firstPaymentRate\":\"" + firstPaymentRate + "\",";

			liuliang += "\"thirtyCustomerRetention\":\""
					+ thirtyCustomerRetention + "\",";
			liuliang += "\"thirtyRepeatPurchaseRate\":\""
					+ thirtyRepeatPurchaseRate + "\",";

			liuliang += "\"flowTime\":\"" + strYesterday + "\",";
			liuliang += "\"nowTime\":\"" + myday + "\",";
			liuliang += "\"shopName\":\"" + shopName + "\",";
			liuliang += "\"platform\":\"" + "京东" + "\",";
			liuliang += "\"version\":\"" + version + "\"}]";
			liuliang = liuliang.replace(/%/g, "*");
			// alert(liuliang);
			var spu = $("div:contains(上架商品数量(SPU))").children("strong").html();
			spu = spu.replace(",", "");
			spu = spu.replace("￥", "");
			var sku = $("div:contains(上架商品数量(SKU))").children("strong").html();
			sku = sku.replace(",", "");
			sku = sku.replace("￥", "");
			var shangjia = "";
			shangjia += "[{\"spu\":\"" + spu + "\",";
			shangjia += "\"sku\":\"" + sku + "\",";
			shangjia += "\"goodsTime\":\"" + strYesterday + "\",";
			shangjia += "\"nowTime\":\"" + myday + "\",";
			shangjia += "\"shopName\":\"" + shopName + "\",";
			shangjia += "\"platform\":\"" + "京东" + "\",";
			shangjia += "\"version\":\"" + version + "\"}]";
			// alert(shangjia);

			var zhibiao = "[";
			for ( var i = 0; i < 24; i++) {
				var detail = new Array();
				var j = i + 1;
				var z = 0;
				if (i < 10) {
					$("td:contains(0" + i + ":00 -- 0" + j + ":00)").parents(
							"tr").children("td").each(function() {
						detail[z] = $(this).text().toString().trim();
						detail[z] = detail[z].replace(",", "");
						detail[z] = detail[z].replace("￥", "");
						z++;
					});
				}
				if (i > 8) {
					$("td:contains(" + i + ":00 -- " + j + ":00)")
							.parents("tr").children("td").each(function() {
								detail[z] = $(this).text().toString().trim();
								detail[z] = detail[z].replace(",", "");
								detail[z] = detail[z].replace("￥", "");
								z++;
							});
				}

				zhibiao += "{\"times\":\"" + detail[0] + "\",";
				zhibiao += "\"pageviews\":\"" + detail[1] + "\",";
				zhibiao += "\"visitors\":\"" + detail[2] + "\",";
				zhibiao += "\"sales\":\"" + detail[3] + "\",";
				zhibiao += "\"orderClientNum\":\"" + detail[4] + "\",";
				zhibiao += "\"orderQuantity\":\"" + detail[5] + "\",";
				zhibiao += "\"orderGoodsNum\":\"" + detail[6] + "\",";
				zhibiao += "\"saleTime\":\"" + strYesterday + "\",";
				zhibiao += "\"nowTime\":\"" + myday + "\",";
				zhibiao += "\"shopName\":\"" + shopName + "\",";
				zhibiao += "\"platform\":\"" + "京东" + "\",";
				zhibiao += "\"version\":\"" + version + "\"},";

			}
			zhibiao = zhibiao.substring(0, zhibiao.length - 1) + "]";
			// alert(zhibiao);
			$("span:contains(经营报告)").after(
					"<form  id='salespost' method='post' action='" + b
							+ "/ZQAction.action'></form>");
			$("#salespost").append(
					"<input type='hidden' name='xiaoliang' value='" + xiaoliang
							+ "' />");
			$("#salespost").append(
					"<input type='hidden' name='liuliang' value='" + liuliang
							+ "' />");
			$("#salespost").append(
					"<input type='hidden' name='shangjia' value='" + shangjia
							+ "' />");
			$("#salespost").append(
					"<input type='hidden' name='zhibiao' value='" + zhibiao
							+ "' />");
			$("#salespost")
					.append(
							"<input type='hidden' name='variable' id='variable' value='jdsalespost' />");

			// window.open($("span:contains(按天流量分析)").parents("a").
			// attr("href"),"_blank");
			// window.open($("span:contains(流量来源分析)").parents("a").
			// attr("href"),"_blank");
//			$("#salespost").submit();

		}

		// 京东页面=====================================================================
		else if (window.location.pathname == "/model/viewFlow/viewFlow.jsp") {
			"undefined" == typeof jQuery && setTimeout("daifaMode(durl);", 50),
					$("#viewFlowDetailTab").children("thead");
			$("#StartDate").val("2014-10-06");
//			var startDate = $("#StartDate").val();
//			$("#EndDate").val("2014-10-06");
//			var endDate = $("#EndDate").val();
//			$("span:contains(查询)").parent("a").addClass("btnOver");
//			$("span:contains(查询)").parent("a").click();
//			alert($("span:contains(查询)").parent("a").attr("class"));
//			alert(startDate);
//			alert(endDate);
//			$.ajax({
//				url:'http://pop.jd.com/advancedDataModel/getViewFlowTopResult.action',
//				data:{
//					"filter.startDate":"2014-10-13",
//					"filter.endDate":"2014-10-13",
//					"filter.zbType":"ArrivePagePV"
//				},
//				type:'post',	
//				success:function(result){
//					$("#container").after("<div class='result' style='display: none'>"+result+"</div>");
//					alert(result);
//				}		
//			});
//			$.ajax({
//				url:'http://pop.jd.com/advancedDataModel/getViewFlowResult.action',
//				data:{
//					"filter.startDate":"2014-10-13",
//					"filter.endDate":"2014-10-13",
//				},
//				type:'post',	
//				success:function(result){
//					$("#container").after("<div class='result' style='display: none'>"+result+"</div>");
//					alert(result);
//					
//				}		
//			});
//			 $a.click(function(){
		                //快查单选按钮渲染
		            	$("span:contains(查询)").parent("a").siblings().removeClass("r-checked");
		            	$("span:contains(查询)").parent("a").addClass("r-checked");
		            	$("span:contains(查询)").parent("a").find("input:radio").jCheck($("span:contains(查询)").parent("a").is(".r-checked"));


		            $(".Calendar .datepickerSelected",$_datepicker).removeClass("datepickerSelected");
		            var desc = $(this).attr("desc"),val = $(this).attr("val");
		            rapidSet(desc,val);
		            if(bSeparate){
		            	$("#"+$_datepicker.jId().substring(0,$_datepicker.jId().length-1)+"RapidSel").val(desc);
		            }else{
		            	$("#"+$_datepicker.jId()+"RapidSel").val(desc);
		            }

		            if(($.jIsArray(rapid)&&rapid[1])||(!$.jIsArray(rapid)&&rapid)){
		            	if(bSeparate){
		            		$(".btn.query",$_datepicker.siblings(".queryBtn")).eq(0).click();
		            	}else{
		            		if($(".btn.query").length==1){
		            			$(".btn.query").eq(0).click();
		            		}else{
		            			$('.widgetCalendar .c-btn .btn',$_datepicker).eq(0).click();
		            		}
		            	}
		            }
//		        });
			
//			$("label:contains(昨天)").prev().addClass("r-checked");
			var laiyuan = "";
			var row = new Array();
			var z = 0;
			$("#viewFlowDetailTab").children("tbody").children("tr").each(
					function() {
						row[z] = $(this).attr("id");
						z++;
					});

			for ( var j = 0; j < z; j++) {
				if (j == 0) {
					var i = 0;
					var a = new Array();
					$("label:contains(总计)").parents("td").parents("tr")
							.children("td").each(function() {
								a[i] = $(this).text().toString().trim();
								i++;
							});
				} else {
					var i = 0;
					var a = new Array();
					var id = row[j];
					$("#" + id).children("td").each(function() {
						a[i] = $(this).text().toString().trim();
						i++;
					});
				}
				laiyuan += "{\"flowSource\":\"" + a[0] + "\",";
				laiyuan += "\"landPageView\":\"" + a[1] + "\",";
				laiyuan += "\"landPageViewAccounted\":\"" + a[2] + "\",";
				laiyuan += "\"pageView\":\"" + a[3] + "\",";
				laiyuan += "\"pageViewAccounted\":\"" + a[4] + "\",";
				laiyuan += "\"flowSourceTime\":\"" + strYesterday + "\",";
				laiyuan += "\"nowTime\":\"" + myday + "\",";
				laiyuan += "\"shopName\":\"" + shopName + "\",";
				laiyuan += "\"platform\":\"" + "京东" + "\",";
				laiyuan += "\"version\":\"" + version + "\"},";
			}
			laiyuan = laiyuan.substring(0, laiyuan.length - 1);
			laiyuan = "[" + laiyuan.replace(/%/g, "*") + "]";
//			alert(laiyuan);
			$("span:contains(浏览量占比)").after(
					"<form  id='flowSourcepost' method='post' action='" + b
							+ "/ZQAction.action'></form>");
			$("#flowSourcepost").append(
					"<input type='hidden' name='laiyuan' value='" + laiyuan
							+ "' />");
			$("#flowSourcepost")
					.append(
							"<input type='hidden' name='variable' id='variable' value='jdflowSourcepost' />");
//			alert(laiyuan);
//			$("#flowSourcepost").submit();

		}

		// 京东页面====================================================================
		else if (window.location.pathname == "/model/viewFlowForDay/viewFlowForDay.jsp") {
					"undefined" == typeof jQuery
							&& setTimeout("daifaMode(durl);", 50),
					window
							.setInterval(
									function laiyuan() {
										var flowInfo = "";
										// alert(strYesterday);
										// 流量信息
										var flow = new Array();
										var i = 0;
										$("td:contains(" + strYesterday + ")")
												.parents("tr").children("td")
												.each(function() {
													flow[i] = $(this).html();
													i++;
												});
										flowInfo += "[{\"flowTime\":\""
												+ flow[0] + "\",";
										flowInfo += "\"pageviews\":\""
												+ flow[1] + "\",";
										flowInfo += "\"visitors\":\"" + flow[2]
												+ "\",";
										flowInfo += "\"avgVisitDepth\":\""
												+ flow[3] + "\",";
										flowInfo += "\"avgPaceTime\":\""
												+ flow[4] + "\",";
										flowInfo += "\"bounceRate\":\""
												+ flow[5] + "\",";
										flowInfo += "\"backVisitorsRate\":\""
												+ flow[6] + "\",";
										flowInfo += "\"shopName\":\""
												+ shopName + "\",";
										flowInfo += "\"version\":\"" + version
												+ "\"}]";

										flowInfo = flowInfo.replace(/%/g, "*");

										alert(flowInfo);
										$("span:contains(按天流量分析)")
												.after(
														"<form class='flow' id='flowpost' method='post' action='"
																+ b
																+ "/ZQAction.action'></form>");
										$("#flowpost").append(
												"<input type='hidden' name='flowInfo' value='"
														+ flowInfo + "' />");
										$("#flowpost")
												.append(
														"<input type='hidden' name='variable' id='variable' value='jdflowpost' />");
										$("#flowpost").submit();
									}, 2000);
		}
		// 京东页面====================================================================
		else if (window.location.pathname == "/model/hotBusiness/hotProductPage.jsp") {
			// 当前时间
			var captureTime = myday;
			// 当天日期日期
			var today = new Date(); // 月份为0-11
			var strYear = today.getFullYear();
			var strDay = today.getDate();
			var strMonth = today.getMonth() + 1;
			if (strMonth < 10) {
				strMonth = "0" + strMonth;
			}
			if (strDay < 10) {
				strDay = "0" + strDay;
			}
			var captureDate = strYear + "-" + strMonth + "-" + strDay;
			
			$("span:contains(京麦工作台)").parents("a").parents("li").before('<a class="btn print btnOver" id="capture"  style="background-position:0 -25px;color:white" href="#">抓取数据</a>');
			
			$("#capture").click(function() {
				var hotInfo  = "[";
				$("#hotProductTblXls").children("tbody").children("tr").each(function(){
					
					var baseinfo = new Array();
					var i = 0;
					$(this).children("td").each(function(){
						baseinfo[i] = $(this).text().toString().trim();
						baseinfo[i] = baseinfo[i].replace(",","");					
						if(i==2){
							i++;
							baseinfo[i] = $(this).children("label").children("a").attr("href").toString().trim();
						}
						if(i==7){
							var attr = $(this).children("a").attr("val");
							$.ajax({
								url:'http://pop.jd.com/interDataModel/hotProActFlowView.action',
								data:{
									"filter.rm_bs_type":"1",
									"filter.sku":attr,
									"filter.date":"7"
								},
								type:'post',	
								success:function(result){
									$("#hotProductTblXls_wrapper").each(function(){
										
									$(this).find("a[val="+attr+"]").parent("td").after("<div class='result' style='display: none'>"+result+"</div>");
									$(this).find("a[val="+attr+"]").parent("td").parent("tr").children("div").find("#demoDiv").children("ul").not(".pro-title-bold").each(function(){
										var infototal = new Array();
										var y = 0;
										$(this).children("li").each(function(){
											infototal[y] = $(this).text().toString().trim();
											y++;
										});
										hotInfo += "{\"rank\":\""+baseinfo[0]+"\",";
										hotInfo += "\"goodsName\":\""+baseinfo[2]+"\",";
										hotInfo += "\"goodsUrl\":\""+baseinfo[3]+"\",";
										hotInfo += "\"price\":\""+baseinfo[4]+"\",";
										hotInfo += "\"dealGoodsIndex\":\""+baseinfo[5]+"\",";
										hotInfo += "\"linkChangeRate\":\""+baseinfo[6]+"\",";
										hotInfo += "\"flowSource\":\""+infototal[1]+"\",";
										hotInfo += "\"pviews\":\""+infototal[2]+"\",";
										hotInfo += "\"bounceRate\":\""+infototal[3]+"\",";
										hotInfo += "\"pvisits\":\""+infototal[4]+"\",";
										hotInfo += "\"avgVisitNum\":\""+infototal[5]+"\",";
										hotInfo += "\"sign\":\""+"1"+"\",";
										hotInfo += "\"shopName\":\""+shopName+"\",";
										hotInfo += "\"captureDate\":\""+captureDate+"\",";
										hotInfo += "\"captureTime\":\""+captureTime+"\",";
										hotInfo += "\"version\":\""+version+"\"},";
									});
									var n = 1;
									$(this).find("a[val="+attr+"]").parent("td").parent("tr").children("div").find("#demoDiv").children("div").children("ul").each(function(){
										var info = new Array();
										var j = 0;
										$(this).children("li").each(function(){
											info[j] = $(this).text().toString().trim();
											if(j==1 && info[j]==""){
												info[j] = $(this).parent("ul").parent("div").prev("ul").children("li.t-total-font").text().toString().trim()+n;
												n++;
											}
											j++;
										});
										hotInfo += "{\"rank\":\""+baseinfo[0]+"\",";
										hotInfo += "\"goodsName\":\""+baseinfo[2]+"\",";
										hotInfo += "\"goodsUrl\":\""+baseinfo[3]+"\",";
										hotInfo += "\"price\":\""+baseinfo[4]+"\",";
										hotInfo += "\"dealGoodsIndex\":\""+baseinfo[5]+"\",";
										hotInfo += "\"linkChangeRate\":\""+baseinfo[6]+"\",";
										hotInfo += "\"flowSource\":\""+info[1]+"\",";
										hotInfo += "\"pviews\":\""+info[2]+"\",";
										hotInfo += "\"bounceRate\":\""+info[3]+"\",";
										hotInfo += "\"pvisits\":\""+info[4]+"\",";
										hotInfo += "\"avgVisitNum\":\""+info[5]+"\",";
										hotInfo += "\"sign\":\""+"2"+"\",";
										hotInfo += "\"shopName\":\""+shopName+"\",";
										hotInfo += "\"captureDate\":\""+captureDate+"\",";
										hotInfo += "\"captureTime\":\""+captureTime+"\",";
										hotInfo += "\"version\":\""+version+"\"},";
									});
									return false;
									});
								}		
							});
					
						}
						i++;
					});
				});
				window.setTimeout(function info(){
				hotInfo = hotInfo.substring(0, hotInfo.length-1);
				hotInfo = hotInfo + "]";
				hotInfo = hotInfo.replace(/%/g, "*");
				},2000);
				window.setTimeout(function shopinfo(){
					$("#header").after("<form  id='hotpost' method='post' action='"+b+"/ZQAction.action'></form>");
					$("#hotpost").append("<input type='hidden' name='hotInfo' value='"+hotInfo+"' />");
					$("#hotpost").append("<input type='hidden' name='variable' id='variable' value='jdhotGoodspost' />");
//					alert(hotInfo);
					$("#hotProductTblXls").children("tbody").children("tr").each(function(){
						var x = 0;
						$(this).children("td").each(function(){
							if(x==2){
//								window.open($(this).children("label").children("a").attr("href"), "_blank");
								alert($(this).children("label").children("a").attr("href"));
							}
							x++;
						});
						return false;
					});
//					$("#hotpost").submit();
					},3000);
			});
		}
	}
	if(window.location.hostname == "item.jd.com"){
		// 当天日期日期
			var today = new Date(); // 月份为0-11
			var strYear = today.getFullYear();
			var strDay = today.getDate();
			var strMonth = today.getMonth() + 1;
			if (strMonth < 10) {
				strMonth = "0" + strMonth;
			}
			if (strDay < 10) {
				strDay = "0" + strDay;
			}
			var captureDate = strYear + "-" + strMonth + "-" + strDay;

			var thisURL = window.location.href;
			var allURL = "";
			var jsonData = $("#choose").children("script").text().toString().trim();
			jsonData = jsonData.substring(jsonData.indexOf("=")+2, jsonData.length-1);
			var obj = eval("(" + jsonData + ")");
			alert(obj[0].SkuId);
			
			for(var i=0; i<obj.length;i++){
				allURL += "http://item.jd.com/" + obj[i].SkuId+".html"; 
			}
			var goodsName = $("#name").children("h1").text().toString().trim();
			if(allURL != ""){
			if(goodsName != ""){
			window.setTimeout(function a(){
				var urlJson = "[{\"goodsURL\":\"" + thisURL + "\"," 
				urlJson +="\"sign\":\"" + allURL + "\"," 
				urlJson +="\"goodsName\":\"" + goodsName + "\"," 
				urlJson +="\"captureDate\":\"" + captureDate+"\"}]";
//			$.post(b + "/ZQAction",{hotInfo:urlJson,variable:"jdhotGoodsDetailpost"},function(){});
//			window.setTimeout(function b(){window.close();},1000);
				window.open("http://www.baidu.com","_self").close();
//				window.open("","_self").close();
//				window.open("","_top").close();
//			        if(confirm("确定要退出吗？")){
//			                 var browserName=navigator.appName;
//			                 if (browserName=="Netscape"){
//			                       window.open('', '_self', '');
//			                       window.close();
//			                 }
//			                 if (browserName=="Microsoft Internet Explorer") {
//			                       window.parent.opener = "whocares";
//			                       window.parent.close();
//			                 }
//			        }
//				window.parent.close();
			},2000);
		}else{
			window.location.reload();
		}
		}else{
//			window.close();1330224449
		}

	}
//	alert(window.location.hostname);
	if(window.location.hostname == "www.hao123.com"){
		alert(window.location.href);
		if(confirm("确定要退出吗？")){
            var browserName=navigator.appName;
            if (browserName=="Netscape"){
                  window.open('', '_self', '');
                  window.close();
            }
            if (browserName=="Microsoft Internet Explorer") {
                  window.parent.opener = "whocares";
                  window.parent.close();
            }
   }
		
	}
	// 当当****************************************************************************
	if (window.location.hostname == "report.dangdang.com") {
		// 店名
		var shopName = $(".bd_title").children("div").children("b").text();
		// shopName =
		// shopName.substring(shopName.indexOf("("),shopName.length-8);
		shopName = shopName.substring(0, shopName.indexOf("("));
		// shopName = shopName.replace(/(//g, "*");
		alert(shopName);
		// 当当页面=======================================================================
		if (window.location.pathname == "/shop-s") {
			alert(window.location.pathname);
			$("#banner_searchInfo").after(
					'<a id="capture"  style="" href="#">抓取数据</a>');
			$("#capture").click(function() {
				window.open($("#banner_shopInfo").attr("href"), "_blank");
				window.open($("#banner_flowInfo").attr("href"), "_blank");
			});
		}
		// 当当页面=======================================================================
		if (window.location.pathname == "/shop-info") {
			// "undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
			// $("#shop_left");
			// window.setInterval(function shopinfo(){
			var head = new Array();
			var j = 0;
			var body = new Array();
			var z = 0;
			$("#shop_right_head").children("tr").children("td").each(
					function() {
						head[j] = $(this).children("div").children("span")
								.text().toString().trim();
						alert(head[j]);
						if ("PV,UV,收订订单数,销售金额,购买转化率,平均访问页数,客单价,平均跳出率"
								.contains(head[j])) {
							body[z] = j;
							alert(body[z]);
							z++;
						}
						j++;
					});

			var detail = new Array();
			var i = 0;
			$("#shop_detail_right").children("tr").children("td").each(
					function() {
						detail[i] = $(this).text().toString().trim();
						i++;
					});
			var xiaoliang = "";
			xiaoliang += "[{\"sales\":\"" + detail[body[3]] + "\",";
			xiaoliang += "\"clientPrice\":\"" + detail[body[6]] + "\",";
			xiaoliang += "\"orderQuantity\":\"" + detail[body[2]] + "\",";
			xiaoliang += "\"saleTime\":\"" + strYesterday + "\",";
			xiaoliang += "\"nowTime\":\"" + myday + "\",";
			xiaoliang += "\"shopName\":\"" + shopName + "\",";
			xiaoliang += "\"platform\":\"" + "dangdang" + "\",";
			xiaoliang += "\"version\":\"" + version + "\"}]";
			alert(xiaoliang);

			var liuliang = "";
			liuliang += "[{\"pageviews\":\"" + detail[body[0]] + "\",";
			liuliang += "\"visitors\":\"" + detail[body[1]] + "\",";
			liuliang += "\"shopDealRate\":\"" + detail[body[4]] + "\",";
			liuliang += "\"avgVisitDepth\":\"" + detail[body[5]] + "\",";
			liuliang += "\"bounceRate\":\"" + detail[body[7]] + "\",";
			liuliang += "\"flowTime\":\"" + strYesterday + "\",";
			liuliang += "\"nowTime\":\"" + myday + "\",";
			liuliang += "\"shopName\":\"" + shopName + "\",";
			liuliang += "\"platform\":\"" + "dangdang" + "\",";
			liuliang += "\"version\":\"" + version + "\"}]";

			liuliang = liuliang.replace(/%/g, "*");
			alert(liuliang);

			// $.post(b +
			// "/ZQAction",{xiaoliang:xiaoliang,liuliang:liuliang,variable:"ddsalespost"},function(){});

			// },2000);
		}

		// 当当页面==================================================================
		else if (window.location.pathname == "/shop-flow-source") {
			"undefined" == typeof jQuery && setTimeout("daifaMode(durl);", 50),
					$("td:contains(流量来源)");
			// window.setInterval(function shopflowsource(){
			var n = "";
			$("td:contains(流量来源)").parents("table").children("tbody")
					.find("td").each(function() {
						var date = $(this).text();
						n += date + "*";
					});
			var f = n.substring(0, n.length - 1);
			var head = $("td:contains(流量来源)").parents("table")
					.children("tbody").children("tr");
			var k = f.split("*");
			var ddllly1 = "";
			var ddllly2 = "";
			// var ddllly3="";
			for ( var i = 0; i < head.length; i++) {
				for ( var j = i + 9 * i; j < (i + 1) * 10; j = j + 10) {
					var num1 = k[j];
//					 var num2 = k[j+1];
					var num3 = k[j + 2];
//					 var num4 = k[j+3];
//					 var num5 = k[j+4];
//					 var num6 = k[j+5];
//					 var num7 = k[j+6];
//					 var num8 = k[j+7];
//					 var num9 = k[j+8];
//					 var num10 = k[j+9];
				}
				var ddllly = "{\"flowSource\":\"" + num1 + "\",";
				ddllly += "\"pageView\":\"" + num3 + "\",";
				ddllly += "\"flowSourceTime\":\"" + strYesterday + "\",";
				ddllly += "\"nowTime\":\"" + myday + "\",";
				ddllly += "\"shopName\":\"" + shopName + "\",";
				ddllly += "\"platform\":\"" + "当当" + "\",";
				ddllly += "\"version\":\"" + version + "\"},";
				ddllly1 += ddllly;
			}
			ddllly2 = ddllly1.substring(0, ddllly1.length - 1);
			var laiyuan = "[" + ddllly2 + "]";
//			alert(laiyuan);

			 $.post(b +"/ZQAction",{laiyuan:laiyuan,variable:"ddflowSourcepost"},function(){});

			// },2000);
			// window.open($("a:contains(流量概览)"). attr("href"),"_blank");

		}

		// 当当页面=========================================================================
		else if (window.location.pathname == "/shop-flow-entire") {
			"undefined" == typeof jQuery && setTimeout("daifaMode(durl);", 50),
					$(".bd_title");
			// window.setInterval(function shopflowentire(){
			var zhibiao = "[";
			for ( var i = 1; i < 25; i++) {
				var detail = new Array();
				var j = 0;
				if (i < 10) {
					$("td:contains(0" + i + ":00:00)").parents("tr").children(
							"td").each(function() {
						detail[j] = $(this).text().toString().trim();
						j++;
					});
				}
				if (i > 8) {
					$("td:contains(" + i + ":00:00)").parents("tr").children(
							"td").each(function() {
						detail[j] = $(this).text().toString().trim();
						j++;
					});
				}

				zhibiao += "{\"times\":\"" + detail[0] + "\",";
				zhibiao += "\"pageviews\":\"" + detail[1] + "\",";
				zhibiao += "\"visitors\":\"" + detail[2] + "\",";
				zhibiao += "\"orderClientNum\":\"" + detail[3] + "\",";
				zhibiao += "\"saleTime\":\"" + strYesterday + "\",";
				zhibiao += "\"nowTime\":\"" + myday + "\",";
				zhibiao += "\"shopName\":\"" + shopName + "\",";
				zhibiao += "\"platform\":\"" + "dangdang" + "\",";
				zhibiao += "\"version\":\"" + version + "\"},";

			}
			zhibiao = zhibiao.substring(0, zhibiao.length - 1) + "]";
			// alert(zhibiao);
			$.post(b + "/ZQAction", {
				zhibiao : zhibiao,
				variable : "ddsales"
			}, function(data) {
				alert(data);
			});
			// $(".bd_title").children("div").children("b").after("<form
			// id='salespost'
			// method='post' action='"+b+"/ZQAction.action'></form>");
			// $("#salespost").append("<input type='hidden' name='zhibiao'
			// value='"+zhibiao+"' />");
			// $("#salespost").append("<input type='hidden' name='variable'
			// id='variable'
			// value='ddsales' />");
			// $("#salespost").submit();
			// },2000);
		}

	}

	// 淘宝************************************************************************************
	if (window.location.hostname == "lz.taobao.com") {
		// 店名
		var shopName = $("#usr_name_all").children("a").text();
		// 淘宝页面==========================================================
		alert(window.location.hash);
		if (window.location.hash == "#!/diagnose/lznewhealthyreport/~") {
			$("#st_time_submit")
					.after(
							'<a class="date_d_viewBtn" id="capture"  href="#">抓取数据</a>');
			$("#capture").click(function() {
				window.open($("#J_ms_mid__15").attr("href"), "_blank");
				window.open($("#J_ms_mid__1").attr("href"), "_blank");
			});
		}
		// 淘宝页面==========================================================
		else if (window.location.hash == "#selldetail/~") {
			window
					.setTimeout(
							function selldetail() {
								var detail = new Array();
								var i = 0;
								$(".right-container").children("table")
										.children("tbody").children("tr")
										.children("td").each(function() {
											detail[i] = $(this).html();
											i++;
											if (i > 26) {
												return false;
											}
										});
								var xiaoliang = "";
								xiaoliang += "[{\"sales\":\"" + detail[8]
										+ "\",";
								xiaoliang += "\"clientPrice\":\"" + detail[21]
										+ "\",";
								xiaoliang += "\"orderClientNum\":\""
										+ detail[9] + "\",";
								xiaoliang += "\"orderQuantity\":\"" + detail[7]
										+ "\",";
								xiaoliang += "\"orderGoodsNum\":\"" + detail[5]
										+ "\",";
								xiaoliang += "\"saleTime\":\"" + strYesterday
										+ "\",";
								xiaoliang += "\"nowTime\":\"" + myday + "\",";
								xiaoliang += "\"shopName\":\"" + shopName
										+ "\",";
								xiaoliang += "\"platform\":\"" + "淘宝" + "\",";
								xiaoliang += "\"version\":\"" + version
										+ "\"}]";
								// alert(xiaoliang);

								var liuliang = "";
								liuliang += "[{\"pageviews\":\"" + detail[0]
										+ "\",";
								liuliang += "\"visitors\":\"" + detail[1]
										+ "\",";
								liuliang += "\"avgVisitDepth\":\"" + detail[4]
										+ "\",";
								liuliang += "\"backVisitorsRate\":\""
										+ detail[3] + "\",";

								liuliang += "\"shopDealRate\":\"" + detail[25]
										+ "\",";

								liuliang += "\"flowTime\":\"" + strYesterday
										+ "\",";
								liuliang += "\"nowTime\":\"" + myday + "\",";
								liuliang += "\"shopName\":\"" + shopName
										+ "\",";
								liuliang += "\"platform\":\"" + "淘宝" + "\",";
								liuliang += "\"version\":\"" + version + "\"}]";

								liuliang = liuliang.replace(/%/g, "*");
								// alert(liuliang);
								$("#limain1").after(
										"<form  id='salespost' method='post' action='"
												+ b
												+ "/ZQAction.action'></form>");
								$("#salespost").append(
										"<input type='hidden' name='xiaoliang' value='"
												+ xiaoliang + "' />");
								$("#salespost").append(
										"<input type='hidden' name='liuliang' value='"
												+ liuliang + "' />");
								$("#salespost")
										.append(
												"<input type='hidden' name='variable' id='variable' value='tbsalespost' />");
								$("#salespost").submit();
							}, 5000);
		}
		// 淘宝页面==========================================================
		else if (window.location.hash == "#shopsummary/~") {
			window
					.setInterval(
							function shopsummary() {
								var flow = new Array();
								var i = 0;
								$("td:contains(昨日)").parents("tr").children(
										"td").each(function() {
									flow[i] = $(this).text().toString().trim();
									i++;
								});
								var flowInfo = "";
								flowInfo += "[{\"flowTime\":\"" + strYesterday
										+ "\",";
								flowInfo += "\"avgPaceTime\":\"" + flow[4]
										+ "\",";
								flowInfo += "\"shopName\":\"" + shopName
										+ "\",";
								flowInfo += "\"version\":\"" + version + "\"}]";

								flowInfo = flowInfo.replace(/%/g, "*");
								$("a:contains(查看实时成交 )").after(
										"<form class='flow' id='flowpost' method='post' action='"
												+ b
												+ "/ZQAction.action'></form>");
								$("#flowpost").append(
										"<input type='hidden' name='flowInfo' value='"
												+ flowInfo + "' />");
								$("#flowpost")
										.append(
												"<input type='hidden' name='variable' id='variable' value='tbflowpost' />");
								$("#flowpost").submit();
							}, 2000);
		}
	}

	// 凡客*************************************************************************************
	if (window.location.hostname == "win.vjia.com") {
		// 店名
		var shopName = $("div.fl").text().toString().trim();
		shopName = shopName.substring(shopName.indexOf("("),
				shopName.length - 17);
		// 前一天日期1
		var today = new Date(); // 月份为0-11
		var yesterday_milliseconds = today.getTime() - 1000 * 60 * 60 * 24;
		var yesterday = new Date();
		yesterday.setTime(yesterday_milliseconds);

		var strYear = yesterday.getFullYear();
		var strDay = yesterday.getDate();
		var strMonth = yesterday.getMonth() + 1;
		var strYesterdayTwo = strYear + "-" + strMonth + "-" + strDay;
		// 前一天日期2
		var today = new Date(); // 月份为0-11
		var yesterday_milliseconds = today.getTime() - 1000 * 60 * 60 * 24;
		var yesterday = new Date();
		yesterday.setTime(yesterday_milliseconds);

		var strYear = yesterday.getFullYear();
		var strDay = yesterday.getDate();
		var strMonth = yesterday.getMonth() + 1;
		var strYesterday1 = strYear + "/" + strMonth + "/" + strDay;
		// 前一天日期3
		var today = new Date(); // 月份为0-11
		var yesterday_milliseconds = today.getTime() - 1000 * 60 * 60 * 24;
		var yesterday = new Date();
		yesterday.setTime(yesterday_milliseconds);

		var strYear = yesterday.getFullYear();
		var strDay = yesterday.getDate();
		var strMonth = yesterday.getMonth() + 1;
		var strYesterday2 = strYear + "-" + strMonth + "-" + strDay;

		// alert(strYesterday);

		// 凡客页面==========================================================
		if (window.location.pathname == "/SelfShip/AllOrder.aspx") {
			$("#affiche_scroll")
					.after(
							'<a id="capture" style="cursor: pointer;display: inline-block;height: 25px;line-height: 25px;text-align: center;width: 100px;color: blue;" href="#">抓取数据</a>');
			$("#capture").click(function() {
				window.open($("a:contains(销售分析)").attr("href"), "_blank");
				window.open($("a:contains(流量分析)").attr("href"), "_blank");
			});
			// $("#d5221").val(strYesterday);
			// $("#d5222").val(strYesterday);
			// $("#btnSearch").click();
			var search = window.location.search;
			if ($("a:contains(下一页)").text() == "下一页" && search.indexOf("txtBeginDate="+strYesterday+"&txtEndDate="+strYesterday+"&txtFormCode=&selPayMentType=&txtAddressee=&txtPhone=&txtDispatchNo=&selExpressCompany=0&selIsNeedInvoice=&button=&selStatus=0")>0) {
				window.open($("a:contains(下一页)").attr("href"), "_blank");
			}
			var t = 0;
			$(".order_list").children("tbody").children("tr.order-hd").each(
					function() {
						t++;
						// window.open($(this).children("td").children("div").children("span:contains(订单编号：)").children("a").
						// attr("href"),"_blank");
					});
//			alert(window.location.search);
			// window.open($("span:contains(订单编号：)").children("a").
			// attr("href"),"_blank");
			if ($("a:contains(下一页)").text() == "下一页" && search.indexOf("page=2&txtBeginDate="+strYesterday+"&txtEndDate="+strYesterday+"&txtFormCode=&selPayMentType=&txtAddressee=&txtPhone=&txtDispatchNo=&selExpressCompany=0&selIsNeedInvoice=&button=&selStatus=0")>0) {
				window.open($("a:contains(下一页)").attr("href"), "_blank");
			}
		}
		if (window.location.pathname == "/SelfShip/orderdetails.aspx") {
			"undefined" == typeof jQuery && setTimeout("daifaMode(durl);", 50),
					$("li:contains(收 货 人：)").text();
			var wantdoName = $("li:contains(收 货 人：)").text().toString().trim();
			wantdoName = wantdoName.substring(4, 9);
			if (wantdoName.indexOf("W") < 0) {
				var orderNo = $("strong:contains(订单   号：)").parent().text();
				orderNo = orderNo.substring(orderNo.indexOf("：") + 1, orderNo
						.indexOf("当") - 1);
				orderNo = orderNo.trim();

				var clientName = $("li:contains(收 货 人：)").text().toString()
						.trim();
				clientName = clientName.substring(clientName.indexOf("：") + 1,
						clientName.length);
				var orderPrice = $("li:contains(商品总金额：)").text().toString()
						.trim();
				orderPrice = orderPrice.substring(orderPrice.indexOf("：") + 2,
						orderPrice.length);
				var goodsNum = $("li:contains(商品数量总计：)").text();
				goodsNum = goodsNum.substring(goodsNum.indexOf("：") + 1,
						goodsNum.indexOf("优"));
				goodsNum = goodsNum.trim();
				var orderDate = $("td:contains(您的订单商家正在处理准备发货)").prev().text().toString().trim();
				orderDate = orderDate.substring(0,10);
				orderDate = orderDate.replace("/","-");
				orderDate = orderDate.replace("/","-");
				var saleJson = "[{";
				saleJson += "\"sales\":\"" + orderPrice + "\",";
				saleJson += "\"goodsNum\":\"" + goodsNum + "\",";
				saleJson += "\"clientName\":\"" + clientName + "\",";
				saleJson += "\"saleTime\":\"" + orderDate + "\",";
				saleJson += "\"orderNo\":\"" + orderNo + "\",";
				saleJson += "\"shopName\":\"" + shopName + "\",";
				saleJson += "\"version\":\"" + version+ "\"}]";
				$("a:contains(商品信息管理)").after(
						"<form  id='salespost' method='post' action='" + b
								+ "/OrderSaleAction.action'></form>");
				$("#salespost").append(
						"<input type='hidden' name='saleJson' value='"
								+ saleJson + "' />");
				$("#salespost")
						.append(
								"<input type='hidden' name='variable' id='variable' value='fkordersalespost' />");
				alert(saleJson);
				 $("#salespost").submit();
			}
		}
		// 凡客页面==========================================================
		if (window.location.pathname == "/SalesUI/todayobserve.aspx") {
			window.open($("a:contains(销售明细)").attr("href"), "_blank");

		}
		// 凡客页面==========================================================
		else if (window.location.pathname == "/SalesUI/SalesDetails.aspx") {
			"undefined" == typeof jQuery && setTimeout("daifaMode(durl);", 50),
					$("div:contains(" + strYesterdayTwo + ")");
			var detail = new Array();
			var i = 0;
			$("div:contains(" + strYesterdayTwo + ")").parents("td").parents(
					"tr").children("td").each(function() {
				detail[i] = $(this).text().toString().trim();
				i++;
			});
			var xiaoliang = "";
			xiaoliang += "[{\"sales\":\"" + detail[13] + "\",";
			xiaoliang += "\"saleTime\":\"" + strYesterday + "\",";
			xiaoliang += "\"nowTime\":\"" + myday + "\",";
			xiaoliang += "\"shopName\":\"" + shopName + "\",";
			xiaoliang += "\"platform\":\"" + "凡客" + "\",";
			xiaoliang += "\"version\":\"" + version + "\"}]";
			// alert(xiaoliang);
			$("#ctl00_ContentPlaceHolder1_ReportViewer1_ctl04_ctl00").after(
					"<form  id='salespost' method='post' action='" + b
							+ "/ZQAction.action'></form>");
			$("#salespost").append(
					"<input type='hidden' name='xiaoliang' value='" + xiaoliang
							+ "' />");
			$("#salespost")
					.append(
							"<input type='hidden' name='variable' id='variable' value='fksales1' />");
			$("#salespost").submit();
		}
		// 凡客页面==========================================================
		if (window.location.pathname == "/PVUI/MallPVShopAndProduct.aspx") {
			"undefined" == typeof jQuery && setTimeout("daifaMode(durl);", 50),
					$("div:contains(" + strYesterday2 + ")");
			var detail = new Array();
			var i = 0;
			$("div:contains(" + strYesterday2 + ")").parents("td")
					.parents("tr").children("td").each(function() {
						detail[i] = $(this).text().toString().trim();
						i++;
					});
			var liuliang = "";
			liuliang += "[{\"pageviews\":\"" + detail[12] + "\",";
			liuliang += "\"visitors\":\"" + detail[13] + "\",";
			liuliang += "\"shopDealRate\":\"" + detail[15] + "\",";
			liuliang += "\"flowTime\":\"" + strYesterday + "\",";
			liuliang += "\"nowTime\":\"" + myday + "\",";
			liuliang += "\"shopName\":\"" + shopName + "\",";
			liuliang += "\"platform\":\"" + "凡客" + "\",";
			liuliang += "\"version\":\"" + version + "\"}]";

			liuliang = liuliang.replace(/%/g, "*");
			// alert(liuliang);
			$("#ctl00_ContentPlaceHolder1_ReportViewer1_ctl04_ctl00").after(
					"<form  id='salespost' method='post' action='" + b
							+ "/ZQAction.action'></form>");
			$("#salespost").append(
					"<input type='hidden' name='liuliang' value='" + liuliang
							+ "' />");
			$("#salespost")
					.append(
							"<input type='hidden' name='variable' id='variable' value='fksales3' />");
			$("#salespost").submit();
		}
		// 凡客页面==========================================================
		if (window.location.pathname == "/PVUI/MallPVHouseData.aspx") {
					"undefined" == typeof jQuery
							&& setTimeout("daifaMode(durl);", 50),
					$(
							"#ctl00_ContentPlaceHolder1_ReportViewer1_ctl04_ctl03_txtValue")
							.val(strYesterday1 + " 0:00:00");
			var a = $("td:contains( 0:00)").children("div:contains( 0:00)")
					.text().toString().trim();
			a = a.substring(a.indexOf("2"), a.indexOf(" "));
			if (a == strYesterday1) {
				var zhibiao = "[";
				for ( var i = 0; i < 24; i++) {
					var j = 0;
					var detail = new Array();
					$("td:contains(" + strYesterday1 + " " + i + ":00)")
							.parent("tr").children("td").children("div").each(
									function() {
										detail[j] = $(this).text().toString()
												.trim();
										j++;
									});
					zhibiao += "{\"times\":\"" + detail[3] + "\",";
					zhibiao += "\"pageviews\":\"" + detail[4] + "\",";
					zhibiao += "\"visitors\":\"" + detail[5] + "\",";
					zhibiao += "\"saleTime\":\"" + strYesterday1 + "\",";
					zhibiao += "\"nowTime\":\"" + myday + "\",";
					zhibiao += "\"shopName\":\"" + shopName + "\",";
					zhibiao += "\"platform\":\"" + "凡客" + "\",";
					zhibiao += "\"version\":\"" + version + "\"},";
				}
				zhibiao = zhibiao.substring(0, zhibiao.length - 1) + "]";
				zhibiao = zhibiao.replace("\\s*|\t|\r|\n", "");
				// alert(zhibiao);
				$("#ctl00_ContentPlaceHolder1_ReportViewer1_ctl04_ctl00")
						.after(
								"<form  id='salespost' method='post' action='"
										+ b + "/ZQAction.action'></form>");
				$("#salespost").append(
						"<input type='hidden' name='zhibiao' value='" + zhibiao
								+ "' />");
				$("#salespost")
						.append(
								"<input type='hidden' name='variable' id='variable' value='fksales2' />");
				$("#salespost").submit();
			}
		}
	}

	// 亚马逊***************************************************************
	if (window.location.hostname == "mai.amazon.cn") {
		// 店名
		var shopName = $("#merchant-name").text().toString().trim();

		// 亚马逊页面==========================================================
		if (window.location.pathname == "/gp/homepage.html") {
			$(".sc-mkt-switcher-flag")
					.before(
							'<a id="capture" style="cursor: pointer;display: inline-block;height: 25px;line-height: 25px;text-align: center;width: 100px;color: blue;" href="#">抓取数据</a>');
			$("#capture").click(function() {
				window.open($("a:contains(业务报告)").attr("href"), "_blank");
			});

		}
		// alert(window.location.pathname=="/gp/site-metrics/report.html" &&
		// window.location.hash.substring(0,
		// window.location.hash.indexOf("="))=="#&cols");
		// alert(window.location.pathname);
		// 亚马逊页面==========================================================
		if (window.location.pathname == "/gp/site-metrics/report.html"
				&& window.location.hash.substring(0, window.location.hash
						.indexOf("=")) == "#&cols") {
			"undefined" == typeof jQuery && setTimeout("daifaMode(durl);", 50),
					$("a:contains(业务报告)");
			// window.open($("#report_SalesTrafficTimeSeries").
			// attr("href"),"_blank");
			// if($("#reportTitle").text()=="销售"){

			var detail = new Array();
			var i = 0;
			$("td:contains(" + strYesterday + ")").parents("tr").children("td")
					.each(function() {
						detail[i] = $(this).text().toString().trim();
						i++;
					});
			var xiaoliang = "";
			xiaoliang += "[{\"sales\":\"" + detail[2] + "\",";
			xiaoliang += "\"orderQuantity\":\"" + detail[4] + "\",";
			xiaoliang += "\"orderGoodsNum\":\"" + detail[3] + "\",";
			xiaoliang += "\"saleTime\":\"" + strYesterday + "\",";
			xiaoliang += "\"nowTime\":\"" + myday + "\",";
			xiaoliang += "\"shopName\":\"" + shopName + "\",";
			xiaoliang += "\"platform\":\"" + "亚马逊" + "\",";
			xiaoliang += "\"version\":\"" + version + "\"}]";
			alert(xiaoliang);
			$("#reportTitle").after(
					"<form  id='salespost' method='post' action='" + b
							+ "/ZQAction.action'></form>");
			$("#salespost").append(
					"<input type='hidden' name='xiaoliang' value='" + xiaoliang
							+ "' />");
			$("#salespost")
					.append(
							"<input type='hidden' name='variable' id='variable' value='ymxsalespost' />");
			// $("#salespost").submit();

			// }
		}
	}
	// //亚马逊***************************************************************
	// if(window.location.hostname=="mai.amazon.cn"){
	// //店名
	// var shopName = $("#merchant-name").text().toString().trim();
	// //亚马逊页面==========================================================
	// if(window.location.pathname=="/gp/homepage.html" ){
	// $(".sc-mkt-switcher-flag").before('<a id="capture" style="cursor:
	// pointer;display: inline-block;height: 25px;line-height: 25px;text-align:
	// center;width: 100px;color: blue;" href="#">抓取数据</a>');
	// $("#capture").click(function() {
	// window.open($("a:contains(业务报告)"). attr("href"),"_parent");
	// });
	// }
	// //亚马逊页面==========================================================
	// if(window.location.pathname=="/gp/site-metrics/report.html" ){
	// window.setInterval(function report(){
	// if(window.location.hash.substring(0,
	// window.location.hash.indexOf("="))=="#&reportID"){
	// window.open($("#report_SalesTrafficTimeSeries").
	// attr("href"),$("#report_SalesTrafficTimeSeries").attr("target"));
	// }
	// if(window.location.hash.substring(0,
	// window.location.hash.indexOf("="))=="#&cols"){
	// var detail = new Array();
	// var i = 0;
	// $("td:contains("+strYesterday+")").parents("tr").children("td").each(function(){
	// detail[i] = $(this).text().toString().trim();
	// i++;
	// });
	// var xiaoliang = "";
	// xiaoliang+="[{\"sales\":\"" + detail[2]+"\",";
	// xiaoliang+="\"orderQuantity\":\"" + detail[4]+"\",";
	// xiaoliang+="\"orderGoodsNum\":\"" + detail[3]+"\",";
	// xiaoliang+="\"saleTime\":\"" + strYesterday+"\",";
	// xiaoliang+="\"nowTime\":\"" + myday+"\",";
	// xiaoliang+="\"shopName\":\"" + shopName+"\",";
	// xiaoliang+="\"platform\":\"" + "亚马逊"+"\",";
	// xiaoliang+="\"version\":\"" + version+"\"}]";
	// // alert(xiaoliang);
	// $("#reportTitle").after("<form id='salespost' method='post'
	// action='"+b+"/ZQAction.action'></form>");
	// $("#salespost").append("<input type='hidden' name='xiaoliang'
	// value='"+xiaoliang+"' />");
	// $("#salespost").append("<input type='hidden' name='variable'
	// id='variable'
	// value='ymxsalespost' />");
	// $("#salespost").submit();
	//			
	// }
	// },5000);
	// }
	// }

	// alert(window.location.hostname);
	// 当当订单****************************************************************************
	if (window.location.hostname == "mt.dangdang.com") {
		"undefined" == typeof jQuery && setTimeout("daifaMode(durl);", 50),
				$("a:contains(管理首页)");
		// 日期1
		var today = new Date(); // 月份为0-11
		var yesterday_milliseconds = today.getTime() - 1000 * 60 * 60 * 24;
		var day1 = new Date();
		day1.setTime(yesterday_milliseconds);

		var strYear = day1.getFullYear();
		var strDay = day1.getDate();
		var strMonth = day1.getMonth() + 1;
		if (strMonth < 10) {
			strMonth = "0" + strMonth;
		}
		if (strDay < 10) {
			strDay = "0" + strDay;
		}
		var strday1 = strYear + "-" + strMonth + "-" + strDay + " 00:00:00";

		// 日期2
		var today = new Date(); // 月份为0-11
		var yesterday_milliseconds = today.getTime();
		var day2 = new Date();
		day2.setTime(yesterday_milliseconds);

		var strYear = day2.getFullYear();
		var strDay = day2.getDate();
		var strMonth = day2.getMonth() + 1;
		if (strMonth < 10) {
			strMonth = "0" + strMonth;
		}
		if (strDay < 10) {
			strDay = "0" + strDay;
		}
		var strday2 = strYear + "-" + strMonth + "-" + strDay + " 00:00:00";

		// 日期3
		var today = new Date(); // 月份为0-11
		var yesterday_milliseconds = today.getTime();
		var day2 = new Date();
		day2.setTime(yesterday_milliseconds);

		var strYear = day2.getFullYear();
		var strDay = day2.getDate();
		var strMonth = day2.getMonth() + 1;
		if (strMonth < 10) {
			strMonth = "0" + strMonth;
		}
		if (strDay < 10) {
			strDay = "0" + strDay;
		}
		var strday3 = strYear + "-" + strMonth + "-" + strDay;

		// 店名
		var shopName = $("a:contains(帮助中心)").next().next().next().next().next()
				.text().toString().trim();
		if (window.location.pathname == "/order/list/index") {
			// alert(window.location.pathname);
			$("#create_date_begin").val(strday1);
			$("#create_date_end").val(strday2);
			window.setTimeout(function a() {
				$("#search").click();
			}, 100);
			window.setTimeout(function b() {
				window.location.reload();
			}, 1000);

		}
		if (window.location.pathname == "/order/list/search") {
			window
					.setTimeout(
							function a() {
								var s = 0;
								$("table")
										.children("tbody")
										.children("tr")
										.children("td")
										.children("i.mark")
										.parents("td")
										.each(
												function() {
													var order = $(this).text()
															.toString().trim();
													var orderNo = $(this)
															.parent().prev()
															.children("input").value;
													$(this).parent().parent()
															.children("tr")
															.each(function() {
																// if(){
																//							
																// }
															});
													var orderNum = $(this)
															.prev().prev()
															.text().toString()
															.trim();
													var wantdoName = $(this)
															.prev().html()
															.toString().trim();
													wantdoName = wantdoName
															.substring(
																	0,
																	wantdoName
																			.indexOf("<"));
													if (s == 0) {
														// alert(wantdoName);
														alert(orderNo);
													}
													if (order != "取消"
															&& order != "等待到款") {

														// window.open($(this).parent("tr").children("td.tx_l_block").find("a:contains(详情)").
														// attr("href"),"_blank");
													}
													s++;
												});
								var totalData = $("span:contains(条记录)").text()
										.toString().trim();
								totalData = totalData.substring(1,
										totalData.length - 3);
								totalData.trim();
								var total = Number(totalData);
								var totalPage = total / 15 + 1;
								for ( var i = 1; i < totalPage; i++) {
									var url = "http://mt.dangdang.com/order/list/ajax?order_id=&product_id=&create_date_begin="
											+ strYesterday
											+ "+00%3A00%3A00&create_date_end="
											+ strday3
											+ "+00%3A00%3A00&status=9999&express_no=&send_date_begin=&send_date_end=&ship_type=9999&order_label=9999&pay_type=9999&send_way=9999&external_order_id=&external_product_id=&receiver_name=&receiver_phone=&select_period=0&page="
											+ i + "&perPage=15&t=0";
									// window.open(url,"_blank");

								}
							}, 0);

		}
		if (window.location.pathname == "/order/list/ajax") {
			var s = 0;
			$("table").children("tbody").children("tr").children("td")
					.children("i.mark").parents("td").each(function() {
						order = $(this).text().toString().trim();
						alert(order);
						if (order != "取消" && order != "等待到款") {
							alert(order + "==========");
							// window.open($(this).parent("tr").children("td.tx_l_block").find("a:contains(详情)").
							// attr("href"),"_blank");
						}
					});
		}

		if (window.location.pathname == "/order/detail/search") {
			$("p:contains(收 货 人：)").text();
			var wantdoName = $("p:contains(收 货 人：)").text().toString().trim();
			wantdoName = wantdoName.substring(4, 9);
			if (wantdoName.indexOf("W") < 0) {
				var clientName = $("p:contains(收 货 人：)").text().toString().trim();
				clientName = clientName.substring(clientName.indexOf("：") + 1,
						clientName.length);
				var total = $("p:contains(商品金额合计：)").text();
				total = total.substring(total.indexOf("：") + 2, total.length);
				var freight = $("p:contains(手续费合计：)").next().text();
				freight = freight.substring(freight.indexOf("：") + 2,
						freight.length);
				var orderPromotion = $("p:contains(订单享受【订单级促销】 ：)").text();
				orderPromotion = orderPromotion.substring(orderPromotion
						.indexOf("：") + 3, orderPromotion.length);
//				alert(orderPromotion);
				var orderPrice = Number(total) + Number(freight)
						- Number(orderPromotion);
				var orderDate = $("span:contains(顾客下单)").prev("span.it2").text().toString().trim();
				orderDate = orderDate.substring(0,10);
//				alert(orderDate);
				var goodsNum = 0;
				$("#realList").children("p").each(function() {
									var i = 0;
									$(this).children("span").each(function() {
											if (i == 3&& $(this).text().indexOf("￥") > -1) {
													goodsNum += Number($(
													this)
													.next()
													.next()
													.text()
													.toString()
													.trim());
										}
										i++;
									});
								});
				var orderNo = $("span:contains(订单号：)").text().toString().trim();
				orderNo = orderNo.substring(orderNo.indexOf("：") + 1, orderNo
						.indexOf("("));
				orderNo = orderNo.trim();

				var saleJson = "[{";
				saleJson += "\"sales\":\"" + orderPrice + "\",";
				saleJson += "\"goodsNum\":\"" + goodsNum + "\",";
				saleJson += "\"clientName\":\"" + clientName + "\",";
				saleJson += "\"saleTime\":\"" + strYesterday + "\",";
				saleJson += "\"orderNo\":\"" + orderNo + "\",";
				saleJson += "\"shopName\":\"" + shopName + "\",";
				saleJson += "\"version\":\"" + version+ "\"}]";
				// alert(saleJson);
				// $.post(b +
				// "/OrderSaleAction",{saleJson:saleJson,variable:"ddordersalespost"},function(){});
			}

		}

	}
	// alert(window.location.search);
	// var str ="china2008china2007"
	// var reg = /china/g;
	// var arr = str.match(reg);
	// alert(arr.length);
	// 京东订单****************************************************************************
	if (window.location.hostname == "order.shop.jd.com") {
		// 日期1
		var today = new Date(); // 月份为0-11
		var yesterday_milliseconds = today.getTime() - 1000 * 60 * 60 * 24;
		var day1 = new Date();
		day1.setTime(yesterday_milliseconds);

		var strYear = day1.getFullYear();
		var strDay = day1.getDate();
		var strMonth = day1.getMonth() + 1;
		if (strMonth < 10) {
			strMonth = "0" + strMonth;
		}
		if (strDay < 10) {
			strDay = "0" + strDay;
		}
		var day1 = strYear + "-" + strMonth + "-" + strDay;

		// 日期2
		var today = new Date(); // 月份为0-11
		var yesterday_milliseconds = today.getTime();
		var day2 = new Date();
		day2.setTime(yesterday_milliseconds);

		var strYear = day2.getFullYear();
		var strDay = day2.getDate();
		var strMonth = day2.getMonth() + 1;
		if (strMonth < 10) {
			strMonth = "0" + strMonth;
		}
		if (strDay < 10) {
			strDay = "0" + strDay;
		}
		var day2 = strYear + "-" + strMonth + "-" + strDay;

		if (window.location.pathname == "/order/sSopUp_allList.action") {

			var search = window.location.search;
			// search = search.substring(0, search.indexOf("=")+1);

			if (search == "") {
				$("span:contains(京麦工作台)")
						.parents("a")
						.parents("li")
						.before(
								'<a class="btn print btnOver" id="capture"  style="background-position:0 -25px;color:white" href="#">抓取订单</a>');
				$("#capture")
						.click(
								function() {
									var url = "http://order.shop.jd.com/order/sSopUp_allList.action?oq.id=&oq.startDate="
											+ day1
											+ "+00%3A00%3A00&oq.endDate="
											+ day2
											+ "+00%3A00%3A00&oq.consName=&oq.consPhone=&oq.pin=&oq.paymentType=&oq.skuName=&oq.logiNo=&oq.skuId=&oq.orderSaleType=&oq.orderBusinessType=&oq.deliveryType=";
									window.open(url, "_parent");
								});
			}
			if (search.indexOf("oq.endDate=" + day2
					+ "+00%3A00%3A00&oq.startDate=" + day1
					+ "+00%3A00%3A00&page=") > 0) {
				var saleJson = "[";
				$(".table-list")
						.children("tbody")
						.children("tr.content")
						.each(
								function() {
									var i = 0
									var goodsNum = 0;
									var orderPrice = "";
									$(this)
											.children("td")
											.each(
													function() {
														if (i == 0) {
															$(this)
																	.children(
																			"div.p-detail")
																	.each(
																			function() {
																				var num = $(
																						this)
																						.find(
																								"span:contains(商品数量)")
																						.text();
																				num = num
																						.substring(
																								5,
																								goodsNum.length);
																				goodsNum += Number(num);
																			});
														}
														if (i == 1) {
															orderPrice = $(this)
																	.children(
																			"div.p-value2")
																	.text();
															orderPrice = orderPrice
																	.substring(
																			5,
																			orderPrice.length);
														}
														if (i == 3) {
															var orderDate = $(
																	this)
																	.parent(
																			"tr")
																	.prev()
																	.find(
																			"span:contains(下单时间：)")
																	.text()
																	.toString()
																	.trim();
															orderDate = orderDate
																	.substring(
																			orderDate
																					.indexOf("：") + 1,
																			orderDate.length - 6);
															var temp = $(this)
																	.text();
															if (temp
																	.indexOf("删除") < 0) {
																saleJson += "{\"sales\":\""
																		+ orderPrice
																		+ "\",";
																saleJson += "\"goodsNum\":\""
																		+ goodsNum
																		+ "\",";
																saleJson += "\"shopName\":\""
																		+ "京东"
																		+ "\",";
																saleJson += "\"saleTime\":\""
																		+ orderDate
																		+ "\",";
																saleJson += "\"version\":\"" + version+ "\"}";
															}
														}
														i++;
													});
								});
				saleJson = saleJson.substring(0, saleJson.length - 1);
				saleJson = saleJson + "]";
				// alert(saleJson);
				// $.post(b +
				// "/OrderSaleAction",{saleJson:saleJson,variable:"jdordersalespost"},function(){});
				var currentPage = Number($(".current").text().toString().trim());
				var totalPage = $("span:contains(条记录)").next().text()
						.toString().trim();
				totalPage = Number(totalPage.substring(1, totalPage.length - 1));
				if (currentPage < totalPage) {
					// window.open($("a:contains(下一页)"). attr("href"),"_blank");
				}
				// window.open($("span:contains(我的店铺)").parent("a").
				// attr("href"),"_blank");
			}
			if (search
					.indexOf("oq.id=&oq.startDate="
							+ day1
							+ "+00%3A00%3A00&oq.endDate="
							+ day2
							+ "+00%3A00%3A00&oq.consName=&oq.consPhone=&oq.pin=&oq.paymentType=&oq.skuName=&oq.logiNo=&oq.skuId=&oq.orderSaleType=&oq.orderBusinessType=&oq.deliveryType=") > 0) {
				$(".table-list").children("tbody").children("tr.content").each(
						function() {
							var i = 0
							$(this).children("td").each(
									function() {
										if (i == 3) {
											var temp = $(this).text();
											if (temp.indexOf("删除") < 0
													&& temp.indexOf("锁定") < 0) {
												// window.open($(this).parent("tr").prev().find("a").attr("href"),"_blank");
											}
										}
										i++;
									});
						});
				var currentPage = Number($(".current").text().toString().trim());
				var totalPage = $("span:contains(条记录)").next().text()
						.toString().trim();
				totalPage = Number(totalPage.substring(1, totalPage.length - 1));
				if (currentPage < totalPage
						&& search
								.indexOf("oq.id=&oq.startDate="
										+ day1
										+ "+00%3A00%3A00&oq.endDate="
										+ day2
										+ "+00%3A00%3A00&oq.consName=&oq.consPhone=&oq.pin=&oq.paymentType=&oq.skuName=&oq.logiNo=&oq.skuId=&oq.orderSaleType=&oq.orderBusinessType=&oq.deliveryType=") > 0) {
					// window.open($("a:contains(下一页)"). attr("href"),"_blank");
				}
				// window.open($("span:contains(我的店铺)").parent("a").
				// attr("href"),"_blank");

			}
		}
		if(window.location.pathname=="/order/order_orderInfoPage.action"){
			 var wantdoName = $("li:contains(人：)").text().toString().trim();
			 wantdoName =
			 wantdoName.substring(wantdoName.indexOf("：")+1,wantdoName.length);
			 var name1 = wantdoName.substring(0,1);
			 var name2 =
			 wantdoName.substring(wantdoName.indexOf("b")-2,wantdoName.indexOf("b")-1);
			 if(name1!="W" && name2 !="W" && name1!="w" && name2 !="w"  ){
			 var orderPrice = $("商品总金额：").children("b").text().toString().trim();
			 var orderNo = $("strong:contains(订单号：)").text();
			 orderNo =
			 orderNo.substring(orderNo.indexOf("：")+1,orderNo.indexOf("状")-1);
			 orderNo = orderNo.trim();
			 orderPrice =orderPrice.replace(",","");
			 orderPrice =orderPrice.replace("￥","");
			 var saleJson = "[{";
			 saleJson += "\"clientName\":\"" + wantdoName+"\",";
			 saleJson+="\"orderNo\":\"" + orderNo+"\"}]";
//			alert(saleJson);
			$.post(b +"/OrderSaleAction",{saleJson:saleJson,variable:"jdclientNamepost"},function(){});
							
			 }
						
		}
	}
	if (window.location.pathname == "/seller/sellerinfo/seller_info.action") {
		window.open($("a:contains(店铺信息)").attr("href"), "_blank");

	}
	if (window.location.pathname == "/seller/venderContact/venderContact_shopBaseInfo.action") {
		var shopName = $("p:contains(店铺名称)").parent("td").next().text()
				.toString().trim();
		var saleData = "";
		saleData += "[{\"saleTime\":\"" + strYesterday + "\"},";
		saleData += "\"shopName\":\"" + shopName + "\"}]";
		$.post(b + "/OrderSaleAction", {
			saleData : saleData,
			variable : "jdshopNamepost"
		}, function() {
		});
	}

	// alert("111");
	// 亚马逊订单****************************************************************************
	if (window.location.hostname == "mai.amazon.cn") {
		var today = new Date(); // 月份为0-11
		var yesterday_milliseconds = today.getTime() - 1000 * 60 * 60 * 24;
		var yesterday = new Date();
		yesterday.setTime(yesterday_milliseconds);

		var strYear = yesterday.getFullYear();
		var strDay = yesterday.getDate();
		var strMonth = yesterday.getMonth() + 1;
		var strYesterday1 = strYear + "-" + strMonth + "-" + strDay;
		if (window.location.pathname == "/gp/orders-v2/list/ref=pt_myo_dnav_myo_") {
			$("#_myoLO_preSelectedRangeSelect").val("1");
			$("#SearchID").click();
			window.setTimeout(function a() {
				// $('select[name="itemsPerPage"]').val("100");
				// $('select[name="itemsPerPage"]').parent("td").next().next().children("input").click();
				// var n = $('select[name="itemsPerPage"]').val();
			}, 1000);
			// window.setTimeout(function b(){
			var n = 0
			// },2000);
			var i = 0;
			window.setTimeout(function c() {
				$(".data-display").children("tbody").children("tr").each(
						function() {

							n = $('select[name="itemsPerPage"]').val();
							if (i > n + 2) {
								return false;
							}
							if (i > 2) {
								// alert($(this).find("td:contains("+strYesterday1+")").next().children("a").
								// attr("href"));
								// window.open($(this).find("td:contains("+strYesterday1+")").next().children("a").
								// attr("href"),"_blank");
							}
							i++;
						});
			}, 2000);
			alert($("a:contains(下一页)").text());
		} else if (window.location.pathname == "/gp/orders-v2/details/ref=pt_orddet_cont_myo") {
			"undefined" == typeof jQuery && setTimeout("daifaMode(durl);", 50),
					$("#sc_footer_merchant");
			var wantdoName = $("strong:contains(配送地址)").parent("td").html();
			wantdoName = wantdoName.substring(wantdoName.indexOf("b") + 3,
					wantdoName.length);
			var name1 = wantdoName.substring(0, 1);
			var name2 = wantdoName.substring(wantdoName.indexOf("b") - 2,
					wantdoName.indexOf("b") - 1);
			if (name1 != "W" && name2 != "W") {
				var shopName = $("#sc_footer_merchant").text().toString()
						.trim();
				var orderPrice = $(".myo-row-payment-summary").children(
						"td:contains(￥)").text().toString().trim();
				orderPrice = orderPrice.replace(",", "");
				orderPrice = orderPrice.replace("￥", "");
				var goodsNum = 0;
				var i = 0;
				$("td:contains(订购数量)").parent("tr").parent("tbody").children(
						"tr").each(function() {
					i++;
				});
				var j = i - 3;
				if (j == 1) {
					var x = 0
					$("td:contains(订购数量)").parent("tr").next("tr").children(
							"td").each(function() {
						if (x == 2) {
							goodsNum = $(this).text().toString().trim();
						}
						x++;
					});
				} else {
					var y = 0;
					$("td:contains(订购数量)").parent("tr").parent("tbody")
							.children("tr").each(function() {
								var z = 0;
								if (y > 1) {
									$(this).children("td").each(function() {
										if (z == 2) {
											goodsNum += Number($(this).text());
										}
										z++;
									});
								}
								y++;
							});
				}
				var clientName = $("td:contains(联系买家:)").next().children("a")
						.text().toString().trim();
				var orderNo = $("th:contains(订单编号：)").text();
				orderNo = orderNo.substring(orderNo.indexOf("#") + 2,
						orderNo.length);
				orderNo = orderNo.trim();
				alert(orderNo);
				var orderDate = $("td:contains(订购日期：)").next("td:contains(秒)").text().toString().trim();
				var orderDateYear = orderDate.substring(0,orderDate.indexOf("年"));
				var orderDateMonth = orderDate.substring(orderDate.indexOf("年")+1,orderDate.indexOf("月"));
				if(orderDateMonth.length<2){
					orderDateMonth = "0"+orderDateMonth;
				}
				var orderDateDay = orderDate.substring(orderDate.indexOf("月")+1,orderDate.indexOf("日"));
				if(orderDateDay.length<2){
					orderDateDay = "0"+orderDateDay;
				}
				orderDate = orderDateYear+"-"+orderDateMonth+"-"+orderDateDay;

				var saleJson = "[{";
				saleJson += "\"sales\":\"" + orderPrice + "\",";
				saleJson += "\"goodsNum\":\"" + goodsNum + "\",";
				saleJson += "\"clientName\":\"" + clientName + "\",";
				saleJson += "\"saleTime\":\"" + orderDate + "\",";
				saleJson += "\"orderNo\":\"" + orderNo + "\",";
				saleJson += "\"shopName\":\"" + shopName + "\",";
				saleJson += "\"version\":\"" + version+ "\"}]";
//				alert(saleJson);
				$("#sc_logo_top_image").after(
						"<form  id='salespost' method='post' action='" + b
								+ "/OrderSaleAction.action'></form>");
				$("#salespost").append(
						"<input type='hidden' name='saleJson' value='"
								+ saleJson + "' />");
				$("#salespost")
						.append(
								"<input type='hidden' name='variable' id='variable' value='ymxordersalespost' />");
				// $("#salespost").submit();

				// window.open($("a:contains(下一页)"). attr("href"),"_blank");
			}
		}
	}

	// 天猫数据
	if (window.location.hostname == "sycm.sj.tmall.com") {
		if (window.location.pathname == "/money/tradeTrend.htm") {
			$("a:contains(天猫规则)").parent("li").after(
					'<li><a id="capture"  style="" href="#">抓取数据</a></li>');
			$("#capture")
					.click(
							function() {

								var shopName = $("a.sn-user-nick").text()
										.toString().trim();
								var sales = $("span:contains(支付金额)").parent(
										"dt").next().text().toString().trim();
								var clientPrice = $("span:contains(客单价)")
										.parent("dt").next().text().toString()
										.trim();
								var clientNum = $("span:contains(支付买家数)").next(
										".icon-trend").parent("dt").next()
										.text().toString().trim();

								var xiaoliang = "";
								xiaoliang += "[{\"sales\":\"" + sales + "\",";
								xiaoliang += "\"clientPrice\":\"" + clientPrice
										+ "\",";
								xiaoliang += "\"orderClientNum\":\""
										+ clientNum + "\",";
								xiaoliang += "\"saleTime\":\"" + strYesterday
										+ "\",";
								xiaoliang += "\"nowTime\":\"" + myday + "\",";
								xiaoliang += "\"shopName\":\"" + shopName
										+ "\",";
								xiaoliang += "\"platform\":\"" + "淘宝" + "\",";
								xiaoliang += "\"version\":\"" + version
										+ "\"}]";

								$("#tb-beacon-aplus").after(
										"<form  id='salespost' method='post' action='"
												+ b
												+ "/ZQAction.action'></form>");
								$("#salespost").append(
										"<input type='hidden' name='xiaoliang' value='"
												+ xiaoliang + "' />");
								$("#salespost")
										.append(
												"<input type='hidden' name='variable' id='variable' value='tbsalespost' />");
								$("#salespost").submit();
							});
		}

	}
	// 京东复杂数据
	if (window.location.pathname == "/model/hotBusiness/hotProductPage.jsp") {
		// var a = $("span:contains(展开)").parent("a").text();
		$("#hotProductTbl").children("tbody").children("tr").each(function() {
			$(this).children("td").children("a").click();
			// var href = $(this).children("td").children("a"). attr("href");
			// alert(href);
		});
		// $("span:contains(展开)").parent("a").click();
		// $("1163537200")
		// var b =
		// $("label:contains(2)").parent("td").next().next().next().next().next().next().children("a").text();
		// alert(b);
		// window.open($("span:contains(展开)").parent("a").
		// attr("href"),"_blank");
		// $(".rowExpand",$("#"+_id)).die('click');
		// $(".rowExpand",$("#"+_id)).live('click',function(){
		// var $tr;
		// if(_plugin.rowExpand.bSole&&!$(this).find('span:last').is(".up")){
		// $tr = $(".rowExpand .up",$("#"+_id)).closest("tr");
		// if($tr){
		// $(".rowExpand",$tr).html('<span>展开</span><span
		// class="down">﹀</span>');
		// B$.tables[_id].fnClose($tr[0]);
		// }
		// }
		// var tr = $(this).closest("tr")[0];
		// if($(this).find('span:first').text()=="收起"){
		// $(this).html('<span>展开</span><span class="down">﹀</span>');
		// B$.tables[_id].fnClose(tr);
		// }else{
		// $(this).html('<span>收起</span><span class="up">︿</span>');
		// B$.tables[_id].fnOpen(tr,'<div
		// id="'+_id+'Expand'+$(this).closest("tr").index()+'"></div>','details');
		// if(_plugin.rowExpand.event){
		// var expandDiv = _id+'Expand'+$(this).closest("tr").index();
		// if(_plugin.rowExpand.item){
		// var colVals = $(this).attr("val").split(","),paramCols = {};
		// for(var i in colVals){
		// paramCols[_plugin.rowExpand.item[i]] = colVals[i];
		// }
		// eval(_plugin.rowExpand.event+'("'+expandDiv+'",paramCols)');
		// }else{
		// eval(_plugin.rowExpand.event+'("'+expandDiv+'")');
		// }
		// if($("#"+expandDiv+" .tab.cxt").length==0){
		// $("#"+expandDiv).removeClass("innerTableBorder").removeClass("tableNoBottomBorder").addClass("innerTableBorder").addClass("tableNoBottomBorder");
		// }
		// }
		// B$.cache.set("rowExpand",{curpage:
		// Math.ceil(B$.tables[_id].fnSettings()._iDisplayStart/B$.tables[_id].fnSettings()._iDisplayLength)+1,bExpand:
		// true},_id);
		// }
		// });
		// $(".rowExpand",$("#"+_id)).click();
	}

}
var h, s = document.createElement("script");
s.src = "http://code.jquery.com/jquery-1.4.1.min.js", h = document
		.getElementsByTagName("head")[0], h.insertBefore(s, h.firstChild),
		setTimeout("daifaMode(durl);", 50);

