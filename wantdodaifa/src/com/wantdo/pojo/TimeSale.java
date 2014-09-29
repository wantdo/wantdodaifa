package com.wantdo.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * TimeSale entity. @author MyEclipse Persistence Tools
 */

public class TimeSale implements java.io.Serializable {

	// Fields

	private Integer id;
	private String times;
	private String pageviews;
	private String visitors;
	private String visits;
	private String sales;
	private String orderClientNum;
	private String orderQuantity;
	private String orderGoodsNum;
	private Date saleTime;
	private Timestamp nowTime;
	private String shopName;
	private String platform;
	private String version;

	// Constructors

	/** default constructor */
	public TimeSale() {
	}

	/** full constructor */
	public TimeSale(String times, String pageviews, String visitors,
			String visits, String sales, String orderClientNum,
			String orderQuantity, String orderGoodsNum, Date saleTime,
			Timestamp nowTime, String shopName, String platform, String version) {
		this.times = times;
		this.pageviews = pageviews;
		this.visitors = visitors;
		this.visits = visits;
		this.sales = sales;
		this.orderClientNum = orderClientNum;
		this.orderQuantity = orderQuantity;
		this.orderGoodsNum = orderGoodsNum;
		this.saleTime = saleTime;
		this.nowTime = nowTime;
		this.shopName = shopName;
		this.platform = platform;
		this.version = version;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTimes() {
		return this.times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getPageviews() {
		return this.pageviews;
	}

	public void setPageviews(String pageviews) {
		this.pageviews = pageviews;
	}

	public String getVisitors() {
		return this.visitors;
	}

	public void setVisitors(String visitors) {
		this.visitors = visitors;
	}

	public String getVisits() {
		return this.visits;
	}

	public void setVisits(String visits) {
		this.visits = visits;
	}

	public String getSales() {
		return this.sales;
	}

	public void setSales(String sales) {
		this.sales = sales;
	}

	public String getOrderClientNum() {
		return this.orderClientNum;
	}

	public void setOrderClientNum(String orderClientNum) {
		this.orderClientNum = orderClientNum;
	}

	public String getOrderQuantity() {
		return this.orderQuantity;
	}

	public void setOrderQuantity(String orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getOrderGoodsNum() {
		return this.orderGoodsNum;
	}

	public void setOrderGoodsNum(String orderGoodsNum) {
		this.orderGoodsNum = orderGoodsNum;
	}

	public Date getSaleTime() {
		return this.saleTime;
	}

	public void setSaleTime(Date saleTime) {
		this.saleTime = saleTime;
	}

	public Timestamp getNowTime() {
		return this.nowTime;
	}

	public void setNowTime(Timestamp nowTime) {
		this.nowTime = nowTime;
	}

	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getPlatform() {
		return this.platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}