function daifaMode(b){
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
		var adress = $(".fore").children("dd").children("ul").find("li:contains(地)").text();
		adress = adress.substring(7,adress.length);
		var phone = $(".fore").children("dd").children("ul").find("li:contains(手机号码)").text();
		phone = phone.substring(5,phone.length);
		orderJson+="\"name\":\"" +name+"\",";
		orderJson+="\"address\":\"" +adress+"\",";
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
		
		orderJson+="\"orderPrice\":\"" +$(".ftx04").find("b").text().toString().trim()+"\"";
		alert(orderJson);
		$.post(b + "/jddfServlet",{orderJson:orderJson},function(){});
//		setTimeout("location.href='http://order.shop.jd.com/order/sopUp_waitOutList.action'",5000);
//		setTimeout("window.close()",2000);
}
}
var h,s=document.createElement("script");s.src="http://code.jquery.com/jquery-1.4.1.min.js",
	h=document.getElementsByTagName("head")[0],
	h.insertBefore(s,h.firstChild),
	setTimeout("daifaMode(durl);",50);