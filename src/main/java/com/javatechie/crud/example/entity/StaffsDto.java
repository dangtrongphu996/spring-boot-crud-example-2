package com.javatechie.crud.example.entity;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class StaffsDto {

	
	private Integer id;
	
	
	private String name;
	
	
	private String gender;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birthday;
	
	private MultipartFile photo;
	
	private String photoEdit;
	
	
	private String email;
	
	
	private String phone;
	
	
	private Double salary;
	
	
	private String notes;
	
	private Integer departs;

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Integer getDeparts() {
		return departs;
	}

	public void setDeparts(Integer departs) {
		this.departs = departs;
	}

	public StaffsDto() {
		super();
	}

	public StaffsDto(Integer id, String name, String gender, Date birthday, String photoEdit, String email,
			String phone, Double salary, String notes, Integer departs) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.photoEdit = photoEdit;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
		this.notes = notes;
		this.departs = departs;
	}

	public String getPhotoEdit() {
		return photoEdit;
	}

	public void setPhotoEdit(String photoEdit) {
		this.photoEdit = photoEdit;
	}

	
}
