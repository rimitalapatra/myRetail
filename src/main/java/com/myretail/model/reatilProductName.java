package com.myretail.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class reatilProductName {
	@Id
	private int id;
	@Override
	public String toString() {
		return "reatilProductName [id=" + id + ", currencyCode=" + currencyCode + ", price=" + price + "]";
	}

	private String currencyCode;
	private double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public reatilProductName(int id, String currencyCode, double price) {
		super();
		this.id = id;
		this.currencyCode = currencyCode;
		this.price = price;
	}
	
	
}
