package com.buildingmanager.service;

import java.util.List;
import java.util.Map;

import com.buildingmanager.model.response.BuildingSearchResponse;

public interface BuildingService {
	List<BuildingSearchResponse> findBuildings(Map<String, String> params, List<String> rentTypes);
}
