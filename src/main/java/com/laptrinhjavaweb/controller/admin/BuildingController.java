package com.laptrinhjavaweb.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.enums.BuildingTypeEnum;
import com.laptrinhjavaweb.enums.DistrictEnum;
import com.laptrinhjavaweb.model.request.BuildingSearchRequest;
import com.laptrinhjavaweb.model.response.BuildingSearchResponse;
import com.laptrinhjavaweb.security.utils.SecurityUtils;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.impl.UserService;

@Controller
@RequestMapping("/admin")
public class BuildingController {
	@Autowired
	private IBuildingService buildingService;

	@Autowired
	private UserService userService;

	@Autowired
	BuildingConverter buildingConverter;

	@GetMapping("/building-list")
	public ModelAndView buildingSearchForm(@ModelAttribute("searchModel") BuildingSearchRequest searchModel) {
		List<BuildingSearchResponse> listBuildings = new ArrayList<BuildingSearchResponse>();
		
		if (SecurityUtils.getAuthorities().contains("ROLE_STAFF")) {
			listBuildings = buildingService.findBuildingsByUsers_Id(SecurityUtils.getPrincipal().getId());
		} else {
			listBuildings = buildingService.findAll();
		}
		
		ModelAndView mav = new ModelAndView("admin/building-list");
		mav.addObject("searchModel", searchModel).addObject("districts", DistrictEnum.values())
				.addObject("rentTypes", BuildingTypeEnum.values()).addObject("staffs", userService.findAllStaffs())
				.addObject("buildings", listBuildings);
		return mav;
	}

	@GetMapping("/building-search")
	public ModelAndView buildingSearchList(@ModelAttribute("searchModel") BuildingSearchRequest searchModel) {
		if (SecurityUtils.getAuthorities().contains("ROLE_STAFF")) {
			searchModel.setStaffId(SecurityUtils.getPrincipal().getId());
		}
		
		ModelAndView mav = new ModelAndView("admin/building-list");
		List<BuildingSearchResponse> buildings = buildingService.findBuildings(searchModel);
		mav.addObject("searchModel", searchModel).addObject("districts", DistrictEnum.values())
				.addObject("rentTypes", BuildingTypeEnum.values()).addObject("staffs", userService.findAllStaffs())
				.addObject("buildings", buildings);
		return mav;
	}

	@GetMapping("/building-save")
	public ModelAndView buildingFieldForm() {
		ModelAndView mav = new ModelAndView("admin/building-form");
		mav.addObject("districts", DistrictEnum.values()).addObject("rentTypes", BuildingTypeEnum.values());
		return mav;
	}

	@GetMapping("/building-update")
	public ModelAndView buildingUpdateForm(@RequestParam("id") Long buildingId) {
		ModelAndView mav = new ModelAndView("admin/building-form");
		mav.addObject("districts", DistrictEnum.values()).addObject("rentTypes", BuildingTypeEnum.values())
				.addObject("building", buildingService.findById(buildingId));
		return mav;
	}

	@PostMapping(value = { "/building-update", "/building-save" })
	public ModelAndView updateBuilding(@ModelAttribute("buildingModel") BuildingDTO dto) {
		buildingService.saveOrUpdate(dto);
		ModelAndView mav = new ModelAndView("redirect:building-list");
		return mav;
	}

	@PostMapping("/building-delete")
	public ModelAndView delete(@RequestParam("ids") Long[] ids) {
		ModelAndView mav = new ModelAndView("redirect:building-list");
		buildingService.delete(ids);
		return mav;
	}

	@PostMapping("/assign-building")
	public ModelAndView assignBuilding(@RequestParam(name = "staffIds", required=false) List<Long> staffIds,
			@RequestParam("buildingId") Long buildingId) {
		ModelAndView mav = new ModelAndView("redirect:/admin/building-list");
		buildingService.assignBuilding(staffIds, buildingId);
		return mav;
	}
}
