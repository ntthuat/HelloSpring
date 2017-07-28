package demo.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ordersdetail database table.
 * 
 */
@Embeddable
public class OrdersdetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int productid;

	@Column(insertable=false, updatable=false)
	private int ordersid;

	public OrdersdetailPK() {
	}
	public int getProductid() {
		return this.productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getOrdersid() {
		return this.ordersid;
	}
	public void setOrdersid(int ordersid) {
		this.ordersid = ordersid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrdersdetailPK)) {
			return false;
		}
		OrdersdetailPK castOther = (OrdersdetailPK)other;
		return 
			(this.productid == castOther.productid)
			&& (this.ordersid == castOther.ordersid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.productid;
		hash = hash * prime + this.ordersid;
		
		return hash;
	}
}