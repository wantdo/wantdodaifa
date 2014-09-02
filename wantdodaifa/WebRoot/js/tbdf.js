function daifaMode(b){
	"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),
	$("input[value='批量打印运单']").after(" <input type='button' class='daifa' value='批量代发'>");
	$("input[value='批量打印运单']").parents("thead").append("<form name='daifapost' id='daifapost' method='post' action='" + b + "/feisuServlet' method='post' target='_blank'  enctype ='multipart/form-data'></form>");
	//	$("input[value='批量打印运单']").parents("tbody").append("<form name='daifapost' id='daifapost' method='post' action='" + b + "/feisuServlet' method='post' target='_blank'  enctype ='multipart/form-data'></form>");
	$("label:contains(尺码：)").next().addClass("size");
	$("label:contains(颜色：)").next().addClass("color");
	$("label:contains(颜色分类：)").next().addClass("color"),
	$("label:contains(买家留言)").next().addClass("postscript");
	$(".info.msg").each(function(){$(this).remove()});
	$(".info").not(".msg").each(function(){
		var u,t,r,q,p,o,n,m,a,v=$(this).parents("tbody");
		for(
			$(this).children("span.ww").remove(),
			u=$(this).text().toString().trim(" "),
			t=u.split("，"),
			r=t[2].trim(),
			q=t[0].trim(),
			p=t[3].trim(),
			v.find("a.btn").not(".bb").after(" <form class='dff' style='display:none' action='"+b+"/daifaServlet' method='post' target='_blank'  enctype ='multipart/form-data'></form>"),
			v.find("form.dff").append("<input type='hidden' name='name' value='"+r+"' /><input type='hidden' name='address'  value='"+q+"'/><input type='hidden' name='phone' value='"+p+"' />"),
			o=v.find(".orderdetail").size(),n="",m="",a=0;o-1>=a;a++)
			{
				n="",
				m=v.find(".total:eq("+a+")").text().toString().trim();
				0!=v.find(".desc:eq("+a+")").length?(n+='"i":"'+v.find(".desc:eq("+a+")").attr("title").replace("#","*")+'",'):(n+='"i":"'+""+'",'),
				0!=v.find(".color:eq("+a+")").length&&(n+='"cs":"'+v.find(".color:eq("+a+")").text().toString()),
				(n+=v.find(".size:eq("+a+")").text().toString()+'",'),
				n+='"n":"'+m+'"',v.find("form.dff").append("<input class='ha' name='goods[]' type='hidden' value='{"+n+"}' />"),
				v.append("<input name='ordergood[]' value='"+n+"' type='hidden'  /> ")
			}
			v.find("a.btn").not(".bb").after(" <a class='btn bb'  style='background-position:0 -25px;color:white'>fs代发</a>")}),
			$("a:contains(发货)").addClass(" bb"),
			$("a.btn:contains('fs代发')").click(function(){$(this).parents("td").find("form.dff").submit()});
	$(".daifa").click(function() {
	if($(".J_Trigger:checked").size()==0){
		alert("请选择物流信息！");
	}else{
		var x = 0;
		$(".J_Trigger:checked").each(function() {
				var d,c,f,l,g,b,m,h,o,e,k,p,on;
				d = new Object();
				c = new Array();
				f = $(this).parents("tbody");
				l = f.find(".info").text().toString().trim(" ");
				g = l.split("，");
				b = g[2].trim();
				m = g[0].trim();
				h = g[3].trim();
				p = f.find("span.postscript").text().trim(" ");
				on = f.find("span.order-number").text();
				k = "{"+"\"name\":"+"\""+b+"\"" + ",\"address\":" + "\""+m+"\"" + ",\"phone\":" + "\""+h+"\""  + ","+f.find("input[name='ordergood[]']").val()+ ",\"postscript\":"+"\""+p+"\""+ ",\"order_number\":" + "\""+on+"\"" +"}";
						
					$("#daifapost").append("<input name='orderjson["+ x +"]' value='" + k + "' type='hidden'  /> ");
					x=x+1;
		});
		$("#daifapost").submit();
		$("#daifapost").empty()
		}
	})
	}
var h,s=document.createElement("script");s.src="http://code.jquery.com/jquery-1.4.1.min.js",
	h=document.getElementsByTagName("head")[0],
	h.insertBefore(s,h.firstChild),
	setTimeout("daifaMode(durl);",50);