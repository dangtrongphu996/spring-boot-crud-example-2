package com.javatechie.crud.example.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity(name = "bill_detail")
@Table(name = "bill_detail")
public class BillDetail {

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdBill() {
		return idBill;
	}

	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="id_bill")
    private int idBill;
    
    @Column(name="id_product")
    private int idProduct;
    
    @Column(name="quantity")
    @Getter
    @Setter
    private int quantity;
    
    @Column(name="unit_price")
    @Getter
    @Setter
    private double unitPrice;

	public BillDetail() {
		super();
	}

	public BillDetail(int id, int idBill, int idProduct, int quantity, double unitPrice) {
		super();
		this.id = id;
		this.idBill = idBill;
		this.idProduct = idProduct;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
    
}