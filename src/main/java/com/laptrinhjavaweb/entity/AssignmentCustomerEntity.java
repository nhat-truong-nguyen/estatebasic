package com.laptrinhjavaweb.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "assignmentcustomer")
public class AssignmentCustomerEntity extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "customerid", nullable = false)
	private CustomerEntity customer;

	@ManyToOne
	@JoinColumn(name = "staffid", nullable = false)
	private UserEntity staff;


	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public UserEntity getStaff() {
		return staff;
	}

	public void setStaff(UserEntity staff) {
		this.staff = staff;
	}
}
