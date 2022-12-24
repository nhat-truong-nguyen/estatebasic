package com.laptrinhjavaweb.repository.custom;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.entity.BuildingEntity;

public interface BuildingRepositoryCustom {
	List<BuildingEntity> findBuildings(Map<String, String> params, List<String> rentTypes);
	void deleteBuildingAssignment(Long id);
	void saveAssignmentBuilding(Long[] staffIds, Long buildingId);
	void delete(Long[] ids);
	void update(BuildingEntity buildingEntity);
}
