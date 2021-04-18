package com.javatechie.crud.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "products")
@Table(name = "products")
public class Products {

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


	public ProductType getProductType() {
		return productType;
	}


	public void setProductType(ProductType productType) {
		this.productType = productType;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getUnit_price() {
		return unit_price;
	}


	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}


	public float getPromotion_price() {
		return promotion_price;
	}


	public void setPromotion_price(float promotion_price) {
		this.promotion_price = promotion_price;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public int getId_unit() {
		return id_unit;
	}


	public void setId_unit(int id_unit) {
		this.id_unit = id_unit;
	}


	public int getNews() {
		return news;
	}


	public void setNews(int news) {
		this.news = news;
	}


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    
    @Column(name="name")
    @Getter
    @Setter
    private String name;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_type")
	private ProductType productType;
    
    @Column(name="description")
    @Getter
    @Setter
    private String description;
    
    @Column(name="unit_price")
    @Getter
    @Setter
    private double unit_price;
    
    @Column(name="promotion_price")
    @Getter
    @Setter
    private float promotion_price;
    
    @Column(name="image")
    @Getter
    @Setter
    private String image;

	
    @Column(name="id_unit")
    @Getter
    @Setter
    private int id_unit;
    
    
    @Column(name="news")
    @Getter
    @Setter
    private int news;


	public Products() {
		super();
	}


	public Products(int id, String name, ProductType productType, String description, float unit_price,
			float promotion_price, String image, int id_unit, int news) {
		super();
		this.id = id;
		this.name = name;
		this.productType = productType;
		this.description = description;
		this.unit_price = unit_price;
		this.promotion_price = promotion_price;
		this.image = image;
		this.id_unit = id_unit;
		this.news = news;
	}
    
}

