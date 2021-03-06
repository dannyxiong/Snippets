package com.hibernate;

// Generated Jul 29, 2015 11:05:27 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Peasant generated by hbm2java
 */
@Entity
@Table(name = "peasant", catalog = "sakila")
public class Peasant implements java.io.Serializable {

	private Integer id;
	private String name;
	private Integer age;

	public Peasant() {
	}

	public Peasant(String name, Integer age) {
		this.name = name;
		this.age = age;
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

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
