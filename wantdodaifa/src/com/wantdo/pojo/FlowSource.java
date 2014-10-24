package com.wantdo.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * FlowSource entity. @author MyEclipse Persistence Tools
 */

public class FlowSource implements java.io.Serializable {

	// Fields

	private Integer id;
	private String flowSource;
	private String landPageView;
	private String landPageViewAccounted;
	private String pageView;
	private String pageViewAccounted;
	private Date flowSourceTime;
	private Timestamp nowTime;
	private String shopName;
	private String platform;
	private String version;
	private String remark;

	// Constructors

	/** default constructor */
	public FlowSource() {
	}

	/** full constructor */
	public FlowSource(String flowSource, String landPageView,
			String landPageViewAccounted, String pageView,
			String pageViewAccounted, Date flowSourceTime, Timestamp nowTime,
			String shopName, String platform, String version, String remark) {
		this.flowSource = flowSource;
		this.landPageView = landPageView;
		this.landPageViewAccounted = landPageViewAccounted;
		this.pageView = pageView;
		this.pageViewAccounted = pageViewAccounted;
		this.flowSourceTime = flowSourceTime;
		this.nowTime = nowTime;
		this.shopName = shopName;
		this.platform = platform;
		this.version = version;
		this.remark = remark;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFlowSource() {
		return this.flowSource;
	}

	public void setFlowSource(String flowSource) {
		this.flowSource = flowSource;
	}

	public String getLandPageView() {
		return this.landPageView;
	}

	public void setLandPageView(String landPageView) {
		this.landPageView = landPageView;
	}

	public String getLandPageViewAccounted() {
		return this.landPageViewAccounted;
	}

	public void setLandPageViewAccounted(String landPageViewAccounted) {
		this.landPageViewAccounted = landPageViewAccounted;
	}

	public String getPageView() {
		return this.pageView;
	}

	public void setPageView(String pageView) {
		this.pageView = pageView;
	}

	public String getPageViewAccounted() {
		return this.pageViewAccounted;
	}

	public void setPageViewAccounted(String pageViewAccounted) {
		this.pageViewAccounted = pageViewAccounted;
	}

	public Date getFlowSourceTime() {
		return this.flowSourceTime;
	}

	public void setFlowSourceTime(Date flowSourceTime) {
		this.flowSourceTime = flowSourceTime;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}