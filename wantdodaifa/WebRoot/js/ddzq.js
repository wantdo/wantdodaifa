function daifaMode(b){
if(window.location.pathname=="/shop-info"){
	"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
	$("#shop_status_right").children("tr").each(function(){
		var n="{";
		var body1 = $(this).children("td");
		var head1 = $("#shop_status_head").children("tr").children("td");
		for(var i=0;i<head1.length;i++){
			for(var j=0;j<body1.length;j++){
				if(i == j){
					n+="\""+head1.eq(i).text().toString().trim()+"\":";
					if(j!=body1.length-1){
						n+="\""+body1.eq(j).text().toString().trim()+"\",";
					}
					else{
						n+="\""+body1.eq(j).text().toString().trim()+"\"}";
					}
				}
			}
		}
		alert(n);
	});
	$("#shop_detail_right").children("tr").each(function(){
		var m = "{";
		var head2 = $("#shop_status_head").children("tr").children("td");
			$(this).children("td").each(function(){
				var j=0;
					m+="\""+$(this).eq(j).text().toString().trim()+"\",";
				j++;
			});
			m=m.substring(0, m.length-1)
		m+="}"
		alert(m);
	});
	
}else if(window.location.pathname=="/shop-order-entire"){
	
}
}
var h,s=document.createElement("script");s.src="http://code.jquery.com/jquery-1.4.1.min.js",
	h=document.getElementsByTagName("head")[0],
	h.insertBefore(s,h.firstChild),
	setTimeout("daifaMode(durl);",50);
	