package com.buildingmanager.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.buildingmanager.entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> findAllByName(String name);
}
