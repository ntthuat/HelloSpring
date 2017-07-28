package demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ordersdetail database table.
 * 
 */
@Entity
@NamedQuery(name="Ordersdetail.findAll", query="SELECT o FROM Ordersdetail o")
public class Ordersdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrdersdetailPK id;

	private BigDecimal price;

	private int quantity;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="productid", insertable = false, updatable = false)
	private Product product;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="ordersid", insertable = false, updatable = false)
	private Order order;

	public Ordersdetail() {
	}

	public OrdersdetailPK getId() {
		return this.id;
	}

	public void setId(OrdersdetailPK id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}