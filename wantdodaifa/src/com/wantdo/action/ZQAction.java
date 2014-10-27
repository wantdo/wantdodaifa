package com.wantdo.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.wantdo.pojo.Flow;
import com.wantdo.pojo.FlowSource;
import com.wantdo.pojo.Goods;
import com.wantdo.pojo.HotGoodsRank;
import com.wantdo.pojo.OrderSale;
import com.wantdo.pojo.Sale;
import com.wantdo.pojo.TimeSale;
import com.wantdo.service.ICusShopsService;
import com.wantdo.service.IFlowService;
import com.wantdo.service.IFlowSourceService;
import com.wantdo.service.IGoodsService;
import com.wantdo.service.IHotGoodsRankService;
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
	private String hotInfo;
	private String variable;
	private ISaleService saleService;
	private IFlowService flowService;
	private IFlowSourceService flowSourceService;
	private IGoodsService goodsService;
	private ITimeSaleService timeSaleService;
	private IOrderSaleService orderSaleService;
	private ICusShopsService cusShopsService;
	private IWspShopsService wspShopsService;
	private IHotGoodsRankService hotGoodsRankService;
	private List<Sale> saleList;
	private List<Flow> flowList;
	private List<TimeSale> timeSaleList;
	private List<FlowSource> flowSourceList;
	private List<Goods> goodsList;
	private List<HotGoodsRank> hotGoodsRankList;
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
						if(saleList.get(0).getVersion().equals("1.1.5")){
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
									clientPrice = total/clientNum;
								}
								int temp1 = (int)Math.round(total * 100); //小数点后两位前移，并四舍五入 
								total = (double)temp1 / 100.00; //还原小数点后两位
								int temp2 = (int)Math.round(clientPrice * 100); //小数点后两位前移，并四舍五入 
								clientPrice = (double)temp2 / 100.00; //还原小数点后两位
								
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
						}else{
							return "pluginerror";
						}
					}
					//======================================================京东流量=======================================================
					if(!liuliang.equals("") && liuliang != null){
						
						liuliang = liuliang.replaceAll("\\*","%");
						
	//				System.out.println(liuliang);
						
						flowList = flowService.getData(liuliang);
						if(flowList.get(0).getVersion().equals("1.1.5")){
						for(Flow f : flowList) {
							if(!"undefined".equals(f.getShopDealRate()) && f.getShopDealRate() != null && f.getShopDealRate() != "--"){
								Date flowTime = f.getFlowTime();
								String shopName = f.getShopName();
								List<Flow> fList = flowService.findbyTimeAndName(flowTime,shopName);
								if(fList.size()==0){
									flowService.save(f);
								}else{
									for(Flow fl : fList){
										fl.setAvgPaceTime(f.getAvgPaceTime());
										fl.setNowTime(f.getNowTime());
										fl.setFirstPaymentRate(f.getFirstPaymentRate());
										fl.setGoodsVolume(f.getGoodsVolume());
										fl.setShopDealRate(f.getShopDealRate());
										fl.setShopVolume(f.getShopVolume());
										fl.setThirtyCustomerRetention(f.getThirtyCustomerRetention());
										fl.setThirtyRepeatPurchaseRate(f.getThirtyRepeatPurchaseRate());
										fl.setVisits(f.getVisits());
										flowService.update(fl);
									}
								}
							}else{
								return "error";
							}
						}
						}else{
							return "pluginerror";
						}
					}
					//======================================================京东实时销量=======================================================
					if(!zhibiao.equals("") && zhibiao != null){
						
	//					System.out.println(zhibiao);
						
						timeSaleList = timeSaleService.getData(zhibiao);
						if(timeSaleList.get(0).getVersion().equals("1.1.5")){
						for(TimeSale t : timeSaleList) {
							if(!"undefined".equals(t.getSales()) && t.getSales() !=null && t.getSales() !="--"){
								String times = t.getTimes();
								String shopName = t.getShopName();
								Date saleTime = t.getSaleTime();
								
								List<TimeSale> tsList = timeSaleService.findbyTimeAndName(times,shopName,saleTime);
								if(tsList.size()==0){
									timeSaleService.save(t);
								}else{
									for(TimeSale ts : tsList){
										ts.setNowTime(t.getNowTime());
										ts.setOrderClientNum(t.getOrderClientNum());
										ts.setOrderGoodsNum(t.getOrderGoodsNum());
										ts.setOrderQuantity(t.getOrderQuantity());
										ts.setPageviews(t.getPageviews());
										ts.setSales(t.getSales());
										ts.setVisitors(t.getVisitors());
										ts.setVisits(t.getVisits());
										timeSaleService.update(ts);
									}
								}
							}else{
								return "error";
							}
						}
						}else{
							return "pluginerror";
						}
					}
					//======================================================京东上架=======================================================
					if(!shangjia.equals("") && shangjia != null){
						
	//					System.out.println(shangjia);
						
						goodsList = goodsService.getData(shangjia);
						if(goodsList.get(0).getVersion().equals("1.1.5")){
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
						} else
							return "pluginerror";
						}
				}
				if(variable.equals("jdflowSourcepost")){
				//======================================================京东流量来源=======================================================
					if(!laiyuan.equals("") && laiyuan != null){
						laiyuan = laiyuan.replaceAll("\\*","%");
						flowSourceList = flowSourceService.getData(laiyuan);
						if(flowSourceList.get(0).getVersion().equals("1.1.5")){
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
								}else{
									for(FlowSource fls : fsList){
										fls.setFlowSource(fs.getFlowSource());
										fls.setLandPageView(fs.getLandPageView());
										fls.setLandPageViewAccounted(fs.getLandPageViewAccounted());
										fls.setNowTime(fs.getNowTime());
										fls.setPageView(fs.getPageView());
										fls.setPageViewAccounted(fs.getPageViewAccounted());
										flowSourceService.update(fls);
									}
								}
							}else{
								return "error";
							}
						}
						}else{
							return "pluginerror";
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
							if(flowList.get(0).getVersion().equals("1.1.5")){
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
							}else{
								return "pluginerror";
							}
						}
					}
				}
				//======================================================京东热销商品排行=======================================================
				if(variable.equals("jdhotGoodspost")){
					if(!hotInfo.equals("") && hotInfo != null){
						
						hotInfo = hotInfo.replaceAll("\\*","%");
//						System.out.println(hotInfo);
						hotGoodsRankList = hotGoodsRankService.getData(hotInfo);
						if(hotGoodsRankList.get(0).getVersion().equals("1.1.5")){
						for(HotGoodsRank h : hotGoodsRankList) {
							if(!"undefined".equals(h.getPrice()) && h.getPrice() != null){
								Date captureDate = h.getCaptureDate();
								String goodsName = h.getGoodsName();
								String shopName = h.getShopName();
								String flowSource = h.getFlowSource();
								String avgVisitNum = h.getAvgVisitNum();
								String bounceRate = h.getBounceRate();
								
								List<HotGoodsRank> hgrList1 = hotGoodsRankService.findbyTimeAndName(goodsName,captureDate,shopName,flowSource,avgVisitNum,bounceRate);
								if(hgrList1.size()==0){
									hotGoodsRankService.save(h);
								}else{
									for(HotGoodsRank hgr : hgrList1){
										hgr.setFlowSource(h.getBounceRate());
										hgr.setAvgVisitNum(h.getAvgVisitNum());
										hgr.setCaptureTime(h.getCaptureTime());
										hgr.setDealGoodsIndex(h.getDealGoodsIndex());
										hgr.setFlowSource(h.getFlowSource());
										hgr.setGoodsUrl(h.getGoodsUrl());
										hgr.setLinkChangeRate(h.getLinkChangeRate());
										hgr.setPrice(h.getPrice());
										hgr.setPviews(h.getPviews());
										hgr.setPvisits(h.getPvisits());
										hgr.setRank(h.getRank());
										hgr.setCaptureTime(h.getCaptureTime());
										
										hotGoodsRankService.update(hgr);
									}
								}
								
							}else{
								return "error";
							}
						}
						}else{
							return "pluginerror";
						}
					}
				}

				if(variable.equals("jdhotGoodsDetailpost")){
					if(!hotInfo.equals("") && hotInfo != null){
						
//						System.out.println(hotInfo);
						hotGoodsRankList = hotGoodsRankService.getData(hotInfo);
						if(hotGoodsRankList.get(0).getVersion().equals("1.1.5")){
						for(HotGoodsRank h : hotGoodsRankList) {
							if(!"undefined".equals(h.getSign()) && h.getSign() != null){
								Date captureDate = h.getCaptureDate();
								String goodsUrl = h.getGoodsUrl();
								List<HotGoodsRank> hgrList = hotGoodsRankService.findbyURL(goodsUrl,captureDate);
									for(HotGoodsRank hgr : hgrList){
										hgr.setSign(h.getSign());
										hotGoodsRankService.update(hgr);
									}
							}else{
								return "error";
							}
						}
						}else{
							return "pluginerror";
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
						if(saleList.get(0).getVersion().equals("1.1.5")){
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
									clientPrice = total/clientNum;
								}
								int temp1 = (int)Math.round(total * 100); //小数点后两位前移，并四舍五入 
								total = (double)temp1 / 100.00; //还原小数点后两位
								int temp2 = (int)Math.round(clientPrice * 100); //小数点后两位前移，并四舍五入 
								clientPrice = (double)temp2 / 100.00; //还原小数点后两位
								
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
						}else{
							return "pluginerror";
						}
					}
				
					//======================================================当当流量=======================================================
					if(!liuliang.equals("") && liuliang != null){
						
						liuliang = liuliang.replaceAll("\\*","%");
						
	//				System.out.println(liuliang);
						
						flowList = flowService.getData(liuliang);
						if(flowList.get(0).getVersion().equals("1.1.5")){
						for(Flow f : flowList) {
							if(!"undefined".equals(f.getPageviews()) && f.getPageviews() != null && f.getPageviews() != "--"){
								Date flowTime = f.getFlowTime();
								String shopName = f.getShopName();
								List<Flow> fList = flowService.findbyTimeAndName(flowTime,shopName);
								if(fList.size()==0){
									flowService.save(f);
								}else{
									for(Flow fl : fList){
										fl.setAvgPaceTime(f.getAvgPaceTime());
										fl.setNowTime(f.getNowTime());
										fl.setAvgVisitDepth(f.getAvgVisitDepth());
										fl.setBackVisitorsRate(f.getBackVisitorsRate());
										fl.setBounceRate(f.getBounceRate());
										fl.setFirstPaymentRate(f.getFirstPaymentRate());
										fl.setGoodsVolume(f.getGoodsVolume());
										fl.setPageviews(f.getPageviews());
										fl.setShopDealRate(f.getShopDealRate());
										fl.setShopVolume(f.getShopVolume());
										fl.setThirtyCustomerRetention(f.getThirtyCustomerRetention());
										fl.setThirtyRepeatPurchaseRate(f.getThirtyRepeatPurchaseRate());
										fl.setVisitors(f.getVisitors());
										fl.setVisits(f.getVisits());
										flowService.update(fl);
									}
								}
							}else{
								return "error";
							}
						}
						}else{
							return "pluginerror";
						}
					}
				
				}
				if(variable.equals("ddsales")){
					//======================================================当当实时流量=======================================================
					if(!zhibiao.equals("") && zhibiao != null){
						
	//					System.out.println(zhibiao);
						
						timeSaleList = timeSaleService.getData(zhibiao);
						if(timeSaleList.get(0).getVersion().equals("1.1.5")){
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
								}else{
									for(TimeSale ts : tsList){
										ts.setNowTime(t.getNowTime());
										ts.setOrderClientNum(t.getOrderClientNum());
										ts.setOrderGoodsNum(t.getOrderGoodsNum());
										ts.setOrderQuantity(t.getOrderQuantity());
										ts.setPageviews(t.getPageviews());
										ts.setSales(t.getSales());
										ts.setVisitors(t.getVisitors());
										ts.setVisits(t.getVisits());
										timeSaleService.update(ts);
									}
								}
							}else{
								return "error";
							}
						}
						}else{
							return "pluginerror";
						}
					}
				}
				if(variable.equals("ddflowSourcepost")){
					//======================================================当当流量来源=======================================================
					if(!laiyuan.equals("") && laiyuan != null){
	//						System.out.println(laiyuan);
						laiyuan = laiyuan.replaceAll("\\*","%");
						flowSourceList = flowSourceService.getData(laiyuan);
						if(flowSourceList.get(0).getVersion().equals("1.1.5")){
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
								}else{
									for(FlowSource fls : fsList){
										fls.setLandPageView(fs.getLandPageView());
										fls.setLandPageViewAccounted(fs.getLandPageViewAccounted());
										fls.setNowTime(fs.getNowTime());
										fls.setPageView(fs.getPageView());
										fls.setPageViewAccounted(fs.getPageViewAccounted());
										flowSourceService.update(fls);
									}
								}
							}else{
								return "error";
							}
						}
						}else{
							return "pluginerror";
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
						if(saleList.get(0).getVersion().equals("1.1.5")){
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
									clientPrice = total/clientNum;
								}
								int temp1 = (int)Math.round(total * 100); //小数点后两位前移，并四舍五入 
								total = (double)temp1 / 100.00; //还原小数点后两位
								int temp2 = (int)Math.round(clientPrice * 100); //小数点后两位前移，并四舍五入 
								clientPrice = (double)temp2 / 100.00; //还原小数点后两位
								
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
						}else{
							return "pluginerror";
						}
					}
				}
				if(variable.equals("fksales3")){
					//======================================================凡客流量=======================================================
					if(!liuliang.equals("") && liuliang != null){
						
						liuliang = liuliang.replaceAll("\\*","%");
						
		//			System.out.println(liuliang);
						
						flowList = flowService.getData(liuliang);
						if(flowList.get(0).getVersion().equals("1.1.5")){
						for(Flow f : flowList) {
							if(!"undefined".equals(f.getPageviews()) && f.getPageviews() != null && f.getPageviews() != "--"){
								Date flowTime = f.getFlowTime();
								String shopName = f.getShopName();
								List<Flow> fList = flowService.findbyTimeAndName(flowTime,shopName);
								if(fList.size()==0){
									flowService.save(f);
								}else{
									for(Flow fl : fList){
										fl.setAvgPaceTime(f.getAvgPaceTime());
										fl.setNowTime(f.getNowTime());
										fl.setAvgVisitDepth(f.getAvgVisitDepth());
										fl.setBackVisitorsRate(f.getBackVisitorsRate());
										fl.setBounceRate(f.getBounceRate());
										fl.setFirstPaymentRate(f.getFirstPaymentRate());
										fl.setGoodsVolume(f.getGoodsVolume());
										fl.setPageviews(f.getPageviews());
										fl.setShopDealRate(f.getShopDealRate());
										fl.setShopVolume(f.getShopVolume());
										fl.setThirtyCustomerRetention(f.getThirtyCustomerRetention());
										fl.setThirtyRepeatPurchaseRate(f.getThirtyRepeatPurchaseRate());
										fl.setVisitors(f.getVisitors());
										fl.setVisits(f.getVisits());
										flowService.update(fl);
									}
								}
							}else{
								return "error";
							}
						}
						}else{
							return "pluginerror";
						}
					}
				}

				if(variable.equals("fksales2")){
				//======================================================凡客实时流量=======================================================

					if(!zhibiao.equals("") && zhibiao != null){
						
	//					System.out.println(zhibiao);
						
						timeSaleList = timeSaleService.getData(zhibiao);
						if(timeSaleList.get(0).getVersion().equals("1.1.5")){
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
								}else{
									for(TimeSale ts : tsList){
										ts.setNowTime(t.getNowTime());
										ts.setOrderClientNum(t.getOrderClientNum());
										ts.setOrderGoodsNum(t.getOrderGoodsNum());
										ts.setOrderQuantity(t.getOrderQuantity());
										ts.setPageviews(t.getPageviews());
										ts.setSales(t.getSales());
										ts.setVisitors(t.getVisitors());
										ts.setVisits(t.getVisits());
										timeSaleService.update(ts);
									}
								}
							}else{
								return "error";
							}
						}
						}else{
							return "pluginerror";
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
						if(saleList.get(0).getVersion().equals("1.1.5")){
						for(Sale s : saleList) {
							if(!"undefined".equals(s.getSales()) && s.getSales() !=null && s.getSales() !="--"){
								Date saleTime = s.getSaleTime();
								String shopName = s.getShopName();
								List<Sale> sList = saleService.findbyTimeAndName(saleTime,shopName);
								if(sList.size() == 0){
									saleService.save(s);
								}else{
									for(Sale sa : sList){
										sa.setNowTime(s.getNowTime());
										sa.setOrderGoodsNum(s.getOrderGoodsNum());
										sa.setOrderQuantity(s.getOrderQuantity());
										sa.setSales(s.getSales());
										sa.setOrderClientNum(s.getOrderClientNum());
										sa.setClientPrice(s.getClientPrice());
										saleService.update(sa);
									}
								}
							}else{
								return "error";
							}
						}
						}else{
							return "pluginerror";
						}
					}
					//======================================================淘宝流量=======================================================
	
					if(!liuliang.equals("") && liuliang != null){
						
						liuliang = liuliang.replaceAll("\\*","%");
						
	//				System.out.println(liuliang);
						
						flowList = flowService.getData(liuliang);
						if(flowList.get(0).getVersion().equals("1.1.5")){
						for(Flow f : flowList) {
							if(!"undefined".equals(f.getPageviews()) && f.getPageviews() != null && f.getPageviews() != "--"){
								Date flowTime = f.getFlowTime();
								String shopName = f.getShopName();
								List<Flow> fList = flowService.findbyTimeAndName(flowTime,shopName);
								if(fList.size()==0){
									flowService.save(f);
								}else{
									for(Flow fl : fList){
										fl.setNowTime(f.getNowTime());
										fl.setAvgVisitDepth(f.getAvgVisitDepth());
										fl.setBackVisitorsRate(f.getBackVisitorsRate());
										fl.setBounceRate(f.getBounceRate());
										fl.setFirstPaymentRate(f.getFirstPaymentRate());
										fl.setGoodsVolume(f.getGoodsVolume());
										fl.setPageviews(f.getPageviews());
										fl.setShopDealRate(f.getShopDealRate());
										fl.setShopVolume(f.getShopVolume());
										fl.setThirtyCustomerRetention(f.getThirtyCustomerRetention());
										fl.setThirtyRepeatPurchaseRate(f.getThirtyRepeatPurchaseRate());
										fl.setVisitors(f.getVisitors());
										fl.setVisits(f.getVisits());
										flowService.update(fl);
									}
								}
							}else{
								return "error";
							}
						}
						}else{
							return "pluginerror";
						}
					}
				}
				if(variable.equals("tbtmsalespost")){
					
					//======================================================淘宝销量=======================================================
					if(!xiaoliang.equals("") && xiaoliang != null){
						
						//					System.out.println(xiaoliang);
						
						saleList = saleService.getData(xiaoliang);
						if(saleList.get(0).getVersion().equals("1.1.5")){
						for(Sale s : saleList) {
							if(!"undefined".equals(s.getSales()) && s.getSales() !=null && s.getSales() !="--"){
								Date saleTime = s.getSaleTime();
								String shopName = s.getShopName();
								List<Sale> sList = saleService.findbyTimeAndName(saleTime,shopName);
								if(sList.size() == 0){
									saleService.save(s);
								}else if(sList.size() == 1){
									for(Sale sa : sList){
										sa.setSales(s.getSales());
										sa.setOrderClientNum(s.getOrderClientNum());
										sa.setClientPrice(s.getClientPrice());
										saleService.update(sa);
									}
								}
							}else{
								return "error";
							}
						}
						}else{
							return "pluginerror";
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
							if(flowList.get(0).getVersion().equals("1.1.5")){
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
							}else{
								return "pluginerror";
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
						if(saleList.get(0).getVersion().equals("1.1.5")){
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
									clientPrice = total/clientNum;
								}
								int temp1 = (int)Math.round(total * 100); //小数点后两位前移，并四舍五入 
								total = (double)temp1 / 100.00; //还原小数点后两位
								int temp2 = (int)Math.round(clientPrice * 100); //小数点后两位前移，并四舍五入 
								clientPrice = (double)temp2 / 100.00; //还原小数点后两位
								
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
						}else{
							return "pluginerror";
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

	public IHotGoodsRankService getHotGoodsRankService() {
		return hotGoodsRankService;
	}

	public void setHotGoodsRankService(IHotGoodsRankService hotGoodsRankService) {
		this.hotGoodsRankService = hotGoodsRankService;
	}

	public List<HotGoodsRank> getHotGoodsRankList() {
		return hotGoodsRankList;
	}

	public void setHotGoodsRankList(List<HotGoodsRank> hotGoodsRankList) {
		this.hotGoodsRankList = hotGoodsRankList;
	}

	public String getHotInfo() {
		return hotInfo;
	}

	public void setHotInfo(String hotInfo) {
		this.hotInfo = hotInfo;
	}


}
