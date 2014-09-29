package com.wantdo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wantdo.pojo.OrderJd;
import com.wantdo.service.IOrderJdService;

public class JDDFAction extends ActionSupport{
	private String OrderJson;
	private IOrderJdService orderJdService;
	
	public String execute() throws Exception {
		if(!OrderJson.equals("") && OrderJson != null){
			OrderJson = "["+OrderJson+"]";
			System.out.println(OrderJson);
			
//			ActionContext ctx = ActionContext.getContext();
//			ctx.put("request", "OrderJson");
//			HttpServletRequest request = ServletActionContext.getRequest();
//			String OrderJson = request.getParameter("OrderJson");
//			System.out.println(OrderJson);
			
			List<OrderJd> orderJds = orderJdService.getData(OrderJson);
			for(OrderJd o : orderJds) {
				System.out.println(o.getAddress() + " ============================ ");
				orderJdService.save(o);
				return SUCCESS;
			}
		}
		return SUCCESS;
	}
	public String getOrderJson() {
		return OrderJson;
	}

	public void setOrderJson(String orderJson) {
		OrderJson = orderJson;
	}

	public IOrderJdService getOrderJdService() {
		return orderJdService;
	}

	public void setOrderJdService(IOrderJdService orderJdService) {
		this.orderJdService = orderJdService;
	}

}
