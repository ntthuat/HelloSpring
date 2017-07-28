package demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Product.findAll", 
		query="SELECT p FROM Product p"),
	@NamedQuery(name="Product.findByPriceNQ", 
		query="SELECT p FROM Product p where p.price between :min and :max")
})
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String description;

	private boolean feature;

	private String name;

	private String photo;

	private BigDecimal price;

	private int quantity;

	//bi-directional many-to-one association to Ordersdetail
	@OneToMany(mappedBy="product")
	private List<Ordersdetail> ordersdetails;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="categoryid", insertable = false, updatable = false)
	private Category category;

	//bi-directional many-to-one association to Partner
	@ManyToOne
	@JoinColumn(name="partnerId", insertable = false, updatable = false)
	private Partner partner;

	public Product() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isFeature() {
		return this.feature;
	}

	public void setFeature(boolean feature) {
		this.feature = feature;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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

	public List<Ordersdetail> getOrdersdetails() {
		return this.ordersdetails;
	}

	public void setOrdersdetails(List<Ordersdetail> ordersdetails) {
		this.ordersdetails = ordersdetails;
	}

	public Ordersdetail addOrdersdetail(Ordersdetail ordersdetail) {
		getOrdersdetails().add(ordersdetail);
		ordersdetail.setProduct(this);

		return ordersdetail;
	}

	public Ordersdetail removeOrdersdetail(Ordersdetail ordersdetail) {
		getOrdersdetails().remove(ordersdetail);
		ordersdetail.setProduct(null);

		return ordersdetail;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Partner getPartner() {
		return this.partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	@Override
	public String toString() {
		return "Product (" + getId() + ", " + getName() + ", " + getPrice() + ", " + getQuantity() + ", " + this.isFeature() + ")";
	}
	
	

}