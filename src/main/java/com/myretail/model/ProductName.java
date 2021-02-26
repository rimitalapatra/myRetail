package com.myretail.model;

public class ProductName {
	public ProductName() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ProductName [name=" + name + ", id=" + id + "]";
	}
	private int id;
	public ProductName(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	private String name;



}
