package com.wantdo.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.opensymphony.xwork2.ActionSupport;
import com.wantdo.pojo.Flow;
import com.wantdo.pojo.FlowSource;
import com.wantdo.pojo.Sale;
import com.wantdo.service.IFlowSourceService;
import com.wantdo.service.ISaleService;

public class SProcessedAction extends ActionSupport {
	
	private String[] strArray={"店铺名","平台","流量来源","到达页浏览量","到达页浏览量占比","浏览量","浏览量占比","数据日期","操作时间"};
	
	private String startTime;
	private String endTime;
	private Map<String, List<Sale>> saleMap;
	private ISaleService saleService;
	
	

	public SProcessedAction() {
		super();
		// TODO Auto-generated constructor stub
		saleMap=new LinkedHashMap<String, List<Sale>>();
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
		List<Object[]> list=saleService.getByOpDate(startBuffer.toString(), endBuffer.toString());
		SimpleDateFormat sdFormat=new SimpleDateFormat("yy-MM-dd");
		boolean isBreak=false;
		if (list!=null) {
			for(int i=0;i<list.size();++i){
				if (i==0) {

					double clientPrice = Double.parseDouble(list.get(0)[5].toString());
					int temp2 = (int)Math.round(clientPrice * 100); //小数点后两位前移，并四舍五入 
					clientPrice = (double)temp2 / 100.00; //还原小数点后两位
					
					List<Sale> cList=new ArrayList<Sale>();
					Sale s = new Sale();
					s.setShopName(list.get(0)[0].toString());
					s.setPlatform(list.get(0)[1].toString());
					s.setSales(list.get(0)[2].toString());
					s.setOrderQuantity(list.get(0)[3].toString());
					s.setOrderGoodsNum(list.get(0)[4].toString().substring(0,list.get(0)[4].toString().length()-2));
					s.setOrderClientNum(list.get(0)[3].toString());
					s.setClientPrice(String.valueOf(clientPrice));
					s.setVersion(startBuffer.toString()+"至"+endBuffer.toString());
					cList.add(s);
					saleMap.put(endBuffer.toString(), cList);
				}else {
					isBreak=false;
					String operatedate=endBuffer.toString();
					for(Entry<String, List<Sale>> entry:saleMap.entrySet()){
						if (operatedate.equals(entry.getKey())) {
							
							double clientPrice = Double.parseDouble(list.get(i)[5].toString());
							int temp2 = (int)Math.round(clientPrice * 100); //小数点后两位前移，并四舍五入 
							clientPrice = (double)temp2 / 100.00; //还原小数点后两位
							
							List<Sale> cList=entry.getValue();
							Sale s = new Sale();
							s.setShopName(list.get(i)[0].toString());
							s.setPlatform(list.get(i)[1].toString());
							s.setSales(list.get(i)[2].toString());
							s.setOrderQuantity(list.get(i)[3].toString());
							s.setOrderGoodsNum(list.get(i)[4].toString().substring(0,list.get(i)[4].toString().length()-2));
							s.setOrderClientNum(list.get(i)[3].toString());
							s.setClientPrice(String.valueOf(clientPrice));
							s.setVersion(startBuffer.toString()+"至"+endBuffer.toString());
							cList.add(s);
							saleMap.put(operatedate, cList);
							isBreak=true;
							break;
						}
					}
					if (isBreak==false) {

						double clientPrice = Double.parseDouble(list.get(i)[5].toString());
						int temp2 = (int)Math.round(clientPrice * 100); //小数点后两位前移，并四舍五入 
						clientPrice = (double)temp2 / 100.00; //还原小数点后两位
						
						List<Sale> cList=new ArrayList<Sale>();
						Sale s = new Sale();
						s.setShopName(list.get(i)[0].toString());
						s.setPlatform(list.get(i)[1].toString());
						s.setSales(list.get(i)[2].toString());
						s.setOrderQuantity(list.get(i)[3].toString());
						s.setOrderGoodsNum(list.get(i)[4].toString().substring(0,list.get(i)[4].toString().length()-2));
						s.setOrderClientNum(list.get(i)[3].toString());
						s.setClientPrice(String.valueOf(clientPrice));
						s.setVersion(startBuffer.toString()+"至"+endBuffer.toString());
						cList.add(s);
						saleMap.put(operatedate, cList);
					}
				}
			}
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
	
	public String[] getStrArray() {
		return strArray;
	}

	public void setStrArray(String[] strArray) {
		this.strArray = strArray;
	}

	public Map<String, List<Sale>> getSaleMap() {
		return saleMap;
	}

	public void setSaleMap(Map<String, List<Sale>> saleMap) {
		this.saleMap = saleMap;
	}

	public ISaleService getSaleService() {
		return saleService;
	}

	public void setSaleService(ISaleService saleService) {
		this.saleService = saleService;
	}



	
	
	
	



}
