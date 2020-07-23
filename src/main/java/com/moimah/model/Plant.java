package com.moimah.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Class entity for plant
 * @author moimah
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "plant", catalog = "7057507_ecommerce")
public class Plant implements java.io.Serializable {

	private Integer id;
	private String description;
	private String name;
	private byte[] picByte;
	private Double price;
	private Set<Detail> details = new HashSet<Detail>(0);

	public Plant() {
	}

	public Plant(String description, String name, byte[] picByte, Double price, Set<Detail> details) {
		this.description = description;
		this.name = name;
		this.picByte = picByte;
		this.price = price;
		this.details = details;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Lob
	@Column(name = "picByte")
	public byte[] getPicByte() {
		return this.picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	@Column(name = "price", precision = 22, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@OneToMany( cascade= CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "plant")
	@JsonIgnore
	public Set<Detail> getDetails() {
		return this.details;
	}

	public void setDetails(Set<Detail> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Plant [id=" + id + ", description=" + description + ", name=" + name + ", picByte="
				+ Arrays.toString(picByte) + ", price=" + price + ", details=" + details + "]";
	}
	
	

}
