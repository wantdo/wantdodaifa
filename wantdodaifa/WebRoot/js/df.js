function daifaMode(b){
	"undefined"==typeof jQuery&&setTimeout("daifaMode(durl);",50),	
	$("#hotProductTbl").children("tbody").children("tr").each(function(){
		var arr = " ";
		var baseinfo = " ";
		$(this).children("td").each(function(){
			var text = $(this).text().replace(",","");					
			baseinfo = baseinfo + text +";";		
		});
		var baseinf = baseinfo.toString().trim(" ");
		var basein = baseinf.split(";")
		var basei = basein[0].trim(" ");
		var base = basein[2].trim(" ");
		var bas = basein[3].trim(" ");
		var ba = basein[4];
		var b = basein[5].trim(" ");
		alert(ba);
		$(this).children("td.t-l").each(function(){
			arr = arr + $(this).children("label").children("a.bus-need-tips").attr("href") + ";";
			//alert(arr);
		});
		var url = arr.toString().trim(" ");
		var ur = url.split(";");
		var u = ur[1].trim(" ");
		//alert(u);
		var attr = $(this).children("td").children("a.rowExpand").attr("val");
		//alert(attr);
		$.ajax({
			url:'http://pop.jd.com/interDataModel/hotProActFlowView.action',
			data:{
				"filter.rm_bs_type":"1",
				"filter.sku":attr,
				//"filter.sku":"1168902263",
				"filter.date":"7"
			},
			type:'post',	
			success:function(result){
				//console.log(result);
				//alert(result);
				$("a[val="+attr+"]").parent("td").after("<div id='result' style='display: none'>"+result+"</div>");
				//$("a[val='1168902263']").parent("td").after("<div id='result' style='display: none'>"+result+"</div>");
				var message = "";
				var info = "";
//				$("#demoDiv").children("ul").children("li").children("div").each(function(){
//					message = message + $(this).text() +",";
//					//alert($(this).html());
//				});
				//$("a[val="+attr+"]").parent("td").parent("tr").children("div").each(function(){
					//message = message + $(this).text() +",";
					//alert($(this).find("ul").find("li").text());
					$("a[val="+attr+"]").parent("td").parent("tr").children("div").find("#demoDiv").children("ul").children("li").children("div").each(function(){
					//$("a[val='1168902263']").parent("td").parent("tr").children("div").find("#demoDiv").children("ul").children("li").children("div").each(function(){
						message = message + $(this).text() +",";
						//alert($(this).text());
					});	
				//});
					var mess = message.toString().trim(" ");
					var me = mess.split(",");
					var a = me[0].trim(" ");
					var b = me[2].trim(" ");
					var c = me[4].trim(" ");
					var d = me[5].trim(" ");
					//alert(mess);
				//alert(message);
				var arr = message.toString().trim(" ");
				//alert(message);
				$("a[val="+attr+"]").parent("td").parent("tr").children("div").find("#demoDiv").children("div").children("ul").children("li").each(function(){
					info = info + $(this).text() +",";
					//alert($(this).text());
				});
				//alert(info);
			}		
		});
	});
	
	
	//$(".rowExpand ").find("span").eq(0).click();
	//alert($("#demoDiv").html());
	//alert($(".pro-marginright pro-textalign").html());
//	$("#hotProductTbl");
//	var i=1;
//	var href = document.getElementById("hotProductTbl");
//	var t = href.getElementsByTagName('a');
	
	/*
	$("#hotProductTbl").children("tbody").children("tr").children("td").each(function(){
		if(i<23){
			t[i].click();
			if(i>1){
				i=i+2;
			}else if(i=1){
				i=i+5;
			}
			window.setTimeout(function c(){},5000);
			//alert(href);
			alert(t);
			}		
		//("#hotProduct").children("tbody").children("tr");
		//alert("1");
	});
	*/
	}
var h,s=document.createElement("script");s.src="http://code.jquery.com/jquery-1.4.1.min.js",
	h=document.getElementsByTagName("head")[0],
	h.insertBefore(s,h.firstChild),
	setTimeout("daifaMode(durl);",50);