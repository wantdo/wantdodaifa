package com.wantdo.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Flow entity. @author MyEclipse Persistence Tools
 */

public class Flow implements java.io.Serializable {

	// Fields

	private Integer id;
	private String pageviews;
	private String visitors;
	private String visits;
	private String avgVisitDepth;
	private String avgPaceTime;
	private String bounceRate;
	private String backVisitorsRate;
	private String goodsVolume;
	private String shopVolume;
	private String shopDealRate;
	private String firstPaymentRate;
	private String thirtyCustomerRetention;
	private String thirtyRepeatPurchaseRate;
	private Date flowTime;
	private Timestamp nowTime;
	private String shopName;
	private String platform;
	private String version;

	// Constructors

	/** default constructor */
	public Flow() {
	}

	/** full constructor */
	public Flow(String pageviews, String visitors, String visits,
			String avgVisitDepth, String avgPaceTime, String bounceRate,
			String backVisitorsRate, String goodsVolume, String shopVolume,
			String shopDealRate, String firstPaymentRate,
			String thirtyCustomerRetention, String thirtyRepeatPurchaseRate,
			Date flowTime, Timestamp nowTime, String shopName, String platform,
			String version) {
		this.pageviews = pageviews;
		this.visitors = visitors;
		this.visits = visits;
		this.avgVisitDepth = avgVisitDepth;
		this.avgPaceTime = avgPaceTime;
		this.bounceRate = bounceRate;
		this.backVisitorsRate = backVisitorsRate;
		this.goodsVolume = goodsVolume;
		this.shopVolume = shopVolume;
		this.shopDealRate = shopDealRate;
		this.firstPaymentRate = firstPaymentRate;
		this.thirtyCustomerRetention = thirtyCustomerRetention;
		this.thirtyRepeatPurchaseRate = thirtyRepeatPurchaseRate;
		this.flowTime = flowTime;
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

	public String getAvgVisitDepth() {
		return this.avgVisitDepth;
	}

	public void setAvgVisitDepth(String avgVisitDepth) {
		this.avgVisitDepth = avgVisitDepth;
	}

	public String getAvgPaceTime() {
		return this.avgPaceTime;
	}

	public void setAvgPaceTime(String avgPaceTime) {
		this.avgPaceTime = avgPaceTime;
	}

	public String getBounceRate() {
		return this.bounceRate;
	}

	public void setBounceRate(String bounceRate) {
		this.bounceRate = bounceRate;
	}

	public String getBackVisitorsRate() {
		return this.backVisitorsRate;
	}

	public void setBackVisitorsRate(String backVisitorsRate) {
		this.backVisitorsRate = backVisitorsRate;
	}

	public String getGoodsVolume() {
		return this.goodsVolume;
	}

	public void setGoodsVolume(String goodsVolume) {
		this.goodsVolume = goodsVolume;
	}

	public String getShopVolume() {
		return this.shopVolume;
	}

	public void setShopVolume(String shopVolume) {
		this.shopVolume = shopVolume;
	}

	public String getShopDealRate() {
		return this.shopDealRate;
	}

	public void setShopDealRate(String shopDealRate) {
		this.shopDealRate = shopDealRate;
	}

	public String getFirstPaymentRate() {
		return this.firstPaymentRate;
	}

	public void setFirstPaymentRate(String firstPaymentRate) {
		this.firstPaymentRate = firstPaymentRate;
	}

	public String getThirtyCustomerRetention() {
		return this.thirtyCustomerRetention;
	}

	public void setThirtyCustomerRetention(String thirtyCustomerRetention) {
		this.thirtyCustomerRetention = thirtyCustomerRetention;
	}

	public String getThirtyRepeatPurchaseRate() {
		return this.thirtyRepeatPurchaseRate;
	}

	public void setThirtyRepeatPurchaseRate(String thirtyRepeatPurchaseRate) {
		this.thirtyRepeatPurchaseRate = thirtyRepeatPurchaseRate;
	}

	public Date getFlowTime() {
		return this.flowTime;
	}

	public void setFlowTime(Date flowTime) {
		this.flowTime = flowTime;
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