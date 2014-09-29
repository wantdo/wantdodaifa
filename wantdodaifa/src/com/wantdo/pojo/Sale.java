package com.wantdo.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Sale entity. @author MyEclipse Persistence Tools
 */

public class Sale implements java.io.Serializable {

	// Fields

	private Integer id;
	private String sales;
	private String orderQuantity;
	private String orderGoodsNum;
	private String orderClientNum;
	private String clientPrice;
	private Date saleTime;
	private Timestamp nowTime;
	private String shopName;
	private String platform;
	private String version;

	// Constructors

	/** default constructor */
	public Sale() {
	}

	/** full constructor */
	public Sale(String sales, String orderQuantity, String orderGoodsNum,
			String orderClientNum, String clientPrice, Date saleTime,
			Timestamp nowTime, String shopName, String platform, String version) {
		this.sales = sales;
		this.orderQuantity = orderQuantity;
		this.orderGoodsNum = orderGoodsNum;
		this.orderClientNum = orderClientNum;
		this.clientPrice = clientPrice;
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

	public String getSales() {
		return this.sales;
	}

	public void setSales(String sales) {
		this.sales = sales;
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

	public String getOrderClientNum() {
		return this.orderClientNum;
	}

	public void setOrderClientNum(String orderClientNum) {
		this.orderClientNum = orderClientNum;
	}

	public String getClientPrice() {
		return this.clientPrice;
	}

	public void setClientPrice(String clientPrice) {
		this.clientPrice = clientPrice;
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