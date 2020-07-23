package com.moimah.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Class Entity for detail
 * @author moimah
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "detail", catalog = "7057507_ecommerce")
public class Detail implements java.io.Serializable {

	private DetailId id;
	private Order order;
	private Plant plant;
	private Double price;
	private Integer uds;

	public Detail() {
	}

	public Detail(DetailId id, Order order, Plant plant) {
		this.id = id;
		this.order = order;
		this.plant = plant;
	}

	public Detail(DetailId id, Order order, Plant plant, Double price, Integer uds) {
		this.id = id;
		this.order = order;
		this.plant = plant;
		this.price = price;
		this.uds = uds;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "orderId", column = @Column(name = "order_id", nullable = false)),
			@AttributeOverride(name = "plantId", column = @Column(name = "plant_id", nullable = false)) })
	public DetailId getId() {
		return this.id;
	}

	public void setId(DetailId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id", nullable = false, insertable = false, updatable = false)
	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "plant_id", nullable = false, insertable = false, updatable = false)
	public Plant getPlant() {
		return this.plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	@Column(name = "price", precision = 22, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "uds")
	public Integer getUds() {
		return this.uds;
	}

	public void setUds(Integer uds) {
		this.uds = uds;
	}

	@Override
	public String toString() {
		return "Detail [id=" + id + ", order=" + order + ", plant=" + plant + ", price=" + price + ", uds=" + uds + "]";
	}
	
	

}
