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
import com.wantdo.pojo.TimeSale;
import com.wantdo.service.ISaleService;
import com.wantdo.service.ITimeSaleService;
import com.wantdo.utils.ExcelUtil;

public class TsDownloadAction extends ActionSupport {
	
	private static String[] excelHeader={
		"序号","店铺名","平台","时间段","浏览量","访客数","下单金额","下单客户数",
		"下单单量","下单商品数","数据日期","操作时间"
	};
	private String startTime;
	private String endTime;
	private Map<String, List<TimeSale>> timeSaleMap;
	private ITimeSaleService timeSaleService;
	private List<String[]> tslist=new ArrayList<String[]>();
	

	public TsDownloadAction() {
		super();
		// TODO Auto-generated constructor stub
		timeSaleMap=new LinkedHashMap<String, List<TimeSale>>();
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
		}
	
		int index=1;
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		for(Entry<String, List<TimeSale>> entry:timeSaleMap.entrySet()){
			List<TimeSale> timeSaleList=entry.getValue();
			String[] strArr=null;
			for(int i=0;i<timeSaleList.size();i++){
				if (i==0) {
					strArr=new String[]{
						String.valueOf(index),timeSaleList.get(0).getShopName(),
						timeSaleList.get(0).getPlatform(),timeSaleList.get(0).getTimes(),
						timeSaleList.get(0).getPageviews(),timeSaleList.get(0).getVisitors(),
						timeSaleList.get(0).getSales(),
						timeSaleList.get(0).getOrderClientNum(),timeSaleList.get(0).getOrderQuantity(),
						timeSaleList.get(0).getOrderGoodsNum(),sdf1.format(timeSaleList.get(0).getSaleTime()),
						sdf2.format(timeSaleList.get(0).getNowTime())
					};
					++index;
					tslist.add(strArr);
				}else {
					strArr=new String[]{
							String.valueOf(index),timeSaleList.get(i).getShopName(),
							timeSaleList.get(i).getPlatform(),timeSaleList.get(i).getTimes(),
							timeSaleList.get(i).getPageviews(),timeSaleList.get(i).getVisitors(),
							timeSaleList.get(i).getSales(),
							timeSaleList.get(i).getOrderClientNum(),timeSaleList.get(i).getOrderQuantity(),
							timeSaleList.get(i).getOrderGoodsNum(),sdf1.format(timeSaleList.get(i).getSaleTime()),
							sdf2.format(timeSaleList.get(i).getNowTime())
						};
					++index;
					tslist.add(strArr);
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
		excelUtil.writeExpExcel(tslist, excelHeader, excelFile);
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

	public List<String[]> getTslist() {
		return tslist;
	}

	public void setTslist(List<String[]> tslist) {
		this.tslist = tslist;
	}

	public static String[] getExcelHeader() {
		return excelHeader;
	}

	public static void setExcelHeader(String[] excelHeader) {
		TsDownloadAction.excelHeader = excelHeader;
	}


}
