package net.software.projects.carwash.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.format.annotation.DateTimeFormat;

import net.software.projects.carwash.model.base.TransactionalEntity;
import net.software.projects.carwash.model.enums.OrderStatus;

/**
 * The Class JobOrder.
 */
@Entity
public class JobOrder extends TransactionalEntity {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/** The order date. */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate orderDate;

	/** The customer. */
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	/** The attendant. */
	@OneToOne
	private Employee attendant;
	
	/** The service. */
	@OneToOne
	private Service service;

	/** The order status. */
	@Basic
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;

	/** The amount. */
	private double amount;
		
	/**
	 * Before persist.
	 */
	@Override
	@PrePersist
	public void beforePersist() {
		setCreatedAt(LocalDateTime.now());
		setOrderDate(LocalDate.now());
		setOrderStatus(OrderStatus.PENDING);
		setAmount(service.getPrice());
	}

	/**
	 * Before update.
	 */
	@Override
	@PreUpdate
	public void beforeUpdate() {
		setUpdatedAt(LocalDateTime.now());
		setAmount(service.getPrice());
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the order date.
	 *
	 * @return the order date
	 */
	public LocalDate getOrderDate() {
		return orderDate;
	}

	/**
	 * Sets the order date.
	 *
	 * @param orderDate the new order date
	 */
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * Gets the order status.
	 *
	 * @return the order status
	 */
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	/**
	 * Sets the order status.
	 *
	 * @param orderStatus the new order status
	 */
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * Gets the customer.
	 *
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Sets the customer.
	 *
	 * @param customer the new customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Gets the attendant.
	 *
	 * @return the attendant
	 */
	public Employee getAttendant() {
		return attendant;
	}

	/**
	 * Sets the attendant.
	 *
	 * @param attendant the new attendant
	 */
	public void setAttendant(Employee attendant) {
		this.attendant = attendant;
	}

	/**
	 * Gets the service.
	 *
	 * @return the service
	 */
	public Service getService() {
		return service;
	}

	/**
	 * Sets the service.
	 *
	 * @param service the new service
	 */
	public void setService(Service service) {
		this.service = service;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
