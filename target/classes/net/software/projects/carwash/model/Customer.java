package net.software.projects.carwash.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import net.software.projects.carwash.model.base.Person;


/**
 * The Class Customer.
 */
@Entity
public class Customer extends Person {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/** The job orders. */
	@OneToMany(mappedBy = "customer")
	private Set<JobOrder> jobOrders;

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
	 * Gets the job orders.
	 *
	 * @return the job orders
	 */
	public Set<JobOrder> getJobOrders() {
		return jobOrders;
	}

	/**
	 * Sets the job orders.
	 *
	 * @param jobOrders the new job orders
	 */
	public void setJobOrders(Set<JobOrder> jobOrders) {
		this.jobOrders = jobOrders;
	}

}
