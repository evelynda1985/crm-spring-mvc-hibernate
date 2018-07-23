package com.evelynda1985.crm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int id;
	
	@Column(name="customer_firstName")
	private String firstName;
	
	@Column(name="customer_lastName")
	private String lastName;
	
	@Column(name="customer_socSecurityNum")
	private int socSecurityNum;
	
	public Customer() {	}

	public Customer(String firstName, String lastName, int socSecurityNum) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socSecurityNum = socSecurityNum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSocSecurityNum() {
		return socSecurityNum;
	}

	public void setSocSecurityNum(int socSecurityNum) {
		this.socSecurityNum = socSecurityNum;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", socSecurityNum="
				+ socSecurityNum + "]";
	}
	

}
