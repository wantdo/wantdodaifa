package com.wantdo.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */

public class Goods implements java.io.Serializable {

	// Fields

	private Integer id;
	private String spu;
	private String sku;
	private Date goodsTime;
	private Timestamp nowTime;
	private String shopName;
	private String platform;
	private String version;

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** full constructor */
	public Goods(String spu, String sku, Date goodsTime, Timestamp nowTime,
			String shopName, String platform, String version) {
		this.spu = spu;
		this.sku = sku;
		this.goodsTime = goodsTime;
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

	public String getSpu() {
		return this.spu;
	}

	public void setSpu(String spu) {
		this.spu = spu;
	}

	public String getSku() {
		return this.sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Date getGoodsTime() {
		return this.goodsTime;
	}

	public void setGoodsTime(Date goodsTime) {
		this.goodsTime = goodsTime;
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