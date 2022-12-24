package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.model.response.BuildingSearchResponse;

public interface IBuildingService {
	List<BuildingSearchResponse> findBuildings(Map<String, String> params, List<String> rentTypes);
	void delete(Long[] ids);
	List<BuildingSearchResponse> findAll();
	void assignBuilding(Long[] staffIds, Long buildingId);
	BuildingDTO findById(Long id);
	void saveOrUpdate(BuildingDTO dto);
}
