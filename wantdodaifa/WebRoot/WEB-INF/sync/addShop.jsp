<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>店铺名称管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="<%=basePath %>css/bootstrap.min.css">
<script src="<%=basePath%>js/jquery-1.11.0.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function editChange(str){
		var str;
		if(str=="add"){
			document.getElementById("edit").value="add";
		};
		if(str=="update"){
			document.getElementById("edit").value="update";
		};
	}
	function checkdelete(){
		document.getElementById("edit").value="delete";
		if(confirm("确定要删除么")){
			return true;
		}else{
			return false;
		}
	}
</script>
</head>

<body>
<div id="header" class="alert alert-warning" style="font-size:large; padding: 20px">
<form action="CusEditAction" method="post" name = "form1">
	<div style="padding: 20px">
		<table class="table table-bordered">
			<caption align="top" style="font-size: x-large;">店铺名称管理</caption>
			<thead>
				<tr style="background-color:highlight;">
					<!-- <td>ERP_ID</td> -->
					<td>ERP店铺名称</td>
					<td>店铺编号</td>
					<td>抓取店铺名称</td>
				</tr>
			</thead>
			<s:iterator value="tShopReflectList" id="tShopReflectList">
				<tr style="background-color:threedface;"">
					<%-- <td><s:property value="#tShopReflectList.shopId" /></td> --%>
					<td><s:property value="#tShopReflectList.shopName" /></td>
					<td><s:property value="#tShopReflectList.shopNo" /></td>
					<td><s:property value="#tShopReflectList.shopNameCapture" /></td>
				</tr>
			</s:iterator>
		</table>
		<div>
			<span id = "cusDetail.detail" class="labelDis" style="display:none;">ERP店铺名称：<input type = "text" name = "cusDetail.detail" id = "cusDetail.detail"/></span>
			<span id = "cusDetail.detail" class="labelDis" style="display:none;">店铺编号：<input type = "text" name = "cusDetail.detail" id = "cusDetail.detail"/></span>
			<span id = "cusDetail.detail" class="labelDis" style="display:none;">抓取店铺名称：<input type = "text" name = "cusDetail.detail" id = "cusDetail.detail"/></span>
		</div>
		<div class="opa">
			<input type="hidden" name = "edit" id = "edit" value="" />
			<input  class="btn btn-primary timeSubmit btn-sm" type="Submit" value="新增" onClick="editChange('add')"></input>
			<input  class="btn btn-primary timeSubmit btn-sm" type="Submit" value="修改" onClick="editChange('update')"></input>
			<input  class="btn btn-primary timeSubmit btn-sm" type="Submit" value="删除" onClick="return checkdelete()"></input>
			<input type="button" class="btn btn-primary timeSubmit btn-sm" onclick="history.go(-1)" value="返回"></input>
		</div>
	</div>
	</form>
	</div>
</body>
</html>
