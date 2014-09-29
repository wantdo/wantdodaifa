package com.wantdo.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.opensymphony.xwork2.ActionSupport;
import com.wantdo.pojo.FlowSource;
import com.wantdo.pojo.Goods;
import com.wantdo.service.IFlowSourceService;
import com.wantdo.service.IGoodsService;

public class GProcessedAction extends ActionSupport {
	
	private String[] strArray={"店铺名","平台","流量来源","到达页浏览量","到达页浏览量占比","浏览量","浏览量占比","数据日期","操作时间"};
	
	private String startTime;
	private String endTime;
	private Map<String, List<Goods>> goodsMap;
	private IGoodsService goodsService;
	
	

	public GProcessedAction() {
		super();
		// TODO Auto-generated constructor stub
		goodsMap=new LinkedHashMap<String, List<Goods>>();
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
		List<Goods> list=goodsService.getByOpDate(startBuffer.toString(), endBuffer.toString());
		SimpleDateFormat sdFormat=new SimpleDateFormat("yy-MM-dd");
		boolean isBreak=false;
		if (list!=null) {
			for(int i=0;i<list.size();++i){
				if (i==0) {
					List<Goods> cusList=new ArrayList<Goods>();
					cusList.add(list.get(0));
					goodsMap.put(sdFormat.format(list.get(0).getGoodsTime()), cusList);
				}else {
					isBreak=false;
					String operatedate=sdFormat.format(list.get(i).getGoodsTime());
					for(Entry<String, List<Goods>> entry:goodsMap.entrySet()){
						if (operatedate.equals(entry.getKey())) {
							List<Goods> cList=entry.getValue();
							cList.add(list.get(i));
							goodsMap.put(operatedate, cList);
							isBreak=true;
							break;
						}
					}
					if (isBreak==false) {
						List<Goods> cList=new ArrayList<Goods>();
						cList.add(list.get(i));
						goodsMap.put(operatedate, cList);
					}
				}
			}
//			System.out.println(goodsMap);
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

	public Map<String, List<Goods>> getGoodsMap() {
		return goodsMap;
	}

	public void setGoodsMap(Map<String, List<Goods>> goodsMap) {
		this.goodsMap = goodsMap;
	}

	public IGoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(IGoodsService goodsService) {
		this.goodsService = goodsService;
	}




}
