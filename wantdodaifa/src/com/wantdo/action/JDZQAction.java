package com.wantdo.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.wantdo.pojo.Flow;
import com.wantdo.pojo.FlowSource;
import com.wantdo.pojo.Goods;
import com.wantdo.pojo.Sale;
import com.wantdo.service.IFlowService;
import com.wantdo.service.IFlowSourceService;
import com.wantdo.service.IGoodsService;
import com.wantdo.service.ISaleService;
import com.wantdo.service.impl.FlowSourceService;

public class JDZQAction extends ActionSupport{
	private String xiaoliang;
	private String liuliang;
	private String shangjia;
	private String variable;
	private String laiyuan;
	private String flowInfo;
	private ISaleService saleService;
	private IFlowService flowService;
	private IFlowSourceService flowSourceService;
	private IGoodsService goodsService;
	
	public String execute() throws Exception {
//		if(!xiaoliang.equals("") && xiaoliang != null){
//
//			System.out.println(xiaoliang);
//			
//			List<Sale> sales = saleService.getSale(xiaoliang);
//			for(Sale s : sales) {
//				System.out.println(s.getSales() + " ============================ ");
//				saleService.save(s);
//			}
//		}
//		if(!liuliang.equals("") && liuliang != null){
//
//			System.out.println(liuliang);
//			
//			liuliang = liuliang.replaceAll("\\*","%");
//			
//			System.out.println(liuliang);
//			
//			
//			List<Flow> flows = flowService.getSale(liuliang);
//			for(Flow f : flows) {
//				System.out.println(f.getAvgPaceTime() + " ============================ ");
//				flowService.save(f);
//			}
//		}
//		if(!shangjia.equals("") && shangjia != null){
//
//			System.out.println(shangjia);
//			
//			List<Goods> goodss = goodsService.getSale(shangjia);
//			for(Goods g : goodss) {
//				System.out.println(g.getGoodsTime() + " ============================ ");
//				goodsService.save(g);
//			}
//		}
//		if(!laiyuan.equals("") && laiyuan != null){
//
//			System.out.println(laiyuan);
//			
//			List<FlowSource> flowSources = flowSourceService.getSale(laiyuan);
//			for(FlowSource fs : flowSources) {
//				System.out.println(fs.getFlowSource() + " ============================ ");
//				flowSourceService.save(fs);
//			}
//		}
//		if(!flowInfo.equals("") && flowInfo != null){
//
//			System.out.println(flowInfo);
//			
//			flowInfo = flowInfo.replaceAll("\\*","%");
//			
////			flowInfo = new String(flowInfo.getBytes("iso-8859-1"),"GBK");
//			
//			System.out.println(flowInfo);
//			
//			
//			List<Flow> flows = flowService.getSale(flowInfo);
//			for(Flow f : flows) {
//				System.out.println(f.getAvgPaceTime() + " ============================ ");
//				flowService.save(f);
//			}
//		}
		return SUCCESS;
	}
	
	
	public String getXiaoliang() {
		return xiaoliang;
	}
	public void setXiaoliang(String xiaoliang) {
		this.xiaoliang = xiaoliang;
	}
	public String getLiuliang() {
		return liuliang;
	}
	public void setLiuliang(String liuliang) {
		this.liuliang = liuliang;
	}
	public String getShangjia() {
		return shangjia;
	}
	public void setShangjia(String shangjia) {
		this.shangjia = shangjia;
	}


	public String getVariable() {
		return variable;
	}


	public void setVariable(String variable) {
		this.variable = variable;
	}


	public ISaleService getSaleService() {
		return saleService;
	}


	public void setSaleService(ISaleService saleService) {
		this.saleService = saleService;
	}


	public String getLaiyuan() {
		return laiyuan;
	}


	public void setLaiyuan(String laiyuan) {
		this.laiyuan = laiyuan;
	}


	public String getFlowInfo() {
		return flowInfo;
	}


	public void setFlowInfo(String flowInfo) {
		this.flowInfo = flowInfo;
	}


	public IFlowService getFlowService() {
		return flowService;
	}


	public void setFlowService(IFlowService flowService) {
		this.flowService = flowService;
	}


	public IFlowSourceService getFlowSourceService() {
		return flowSourceService;
	}


	public void setFlowSourceService(IFlowSourceService flowSourceService) {
		this.flowSourceService = flowSourceService;
	}


	public IGoodsService getGoodsService() {
		return goodsService;
	}


	public void setGoodsService(IGoodsService goodsService) {
		this.goodsService = goodsService;
	}

}
