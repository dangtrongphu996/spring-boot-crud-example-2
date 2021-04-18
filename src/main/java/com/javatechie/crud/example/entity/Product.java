package com.javatechie.crud.example.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity(name = "product_tbl")
@Table(name = "product_tbl")
public class Product {

    @Id
    @GeneratedValue
    private int id;
    
    @Column(name="name")
    @Getter
    @Setter
    private String name;
    
    @Column(name="quantity")
    @Getter
    @Setter
    private int quantity;
    
    @Column(name="price")
    @Getter
    @Setter
    private double price;

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
    
}