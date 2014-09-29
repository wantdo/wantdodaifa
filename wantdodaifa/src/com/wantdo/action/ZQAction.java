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

public class ZQAction extends ActionSupport{
	private String xiaoliang;
	private String liuliang;
	private String shangjia;
	private String zhibiao;
	private String laiyuan;
	private String flowInfo;
	private String variable;
	private ISaleService saleService;
	private IFlowService flowService;
	private IFlowSourceService flowSourceService;
	private IGoodsService goodsService;
	private ITimeSaleService timeSaleService;
	private IOrderSaleService orderSaleService;
	private ICusShopsService cusShopsService;
	private IWspShopsService wspShopsService;
	private List<Sale> saleList;
	private List<Flow> flowList;
	private List<TimeSale> timeSaleList;
	private List<FlowSource> flowSourceList;
	private List<Goods> goodsList;
//private InputStream inputStream;
	
		@SuppressWarnings("deprecation")
		public String execute() throws Exception {
			
			//京东
			if(variable.contains("jd")){
				if(variable.equals("jdsalespost")){
					//======================================================京东销量=======================================================
					if(!xiaoliang.equals("") && xiaoliang != null){
						
	//					System.out.println(xiaoliang);
						saleList = saleService.getData(xiaoliang);
						for(Sale s : saleList) {
							if(!"undefined".equals(s.getSales()) && s.getSales() !=null && s.getSales() !="--" && s.getSales() !="--"){
								Date saleTime = s.getSaleTime();
								String shopName = s.getShopName();
								List<Sale> sList = saleService.findbyTimeAndName(saleTime,shopName);
								if(sList.size() == 0){
									saleService.save(s);
									return SUCCESS;
								}
							}else{
								return "error";
							}
						}
					}
					//======================================================京东流量=======================================================
					if(!liuliang.equals("") && liuliang != null){
						
						liuliang = liuliang.replaceAll("\\*","%");
						
	//				System.out.println(liuliang);
						
						flowList = flowService.getData(liuliang);
						for(Flow f : flowList) {
							if(!"undefined".equals(f.getShopDealRate()) && f.getShopDealRate() != null && f.getShopDealRate() != "--"){
								Date flowTime = f.getFlowTime();
								String shopName = f.getShopName();
								List<Flow> fList = flowService.findbyTimeAndName(flowTime,shopName);
								if(fList.size()==0){
									flowService.save(f);
								}
							}else{
								return "error";
							}
						}
					}
					//======================================================京东实时销量=======================================================
					if(!zhibiao.equals("") && zhibiao != null){
						
	//					System.out.println(zhibiao);
						
						timeSaleList = timeSaleService.getData(zhibiao);
						for(TimeSale t : timeSaleList) {
							if(!"undefined".equals(t.getSales()) && t.getSales() !=null && t.getSales() !="--"){
								String times = t.getTimes();
								String shopName = t.getShopName();
								Date saleTime = t.getSaleTime();
								
								List<TimeSale> tsList = timeSaleService.findbyTimeAndName(times,shopName,saleTime);
								if(tsList.size()==0){
									timeSaleService.save(t);
								}
							}else{
								return "error";
							}
						}
					}
					//======================================================京东上架=======================================================
					if(!shangjia.equals("") && shangjia != null){
						
	//					System.out.println(shangjia);
						
						goodsList = goodsService.getData(shangjia);
						for(Goods g : goodsList) {
							if(!"undefined".equals(g.getSku()) && g.getSku() != null && g.getSku() !="--"){
								Date goodsTime = g.getGoodsTime();
								String shopName = g.getShopName();
								List<Goods> gList = goodsService.findbyTimeAndName(goodsTime,shopName);
								if(gList.size()==0){
									goodsService.save(g);
								}
							}else{
								return "error";
							}
						}
					}
				}
				if(variable.equals("jdflowSourcepost")){
				//======================================================京东流量来源=======================================================
					if(!laiyuan.equals("") && laiyuan != null){
//						System.out.println(laiyuan);
						laiyuan = laiyuan.replaceAll("\\*","%");
						flowSourceList = flowSourceService.getData(laiyuan);
						for(FlowSource fs : flowSourceList) {
							if(!"undefined".equals(fs.getFlowSource()) && fs.getFlowSource() !=null && fs.getFlowSource() != "--"){
								String flowSource = fs.getFlowSource();
								String shopName = fs.getShopName();
								Date flowSourceTime = fs.getFlowSourceTime();
								fs.setFlowSourceTime(flowSourceTime);
								fs.setNowTime((Timestamp)fs.getNowTime());
								
								List<FlowSource> fsList = flowSourceService.findbyTimeAndName(flowSourceTime,shopName,flowSource);
								if(fsList.size()==0){
									flowSourceService.save(fs);
								}
							}else{
								return "error";
							}
						}
					}
				}
				if(variable.equals("jdflowpost")){
					//======================================================京东流量补充=======================================================
					if(variable.equals("jdflowpost")){
						if(!flowInfo.equals("") && flowInfo != null){
							
							flowInfo = flowInfo.replaceAll("\\*","%");
							
	//						System.out.println(flowInfo);
							
							
							flowList = flowService.getData(flowInfo);
							for(Flow f : flowList) {
								if(!"undefined".equals(f.getPageviews()) && f.getPageviews() != null && f.getPageviews() != "--"){
									Date flowTime = f.getFlowTime();
									String shopName = f.getShopName();
									String version = f.getVersion();
									
									List<Flow> fList = flowService.findbyTimeAndNameV(flowTime,shopName,version);
									for(Flow fl : fList){
										fl.setAvgPaceTime(f.getAvgPaceTime());
											fl.setPageviews(f.getPageviews());
											fl.setVisitors(f.getVisitors());
											fl.setAvgVisitDepth(f.getAvgVisitDepth());
											fl.setBounceRate(f.getBounceRate());
											fl.setBackVisitorsRate(f.getBackVisitorsRate());
										flowService.update(fl);
									}
								}else{
									return "error";
								}
							}
						}
					}
				}
			}
			//当当
			if(variable.contains("dd")){
				//======================================================当当销量=======================================================
				if(variable.equals("ddsalespost")){
					if(!xiaoliang.equals("") && xiaoliang != null){
						
		//					System.out.println(xiaoliang);
						saleList = saleService.getData(xiaoliang);
						for(Sale s : saleList) {
							if(!"undefined".equals(s.getSales()) && s.getSales() !=null && s.getSales() !="--" && s.getSales() !="--"){
								Date saleTime = s.getSaleTime();
								String shopName = s.getShopName();
								List<Sale> sList = saleService.findbyTimeAndName(saleTime,shopName);
								if(sList.size() == 0){
									saleService.save(s);
									return SUCCESS;
								}
							}else{
								return "error";
							}
						}
					}
				
					//======================================================当当流量=======================================================
					if(!liuliang.equals("") && liuliang != null){
						
						liuliang = liuliang.replaceAll("\\*","%");
						
	//				System.out.println(liuliang);
						
						flowList = flowService.getData(liuliang);
						for(Flow f : flowList) {
							if(!"undefined".equals(f.getPageviews()) && f.getPageviews() != null && f.getPageviews() != "--"){
								Date flowTime = f.getFlowTime();
								String shopName = f.getShopName();
								List<Flow> fList = flowService.findbyTimeAndName(flowTime,shopName);
								if(fList.size()==0){
									flowService.save(f);
								}
							}else{
								return "error";
							}
						}
					}
				
				}
				if(variable.equals("ddsales")){
					//======================================================当当实时流量=======================================================
					if(!zhibiao.equals("") && zhibiao != null){
						
	//					System.out.println(zhibiao);
						
						timeSaleList = timeSaleService.getData(zhibiao);
						for(TimeSale t : timeSaleList) {
							if(!"undefined".equals(t.getVisitors()) && t.getVisitors() !=null && t.getVisitors() !="--"){
								String times = t.getTimes();
								String shopName = t.getShopName();
								Date saleTime = t.getSaleTime();
								t.setSaleTime(saleTime);
								t.setNowTime((Timestamp)t.getNowTime());
								
								List<TimeSale> tsList = timeSaleService.findbyTimeAndName(times,shopName,saleTime);
								if(tsList.size()==0){
									timeSaleService.save(t);
								}
							}else{
								return "error";
							}
						}
					}
				}
				if(variable.equals("ddflowSourcepost")){
					//======================================================当当流量来源=======================================================
					if(!laiyuan.equals("") && laiyuan != null){
	//						System.out.println(laiyuan);
						laiyuan = laiyuan.replaceAll("\\*","%");
						flowSourceList = flowSourceService.getData(laiyuan);
						for(FlowSource fs : flowSourceList) {
							if(!"undefined".equals(fs.getFlowSource()) && fs.getFlowSource() !=null && fs.getFlowSource() != "--"){
								String flowSource = fs.getFlowSource();
								String shopName = fs.getShopName();
								Date flowSourceTime = fs.getFlowSourceTime();
								fs.setFlowSourceTime(flowSourceTime);
								fs.setNowTime((Timestamp)fs.getNowTime());
								
								List<FlowSource> fsList = flowSourceService.findbyTimeAndName(flowSourceTime,shopName,flowSource);
								if(fsList.size()==0){
									flowSourceService.save(fs);
								}
	//								else{
	//									return "repeat";
	//								}
							}else{
								return "error";
							}
						}
					}
				}
			}
			//凡客
			if(variable.contains("fk")){
				if(variable.equals("fksales1")){
					//======================================================凡客销量=======================================================
					if(!xiaoliang.equals("") && xiaoliang != null){
						
	//					System.out.println(xiaoliang);
						
						saleList = saleService.getData(xiaoliang);
						for(Sale s : saleList) {
//							if(!"undefined".equals(s.getSales()) && s.getSales() !=null && s.getSales() !="--"){
//								Date saleTime = s.getSaleTime();
//								String shopName = s.getShopName();
//								List<Sale> sList = saleService.findbyTimeAndName(saleTime,shopName);
//								if(sList.size() == 0){
//									saleService.save(s);
//								}
//							}else{
//								return "error";
//							}

							if(!"undefined".equals(s.getSales()) && s.getSales() !=null && s.getSales() !="--" && s.getSales() !="--"){
								Date saleTime = s.getSaleTime();
								String shopName = s.getShopName();
								List<Sale> sList = saleService.findbyTimeAndName(saleTime,shopName);
								List<OrderSale> orderSale = orderSaleService.findbyTimeAndName(saleTime, shopName);
								List<OrderSale> clientList = orderSaleService.findbyTimeAndNameAndClient(saleTime, shopName);
								int clientNum = clientList.size();
								double total=0.00;
								int orderNum=0;
								int goodsNum=0;
								for(OrderSale os : orderSale){
									total += Double.parseDouble(os.getSales());
									orderNum++;
									goodsNum += Integer.parseInt(os.getGoodsNum());
								}
								double clientPrice = total/clientNum;
								if(clientNum<orderNum){
									clientNum = orderNum;
								}
								String sales = String.valueOf(total);
								String orderQuantity = String.valueOf(orderNum);
								String cPrice = String.valueOf(clientPrice);
								String cNum = String.valueOf(clientNum);
								String orderGoodsNum = String.valueOf(goodsNum);
								
								s.setSales(sales);
								s.setOrderQuantity(orderQuantity);
								s.setClientPrice(cPrice);
								s.setOrderGoodsNum(orderGoodsNum);
								s.setOrderClientNum(cNum);
								
								if(sList.size() == 0){
									saleService.save(s);
									return SUCCESS;
								}else{
									for(Sale sa : sList){
										sa.setSales(sales);
										sa.setOrderQuantity(orderQuantity);
										sa.setClientPrice(cPrice);
										sa.setOrderGoodsNum(orderGoodsNum);
										sa.setOrderClientNum(cNum);
										
										saleService.update(sa);
									}
								}
							}else{
								return "error";
							}
						
						}
					}
				}
				if(variable.equals("fksales3")){
					//======================================================凡客流量=======================================================
					if(!liuliang.equals("") && liuliang != null){
						
						liuliang = liuliang.replaceAll("\\*","%");
						
		//			System.out.println(liuliang);
						
						flowList = flowService.getData(liuliang);
						for(Flow f : flowList) {
							if(!"undefined".equals(f.getPageviews()) && f.getPageviews() != null && f.getPageviews() != "--"){
								Date flowTime = f.getFlowTime();
								String shopName = f.getShopName();
								List<Flow> fList = flowService.findbyTimeAndName(flowTime,shopName);
								if(fList.size()==0){
									flowService.save(f);
								}
							}else{
								return "error";
							}
						}
					}
				}

				if(variable.equals("fksales2")){
				//======================================================凡客实时流量=======================================================

					if(!zhibiao.equals("") && zhibiao != null){
						
	//					System.out.println(zhibiao);
						
						timeSaleList = timeSaleService.getData(zhibiao);
						for(TimeSale t : timeSaleList) {
							if(!"undefined".equals(t.getVisitors()) && t.getVisitors() !=null && t.getVisitors() !="--"){
								String times = t.getTimes();
								String shopName = t.getShopName();
								Date saleTime = t.getSaleTime();
								t.setSaleTime(saleTime);
								t.setNowTime((Timestamp)t.getNowTime());
								
								List<TimeSale> tsList = timeSaleService.findbyTimeAndName(times,shopName,saleTime);
								if(tsList.size()==0){
									timeSaleService.save(t);
								}
							}else{
								return "error";
							}
						}
					}
				}
			}
			//淘宝
			if(variable.contains("tb")){
				if(variable.equals("tbsalespost")){
				
					//======================================================淘宝销量=======================================================
					if(!xiaoliang.equals("") && xiaoliang != null){
						
	//					System.out.println(xiaoliang);
						
						saleList = saleService.getData(xiaoliang);
						for(Sale s : saleList) {
							if(!"undefined".equals(s.getSales()) && s.getSales() !=null && s.getSales() !="--"){
								Date saleTime = s.getSaleTime();
								String shopName = s.getShopName();
								List<Sale> sList = saleService.findbyTimeAndName(saleTime,shopName);
								if(sList.size() == 0){
									saleService.save(s);
								}
							}else{
								return "error";
							}
						}
					}
					//======================================================淘宝流量=======================================================
	
					if(!liuliang.equals("") && liuliang != null){
						
						liuliang = liuliang.replaceAll("\\*","%");
						
	//				System.out.println(liuliang);
						
						flowList = flowService.getData(liuliang);
						for(Flow f : flowList) {
							if(!"undefined".equals(f.getPageviews()) && f.getPageviews() != null && f.getPageviews() != "--"){
								Date flowTime = f.getFlowTime();
								String shopName = f.getShopName();
								List<Flow> fList = flowService.findbyTimeAndName(flowTime,shopName);
								if(fList.size()==0){
									flowService.save(f);
								}
							}else{
								return "error";
							}
						}
					}
				}
				if(variable.equals("tbflowpost")){
				
					//======================================================淘宝流量补充=======================================================
					if(variable.equals("tbflowpost")){
						if(!flowInfo.equals("") && flowInfo != null){
							
							flowInfo = flowInfo.replaceAll("\\*","%");
							
	//						System.out.println(flowInfo);
							
							
							flowList = flowService.getData(flowInfo);
							for(Flow f : flowList) {
								if(!"undefined".equals(f.getAvgPaceTime()) && f.getAvgPaceTime() != null && f.getAvgPaceTime() != "--"){
									Date flowTime = f.getFlowTime();
									String shopName = f.getShopName();
									String version = f.getVersion();
									
									List<Flow> fList = flowService.findbyTimeAndNameV(flowTime,shopName,version);
									for(Flow fl : fList){
										fl.setAvgPaceTime(f.getAvgPaceTime());
										flowService.update(fl);
									}
								}else{
									return "error";
								}
							}
						}
					}
				}
			}
			//亚马逊
			if(variable.contains("ymx")){
				if(variable.equals("ymxsalespost")){
				
				//======================================================亚马逊销量=======================================================
					if(!xiaoliang.equals("") && xiaoliang != null){
						
//						System.out.println(xiaoliang);
						saleList = saleService.getData(xiaoliang);
						for(Sale s : saleList) {
							if(!"undefined".equals(s.getSales()) && s.getSales() !=null && s.getSales() !="--" && s.getSales() !="--"){
								Date saleTime = s.getSaleTime();
								String shopName = s.getShopName();
								List<Sale> sList = saleService.findbyTimeAndName(saleTime,shopName);
								List<OrderSale> orderSale = orderSaleService.findbyTimeAndName(saleTime, shopName);
								List<OrderSale> clientList = orderSaleService.findbyTimeAndNameAndClient(saleTime, shopName);
								int clientNum = clientList.size();
								double total=0.00;
								int orderNum=0;
								int goodsNum=0;
								for(OrderSale os : orderSale){
									total += Double.parseDouble(os.getSales());
									orderNum++;
									goodsNum += Integer.parseInt(os.getGoodsNum());
								}
								double clientPrice = total/clientNum;
								if(clientNum<orderNum){
									clientNum = orderNum;
								}
								String sales = String.valueOf(total);
								String orderQuantity = String.valueOf(orderNum);
								String cPrice = String.valueOf(clientPrice);
								String cNum = String.valueOf(clientNum);
								String orderGoodsNum = String.valueOf(goodsNum);
								
								s.setSales(sales);
								s.setOrderQuantity(orderQuantity);
								s.setClientPrice(cPrice);
								s.setOrderGoodsNum(orderGoodsNum);
								s.setOrderClientNum(cNum);
								
								if(sList.size() == 0){
									saleService.save(s);
									return SUCCESS;
								}else{
									for(Sale sa : sList){
										sa.setSales(sales);
										sa.setOrderQuantity(orderQuantity);
										sa.setClientPrice(cPrice);
										sa.setOrderGoodsNum(orderGoodsNum);
										sa.setOrderClientNum(cNum);
										
										saleService.update(sa);
									}
								}
							}else{
								return "error";
							}
						}
					}
				}
			}
			
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


	public String getVariable() {
		return variable;
	}


	public void setVariable(String variable) {
		this.variable = variable;
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



	public String getZhibiao() {
		return zhibiao;
	}


	public void setZhibiao(String zhibiao) {
		this.zhibiao = zhibiao;
	}


	public ITimeSaleService getTimeSaleService() {
		return timeSaleService;
	}


	public void setTimeSaleService(ITimeSaleService timeSaleService) {
		this.timeSaleService = timeSaleService;
	}


	public ICusShopsService getCusShopsService() {
		return cusShopsService;
	}


	public void setCusShopsService(ICusShopsService cusShopsService) {
		this.cusShopsService = cusShopsService;
	}


	public IWspShopsService getWspShopsService() {
		return wspShopsService;
	}


	public void setWspShopsService(IWspShopsService wspShopsService) {
		this.wspShopsService = wspShopsService;
	}


	public List<Sale> getSaleList() {
		return saleList;
	}


	public void setSaleList(List<Sale> saleList) {
		this.saleList = saleList;
	}


	public List<Flow> getFlowList() {
		return flowList;
	}


	public void setFlowList(List<Flow> flowList) {
		this.flowList = flowList;
	}


	public List<TimeSale> getTimeSaleList() {
		return timeSaleList;
	}


	public void setTimeSaleList(List<TimeSale> timeSaleList) {
		this.timeSaleList = timeSaleList;
	}


	public List<FlowSource> getFlowSourceList() {
		return flowSourceList;
	}


	public void setFlowSourceList(List<FlowSource> flowSourceList) {
		this.flowSourceList = flowSourceList;
	}


	public List<Goods> getGoodsList() {
		return goodsList;
	}


	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

	public IOrderSaleService getOrderSaleService() {
		return orderSaleService;
	}

	public void setOrderSaleService(IOrderSaleService orderSaleService) {
		this.orderSaleService = orderSaleService;
	}


}
