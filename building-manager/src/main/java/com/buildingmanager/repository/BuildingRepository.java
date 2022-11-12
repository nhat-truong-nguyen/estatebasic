package com.buildingmanager.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.buildingmanager.entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> findByName(String name);

	List<BuildingEntity> findByFloorArea(Integer floorArea);

	List<BuildingEntity> findByDistrictId(Integer districtId);

	List<BuildingEntity> findByWard(String ward);

	List<BuildingEntity> findByStreet(String street);

	List<BuildingEntity> findByNumberOfBasement(Integer numberOfBasement);

	List<BuildingEntity> findByDirection(String direction);

	List<BuildingEntity> findByLevel(String level);

	List<BuildingEntity> findByRentPriceFrom(Integer rentPriceFrom);

	List<BuildingEntity> findByRentPriceTo(Integer rentPriceTo);

	List<BuildingEntity> findByRentPriceFromTo(Integer rentPriceFrom, Integer rentPriceTo);

	List<BuildingEntity> findByRentAreaFrom(Integer rentAreaFrom);

	List<BuildingEntity> findByRentAreaTo(Integer rentAreaTo);

	List<BuildingEntity> findByRentAreaFromTo(Integer rentAreaFrom, Integer rentAreaTo);

	List<BuildingEntity> findByRentTypeId(Integer[] rentTypeIds);

	List<BuildingEntity> findByFullCondition(String name, Integer floorArea, Integer districtId, String ward,
			String street, Integer numberOfBasement, String direction, String level, Integer rentPriceFrom,
			Integer rentPriceTo, Integer rentAreaFrom, Integer rentAreaTo, Integer[] rentTypeIds);
}
