//package com.buildingmanager.api;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.buildingmanager.entity.BuildingEntityCustom;
//import com.buildingmanager.model.response.BuildingSearchResponse;
//import com.buildingmanager.repository.impl.BaseRepositoryImpl;
//import com.buildingmanager.service.BuildingService;
//
//@RestController
//@RequestMapping("/api/building")
//public class BuildingAPI {
//	@Autowired
//	BuildingService buildingService;
//
//	@GetMapping
//	public List<BuildingSearchResponse> findBuildings(@RequestParam Map<String, String> params, @RequestParam("rentType") List<String> rentTypes) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		Integer abc = (Integer) map.get("abc");
//		String abc1 = (String) map.get("abc");
//		return buildingService.findBuildings(params, rentTypes);
//	}
//}
