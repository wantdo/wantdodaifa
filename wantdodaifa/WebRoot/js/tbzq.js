function daifaMode(b){
//	alert(window.location.pathname);
if(window.location.pathname=="/p/app/basic"){
	"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
	$("td:contains(成交金额)").parents("tr").parents("tbody").children("tr").children("td").children("div").text();
	var general = "";
	general += $("td:contains(成交金额)").parents("tr").parents("tbody").children("tr").children("td").children("div").text() + ",";
	general += $("td:contains(成交人数)").parents("tr").parents("tbody").children("tr").children("td").children("div").text() + ",";
	general += $("td:contains(新顾客数)").parents("tr").parents("tbody").children("tr").children("td").children("div").text() + ",";
	general += $("td:contains(老顾客数)").parents("tr").parents("tbody").children("tr").children("td").children("div").text() + ",";
	general += $("td:contains(成交商品数)").parents("tr").parents("tbody").children("tr").children("td").children("div").text() + ",";
	general += $("td:contains(宝贝页成交转化率)").parents("tr").parents("tbody").children("tr").children("td").children("div").text();
	alert(general);
	
}else if(window.location.pathname=="/"){
	var liuliang = "";
	$("#maintable").children("tbody").children("tr").children("td").each(function(){
		var liul = $(this).children("span").text().toString().trim();
		liul = liul.replace(",", "");
		liuliang += liul + ",";
	});
//	alert(liuliang);
	$(".right-container").children("table").children("tbody").children("tr").each(function(){
		var detail = "";
		$(this).children("td").each(function(){
			var det = $(this).text().toString().trim();
			det = det.replace(",", "");
			detail += det + ",";
		});
		alert(detail);
	});
	$("#shopsummary_line_table").children("table").children("tbody").children("tr").each(function(){
		var fangke = "";
		$(this).children("td").each(function(){
			var fk = $(this).text().toString().trim();
			fk = fk.replace(",", "");
			fangke += fk + ",";
		});
		alert(fangke);
	});
}
}
var h,s=document.createElement("script");s.src="http://code.jquery.com/jquery-1.4.1.min.js",
	h=document.getElementsByTagName("head")[0],
	h.insertBefore(s,h.firstChild),
	setTimeout("daifaMode(durl);",50);
	