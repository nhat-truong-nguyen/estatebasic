package com.buildingmanager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buildingmanager.converter.BuildingConverter;
import com.buildingmanager.entity.BuildingEntity;
import com.buildingmanager.model.response.BuildingSearchResponse;
import com.buildingmanager.repository.BuildingRepository;
import com.buildingmanager.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	BuildingRepository buildingRepository;
	
	@Autowired
	BuildingConverter buildingConverter;
	
	@Override
	public List<BuildingSearchResponse> findBuildings(Map<String, String> params, List<String> rentTypes) {
		return toListBuildingDTO(buildingRepository.findBuildings(params, rentTypes));
	}

	private List<BuildingSearchResponse> toListBuildingDTO(List<BuildingEntity> listBuildingEntity) {
		List<BuildingSearchResponse> listBuilding = null;
		
		if (listBuildingEntity != null) {
			listBuilding = new ArrayList<BuildingSearchResponse>();
			for (BuildingEntity buildingEntity : listBuildingEntity) {
				listBuilding.add(buildingConverter.toBuildingDTO(buildingEntity));
			}
		}

		return listBuilding;
	}
}
