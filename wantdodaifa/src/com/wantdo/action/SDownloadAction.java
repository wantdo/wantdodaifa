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
import com.wantdo.pojo.Sale;
import com.wantdo.service.ISaleService;
import com.wantdo.utils.ExcelUtil;

public class SDownloadAction extends ActionSupport {
	
	private static String[] excelHeader={
		"序号","店铺名称","平台","销售额","下单数量","下单商品数","下单客户数","客单价","数据日期","操作时间"
	};
	private String startTime;
	private String endTime;
	private Map<String, List<Sale>> saleMap;
	private ISaleService saleService;
	private List<String[]> list=new ArrayList<String[]>();
	

	public SDownloadAction() {
		super();
		// TODO Auto-generated constructor stub
		saleMap=new LinkedHashMap<String, List<Sale>>();
	}

	public InputStream getDownloadFile() throws Exception {

		// TODO Auto-generated method stub
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
		List<Sale> salelist=saleService.getByOpDate(startBuffer.toString(), endBuffer.toString());
		SimpleDateFormat sdFormat=new SimpleDateFormat("yy-MM-dd");
		boolean isBreak=false;
		if (salelist!=null) {
			for(int i=0;i<salelist.size();++i){
				if (i==0) {
					List<Sale> cusList=new ArrayList<Sale>();
					cusList.add(salelist.get(0));
					saleMap.put(sdFormat.format(salelist.get(0).getSaleTime()), cusList);
				}else {
					isBreak=false;
					String operatedate=sdFormat.format(salelist.get(i).getSaleTime());
					for(Entry<String, List<Sale>> entry:saleMap.entrySet()){
						if (operatedate.equals(entry.getKey())) {
							List<Sale> cList=entry.getValue();
							cList.add(salelist.get(i));
							saleMap.put(operatedate, cList);
							isBreak=true;
							break;
						}
					}
					if (isBreak==false) {
						List<Sale> cList=new ArrayList<Sale>();
						cList.add(salelist.get(i));
						saleMap.put(operatedate, cList);
					}
				}
			}
		}
	
		int index=1;
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		for(Entry<String, List<Sale>> entry:saleMap.entrySet()){
			List<Sale> saleList=entry.getValue();
			String[] strArr=null;
			for(int i=0;i<saleList.size();i++){
				if (i==0) {
					strArr=new String[]{
						String.valueOf(index),saleList.get(0).getShopName(),
						saleList.get(0).getPlatform(),saleList.get(0).getSales(),
						saleList.get(0).getOrderQuantity(),saleList.get(0).getOrderGoodsNum(),
						saleList.get(0).getOrderClientNum(),saleList.get(0).getClientPrice(),
						sdf1.format(saleList.get(0).getSaleTime()),sdf2.format(saleList.get(0).getNowTime())
					};
					++index;
					list.add(strArr);
				}else {
					strArr=new String[]{
							String.valueOf(index),saleList.get(i).getShopName(),
							saleList.get(i).getPlatform(),saleList.get(i).getSales(),
							saleList.get(i).getOrderQuantity(),saleList.get(i).getOrderGoodsNum(),
							saleList.get(i).getOrderClientNum(),saleList.get(i).getClientPrice(),
							sdf1.format(saleList.get(i).getSaleTime()),sdf2.format(saleList.get(i).getNowTime())
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


	public ISaleService getSaleService() {
		return saleService;
	}

	public void setSaleService(ISaleService saleService) {
		this.saleService = saleService;
	}

	public static String[] getExcelHeader() {
		return excelHeader;
	}

	public static void setExcelHeader(String[] excelHeader) {
		SDownloadAction.excelHeader = excelHeader;
	}


	public Map<String, List<Sale>> getSaleMap() {
		return saleMap;
	}

	public void setSaleMap(Map<String, List<Sale>> saleMap) {
		this.saleMap = saleMap;
	}

	public List<String[]> getList() {
		return list;
	}

	public void setList(List<String[]> list) {
		this.list = list;
	}

}
