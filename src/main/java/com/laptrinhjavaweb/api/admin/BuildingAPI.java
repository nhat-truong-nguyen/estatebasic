package com.laptrinhjavaweb.api.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.model.response.BuildingSearchResponse;
import com.laptrinhjavaweb.service.impl.BuildingService;
import com.laptrinhjavaweb.service.impl.UserService;

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
	
	@RequestMapping(value = "/api/building", method = {RequestMethod.POST, RequestMethod.PUT})
	public void saveBuilding(@RequestBody BuildingDTO dto) {
		buildingService.saveOrUpdate(dto);
	}
	
	@DeleteMapping("/api/building")
	public void deleteBuilding(@RequestBody Long[] ids) {
		buildingService.delete(ids);
	}
}
