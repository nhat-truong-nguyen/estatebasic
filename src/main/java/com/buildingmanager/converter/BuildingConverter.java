package com.buildingmanager.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.buildingmanager.entity.BuildingEntity;
import com.buildingmanager.entity.DistrictEntity;
import com.buildingmanager.model.response.BuildingSearchResponse;
import com.buildingmanager.repository.DistrictRepository;

@Component
public class BuildingConverter {
	@Autowired
	DistrictRepository districtRepository;

	public BuildingSearchResponse toBuildingDTO(BuildingEntity buildingEntity) {
		StringBuilder address = new StringBuilder();
		address.append(buildingEntity.getStreet()).append(", ").append(buildingEntity.getWard()).append(", ")
				.append(districtRepository.findDistrictById(buildingEntity.getDistrictId()).getName());

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
