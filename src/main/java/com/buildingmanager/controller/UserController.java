package com.buildingmanager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.buildingmanager.dto.UserDTO;

@Controller
public class UserController {
	@GetMapping("/login")
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login/login");
		return mav;
	}

	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute("userModel") UserDTO userDTO, HttpSession session) {
		ModelAndView mav = null;
		
		if (userDTO.getUsername().equalsIgnoreCase("admin") && userDTO.getPassword().equalsIgnoreCase("12345")) {
			session.setAttribute("userLogin", userDTO.getFullName());
			mav = new ModelAndView("redirect:/admin/building-list");
		} else {
			mav = new ModelAndView("redirect:/login");
		}
		
		return mav;
	}
}
