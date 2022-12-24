package com.laptrinhjavaweb.controller.admin;

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

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.enums.BuildingTypeEnum;
import com.laptrinhjavaweb.enums.DistrictEnum;
import com.laptrinhjavaweb.model.response.BuildingSearchResponse;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.impl.UserService;

@Controller
public class BuildingController {
	@Autowired
	private IBuildingService buildingService;

	@Autowired
	private UserService userService;

	@Autowired
	BuildingConverter buildingConverter;

	@GetMapping("/admin/building-list")
	public ModelAndView buildingSearchForm(HttpSession session) {
		ModelAndView mav = new ModelAndView("admin/building-list");
		mav.addObject("districts", DistrictEnum.values())
				.addObject("rentTypes", BuildingTypeEnum.values()).addObject("staffs", userService.findAllStaff())
				.addObject("buildings", buildingService.findAll());
		return mav;
	}

	@GetMapping("/admin/building-search")
	public ModelAndView buildingSearchList(@RequestParam Map<String, String> params,
			@RequestParam("rentType") List<String> rentTypes) {
		ModelAndView mav = new ModelAndView("admin/building-list");
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
