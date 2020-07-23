package com.moimah.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Class Entity serializable for DetailId
 * @author moimah
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class DetailId implements java.io.Serializable {

	private int orderId;
	private int plantId;

	public DetailId() {
	}

	public DetailId(int orderId, int plantId) {
		this.orderId = orderId;
		this.plantId = plantId;
	}

	@Column(name = "order_id", nullable = false)
	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Column(name = "plant_id", nullable = false)
	public int getPlantId() {
		return this.plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DetailId))
			return false;
		DetailId castOther = (DetailId) other;

		return (this.getOrderId() == castOther.getOrderId()) && (this.getPlantId() == castOther.getPlantId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getOrderId();
		result = 37 * result + this.getPlantId();
		return result;
	}

	@Override
	public String toString() {
		return "DetailId [orderId=" + orderId + ", plantId=" + plantId + "]";
	}
	
	

}
