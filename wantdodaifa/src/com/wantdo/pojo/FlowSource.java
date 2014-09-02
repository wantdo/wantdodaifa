package com.wantdo.pojo;

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
	private String flowSourceTime;
	private String nowTime;
	private String shopName;
	private String platform;

	// Constructors

	/** default constructor */
	public FlowSource() {
	}

	/** full constructor */
	public FlowSource(String flowSource, String landPageView,
			String landPageViewAccounted, String pageView,
			String pageViewAccounted, String flowSourceTime, String nowTime,
			String shopName, String platform) {
		this.flowSource = flowSource;
		this.landPageView = landPageView;
		this.landPageViewAccounted = landPageViewAccounted;
		this.pageView = pageView;
		this.pageViewAccounted = pageViewAccounted;
		this.flowSourceTime = flowSourceTime;
		this.nowTime = nowTime;
		this.shopName = shopName;
		this.platform = platform;
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

	public String getFlowSourceTime() {
		return this.flowSourceTime;
	}

	public void setFlowSourceTime(String flowSourceTime) {
		this.flowSourceTime = flowSourceTime;
	}

	public String getNowTime() {
		return this.nowTime;
	}

	public void setNowTime(String nowTime) {
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

}