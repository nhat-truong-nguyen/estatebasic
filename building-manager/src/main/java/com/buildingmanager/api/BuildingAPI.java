package com.buildingmanager.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buildingmanager.entity.BuildingEntity;
import com.buildingmanager.repository.BuildingRepository;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {
	
	@Autowired
	BuildingRepository buildingRepository;
	
	@GetMapping
	public List<BuildingEntity> findBuildings() {
		return buildingRepository.findAllByName("u");
	}
}
