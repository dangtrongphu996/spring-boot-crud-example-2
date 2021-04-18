package com.javatechie.crud.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "bills")
@Table(name = "bills")
public class Bills {

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
    @Column(name = "id_customer", unique = true, nullable = false)
	private Integer idCustomer;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_order")
	private Date dateOrder;
	
	@Column(name="total")
	private float total;
	
	@Column(name="payment")
	private String payment;
	
	@Column(name="note")
	private String note;

	public Bills() {
		super();
	}

	public Bills(Integer id, Integer idCustomer, Date dateOrder, float total, String payment, String note) {
		super();
		this.id = id;
		this.idCustomer = idCustomer;
		this.dateOrder = dateOrder;
		this.total = total;
		this.payment = payment;
		this.note = note;
	}
	
	public Bills(Integer idCustomer, Date dateOrder, float total, String payment, String note) {
		super();
		this.idCustomer = idCustomer;
		this.dateOrder = dateOrder;
		this.total = total;
		this.payment = payment;
		this.note = note;
	}
}
