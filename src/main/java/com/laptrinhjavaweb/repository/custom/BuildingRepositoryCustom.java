package com.laptrinhjavaweb.repository.custom;

import java.util.List;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.model.request.BuildingSearchRequest;

public interface BuildingRepositoryCustom {
	List<BuildingEntity> findBuildings(BuildingSearchRequest searchModel);
}
