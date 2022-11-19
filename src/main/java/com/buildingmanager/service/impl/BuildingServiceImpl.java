package com.buildingmanager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buildingmanager.entity.BuildingEntity;
import com.buildingmanager.model.response.BuildingSearchResponse;
import com.buildingmanager.repository.BuildingRepository;
import com.buildingmanager.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	BuildingRepository buildingRepository;
	
	@Override
	public List<BuildingSearchResponse> findBuildings(Map<String, String> params, List<String> rentTypes) {
		return toListBuildingDTO(buildingRepository.findBuildings(params, rentTypes));
	}

	private List<BuildingSearchResponse> toListBuildingDTO(List<BuildingEntity> listBuildingEntity) {
		List<BuildingSearchResponse> listBuilding = null;
		
		if (listBuildingEntity != null) {
			listBuilding = new ArrayList<BuildingSearchResponse>();
			for (BuildingEntity buildingEntity : listBuildingEntity) {
				listBuilding.add(toBuildingDTO(buildingEntity));
			}
		}

		return listBuilding;
	}
	
	private BuildingSearchResponse toBuildingDTO(BuildingEntity buildingEntity) {
		BuildingSearchResponse buildingSearchResponse = new BuildingSearchResponse();
		
		buildingSearchResponse.setName(buildingEntity.getName());
		buildingSearchResponse.setStreet(buildingEntity.getStreet());
		buildingSearchResponse.setWard(buildingEntity.getWard());
		buildingSearchResponse.setDistrictId(buildingEntity.getDistrictId());
		buildingSearchResponse.setStructure(buildingEntity.getStructure());
		buildingSearchResponse.setNumberOfBasement(buildingEntity.getNumberOfBasement());
		buildingSearchResponse.setFloorArea(buildingEntity.getFloorArea());
		buildingSearchResponse.setDirection(buildingEntity.getDirection());
		buildingSearchResponse.setLevel(buildingEntity.getLevel());
		buildingSearchResponse.setRentPrice(buildingEntity.getRentPrice());
		buildingSearchResponse.setRentPriceDescription(buildingEntity.getRentPriceDescription());
		buildingSearchResponse.setServiceFee(buildingEntity.getServiceFee());
		buildingSearchResponse.setCarFee(buildingEntity.getCarFee());
		buildingSearchResponse.setMotorbikeFee(buildingEntity.getMotorbikeFee());
		buildingSearchResponse.setOvertimeFee(buildingSearchResponse.getOvertimeFee());
		buildingSearchResponse.setWaterFee(buildingEntity.getWaterFee());
		buildingSearchResponse.setElectricityFee(buildingEntity.getElectricityFee());
		buildingSearchResponse.setDeposit(buildingEntity.getDeposit());
		buildingSearchResponse.setPayment(buildingEntity.getPayment());
		buildingSearchResponse.setRenttime(buildingEntity.getRenttime());
		buildingSearchResponse.setDecorationTime(buildingEntity.getDecorationTime());
		buildingSearchResponse.setBrokerageFee(buildingEntity.getBrokerageFee());
		buildingSearchResponse.setNote(buildingEntity.getNote());
		buildingSearchResponse.setLinkOfBuilding(buildingEntity.getLinkOfBuilding());
		buildingSearchResponse.setMap(buildingEntity.getMap());
		buildingSearchResponse.setImage(buildingEntity.getImage());
		buildingSearchResponse.setCreatedDate(buildingEntity.getCreatedDate());
		return buildingSearchResponse;
		
	}
}
