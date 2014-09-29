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
import com.wantdo.service.ISaleService;
import com.wantdo.utils.ExcelUtil;

public class SdDownloadAction extends ActionSupport {
	
	private static String[] excelHeader={
		"序号","日期","店铺名称","店铺编号","负责人",
		"销售额","客单价","转化率","毛利率","当日退货金额","当日实际发货金额","当日店铺罚款金额"
	};
	private String startTime;
	private String endTime;
	private Map<String, List<SaleDay>> saleDayMap;
	private ISaleService saleService;
	private SaleDay saleDay;
	private List<String[]> list=new ArrayList<String[]>();
	

	public SdDownloadAction() {
		super();
		// TODO Auto-generated constructor stub
		saleDayMap=new LinkedHashMap<String, List<SaleDay>>();
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
		List<Object[]> saleDaylist=saleService.getByOpDayDate(startBuffer.toString(), endBuffer.toString());
		SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd");
		boolean isBreak=false;
		if (saleDaylist.size()>0) {
			for(int i=0;i<saleDaylist.size();++i){
				Sale sale=(Sale)saleDaylist.get(i)[0];
				Flow flow=(Flow)saleDaylist.get(i)[1];
				saleDay = new SaleDay();
				if(sale.getShopName().equals(flow.getShopName()) && sale.getSaleTime().equals(flow.getFlowTime())){
					saleDay.setSaleTime(sdFormat.format(sale.getSaleTime()));
					saleDay.setSales(sale.getSales());
					saleDay.setShopDealRate(flow.getShopDealRate());
					saleDay.setClientPrice(sale.getClientPrice());
					saleDay.setShopName(sale.getShopName());
				}
				if (i==0) {
					List<SaleDay> cusList=new ArrayList<SaleDay>();
					cusList.add( saleDay);
					saleDayMap.put("sale", cusList);
				}else {
					isBreak=false;
					String operatedate=saleDay.getSaleTime();
					for(Entry<String, List<SaleDay>> entry:saleDayMap.entrySet()){
						if (operatedate.equals(entry.getKey())) {
							List<SaleDay> cList=entry.getValue();
							cList.add(saleDay);
							saleDayMap.put(operatedate, cList);
							isBreak=true;
							break;
						}
					}
					if (isBreak==false) {
						List<SaleDay> cList=new ArrayList<SaleDay>();
						cList.add(saleDay);
						saleDayMap.put(operatedate, cList);
					}
				}
			}
		}
		int index=1;
		for(Entry<String, List<SaleDay>> entry:saleDayMap.entrySet()){
			List<SaleDay> saleDayList=entry.getValue();
			String[] strArr=null;
			for(int i=0;i<saleDayList.size();i++){
				if (i==0) {
					strArr=new String[]{
						String.valueOf(index),saleDayList.get(0).getSaleTime(),saleDayList.get(0).getShopName(),
						saleDayList.get(0).getShopNo(),saleDayList.get(0).getShopmanager(),
						saleDayList.get(0).getSales(),saleDayList.get(0).getClientPrice(),
						saleDayList.get(0).getShopDealRate(),saleDayList.get(0).getGrossMargin(),
						saleDayList.get(0).getReturnAmount(),saleDayList.get(0).getActualDeliveryAmount(),
						saleDayList.get(0).getStoreFines()
					};
					++index;
					list.add(strArr);
				}else {
					strArr=new String[]{
							String.valueOf(index),saleDayList.get(i).getSaleTime(),saleDayList.get(i).getShopName(),
							saleDayList.get(i).getShopNo(),saleDayList.get(i).getShopmanager(),
							saleDayList.get(i).getSales(),saleDayList.get(i).getClientPrice(),
							saleDayList.get(i).getShopDealRate(),saleDayList.get(i).getGrossMargin(),
							saleDayList.get(i).getReturnAmount(),saleDayList.get(i).getActualDeliveryAmount(),
							saleDayList.get(i).getStoreFines()
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


	public Map<String, List<SaleDay>> getSaleDayMap() {
		return saleDayMap;
	}

	public void setSaleDayMap(Map<String, List<SaleDay>> saleDayMap) {
		this.saleDayMap = saleDayMap;
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
		SdDownloadAction.excelHeader = excelHeader;
	}

	public SaleDay getSaleDay() {
		return saleDay;
	}

	public void setSaleDay(SaleDay saleDay) {
		this.saleDay = saleDay;
	}

	public List<String[]> getList() {
		return list;
	}

	public void setList(List<String[]> list) {
		this.list = list;
	}

}
