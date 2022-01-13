package net.software.projects.carwash.model.base;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Convert;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

import net.software.projects.carwash.model.custom.LocalDateTimeAttributeConverter;


/**
 * The Class TransactionalEntity.
 */
@MappedSuperclass
public class TransactionalEntity {

	/** The reference id. */
	@NotNull
	private String referenceId = UUID.randomUUID().toString();

	/**
	 * A reference to the entity or process which created this entity instance.
	 */
	private String createdBy;

	/**
	 * The timestamp when this entity instance was created.
	 */
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime createdAt;

	/**
	 * A reference to the entity or process which most recently updated this
	 * entity instance.
	 */
	private String updatedBy;

	/**
	 * The timestamp when this entity instance was most recently updated.
	 */
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime updatedAt;

	/**
	 * A listener method which is invoked on instances of TransactionalEntity
	 * (or their subclasses) prior to initial persistence. Sets the
	 * <code>created</code> audit values for the entity. Attempts to obtain this
	 * thread's instance of a username from the RequestContext. If none exists,
	 * throws an IllegalArgumentException. The username is used to set the
	 * <code>createdBy</code> value. The <code>createdAt</code> value is set to
	 * the current timestamp.
	 */
	@PrePersist
	public void beforePersist() {
		setCreatedAt(LocalDateTime.now());
	}

	/**
	 * A listener method which is invoked on instances of TransactionalEntity
	 * (or their subclasses) prior to being updated. Sets the
	 * <code>updated</code> audit values for the entity. Attempts to obtain this
	 * thread's instance of username from the RequestContext. If none exists,
	 * throws an IllegalArgumentException. The username is used to set the
	 * <code>updatedBy</code> value. The <code>updatedAt</code> value is set to
	 * the current timestamp.
	 */
	@PreUpdate
	public void beforeUpdate() {
		setUpdatedAt(LocalDateTime.now());
	}

	/**
	 * Gets the reference id.
	 *
	 * @return the reference id
	 */
	public String getReferenceId() {
		return referenceId;
	}

	/**
	 * Sets the reference id.
	 *
	 * @param referenceId the new reference id
	 */
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	/**
	 * Gets the created by.
	 *
	 * @return the created by
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy the new created by
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the created at.
	 *
	 * @return the created at
	 */
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	/**
	 * Sets the created at.
	 *
	 * @param createdAt the new created at
	 */
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * Gets the updated by.
	 *
	 * @return the updated by
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * Sets the updated by.
	 *
	 * @param updatedBy the new updated by
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * Gets the updated at.
	 *
	 * @return the updated at
	 */
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * Sets the updated at.
	 *
	 * @param updatedAt the new updated at
	 */
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}