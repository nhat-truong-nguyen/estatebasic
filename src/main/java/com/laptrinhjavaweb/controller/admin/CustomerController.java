package com.laptrinhjavaweb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.laptrinhjavaweb.model.request.CustomerSearchRequest;
import com.laptrinhjavaweb.service.ICustomerService;
import com.laptrinhjavaweb.service.impl.UserService;

@Controller
@RequestMapping("/admin")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/customer-list")
	public ModelAndView renderCustomerList(@ModelAttribute("searchModel") CustomerSearchRequest searchModel) {
		ModelAndView mav = new ModelAndView("admin/customer-list")
				.addObject("customers", customerService.findAll())
				.addObject("searchModel", searchModel)
				.addObject("staffs", userService.findAllStaffs());
		return mav;
	}

	@GetMapping("/customer-form")
	public ModelAndView renderCustomerForm() {
		ModelAndView mav = new ModelAndView("admin/customer-form");
		return mav;
	}
}
