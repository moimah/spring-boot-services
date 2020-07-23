package com.moimah.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Class Entity for delivery
 * @author moimah
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "delivery", catalog = "7057507_ecommerce")
public class Delivery implements java.io.Serializable {

	private Integer id;
	private Order order;
	private String name;
	private String email;
	private String address;
	private String state;
	private String zip;

	public Delivery() {
	}

	public Delivery(Order order, String name, String email, String address, String state, String zip) {
		this.order = order;
		this.name = name;
		this.email = email;
		this.address = address;
		this.state = state;
		this.zip = zip;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Column(name = "name", length = 500)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "address", length = 500)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "state", length = 100)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "zip", length = 14)
	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
