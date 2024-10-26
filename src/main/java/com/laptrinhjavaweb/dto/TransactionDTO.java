package com.laptrinhjavaweb.dto;

public class TransactionDTO extends AbstractDTO<TransactionDTO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	private String note;

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
