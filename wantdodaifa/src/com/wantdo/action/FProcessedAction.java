package com.wantdo.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.opensymphony.xwork2.ActionSupport;
import com.wantdo.pojo.Flow;
import com.wantdo.pojo.FlowSource;
import com.wantdo.service.IFlowService;
import com.wantdo.service.IFlowSourceService;

public class FProcessedAction extends ActionSupport {
	
	private String[] strArray={"店铺名","平台","流量来源","到达页浏览量","到达页浏览量占比","浏览量","浏览量占比","数据日期","操作时间"};
	
	private String startTime;
	private String endTime;
	private Map<String, List<Flow>> flowMap;
	private IFlowService flowService;
	
	

	public FProcessedAction() {
		super();
		// TODO Auto-generated constructor stub
		flowMap=new LinkedHashMap<String, List<Flow>>();
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
		List<Flow> list=flowService.getByOpDate(startBuffer.toString(), endBuffer.toString());
		SimpleDateFormat sdFormat=new SimpleDateFormat("yy-MM-dd");
		boolean isBreak=false;
		if (list!=null) {
			for(int i=0;i<list.size();++i){
				if (i==0) {
					List<Flow> cusList=new ArrayList<Flow>();
					cusList.add(list.get(0));
					flowMap.put(sdFormat.format(list.get(0).getFlowTime()), cusList);
				}else {
					isBreak=false;
					String operatedate=sdFormat.format(list.get(i).getFlowTime());
					for(Entry<String, List<Flow>> entry:flowMap.entrySet()){
						if (operatedate.equals(entry.getKey())) {
							List<Flow> cList=entry.getValue();
							cList.add(list.get(i));
							flowMap.put(operatedate, cList);
							isBreak=true;
							break;
						}
					}
					if (isBreak==false) {
						List<Flow> cList=new ArrayList<Flow>();
						cList.add(list.get(i));
						flowMap.put(operatedate, cList);
					}
				}
			}
//			System.out.println(flowMap);
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

	public Map<String, List<Flow>> getFlowMap() {
		return flowMap;
	}

	public void setFlowMap(Map<String, List<Flow>> flowMap) {
		this.flowMap = flowMap;
	}

	public IFlowService getFlowService() {
		return flowService;
	}

	public void setFlowService(IFlowService flowService) {
		this.flowService = flowService;
	}


	

	
	
	
	



}
