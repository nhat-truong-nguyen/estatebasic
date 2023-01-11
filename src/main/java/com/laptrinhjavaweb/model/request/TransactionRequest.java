package com.laptrinhjavaweb.model.request;

import com.laptrinhjavaweb.dto.AbstractDTO;

public class TransactionRequest extends AbstractDTO<TransactionRequest> {
	private Long customerId;
	private Long staffId;
	private String type;
	private String note;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
