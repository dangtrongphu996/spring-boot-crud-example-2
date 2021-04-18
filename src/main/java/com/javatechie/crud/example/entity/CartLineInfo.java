package com.javatechie.crud.example.entity;

public class CartLineInfo {

	private Products products;
    
	private int quantity;
  
    public CartLineInfo() {
    	
    	this.quantity = 0;
	}

	public CartLineInfo(Products products, int quantity) {
		super();
		this.products = products;
		this.quantity = quantity;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
        return this.products.getUnit_price() * this.quantity;
    }
}
