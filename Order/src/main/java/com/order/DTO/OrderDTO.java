package com.order.DTO;

public class OrderDTO {
	String custName;
	String custAddress;
	Integer orderId;
	Integer custId;
	String orderName;
	
	OrderDTO()
	{
		
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public Integer getOrderid() {
		return orderId;
	}
	public void setOrderid(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getcustId() {
		return custId;
	}
	public void setCust_id(Integer custId) {
		this.custId = custId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	
}
