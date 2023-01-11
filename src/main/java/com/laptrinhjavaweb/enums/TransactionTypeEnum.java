package com.laptrinhjavaweb.enums;

public enum TransactionTypeEnum {
	QUA_TRINH_CHAM_SOC_KHACH_HANG("Quá trình chăm sóc khách hàng"),
	DAN_DI_XEM("Dẫn đi xem");
	
	private String value;
		
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	TransactionTypeEnum(String value) {
		this.value = value;
	}
}
