package com.wantdo.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.opensymphony.xwork2.ActionSupport;
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
		List<Sale> list=saleService.getByOpDate(startBuffer.toString(), endBuffer.toString());
		SimpleDateFormat sdFormat=new SimpleDateFormat("yy-MM-dd");
		boolean isBreak=false;
		if (list!=null) {
			for(int i=0;i<list.size();++i){
				if (i==0) {
					List<Sale> cusList=new ArrayList<Sale>();
					cusList.add(list.get(0));
					saleMap.put(sdFormat.format(list.get(0).getSaleTime()), cusList);
				}else {
					isBreak=false;
					String operatedate=sdFormat.format(list.get(i).getSaleTime());
					for(Entry<String, List<Sale>> entry:saleMap.entrySet()){
						if (operatedate.equals(entry.getKey())) {
							List<Sale> cList=entry.getValue();
							cList.add(list.get(i));
							saleMap.put(operatedate, cList);
							isBreak=true;
							break;
						}
					}
					if (isBreak==false) {
						List<Sale> cList=new ArrayList<Sale>();
						cList.add(list.get(i));
						saleMap.put(operatedate, cList);
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
