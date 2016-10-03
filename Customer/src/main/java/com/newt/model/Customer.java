package com.newt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer custId;
	private String custName;
	private String custAddress;
	Customer()
	{
		
	}
	public Customer(String custName, String custAddress) {
		super();
		this.custName = custName;
		this.custAddress = custAddress;
	}
	
	@Override
	public String toString(){
		return custId + "" + custName +"" + custAddress;
	}

	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custid) {
		this.custId = custid;
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

}
