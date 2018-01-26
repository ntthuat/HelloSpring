package entities;

// Generated Jun 1, 2015 9:29:28 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.*;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product", catalog = "demo")
@XmlRootElement(name = "product")
public class Product implements java.io.Serializable {

	private Integer id;
	private String name;
	private long price;
	private int quantity;
	private String description;

	public Product() {
	}

	public Product(String name, long price, int quantity, String description) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
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

	@Column(name = "name", nullable = false, length = 250)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price", nullable = false, precision = 10, scale = 0)
	public long getPrice() {
		return this.price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Column(name = "quantity", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "description", nullable = false, length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}