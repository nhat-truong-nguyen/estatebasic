package com.laptrinhjavaweb.enums;

public enum DistrictEnum {
	QUAN_1("Quận 1"),
    QUAN_2("Quận 2"),  
    QUAN_3("Quận 3"),
    QUAN_4("Quận 4");
	
	private final String name;
	
	DistrictEnum(String districtName) {
		this.name = districtName;
	}

	public String getName() {
		return this.name;
	}
}
