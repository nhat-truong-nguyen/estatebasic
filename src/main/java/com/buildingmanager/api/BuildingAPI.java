package com.buildingmanager.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.buildingmanager.dto.BuildingDTO;
import com.buildingmanager.dto.UserDTO;
import com.buildingmanager.entity.BuildingEntity;
import com.buildingmanager.model.response.BuildingSearchResponse;
import com.buildingmanager.service.BuildingService;
import com.buildingmanager.service.UserService;

@RestController
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;
	
	@Autowired
	private UserService userService;

	@GetMapping("/api/building")
	public List<BuildingSearchResponse> findBuildings(@RequestParam Map<String, String> params, @RequestParam("rentType") List<String> rentTypes) {
		return buildingService.findBuildings(params, rentTypes);
	}
	
	@GetMapping("/api/staffs-list")
	public List<UserDTO> findAllStaffs() {
		return userService.findAllStaff();
	}
	
	@GetMapping("/api/staffs")
	public List<UserDTO> findStaffByBuildingId(@RequestParam("buildingId") Long buildingId) {
		return userService.findStaffsByBuildingId(buildingId);
	}
	
	@PostMapping("/api/building")
	public void saveBuilding(@RequestBody BuildingEntity buildingEntity) {
		buildingService.save(buildingEntity);
	}
	
	@DeleteMapping("/api/building")
	public void deleteBuilding(@RequestBody Long[] ids) {
		buildingService.delete(ids);
	}
	
	@PutMapping("/api/building")
	public void updateBuilding(@RequestBody BuildingDTO dto) {
		buildingService.update(dto);
	}
	
}
