package com.wantdo.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.opensymphony.xwork2.ActionSupport;
import com.wantdo.pojo.FlowSource;
import com.wantdo.service.IFlowSourceService;

public class FsProcessedAction extends ActionSupport {
	
	private String[] strArray={"店铺名","平台","流量来源","到达页浏览量","到达页浏览量占比","浏览量","浏览量占比","数据日期","操作时间","备注"};
	
	private String startTime;
	private String endTime;
	private Map<String, List<FlowSource>> flowSourceMap;
	private IFlowSourceService flowSourceService;
	
	

	public FsProcessedAction() {
		super();
		// TODO Auto-generated constructor stub
		flowSourceMap=new LinkedHashMap<String, List<FlowSource>>();
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
		List<FlowSource> list=flowSourceService.getByOpDate(startBuffer.toString(), endBuffer.toString());
		SimpleDateFormat sdFormat=new SimpleDateFormat("yy-MM-dd");
		boolean isBreak=false;
		if (list!=null) {
			for(int i=0;i<list.size();++i){
				if (i==0) {
					List<FlowSource> cusList=new ArrayList<FlowSource>();
					cusList.add(list.get(0));
					flowSourceMap.put(sdFormat.format(list.get(0).getFlowSourceTime()), cusList);
				}else {
					isBreak=false;
					String operatedate=sdFormat.format(list.get(i).getFlowSourceTime());
					for(Entry<String, List<FlowSource>> entry:flowSourceMap.entrySet()){
						if (operatedate.equals(entry.getKey())) {
							List<FlowSource> cList=entry.getValue();
							cList.add(list.get(i));
							flowSourceMap.put(operatedate, cList);
							isBreak=true;
							break;
						}
					}
					if (isBreak==false) {
						List<FlowSource> cList=new ArrayList<FlowSource>();
						cList.add(list.get(i));
						flowSourceMap.put(operatedate, cList);
					}
				}
			}
//			System.out.println(flowSourceMap);
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


	public Map<String, List<FlowSource>> getFlowSourceMap() {
		return flowSourceMap;
	}

	public void setFlowSourceMap(Map<String, List<FlowSource>> flowSourceMap) {
		this.flowSourceMap = flowSourceMap;
	}

	public IFlowSourceService getFlowSourceService() {
		return flowSourceService;
	}

	public void setFlowSourceService(IFlowSourceService flowSourceService) {
		this.flowSourceService = flowSourceService;
	}

	
	
	
	



}
