package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.BuildingEntity;

@Repository
public interface BuildingRepository extends JpaRepository<BuildingEntity, Long>{
	void deleteByIdIn(Long[] ids);
	BuildingEntity findById(Long id);
	List<BuildingEntity> findBuildingsByUsers_Id(Long id);
}

