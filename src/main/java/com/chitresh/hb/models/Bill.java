package com.chitresh.hb.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bills")
public class Bill {
	@Id
	private long billNumber;
	private String billedTo;
	//dd-mm-yy
	private String billedDate;
	private double billedPrice;
	private double billTax;
	private double totalPrice;
	
	public Bill() {
	}
	
	public Bill(long billNumber, String billedTo, String billedDate, double billedPrice, double billTax,
			double totalPrice) {
		super();
		this.billNumber = billNumber;
		this.billedTo = billedTo;
		this.billedDate = billedDate;
		this.billedPrice = billedPrice;
		this.billTax = billTax;
		this.totalPrice = totalPrice;
	}
	
	public long getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(long billNumber) {
		this.billNumber = billNumber;
	}
	public String getBilledTo() {
		return billedTo;
	}
	public void setBilledTo(String billedTo) {
		this.billedTo = billedTo;
	}
	public String getBilledDate() {
		return billedDate;
	}
	public void setBilledDate(String billedDate) {
		this.billedDate = billedDate;
	}
	public double getBilledPrice() {
		return billedPrice;
	}
	public void setBilledPrice(double billedPrice) {
		this.billedPrice = billedPrice;
	}
	public double getBillTax() {
		return billTax;
	}
	public void setBillTax(double billTax) {
		this.billTax = billTax;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
}
