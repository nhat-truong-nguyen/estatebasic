package com.buildingmanager.service;

import java.util.List;
import java.util.Map;

import com.buildingmanager.dto.BuildingDTO;
import com.buildingmanager.entity.BuildingEntity;
import com.buildingmanager.model.response.BuildingSearchResponse;

public interface BuildingService {
	List<BuildingSearchResponse> findBuildings(Map<String, String> params, List<String> rentTypes);
	BuildingEntity save(BuildingEntity buildingEntity);
	void delete(Long[] ids);
	void update(BuildingDTO dto);
	List<BuildingSearchResponse> findAll();
	void assignBuilding(Long[] staffIds, Long buildingId);
	BuildingDTO findById(Long id);
}
