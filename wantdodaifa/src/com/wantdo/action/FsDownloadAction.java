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
import com.wantdo.pojo.FlowSource;
import com.wantdo.pojo.Sale;
import com.wantdo.pojo.SaleDay;
import com.wantdo.service.IFlowSourceService;
import com.wantdo.service.ISaleService;
import com.wantdo.utils.ExcelUtil;

public class FsDownloadAction extends ActionSupport {
	
	private static String[] excelHeader={
		"序号","店铺名称","平台","流量来源","到达页浏览量","到达页浏览量占比","浏览量","浏览量占比","数据日期","操作时间","备注"
	};
	private String startTime;
	private String endTime;
	private Map<String, List<FlowSource>> flowSourceMap;
	private IFlowSourceService flowSourceService;
	private List<String[]> fslist=new ArrayList<String[]>();
	

	public FsDownloadAction() {
		super();
		// TODO Auto-generated constructor stub
		flowSourceMap=new LinkedHashMap<String, List<FlowSource>>();
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
		}
		int index=1;
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		for(Entry<String, List<FlowSource>> entry:flowSourceMap.entrySet()){
			List<FlowSource> flowSourceList=entry.getValue();
			String[] strArr=null;
			for(int i=0;i<flowSourceList.size();i++){
				if (i==0) {
					strArr=new String[]{
						String.valueOf(index),flowSourceList.get(0).getShopName(),
						flowSourceList.get(0).getPlatform(),flowSourceList.get(0).getFlowSource(),
						flowSourceList.get(0).getLandPageView(),flowSourceList.get(0).getLandPageViewAccounted(),
						flowSourceList.get(0).getPageView(),flowSourceList.get(0).getPageViewAccounted(),
						sdf1.format(flowSourceList.get(0).getFlowSourceTime()),sdf2.format(flowSourceList.get(0).getNowTime()),
						flowSourceList.get(0).getRemark()
					};
					++index;
					fslist.add(strArr);
				}else {
					strArr=new String[]{
							String.valueOf(index),flowSourceList.get(i).getShopName(),
							flowSourceList.get(i).getPlatform(),flowSourceList.get(i).getFlowSource(),
							flowSourceList.get(i).getLandPageView(),flowSourceList.get(i).getLandPageViewAccounted(),
							flowSourceList.get(i).getPageView(),flowSourceList.get(i).getPageViewAccounted(),
							sdf1.format(flowSourceList.get(i).getFlowSourceTime()),sdf2.format(flowSourceList.get(i).getNowTime()),
							flowSourceList.get(i).getRemark()
						};
					++index;
					fslist.add(strArr);
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
		excelUtil.writeExpExcel(fslist, excelHeader, excelFile);
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
		FsDownloadAction.excelHeader = excelHeader;
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

	public List<String[]> getFslist() {
		return fslist;
	}

	public void setFslist(List<String[]> fslist) {
		this.fslist = fslist;
	}


}
