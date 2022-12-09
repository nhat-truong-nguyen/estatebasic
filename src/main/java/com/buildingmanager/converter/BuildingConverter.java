package com.buildingmanager.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.buildingmanager.entity.BuildingEntity;
import com.buildingmanager.enums.DistrictEnum;
import com.buildingmanager.model.response.BuildingSearchResponse;

@Component
public class BuildingConverter {

	public BuildingSearchResponse toBuildingDTO(BuildingEntity buildingEntity) {
		StringBuilder address = new StringBuilder();
		
		String district = DistrictEnum.valueOf(buildingEntity.getDistrict()).getDistrictName();	
		
		address.append(String.join(", ", buildingEntity.getWard(), buildingEntity.getStreet(), district));

		BuildingSearchResponse buildingSearchResponse = new BuildingSearchResponse();
		buildingSearchResponse.setName(buildingEntity.getName());
		buildingSearchResponse.setAddress(address.toString());
		buildingSearchResponse.setManagerName(buildingEntity.getManagerName());
		buildingSearchResponse.setManagerPhone(buildingEntity.getManagerPhone());
		buildingSearchResponse.setFloorArea(buildingEntity.getFloorArea());
		buildingSearchResponse.setRentPrice(buildingEntity.getRentPrice());
		buildingSearchResponse.setServiceFee(buildingEntity.getServiceFee());
		buildingSearchResponse.setBrokerageFee(buildingEntity.getBrokerageFee());
		buildingSearchResponse.setCreatedDate(buildingEntity.getCreatedDate());

		return buildingSearchResponse;

	}
}
