package com.moimah.model;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Class Entity for user
 * @author moimah
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "user", catalog = "7057507_ecommerce")
public class User implements java.io.Serializable {

	private Integer id;
	private String password;
	private String type;
	private String username;
	private Set<Order> orders = new HashSet<Order>(0);

	public User() {
	}

	public User(String password, String type, String username, Set<Order> orders) {
		this.password = password;
		this.type = type;
		this.username = username;
		this.orders = orders;
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

	@Column(name = "password")
	@JsonIgnore
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "type")
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "username")
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@JsonIgnore
	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}
