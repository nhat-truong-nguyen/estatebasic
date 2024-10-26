package com.laptrinhjavaweb.model.response;

import com.laptrinhjavaweb.dto.AbstractDTO;

public class CustomerSearchResponse extends AbstractDTO<CustomerSearchResponse> {
	private String fullName;
	private String managerStaffs;
	private String phone;
	private String email;
	private String demand;
	private String status;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getManagerStaffs() {
		return managerStaffs;
	}

	public void setManagerStaffs(String managerStaffs) {
		this.managerStaffs = managerStaffs;
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

	public String getDemand() {
		return demand;
	}

	public void setDemand(String demand) {
		this.demand = demand;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
