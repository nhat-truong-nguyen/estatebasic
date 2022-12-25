package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.model.request.BuildingSearchRequest;
import com.laptrinhjavaweb.model.response.BuildingSearchResponse;

public interface IBuildingService {
	void delete(Long[] ids);
	List<BuildingSearchResponse> findAll();
	void assignBuilding(Long[] staffIds, Long buildingId);
	BuildingDTO findById(Long id);
	void saveOrUpdate(BuildingDTO dto);
	List<BuildingSearchResponse> findBuildings(BuildingSearchRequest searchModel);
}
