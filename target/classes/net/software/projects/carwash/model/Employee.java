package net.software.projects.carwash.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import net.software.projects.carwash.model.base.Person;
import net.software.projects.carwash.model.enums.EmployeePosition;
import net.software.projects.carwash.model.enums.EmployeeStatus;

/**
 * The Class Employee.
 */
@Entity
public class Employee extends Person {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/** The status. */
	@Basic
	@Enumerated(EnumType.STRING)
	private EmployeeStatus status;
	
	/** The position. */
	@Basic
	@Enumerated(EnumType.STRING)
	private EmployeePosition position;

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public EmployeeStatus getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(EmployeeStatus status) {
		this.status = status;
	}

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public EmployeePosition getPosition() {
		return position;
	}

	/**
	 * Sets the position.
	 *
	 * @param position the new position
	 */
	public void setPosition(EmployeePosition position) {
		this.position = position;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
