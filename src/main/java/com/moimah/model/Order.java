package com.moimah.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Class entity for order
 * @author moimah
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "order", catalog = "7057507_ecommerce")
public class Order implements java.io.Serializable {

	private Integer id;
	private User user;
	private Date orderDate;
	private String status;
	private Set<Detail> details = new HashSet<Detail>(0);
	private Set<Delivery> deliveries = new HashSet<Delivery>(0);

	public Order() {
	}

	public Order(User user, Date orderDate, String status, Set<Detail> details) {
		this.user = user;
		this.orderDate = orderDate;
		this.status = status;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "order_date", length = 10)
	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Column(name = "status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	@JsonIgnore
	public Set<Detail> getDetails() {
		return this.details;
	}

	public void setDetails(Set<Detail> details) {
		this.details = details;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	@JsonIgnore
	public Set<Delivery> getDeliveries() {
		return this.deliveries;
	}

	public void setDeliveries(Set<Delivery> deliveries) {
		this.deliveries = deliveries;
	}
	

}
