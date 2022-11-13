package com.buildingmanager.repository;

import java.util.List;
import java.util.Map;

import com.buildingmanager.entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> findBuildings(Map<String, String> params, List<String> rentTypes);
}
