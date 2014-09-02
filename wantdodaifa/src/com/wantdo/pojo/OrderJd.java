package com.wantdo.pojo;

/**
 * OrderJd entity. @author MyEclipse Persistence Tools
 */

public class OrderJd implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String address;
	private String phone;
	private String orderId;
	private String orderNo;
	private String goodinfo;
	private String primeCost;
	private String discountCost;
	private String orderNum;
	private String orderPrice;
	private String gettime;

	// Constructors

	/** default constructor */
	public OrderJd() {
	}

	/** full constructor */
	public OrderJd(String name, String address, String phone, String orderId,
			String orderNo, String goodinfo, String primeCost,
			String discountCost, String orderNum, String orderPrice,
			String gettime) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.orderId = orderId;
		this.orderNo = orderNo;
		this.goodinfo = goodinfo;
		this.primeCost = primeCost;
		this.discountCost = discountCost;
		this.orderNum = orderNum;
		this.orderPrice = orderPrice;
		this.gettime = gettime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getGoodinfo() {
		return this.goodinfo;
	}

	public void setGoodinfo(String goodinfo) {
		this.goodinfo = goodinfo;
	}

	public String getPrimeCost() {
		return this.primeCost;
	}

	public void setPrimeCost(String primeCost) {
		this.primeCost = primeCost;
	}

	public String getDiscountCost() {
		return this.discountCost;
	}

	public void setDiscountCost(String discountCost) {
		this.discountCost = discountCost;
	}

	public String getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getOrderPrice() {
		return this.orderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getGettime() {
		return this.gettime;
	}

	public void setGettime(String gettime) {
		this.gettime = gettime;
	}

}