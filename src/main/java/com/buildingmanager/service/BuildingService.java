package com.buildingmanager.service;

import java.util.List;

import com.buildingmanager.entity.BuildingEntity;
import com.buildingmanager.model.response.BuildingSearchResponse;

public interface BuildingService {
	List<BuildingSearchResponse> findByName(String name);

	List<BuildingSearchResponse> findByFloorArea(Integer floorArea);

	List<BuildingSearchResponse> findByDistrictId(Integer districtId);

	List<BuildingSearchResponse> findByWard(String ward);

	List<BuildingSearchResponse> findByStreet(String street);

	List<BuildingSearchResponse> findByNumberOfBasement(Integer numberOfBasement);

	List<BuildingSearchResponse> findByDirection(String direction);

	List<BuildingSearchResponse> findByLevel(String level);

	List<BuildingSearchResponse> findByRentPriceFrom(Integer rentPriceFrom);

	List<BuildingSearchResponse> findByRentPriceTo(Integer rentPriceTo);

	List<BuildingSearchResponse> findByRentPriceFromTo(Integer rentPriceFrom, Integer rentPriceTo);

	List<BuildingSearchResponse> findByRentAreaFrom(Integer rentAreaFrom);

	List<BuildingSearchResponse> findByRentAreaTo(Integer rentAreaTo);

	List<BuildingSearchResponse> findByRentAreaFromTo(Integer rentAreaFrom, Integer rentAreaTo);

	List<BuildingSearchResponse> findByRentTypeId(Integer[] rentTypeIds);

	List<BuildingSearchResponse> findByFullCondition(String name, Integer floorArea, Integer districtId, String ward,
			String street, Integer numberOfBasement, String direction, String level, Integer rentPriceFrom,
			Integer rentPriceTo, Integer rentAreaFrom, Integer rentAreaTo, Integer[] rentTypeIds);
}
