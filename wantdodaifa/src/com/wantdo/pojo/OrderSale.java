package com.wantdo.pojo;

import java.util.Date;

/**
 * OrderSale entity. @author MyEclipse Persistence Tools
 */

public class OrderSale implements java.io.Serializable {

	// Fields

	private Integer id;
	private String sales;
	private String shopName;
	private Date saleTime;
	private String clientName;
	private String goodsNum;
	private String orderNo;
	private String version;
	private String platform;

	// Constructors

	/** default constructor */
	public OrderSale() {
	}

	/** full constructor */
	public OrderSale(String sales, String shopName, Date saleTime,
			String clientName, String goodsNum, String orderNo,String version,String platform) {
		this.sales = sales;
		this.shopName = shopName;
		this.saleTime = saleTime;
		this.clientName = clientName;
		this.goodsNum = goodsNum;
		this.orderNo = orderNo;
		this.version = version;
		this.platform = platform;
	}

	// Property accessors

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

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

	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Date getSaleTime() {
		return this.saleTime;
	}

	public void setSaleTime(Date saleTime) {
		this.saleTime = saleTime;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getGoodsNum() {
		return this.goodsNum;
	}

	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}