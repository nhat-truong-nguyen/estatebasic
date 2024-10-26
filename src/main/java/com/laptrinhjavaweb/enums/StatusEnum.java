package com.laptrinhjavaweb.enums;

public enum StatusEnum {
	CHUA_XU_LY("Chưa xử lý"),
	DANG_XU_LY("Đang xử lý"),
	DONG("Đóng");
	
	private String value;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	StatusEnum(String value) {
		this.value = value;
	}
}
