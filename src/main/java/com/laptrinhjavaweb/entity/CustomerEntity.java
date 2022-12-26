package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity {
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<TransactionEntity> transactions = new ArrayList<>();
	
    @ManyToMany(mappedBy = "customers", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserEntity> users = new ArrayList<>();

	@Column(name = "fullname")
	private String fullName;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	public List<TransactionEntity> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionEntity> transactions) {
		this.transactions = transactions;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
