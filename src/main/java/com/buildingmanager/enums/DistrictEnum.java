package com.buildingmanager.enums;

public enum DistrictEnum {
	QUAN_1("Quận 1"),
    QUAN_2("Quận 2"),  
    QUAN_3("Quận 3"),
    QUAN_4("Quận 4");
	
	private final String code;
	
	DistrictEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
