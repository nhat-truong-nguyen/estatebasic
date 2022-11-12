package com.buildingmanager.service.impl;

import java.util.ArrayList;
import java.util.List;

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
	public List<BuildingSearchResponse> findByName(String name) {
		return toListBuildingDTO(buildingRepository.findByName(name));
	}

	@Override
	public List<BuildingSearchResponse> findByFloorArea(Integer floorArea) {
		return toListBuildingDTO(buildingRepository.findByFloorArea(floorArea));
	}

	@Override
	public List<BuildingSearchResponse> findByDistrictId(Integer districtId) {
		return toListBuildingDTO(buildingRepository.findByDistrictId(districtId));
	}

	@Override
	public List<BuildingSearchResponse> findByWard(String ward) {
		return toListBuildingDTO(buildingRepository.findByWard(ward));
	}

	@Override
	public List<BuildingSearchResponse> findByStreet(String street) {
		return toListBuildingDTO(buildingRepository.findByStreet(street));
	}

	@Override
	public List<BuildingSearchResponse> findByNumberOfBasement(Integer numberOfBasement) {
		return toListBuildingDTO(buildingRepository.findByNumberOfBasement(numberOfBasement));
	}

	@Override
	public List<BuildingSearchResponse> findByDirection(String direction) {
		return toListBuildingDTO(buildingRepository.findByDirection(direction));
	}

	@Override
	public List<BuildingSearchResponse> findByLevel(String level) {
		return toListBuildingDTO(buildingRepository.findByLevel(level));
	}

	@Override
	public List<BuildingSearchResponse> findByRentPriceFrom(Integer rentPriceFrom) {
		return toListBuildingDTO(buildingRepository.findByRentPriceFrom(rentPriceFrom));
	}

	@Override
	public List<BuildingSearchResponse> findByRentPriceTo(Integer rentPriceTo) {
		return toListBuildingDTO(buildingRepository.findByRentPriceTo(rentPriceTo));
	}

	@Override
	public List<BuildingSearchResponse> findByRentPriceFromTo(Integer rentPriceFrom, Integer rentPriceTo) {
		return toListBuildingDTO(buildingRepository.findByRentPriceFromTo(rentPriceFrom, rentPriceTo));
	}

	@Override
	public List<BuildingSearchResponse> findByRentAreaFrom(Integer rentAreaFrom) {
		return toListBuildingDTO(buildingRepository.findByRentAreaFrom(rentAreaFrom));
	}

	@Override
	public List<BuildingSearchResponse> findByRentAreaTo(Integer rentAreaTo) {
		return toListBuildingDTO(buildingRepository.findByRentAreaTo(rentAreaTo));
	}

	@Override
	public List<BuildingSearchResponse> findByRentAreaFromTo(Integer rentAreaFrom, Integer rentAreaTo) {
		return toListBuildingDTO(buildingRepository.findByRentAreaFromTo(rentAreaFrom, rentAreaTo));
	}

	@Override
	public List<BuildingSearchResponse> findByRentTypeId(Integer[] rentTypeIds) {
		return toListBuildingDTO(buildingRepository.findByRentTypeId(rentTypeIds));
	}

	@Override
	public List<BuildingSearchResponse> findByFullCondition(String name, Integer floorArea, Integer districtId,
			String ward, String street, Integer numberOfBasement, String direction, String level, Integer rentPriceFrom,
			Integer rentPriceTo, Integer rentAreaFrom, Integer rentAreaTo, Integer[] rentTypeIds) {
		return toListBuildingDTO(buildingRepository.findByFullCondition(name, floorArea, districtId, ward, street, numberOfBasement, direction, level, rentPriceFrom, rentPriceTo, rentAreaFrom, rentAreaTo, rentTypeIds));
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
		
		buildingSearchResponse.setId(buildingEntity.getId());
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
		buildingSearchResponse.setModifiedDate(buildingSearchResponse.getModifiedDate());
		buildingSearchResponse.setCreatedBy(buildingSearchResponse.getCreatedBy());
		buildingSearchResponse.setModifiedBy(buildingSearchResponse.getModifiedBy());

		return buildingSearchResponse;
		
	}

}
