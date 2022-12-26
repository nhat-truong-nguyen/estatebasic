package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.model.request.BuildingSearchRequest;
import com.laptrinhjavaweb.model.response.BuildingSearchResponse;

public interface IBuildingService {
	void delete(Long[] ids);
	List<BuildingSearchResponse> findAll();
	BuildingDTO findById(Long id);
	void saveOrUpdate(BuildingDTO dto);
	List<BuildingSearchResponse> findBuildings(BuildingSearchRequest searchModel);
	void assignBuilding(List<Long> staffIds, Long buildingId);
}
