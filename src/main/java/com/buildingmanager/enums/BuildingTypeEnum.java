package com.buildingmanager.enums;

public enum BuildingTypeEnum {
	TANG_TRET("Tầng trệt"),  
    NGUYEN_CAN("Nguyên căn"),  
    NOI_THAT("Nội thất");
	
	private final String value;
	
    BuildingTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
