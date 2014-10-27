package com.wantdo.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * HotGoodsRank entity. @author MyEclipse Persistence Tools
 */

public class HotGoodsRank implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer rank;
	private String goodsName;
	private String price;
	private String dealGoodsIndex;
	private String linkChangeRate;
	private String flowSource;
	private Integer pviews;
	private Integer pvisits;
	private String avgVisitNum;
	private String bounceRate;
	private Timestamp captureTime;
	private String goodsUrl;
	private String shopName;
	private Date captureDate;
	private Timestamp date2;
	private String sign;
	private String version;

	// Constructors

	/** default constructor */
	public HotGoodsRank() {
	}

	/** full constructor */
	public HotGoodsRank(Integer rank, String goodsName, String price,
			String dealGoodsIndex, String linkChangeRate, String flowSource,
			Integer pviews, Integer pvisits, String avgVisitNum,
			String bounceRate, Timestamp captureTime, String goodsUrl,
			String shopName, Date captureDate, Timestamp date2, String sign,
			String version) {
		this.rank = rank;
		this.goodsName = goodsName;
		this.price = price;
		this.dealGoodsIndex = dealGoodsIndex;
		this.linkChangeRate = linkChangeRate;
		this.flowSource = flowSource;
		this.pviews = pviews;
		this.pvisits = pvisits;
		this.avgVisitNum = avgVisitNum;
		this.bounceRate = bounceRate;
		this.captureTime = captureTime;
		this.goodsUrl = goodsUrl;
		this.shopName = shopName;
		this.captureDate = captureDate;
		this.date2 = date2;
		this.sign = sign;
		this.version = version;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDealGoodsIndex() {
		return this.dealGoodsIndex;
	}

	public void setDealGoodsIndex(String dealGoodsIndex) {
		this.dealGoodsIndex = dealGoodsIndex;
	}

	public String getLinkChangeRate() {
		return this.linkChangeRate;
	}

	public void setLinkChangeRate(String linkChangeRate) {
		this.linkChangeRate = linkChangeRate;
	}

	public String getFlowSource() {
		return this.flowSource;
	}

	public void setFlowSource(String flowSource) {
		this.flowSource = flowSource;
	}

	public Integer getPviews() {
		return this.pviews;
	}

	public void setPviews(Integer pviews) {
		this.pviews = pviews;
	}

	public Integer getPvisits() {
		return this.pvisits;
	}

	public void setPvisits(Integer pvisits) {
		this.pvisits = pvisits;
	}

	public String getAvgVisitNum() {
		return this.avgVisitNum;
	}

	public void setAvgVisitNum(String avgVisitNum) {
		this.avgVisitNum = avgVisitNum;
	}

	public String getBounceRate() {
		return this.bounceRate;
	}

	public void setBounceRate(String bounceRate) {
		this.bounceRate = bounceRate;
	}

	public Timestamp getCaptureTime() {
		return this.captureTime;
	}

	public void setCaptureTime(Timestamp captureTime) {
		this.captureTime = captureTime;
	}

	public String getGoodsUrl() {
		return this.goodsUrl;
	}

	public void setGoodsUrl(String goodsUrl) {
		this.goodsUrl = goodsUrl;
	}

	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Date getCaptureDate() {
		return this.captureDate;
	}

	public void setCaptureDate(Date captureDate) {
		this.captureDate = captureDate;
	}

	public Timestamp getDate2() {
		return this.date2;
	}

	public void setDate2(Timestamp date2) {
		this.date2 = date2;
	}

	public String getSign() {
		return this.sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}