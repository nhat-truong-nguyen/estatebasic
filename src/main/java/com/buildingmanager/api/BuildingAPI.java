package com.buildingmanager.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.buildingmanager.entity.BuildingEntity;
import com.buildingmanager.model.response.BuildingSearchResponse;
import com.buildingmanager.repository.BuildingRepository;
import com.buildingmanager.service.BuildingService;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {

	@Autowired
	BuildingService buildingService;

	@GetMapping
	public List<BuildingSearchResponse> findBuildings(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "floorArea", required = false) Integer floorArea,
			@RequestParam(value = "districtId", required = false) Integer districtId,
			@RequestParam(value = "ward", required = false) String ward,
			@RequestParam(value = "street", required = false) String street,
			@RequestParam(value = "numberOfBasement", required = false) Integer numberOfBasement,
			@RequestParam(value = "direction", required = false) String direction,
			@RequestParam(value = "level", required = false) String level,
			@RequestParam(value = "rentAreaFrom", required = false) Integer rentAreaFrom,
			@RequestParam(value = "rentAreaTo", required = false) Integer rentAreaTo,
			@RequestParam(value = "rentPriceFrom", required = false) Integer rentPriceFrom,
			@RequestParam(value = "rentPriceTo", required = false) Integer rentPriceTo,
			@RequestParam(value = "rentTypeIds", required = false) Integer[] rentTypeIds) {

		if (!name.isEmpty() && floorArea != null && districtId != null && !ward.isEmpty() && !street.isEmpty()
				&& numberOfBasement != null && !direction.isEmpty() && !level.isEmpty()
				&& rentPriceFrom != null && rentPriceTo != null && rentAreaFrom != null && rentAreaTo != null
				&& rentTypeIds != null) {
			
			return buildingService.findByFullCondition(name, floorArea,
					districtId, ward, street, numberOfBasement, direction,
					level, rentPriceFrom, rentPriceTo, rentAreaFrom, rentAreaTo, rentTypeIds);
		}
		
		if (!name.isEmpty()) {
			return buildingService.findByName(name);
		}

		if (floorArea != null) {
			return buildingService.findByFloorArea(floorArea);
		}

		if (districtId != null) {
			return buildingService.findByDistrictId(districtId);
		}

		if (!ward.isEmpty()) {
			return buildingService.findByWard(ward);
		}

		if (!street.isEmpty()) {
			return buildingService.findByStreet(street);
		}

		if (numberOfBasement != null) {
			return buildingService.findByNumberOfBasement(numberOfBasement);
		}

		if (!direction.isEmpty()) {
			return buildingService.findByDirection(direction);
		}

		if (!level.isEmpty()) {
			return buildingService.findByLevel(level);
		}

		if (rentPriceFrom != null && rentPriceTo != null) {
			return buildingService.findByRentPriceFromTo(rentPriceFrom, rentPriceTo);
		} else if (rentPriceFrom != null) {
			return buildingService.findByRentPriceFrom(rentPriceFrom);
		} else if (rentPriceTo != null) {
			return buildingService.findByRentPriceTo(rentPriceTo);
		}

		if (rentAreaFrom != null && rentAreaTo != null) {
			return buildingService.findByRentAreaFromTo(rentAreaFrom, rentAreaTo);
		}
		if (rentAreaFrom != null) {
			return buildingService.findByRentAreaFrom(rentAreaFrom);
		} else if (rentAreaTo != null) {
			return buildingService.findByRentAreaTo(rentAreaTo);
		}

		if (rentTypeIds != null) {
			return buildingService.findByRentTypeId(rentTypeIds);
		}
		
		return null;
	}
}
