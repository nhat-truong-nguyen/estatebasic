package com.buildingmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buildingmanager.entity.RentAreaEntity;

@Repository
public interface RentAreaRepository extends JpaRepository<RentAreaEntity, Long>{
	void deleteByBuilding(Long id);
}
