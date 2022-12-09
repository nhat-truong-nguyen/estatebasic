package com.buildingmanager.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.buildingmanager.model.response.BuildingSearchResponse;
import com.buildingmanager.service.BuildingService;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {
	@Autowired
	BuildingService buildingService;

	@GetMapping
	public List<BuildingSearchResponse> findBuildings(@RequestParam Map<String, String> params, @RequestParam("rentType") List<String> rentTypes) {
		return buildingService.findBuildings(params, rentTypes);
	}
}
