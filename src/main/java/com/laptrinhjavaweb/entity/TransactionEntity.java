package com.laptrinhjavaweb.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class TransactionEntity extends BaseEntity {
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customerid", nullable = false)
	private CustomerEntity customer;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "staffid", nullable =  false)
	private UserEntity staff;

	@Column(name = "note")
	private String note;

	@Column(name = "type")
	private String type;

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public UserEntity getStaff() {
		return staff;
	}

	public void setStaff(UserEntity staff) {
		this.staff = staff;
	}
}
