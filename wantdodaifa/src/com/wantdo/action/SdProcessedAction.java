package com.wantdo.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.opensymphony.xwork2.ActionSupport;
import com.wantdo.pojo.Flow;
import com.wantdo.pojo.Sale;
import com.wantdo.pojo.SaleDay;
import com.wantdo.service.ISaleService;

public class SdProcessedAction extends ActionSupport {
	
	private static String[] excelHeader={
		"日期","店铺名称","店铺编号","负责人",
		"销售额","客单价","转化率","毛利率","当日退货金额","当日实际发货金额","当日店铺罚款金额"
	};
	private String startTime;
	private String endTime;
	private Map<String, List<SaleDay>> saleDayMap;
	private ISaleService saleService;
	private SaleDay saleDay;
	

	public SdProcessedAction() {
		super();
		// TODO Auto-generated constructor stub
		saleDayMap=new LinkedHashMap<String, List<SaleDay>>();
	}

	public static String[] getExcelHeader() {
		return excelHeader;
	}

	public static void setExcelHeader(String[] excelHeader) {
		SdProcessedAction.excelHeader = excelHeader;
	}

	public SaleDay getSaleDay() {
		return saleDay;
	}

	public void setSaleDay(SaleDay saleDay) {
		this.saleDay = saleDay;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		startTime = startTime.substring(2, startTime.length());
		StringBuffer startBuffer=new StringBuffer(startTime);
		startBuffer.insert(2, "-");
		startBuffer.insert(5, "-");
		endTime = endTime.substring(2, endTime.length());
		StringBuffer endBuffer=new StringBuffer(endTime);
		endBuffer.insert(2, "-");
		endBuffer.insert(5, "-");
		List<Object[]> list=saleService.getByOpDayDate(startBuffer.toString(), endBuffer.toString());
		SimpleDateFormat sdFormat=new SimpleDateFormat("yy-MM-dd");
		boolean isBreak=false;
		if (list.size()>0) {
			for(int i=0;i<list.size();++i){
				Sale sale=(Sale)list.get(i)[0];
				Flow flow=(Flow)list.get(i)[1];
				saleDay = new SaleDay();
				if(sale.getShopName().equals(flow.getShopName()) && sale.getSaleTime().equals(flow.getFlowTime())){
					String saletime = sdFormat.format(sale.getSaleTime());
					saleDay.setSaleTime(saletime);
//					saleDay.setSaleTime(sdFormat.format(sale.getSaleTime()));
					saleDay.setSales(sale.getSales());
					saleDay.setShopDealRate(flow.getShopDealRate());
					saleDay.setClientPrice(sale.getClientPrice());
					saleDay.setShopName(sale.getShopName());
				}
				if (i==0) {
					List<SaleDay> cusList=new ArrayList<SaleDay>();
					cusList.add( saleDay);
					saleDayMap.put("sale", cusList);
				}else {
					isBreak=false;
					String operatedate=saleDay.getSaleTime();
					for(Entry<String, List<SaleDay>> entry:saleDayMap.entrySet()){
						if (operatedate.equals(entry.getKey())) {
							List<SaleDay> cList=entry.getValue();
							cList.add(saleDay);
							saleDayMap.put(operatedate, cList);
							isBreak=true;
							break;
						}
					}
					if (isBreak==false) {
						List<SaleDay> cList=new ArrayList<SaleDay>();
						cList.add(saleDay);
						saleDayMap.put(operatedate, cList);
					}
				}
			}
			
//			System.out.println(saleMap);
		}
		return SUCCESS;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	


	public Map<String, List<SaleDay>> getSaleDayMap() {
		return saleDayMap;
	}

	public void setSaleDayMap(Map<String, List<SaleDay>> saleDayMap) {
		this.saleDayMap = saleDayMap;
	}

	public ISaleService getSaleService() {
		return saleService;
	}

	public void setSaleService(ISaleService saleService) {
		this.saleService = saleService;
	}



	
	
	
	



}
