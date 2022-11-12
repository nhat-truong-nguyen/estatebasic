package com.buildingmanager.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.buildingmanager.entity.BuildingEntity;
import com.buildingmanager.repository.BuildingRepository;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {
	
	@Autowired
	BuildingRepository buildingRepository;
	
	@GetMapping
	public List<BuildingEntity> findBuildings(
			@RequestParam(value = "name", required = false) String name, @RequestParam(value = "floorArea", required = false) Integer floorArea,
			@RequestParam(value = "districtId", required = false) Integer districtId, @RequestParam(value = "ward", required = false) String ward,
			@RequestParam(value = "street", required = false) String street, @RequestParam(value = "numberOfBasement", required = false) Integer numberOfBasement,
			@RequestParam(value = "direction", required = false) String direction, @RequestParam(value = "level", required = false) String level,
			@RequestParam(value = "rentAreaFrom", required = false) Integer rentAreaFrom, @RequestParam(value = "rentAreaTo", required = false) Integer rentAreaTo,
			@RequestParam(value = "rentPriceFrom", required = false) Integer rentPriceFrom, @RequestParam(value = "rentPriceTo", required = false) Integer rentPriceTo,
			@RequestParam(value = "rentTypeId", required = false) Integer rentTypeId) {
		
		if (!name.isEmpty()) {
			return buildingRepository.findByName(name);
		}
		
		if (floorArea != null) {
			return buildingRepository.findByFloorArea(floorArea);
		}
		
		if (districtId != null) {
			return buildingRepository.findByDistrictId(districtId);
		}
		
		if (!ward.isEmpty()) {
			return buildingRepository.findByWard(ward);
		}
		
		if (!street.isEmpty()) {
			return buildingRepository.findByStreet(street);
		}
		
		if (numberOfBasement != null) {
			return buildingRepository.findByNumberOfBasement(numberOfBasement);
		}
		
		if (!direction.isEmpty()) {
			return buildingRepository.findByDirection(direction);
		}
		
		if (!level.isEmpty()) {
			return buildingRepository.findByLevel(level);
		}
		
		if (rentPriceFrom != null && rentPriceTo != null) {
			return buildingRepository.findByRentPriceFromTo(rentPriceFrom, rentPriceTo);
		}
		else if (rentPriceFrom != null) {
			return buildingRepository.findByRentPriceFrom(rentPriceFrom);
		} else if (rentPriceTo != null){
			return buildingRepository.findByRentPriceTo(rentPriceTo);
		}
		
		return null;
	}
}
