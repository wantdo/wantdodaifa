package com.wantdo.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.wantdo.pojo.TShopReflect;
import com.wantdo.service.ITShopReflectService;

public class ShopNameManageAction extends ActionSupport{
	private String variable;
	private TShopReflect tShopReflect;
	private ITShopReflectService tShopReflectService;
	private List<TShopReflect> updateList;
	private List<ITShopReflectService> tShopReflectList;
	
	public String execute() throws Exception {
		if(variable == "init"){
			tShopReflectList = tShopReflectService.findAll();
			return SUCCESS;
		}
		if(variable == null){
			return SUCCESS;
		}
		if(variable.equals("editing")){
			return "editing";
		}
		if(variable.equals("add")){
			return "add";
		}
		if(variable.equals("delete") && tShopReflect != null){
			tShopReflectService.delete(tShopReflect);
			return "wait";
		}
		if(variable.equals("update") && tShopReflect != null){
			tShopReflect = tShopReflectService.findById(tShopReflect.getId());
			updateList.add(gettShopReflect());
			//System.out.println(updateList.size());
			return "update";
		}
		return SUCCESS;
	}

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	public ITShopReflectService gettShopReflectService() {
		return tShopReflectService;
	}

	public void settShopReflectService(ITShopReflectService tShopReflectService) {
		this.tShopReflectService = tShopReflectService;
	}

	public List<ITShopReflectService> gettShopReflectList() {
		return tShopReflectList;
	}

	public void settShopReflectList(List<ITShopReflectService> tShopReflectList) {
		this.tShopReflectList = tShopReflectList;
	}

	public TShopReflect gettShopReflect() {
		return tShopReflect;
	}

	public void settShopReflect(TShopReflect tShopReflect) {
		this.tShopReflect = tShopReflect;
	}

	public List<TShopReflect> getUpdateList() {
		return updateList;
	}

	public void setUpdateList(List<TShopReflect> updateList) {
		this.updateList = updateList;
	}

}
