package com.wantdo.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Sale entity. @author MyEclipse Persistence Tools
 */

public class SaleDay implements java.io.Serializable {

	// Fields

	private String saleTime;
	private String shopName;
	private String sales;
	private String clientPrice;
	private String shopDealRate;
	private String shopNo;
	private String shopmanager;
	private String grossMargin;
	private String returnAmount;
	private String actualDeliveryAmount;
	private String storeFines;

	// Constructors

	/** default constructor */
	public SaleDay() {
	}


	public SaleDay(String saleTime, String shopName, String sales,
			String clientPrice, String shopDealRate, String shopNo,
			String shopmanager, String grossMargin, String returnAmount,
			String actualDeliveryAmount, String storeFines) {
		super();
		this.saleTime = saleTime;
		this.shopName = shopName;
		this.sales = sales;
		this.clientPrice = clientPrice;
		this.shopDealRate = shopDealRate;
		this.shopNo = shopNo;
		this.shopmanager = shopmanager;
		this.grossMargin = grossMargin;
		this.returnAmount = returnAmount;
		this.actualDeliveryAmount = actualDeliveryAmount;
		this.storeFines = storeFines;
	}


	// Property accessors


	public String getSales() {
		return this.sales;
	}

	public void setSales(String sales) {
		this.sales = sales;
	}



	public String getClientPrice() {
		return this.clientPrice;
	}

	public void setClientPrice(String clientPrice) {
		this.clientPrice = clientPrice;
	}

	public String getSaleTime() {
		return this.saleTime;
	}

	public void setSaleTime(String string) {
		this.saleTime = string;
	}


	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}


	public String getShopDealRate() {
		return shopDealRate;
	}

	public void setShopDealRate(String shopDealRate) {
		this.shopDealRate = shopDealRate;
	}


	public String getShopNo() {
		return shopNo;
	}


	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}


	public String getShopmanager() {
		return shopmanager;
	}


	public void setShopmanager(String shopmanager) {
		this.shopmanager = shopmanager;
	}


	public String getGrossMargin() {
		return grossMargin;
	}


	public void setGrossMargin(String grossMargin) {
		this.grossMargin = grossMargin;
	}


	public String getReturnAmount() {
		return returnAmount;
	}


	public void setReturnAmount(String returnAmount) {
		this.returnAmount = returnAmount;
	}


	public String getActualDeliveryAmount() {
		return actualDeliveryAmount;
	}


	public void setActualDeliveryAmount(String actualDeliveryAmount) {
		this.actualDeliveryAmount = actualDeliveryAmount;
	}


	public String getStoreFines() {
		return storeFines;
	}


	public void setStoreFines(String storeFines) {
		this.storeFines = storeFines;
	}

}