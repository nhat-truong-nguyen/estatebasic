package com.buildingmanager.repository;

import org.springframework.stereotype.Repository;

import com.buildingmanager.entity.DistrictEntity;

public interface DistrictRepository {
	DistrictEntity findDistrictById(Long id);
}
