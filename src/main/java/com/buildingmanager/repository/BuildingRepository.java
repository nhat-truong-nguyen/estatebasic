package com.buildingmanager.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buildingmanager.entity.BuildingEntity;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Integer>{
	List<BuildingEntity> findBuildings(Map<String, String> params, List<String> rentTypes);
}
