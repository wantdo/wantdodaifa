package com.wantdo.action;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wantdo.pojo.Flow;
import com.wantdo.pojo.FlowSource;
import com.wantdo.pojo.Goods;
import com.wantdo.pojo.OrderSale;
import com.wantdo.pojo.Sale;
import com.wantdo.pojo.TimeSale;
import com.wantdo.service.ICusShopsService;
import com.wantdo.service.IFlowService;
import com.wantdo.service.IFlowSourceService;
import com.wantdo.service.IGoodsService;
import com.wantdo.service.IOrderSaleService;
import com.wantdo.service.ISaleService;
import com.wantdo.service.ITimeSaleService;
import com.wantdo.service.IWspShopsService;

public class OrderSaleAction extends ActionSupport{
	private String saleJson;
	private String variable;
	List<OrderSale> orderSaleList;
	private IOrderSaleService orderSaleService;
	
//private InputStream inputStream;

	
		@SuppressWarnings("deprecation")
		public String execute() throws Exception {
			
			if(variable.contains("salespost")){
				//处理销量数据，判断是否重复，插入数据库
				if(!saleJson.equals("") && saleJson != null){
					
					System.out.println(saleJson);
					orderSaleList = orderSaleService.getData(saleJson);
					
					for(OrderSale os : orderSaleList) {
						if(!"undefined".equals(os.getSales()) && os.getSales() !=null && os.getSales() !="--" && os.getSales() !="--"){
							orderSaleService.save(os);
						}else{
							return "error";
						}
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






}
