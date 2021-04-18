package com.javatechie.crud.example.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "departs")
@Table(name = "departs")
public class Departs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "departs")
	private Set<Staffs> staffs;
	
	public Departs() {
		super();
	}

	public Departs(Integer id, String name, Set<Staffs> staffs) {
		super();
		this.id = id;
		this.name = name;
		this.staffs = staffs;
	}
	
	public Departs(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Set<Staffs> getStaffs() {
		return staffs;
	}

	public void setStaffs(Set<Staffs> staffs) {
		this.staffs = staffs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}