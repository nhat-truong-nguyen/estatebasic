package com.buildingmanager.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.buildingmanager.converter.BuildingConverter;
import com.buildingmanager.dto.BuildingDTO;
import com.buildingmanager.entity.BuildingEntity;
import com.buildingmanager.enums.BuildingTypeEnum;
import com.buildingmanager.enums.DistrictEnum;
import com.buildingmanager.model.response.BuildingSearchResponse;
import com.buildingmanager.service.BuildingService;
import com.buildingmanager.service.UserService;

@Controller(value = "homeControllerOfAdmin")
public class BuildingController {
	@Autowired
	private BuildingService buildingService;

	@Autowired
	private UserService userService;

	@Autowired
	BuildingConverter buildingConverter;

	@GetMapping("/admin/building-list")
	public ModelAndView buildingSearchForm(HttpSession session) {
		ModelAndView mav = new ModelAndView("admin/building-search");
		mav.addObject("userLogin", session.getAttribute("userLogin")).addObject("districts", DistrictEnum.values())
				.addObject("rentTypes", BuildingTypeEnum.values()).addObject("staffs", userService.findAllStaff())
				.addObject("buildings", buildingService.findAll());
		return mav;
	}

	@GetMapping("/admin/building-search")
	public ModelAndView buildingSearchList(@RequestParam Map<String, String> params,
			@RequestParam("rentType") List<String> rentTypes) {
		ModelAndView mav = new ModelAndView("admin/building-search");
		List<BuildingSearchResponse> buildings = buildingService.findBuildings(params, rentTypes);
		mav.addObject("districts", DistrictEnum.values()).addObject("rentTypes", BuildingTypeEnum.values())
				.addObject("staffs", userService.findAllStaff()).addObject("buildings", buildings);
		return mav;
	}

	@GetMapping("/admin/building-field-form")
	public ModelAndView buildingFieldForm() {
		ModelAndView mav = new ModelAndView("admin/building-form");
		mav.addObject("districts", DistrictEnum.values()).addObject("rentTypes", BuildingTypeEnum.values());
		return mav;
	}

	@GetMapping("/admin/building-update")
	public ModelAndView buildingUpdateForm(@RequestParam("id") Long buildingId) {
		ModelAndView mav = new ModelAndView("admin/building-form");
		mav.addObject("districts", DistrictEnum.values()).addObject("rentTypes", BuildingTypeEnum.values())
				.addObject("building", buildingService.findById(buildingId));
		return mav;
	}

	@PostMapping("/admin/building-update")
	public ModelAndView updateBuilding(@ModelAttribute("buildingModel") BuildingDTO dto) {
		ModelAndView mav = new ModelAndView("redirect:/admin/building-list");
		buildingService.update(dto);
		return mav;
	}

	@PostMapping("/admin/building-save")
	public ModelAndView saveBuilding(@ModelAttribute("buildingModel") BuildingDTO dto) {
		BuildingEntity buildingEntity = buildingConverter.toBuildingEntity(dto);
		ModelAndView mav = new ModelAndView("redirect:/admin/building-list");
		buildingService.save(buildingEntity);
		return mav;
	}

	@PostMapping("/admin/building-delete")
	public ModelAndView delete(@RequestParam("ids") Long[] ids) {
		ModelAndView mav = new ModelAndView("redirect:/admin/building-list");
		buildingService.delete(ids);
		return mav;
	}

	@PostMapping("/admin/assign-building")
	public ModelAndView assignBuilding(@RequestParam("staffIds") Long[] staffIds,
			@RequestParam("buildingId") Long buildingId) {
		ModelAndView mav = new ModelAndView("redirect:/admin/building-list");
		buildingService.assignBuilding(staffIds, buildingId);
		return mav;
	}
}
