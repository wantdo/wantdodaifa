package com.wantdo.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.opensymphony.xwork2.ActionSupport;
import com.wantdo.pojo.FlowSource;
import com.wantdo.pojo.TimeSale;
import com.wantdo.service.IFlowSourceService;
import com.wantdo.service.ITimeSaleService;

public class TsProcessedAction extends ActionSupport {
	
	private String[] strArray={"店铺名","平台","时间段","浏览量","访客数","访问次数","下单金额","下单客户数","下单单量","下单商品数","数据日期","操作时间"};
	
	private String startTime;
	private String endTime;
	private Map<String, List<TimeSale>> timeSaleMap;
	private ITimeSaleService timeSaleService;
	
	

	public TsProcessedAction() {
		super();
		// TODO Auto-generated constructor stub
		timeSaleMap=new LinkedHashMap<String, List<TimeSale>>();
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
		List<TimeSale> list=timeSaleService.getByOpDate(startBuffer.toString(), endBuffer.toString());
		SimpleDateFormat sdFormat=new SimpleDateFormat("yy-MM-dd");
		boolean isBreak=false;
		if (list!=null) {
			for(int i=0;i<list.size();++i){
				if (i==0) {
					List<TimeSale> cusList=new ArrayList<TimeSale>();
					cusList.add(list.get(0));
					timeSaleMap.put(sdFormat.format(list.get(0).getSaleTime()), cusList);
				}else {
					isBreak=false;
					String operatedate=sdFormat.format(list.get(i).getSaleTime());
					for(Entry<String, List<TimeSale>> entry:timeSaleMap.entrySet()){
						if (operatedate.equals(entry.getKey())) {
							List<TimeSale> cList=entry.getValue();
							cList.add(list.get(i));
							timeSaleMap.put(operatedate, cList);
							isBreak=true;
							break;
						}
					}
					if (isBreak==false) {
						List<TimeSale> cList=new ArrayList<TimeSale>();
						cList.add(list.get(i));
						timeSaleMap.put(operatedate, cList);
					}
				}
			}
//			System.out.println(timeSaleMap);
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

	public Map<String, List<TimeSale>> getTimeSaleMap() {
		return timeSaleMap;
	}

	public void setTimeSaleMap(Map<String, List<TimeSale>> timeSaleMap) {
		this.timeSaleMap = timeSaleMap;
	}

	public ITimeSaleService getTimeSaleService() {
		return timeSaleService;
	}

	public void setTimeSaleService(ITimeSaleService timeSaleService) {
		this.timeSaleService = timeSaleService;
	}


	
	
	
	



}
