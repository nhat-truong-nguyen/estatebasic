package com.buildingmanager.repository.custom;

import java.util.List;
import java.util.Map;

import com.buildingmanager.entity.BuildingEntity;

public interface BuildingRepositoryCustom {
	List<BuildingEntity> findBuildings(Map<String, String> params, List<String> rentTypes);
	void save(BuildingEntity buildingEntity);
	void delete(Long[] ids);
	void update(BuildingEntity buildingEntity);
	void deleteBuildingAssignment(Long id);
}
