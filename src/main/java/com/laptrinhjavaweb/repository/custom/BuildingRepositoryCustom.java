package com.laptrinhjavaweb.repository.custom;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.model.request.BuildingSearchRequest;

public interface BuildingRepositoryCustom {
	void deleteBuildingAssignment(Long id);
	void saveAssignmentBuilding(Long[] staffIds, Long buildingId);
	void delete(Long[] ids);
	void update(BuildingEntity buildingEntity);
	List<BuildingEntity> findBuildings(BuildingSearchRequest searchModel);
}
