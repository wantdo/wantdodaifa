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
import com.wantdo.pojo.Goods;
import com.wantdo.pojo.Sale;
import com.wantdo.pojo.SaleDay;
import com.wantdo.service.IGoodsService;
import com.wantdo.service.ISaleService;
import com.wantdo.utils.ExcelUtil;

public class GDownloadAction extends ActionSupport {
	
	private static String[] excelHeader={
		"序号","店铺名称","平台","上架商品数(SPU)","上架商品数(SKU)","数据日期","操作时间"
	};
	private String startTime;
	private String endTime;
	private Map<String, List<Goods>> goodsMap;
	private IGoodsService goodsService;
	private List<String[]> glist=new ArrayList<String[]>();
	

	public GDownloadAction() {
		super();
		// TODO Auto-generated constructor stub
		goodsMap=new LinkedHashMap<String, List<Goods>>();
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
		}
	
		int index=1;
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		for(Entry<String, List<Goods>> entry:goodsMap.entrySet()){
			List<Goods> goodsList=entry.getValue();
			String[] strArr=null;
			for(int i=0;i<goodsList.size();i++){
				if (i==0) {
					strArr=new String[]{
						String.valueOf(index),goodsList.get(0).getShopName(),
						goodsList.get(0).getPlatform(),goodsList.get(0).getSpu(),
						goodsList.get(0).getSku(),sdf1.format(goodsList.get(0).getGoodsTime()),
						sdf2.format(goodsList.get(0).getNowTime())
					};
					++index;
					glist.add(strArr);
				}else {
					strArr=new String[]{
							String.valueOf(index),goodsList.get(i).getShopName(),
							goodsList.get(i).getPlatform(),goodsList.get(i).getSpu(),
							goodsList.get(i).getSku(),sdf1.format(goodsList.get(i).getGoodsTime()),
							sdf2.format(goodsList.get(i).getNowTime())
						};
					++index;
					glist.add(strArr);
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
		excelUtil.writeExpExcel(glist, excelHeader, excelFile);
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
		GDownloadAction.excelHeader = excelHeader;
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

	public List<String[]> getGlist() {
		return glist;
	}

	public void setGlist(List<String[]> glist) {
		this.glist = glist;
	}


}
