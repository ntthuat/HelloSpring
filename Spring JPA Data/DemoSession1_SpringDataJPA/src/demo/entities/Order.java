package demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="orders")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date datecreation;

	private String name;

	private byte status;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="username", insertable = false, updatable = false)
	private Account account;

	//bi-directional many-to-one association to Ordersdetail
	@OneToMany(mappedBy="order")
	private List<Ordersdetail> ordersdetails;

	public Order() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatecreation() {
		return this.datecreation;
	}

	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Ordersdetail> getOrdersdetails() {
		return this.ordersdetails;
	}

	public void setOrdersdetails(List<Ordersdetail> ordersdetails) {
		this.ordersdetails = ordersdetails;
	}

	public Ordersdetail addOrdersdetail(Ordersdetail ordersdetail) {
		getOrdersdetails().add(ordersdetail);
		ordersdetail.setOrder(this);

		return ordersdetail;
	}

	public Ordersdetail removeOrdersdetail(Ordersdetail ordersdetail) {
		getOrdersdetails().remove(ordersdetail);
		ordersdetail.setOrder(null);

		return ordersdetail;
	}

}