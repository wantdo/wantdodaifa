function daifaMode(b){
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
	myday = myday.Format("yyyy-MM-dd hh:mm:ss");
    //版本号
    var version = "1.0";
if(window.location.pathname=="/order/sopUp_waitOutList.action"){
	"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
	$("a:contains(批量备注)").after('<a class="btn_type daifa"  track="batchprintdeliverybeta" style="margin-right:0;" href="#">批量代发</a>');
	$(function(){
//		$("a:contains('代发')").click(function(){
//			window.open($(this).parents("td").find("a:contains(查看详情)"). attr("href"),"_parent");
//			setTimeout("location.href='http://order.shop.jd.com/order/sopUp_waitOutList.action'",5000);
			

//			var id = $(this).parents("td").find("a:contains(查看详情)").html();
//			var id = $(this).parents("td").find("a:contains(查看详情)").attr('href');
//			alert(id);
			
//			var id = $(this).parents("tbody").children("tr").children("td").children("span").children("p").html();
//			var url = "http://order.shop.jd.com/order/order_orderInfoPage.action?orderId=" + id;
//			
//			$.post(b + "/NetBugServlet",{url:url},function(data){
//				alert(data);
//				$(this).parents("tbody").after(data);
//			});
//		});
		$(".daifa").click(function() {
			var artNo = "";
			if($('input[name="checkedOrder"]:checked').size()==0){
				alert("请选择物流信息！");
			}else{
				$('input[name="checkedOrder"]:checked').each(function() {
					var url = $(this).parents("tbody").children("tr").children("td").find("a:contains(查看详情)").attr('href');
					if(url!=null){
//						artNo = $(this).parents("tbody").children("tr").children("td").children("div").children("span:contains(货号:)").text();
						window.open($(this).parents("tbody").children("tr").children("td").find("a:contains(查看详情)"). attr("href"),"_blank");
//						$.post(b + "/jdtzServlet",{url:url,artNo:artNo},function(){});
					}
				});
//				artNo = artNo.substring(3, artNo.length-1);
//				$.post(b + "/jddfServlet",{artNo:artNo},function(){});
				}
			});
		
		});
		
}else if(window.location.pathname=="/order/order_orderInfoPage.action"){
		"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
		$(".fore").html();
		var orderJson = "";
		var name = $(".fore").children("dd").children("ul").find("li:contains(收)").text();
		name = name.substring(6,name.length);
		var address = $(".fore").children("dd").children("ul").find("li:contains(地)").text();
		address = address.substring(7,address.length);
		var phone = $(".fore").children("dd").children("ul").find("li:contains(手机号码)").text();
		phone = phone.substring(5,phone.length);
		orderJson+="{\"name\":\"" +name+"\",";
		orderJson+="\"address\":\"" +address+"\",";
		orderJson+="\"phone\":\"" +phone+"\",";
		
		var orderID = window.location.search;
		orderID = orderID.substring(9, orderID.length-1);
		orderJson+="\"orderID\":\"" +orderID+"\",";
		var detail=new Array();
		var i = 0;
		$(".p-list").children("table").children("tbody").children("tr").children("td").each(function(){
			detail[i]=$(this).text().toString().trim();
			i++;
		});
		orderJson+="\"orderNo\":\"" +detail[0]+"\",";
		orderJson+="\"goodinfo\":\"" +detail[1]+"\",";
		orderJson+="\"primeCost\":\"" +detail[2]+"\",";
		orderJson+="\"discountCost\":\"" +detail[3]+"\",";
		orderJson+="\"orderNum\":\"" +detail[6]+"\",";
		orderJson+="\"orderPrice\":\"" +$(".ftx04").find("b").text().toString().trim()+"\",";
		orderJson+="\"gettime\":\"" +myday+"\",";
		orderJson+="\"version\":\"" +version+"\"}";
		
		alert(orderJson);
		
		$.post(b + "/JDDFAction",{orderJson:orderJson},function(){});
		
//		$(".fore").after("<form  id='orderpost' method='post' action='"+b+"/JDDFAction.action'></form>");
//	    $("#orderpost").append("<input type='hidden' name='orderJson' value='"+orderJson+"' />");
//	    $("#orderpost").submit();
	    
//		setTimeout("location.href='"+b+"/JDDFAction.action?orderJson="+orderJson+"'",200);
//		$.post(b + "/jddfServlet",{orderJson:orderJson},function(){});
//		setTimeout("location.href='http://order.shop.jd.com/order/sopUp_waitOutList.action'",5000);
//		setTimeout("window.close()",2000);
}else if(window.location.pathname == "/order/detail/search"){
	"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
	$(".fore").html();
	var orderJson = "";
	var name = $("h3:contains(收货人信息)").next().text().toString().trim();
	name = name.substring(name.indexOf("：")+1,name.length);
	var address = $("h3:contains(收货人信息)").next().next().text().toString().trim();
	address = address.substring(address.indexOf("：")+1,address.length);
	var phone = $("h3:contains(收货人信息)").next().next().next().text().toString().trim();
	phone = phone.substring(phone.indexOf("：")+1,phone.length);
	orderJson+="{\"name\":\"" +name+"\",";
	orderJson+="\"address\":\"" +address+"\",";
	orderJson+="\"phone\":\"" +phone+"\",";

	var discountCost = $(".td-bd").children("span.it2").next().next().next().text().toString().trim();
	discountCost = discountCost.substring(1,discountCost.length);
	
//	小计
//	alert($(".td-bd").children("span.it2").next().next().next().next().next().text().toString().trim());
//	运费
//	alert($("p:contains(运费：￥)").text().toString().trim());
//	总计
	var orderPrice = $("p.pay").text().toString().trim();
	orderPrice = orderPrice.substring(orderPrice.indexOf("￥"),orderPrice.length);
	
	orderJson+="\"orderNo\":\"" +$(".td-bd").children("span.it2").next().next().prev().text().toString().trim()+"\",";
	orderJson+="\"goodinfo\":\"" +$(".it2").children("a").text().toString().trim()+"\",";
	orderJson+="\"primeCost\":\"" +$(".td-bd").children("span.it2").next().next().text().toString().trim()+"\",";
	orderJson+="\"discountCost\":\"" +discountCost+"\",";
	orderJson+="\"orderNum\":\"" +$(".td-bd").children("span.it2").next().next().next().next().text().toString().trim()+"\",";
	orderJson+="\"orderPrice\":\"" +orderPrice+"\",";
	orderJson+="\"gettime\":\"" +myday+"\",";
	orderJson+="\"version\":\"" +version+"\"}";
//	alert(orderJson);
	$.post(b + "/JDDFAction",{orderJson:orderJson},function(){});
}
}
var h,s=document.createElement("script");s.src="http://code.jquery.com/jquery-1.4.1.min.js",
	h=document.getElementsByTagName("head")[0],
	h.insertBefore(s,h.firstChild),
	setTimeout("daifaMode(durl);",50);