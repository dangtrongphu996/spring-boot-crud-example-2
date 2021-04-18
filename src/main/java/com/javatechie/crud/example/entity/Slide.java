package com.javatechie.crud.example.entity;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity(name = "slide")
@Table(name = "slide")
@Data
public class Slide {

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    
    @Column(name="link")
    private String link;
    
    @Column(name="image")
    private String image;

	public Slide() {
		super();
	}

	public Slide(int id, String link, String image) {
		super();
		this.id = id;
		this.link = link;
		this.image = image;
	}
	
}