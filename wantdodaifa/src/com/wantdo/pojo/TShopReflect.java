package com.wantdo.pojo;

/**
 * TShopReflect entity. @author MyEclipse Persistence Tools
 */

public class TShopReflect implements java.io.Serializable {

	// Fields

	private Integer id;
	private String shopId;
	private String shopNo;
	private String shopNameCapture;
	private String shopName;
	private String text1;
	private String text2;
	private String text3;

	// Constructors

	/** default constructor */
	public TShopReflect() {
	}

	/** full constructor */
	public TShopReflect(String shopId, String shopNo, String shopNameCapture,
			String shopName, String text1, String text2, String text3) {
		this.shopId = shopId;
		this.shopNo = shopNo;
		this.shopNameCapture = shopNameCapture;
		this.shopName = shopName;
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShopId() {
		return this.shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getShopNo() {
		return this.shopNo;
	}

	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	public String getShopNameCapture() {
		return this.shopNameCapture;
	}

	public void setShopNameCapture(String shopNameCapture) {
		this.shopNameCapture = shopNameCapture;
	}

	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getText1() {
		return this.text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

	public String getText2() {
		return this.text2;
	}

	public void setText2(String text2) {
		this.text2 = text2;
	}

	public String getText3() {
		return this.text3;
	}

	public void setText3(String text3) {
		this.text3 = text3;
	}

}