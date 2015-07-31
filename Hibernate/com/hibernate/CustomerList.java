package com.hibernate;

// Generated Jul 29, 2015 11:05:27 AM by Hibernate Tools 4.3.1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * CustomerList generated by hbm2java
 */
@Entity
@Table(name = "customer_list", catalog = "sakila")
public class CustomerList implements java.io.Serializable {

	private CustomerListId id;

	public CustomerList() {
	}

	public CustomerList(CustomerListId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "id", column = @Column(name = "ID", nullable = false)),
			@AttributeOverride(name = "name", column = @Column(name = "name", length = 91)),
			@AttributeOverride(name = "address", column = @Column(name = "address", nullable = false, length = 50)),
			@AttributeOverride(name = "zipCode", column = @Column(name = "zip code", length = 10)),
			@AttributeOverride(name = "phone", column = @Column(name = "phone", nullable = false, length = 20)),
			@AttributeOverride(name = "city", column = @Column(name = "city", nullable = false, length = 50)),
			@AttributeOverride(name = "country", column = @Column(name = "country", nullable = false, length = 50)),
			@AttributeOverride(name = "notes", column = @Column(name = "notes", nullable = false, length = 6)),
			@AttributeOverride(name = "sid", column = @Column(name = "SID", nullable = false)) })
	public CustomerListId getId() {
		return this.id;
	}

	public void setId(CustomerListId id) {
		this.id = id;
	}

}
