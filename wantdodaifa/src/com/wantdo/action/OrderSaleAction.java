package com.wantdo.action;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.wantdo.pojo.OrderSale;
import com.wantdo.service.IOrderSaleService;

public class OrderSaleAction extends ActionSupport{
	private String saleJson;
	private String variable;
	private String saleData;
	List<OrderSale> orderSaleList;
	private IOrderSaleService orderSaleService;
	
//private InputStream inputStream;

	
		
		public String execute() throws Exception {
			
			if(variable.contains("salespost")){
				//处理销量数据，判断是否重复，插入数据库
				if(!saleJson.equals("") && saleJson != null){
					
//					System.out.println(saleJson);
					orderSaleList = orderSaleService.getData(saleJson);
					
					for(OrderSale os : orderSaleList) {
						String orderNo = os.getOrderNo();
						if(!"undefined".equals(orderNo) && orderNo !=null && orderNo !="--" && orderNo !="--"){
							List<OrderSale> osList = orderSaleService.findbyOrderNo(orderNo);
							if(osList.size() == 0){
								orderSaleService.save(os);
							}
						}else{
							return "error";
						}
					}
				}
			}
			if(variable.contains("shopNamepost")){

				orderSaleList = orderSaleService.getData(saleData);
				
				for(OrderSale os : orderSaleList) {
					if(!"undefined".equals(os.getShopName()) && os.getShopName() !=null && os.getShopName() !="--" && os.getShopName() !="--"){
						String shopName = "京东";
						Date saleTime = os.getSaleTime();
						List<OrderSale> osList = orderSaleService.findbyTimeAndName(saleTime, shopName);
						for(OrderSale ors : osList){
							ors.setShopName(os.getShopName());
							orderSaleService.update(ors);
						}
					}else{
						return "error";
					}
				}
				
			}
		
			return SUCCESS;
		}
		




	public String getSaleJson() {
		return saleJson;
	}



	public void setSaleJson(String saleJson) {
		this.saleJson = saleJson;
	}



	public List<OrderSale> getOrderSaleList() {
		return orderSaleList;
	}



	public void setOrderSaleList(List<OrderSale> orderSaleList) {
		this.orderSaleList = orderSaleList;
	}



	public IOrderSaleService getOrderSaleService() {
		return orderSaleService;
	}



	public void setOrderSaleService(IOrderSaleService orderSaleService) {
		this.orderSaleService = orderSaleService;
	}



	public String getVariable() {
		return variable;
	}


	public void setVariable(String variable) {
		this.variable = variable;
	}





	public String getSaleData() {
		return saleData;
	}





	public void setSaleData(String saleData) {
		this.saleData = saleData;
	}




}
