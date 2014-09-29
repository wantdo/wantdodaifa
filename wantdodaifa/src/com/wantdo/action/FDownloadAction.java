package com.wantdo.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wantdo.pojo.Flow;
import com.wantdo.pojo.Sale;
import com.wantdo.pojo.SaleDay;
import com.wantdo.service.IFlowService;
import com.wantdo.service.ISaleService;
import com.wantdo.utils.ExcelUtil;

public class FDownloadAction extends ActionSupport {
	
	private static String[] excelHeader={
		"序号","店铺名称","平台","商品关注量","店铺关注量","店铺成交转化率","先款付款率",
		"30日客户回头率","30日重复购买率","浏览量","访客数","平均访问深度","平均停留时间","跳失率",
		"回访客占比","数据日期","操作时间"
	};
	private String startTime;
	private String endTime;
	private Map<String, List<Flow>> flowMap;
	private IFlowService flowService;
	private List<String[]> list=new ArrayList<String[]>();
	

	public FDownloadAction() {
		super();
		// TODO Auto-generated constructor stub
		flowMap=new LinkedHashMap<String, List<Flow>>();
	}

	public InputStream getDownloadFile() throws Exception {

		StringBuffer startBuffer;
		StringBuffer endBuffer;
		if(startTime.length() == 8){
			startTime = startTime.substring(2, startTime.length());
			startBuffer=new StringBuffer(startTime);
			startBuffer.insert(2, "-");
			startBuffer.insert(5, "-");
			endTime = endTime.substring(2, endTime.length());
			endBuffer=new StringBuffer(endTime);
			endBuffer.insert(2, "-");
			endBuffer.insert(5, "-");
		}else{
			startBuffer=new StringBuffer(startTime);
			startBuffer.insert(2, "-");
			startBuffer.insert(5, "-");
			endBuffer=new StringBuffer(endTime);
			endBuffer.insert(2, "-");
			endBuffer.insert(5, "-");
		}
		List<Flow> flowlist=flowService.getByOpDate(startBuffer.toString(), endBuffer.toString());
		SimpleDateFormat sdFormat=new SimpleDateFormat("yy-MM-dd");
		boolean isBreak=false;
		if (flowlist!=null) {
			for(int i=0;i<flowlist.size();++i){
				if (i==0) {
					List<Flow> cusList=new ArrayList<Flow>();
					cusList.add(flowlist.get(0));
					flowMap.put(sdFormat.format(flowlist.get(0).getFlowTime()), cusList);
				}else {
					isBreak=false;
					String operatedate=sdFormat.format(flowlist.get(i).getFlowTime());
					for(Entry<String, List<Flow>> entry:flowMap.entrySet()){
						if (operatedate.equals(entry.getKey())) {
							List<Flow> cList=entry.getValue();
							cList.add(flowlist.get(i));
							flowMap.put(operatedate, cList);
							isBreak=true;
							break;
						}
					}
					if (isBreak==false) {
						List<Flow> cList=new ArrayList<Flow>();
						cList.add(flowlist.get(i));
						flowMap.put(operatedate, cList);
					}
				}
			}
		}
		int index=1;
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		for(Entry<String, List<Flow>> entry:flowMap.entrySet()){
			List<Flow> flowList=entry.getValue();
			String[] strArr=null;
			for(int i=0;i<flowList.size();i++){
				if (i==0) {
					strArr=new String[]{
						String.valueOf(index),flowList.get(0).getShopName(),
						flowList.get(0).getPlatform(),flowList.get(0).getGoodsVolume(),
						flowList.get(0).getShopVolume(),
						flowList.get(0).getShopDealRate(),flowList.get(0).getFirstPaymentRate(),
						flowList.get(0).getThirtyCustomerRetention(),flowList.get(0).getThirtyRepeatPurchaseRate(),
						flowList.get(0).getPageviews(),flowList.get(0).getVisitors(),
						flowList.get(0).getAvgVisitDepth(),flowList.get(0).getAvgPaceTime(),
						flowList.get(0).getBounceRate(),flowList.get(0).getBackVisitorsRate(),
						sdf1.format(flowList.get(0).getFlowTime()),sdf2.format(flowList.get(0).getNowTime())
					};
					++index;
					list.add(strArr);
				}else {
					strArr=new String[]{
							String.valueOf(index),flowList.get(i).getShopName(),
							flowList.get(i).getPlatform(),flowList.get(i).getGoodsVolume(),
							flowList.get(i).getShopVolume(),flowList.get(i).getVisits(),
							flowList.get(i).getShopDealRate(),flowList.get(i).getFirstPaymentRate(),
							flowList.get(i).getThirtyCustomerRetention(),flowList.get(i).getThirtyRepeatPurchaseRate(),
							flowList.get(i).getPageviews(),
							flowList.get(i).getAvgVisitDepth(),flowList.get(i).getAvgPaceTime(),
							flowList.get(i).getBounceRate(),flowList.get(i).getBackVisitorsRate(),
							sdf1.format(flowList.get(i).getFlowTime()),sdf2.format(flowList.get(i).getNowTime())
						};
					++index;
					list.add(strArr);
				}
			}
		}
		//保存信息到Excel文件，路径为\download\customer.xls
		String downloadDir=ServletActionContext.getServletContext().getRealPath("download");
		if (!(new File(downloadDir).isDirectory())) {
			new File(downloadDir).mkdirs();
			downloadDir=ServletActionContext.getServletContext().getRealPath("download");
		}
		File excelFile=new File(downloadDir+File.separator+"customer.xls");
		try {
			if (!excelFile.exists()) {
				excelFile.createNewFile();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		ExcelUtil excelUtil=new ExcelUtil();
		excelUtil.writeExpExcel(list, excelHeader, excelFile);
		return new FileInputStream(downloadDir+File.separator+"customer.xls");
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



	public static String[] getExcelHeader() {
		return excelHeader;
	}

	public static void setExcelHeader(String[] excelHeader) {
		FDownloadAction.excelHeader = excelHeader;
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

	public List<String[]> getList() {
		return list;
	}

	public void setList(List<String[]> list) {
		this.list = list;
	}

}
