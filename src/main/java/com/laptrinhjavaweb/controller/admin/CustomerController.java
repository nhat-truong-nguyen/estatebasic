package com.laptrinhjavaweb.controller.admin;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.enums.TransactionTypeEnum;
import com.laptrinhjavaweb.model.request.CustomerSearchRequest;
import com.laptrinhjavaweb.model.request.TransactionRequest;
import com.laptrinhjavaweb.security.utils.SecurityUtils;
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
	
	@GetMapping("/customer-search")
	public ModelAndView renderCustomerSearchList(@ModelAttribute("searchModel") CustomerSearchRequest searchModel) {
		ModelAndView mav = new ModelAndView("admin/customer-list")
				.addObject("customers", customerService.findCustomers(searchModel))
				.addObject("searchModel", searchModel)
				.addObject("staffs", userService.findAllStaffs());
		return mav;
	}

	@GetMapping("/customer-form")
	public ModelAndView renderCustomerForm() {
		ModelAndView mav = new ModelAndView("admin/customer-form")
				.addObject("transactions", TransactionTypeEnum.values());
		return mav;
	}
	
	@GetMapping("/customer-update")
	public ModelAndView renderCustomerUpdatePage(@RequestParam("id") long id) {
		ModelAndView mav = new ModelAndView("admin/customer-form")
				.addObject("customer", customerService.findById(id))
				.addObject("transactions", Arrays.asList(TransactionTypeEnum.values()))
				.addObject("customerService", customerService);
		return mav;
	}
	
	@PostMapping({"/customer-save", "/customer-update"})
	public ModelAndView addCustomer(@ModelAttribute("model") CustomerDTO dto) {
		customerService.saveOrUpdate(dto);
		ModelAndView mav = new ModelAndView("redirect:/admin/customer-list");
		return mav;
	}
	
	@PostMapping("/customer-delete")
	public ModelAndView delete(@RequestParam("ids") Long[] ids) {
		customerService.delete(ids);
		ModelAndView mav = new ModelAndView("redirect:/admin/customer-list");
		return mav;
	}
	
	@PostMapping("/assign-customer")
	public ModelAndView assignBuilding(@RequestParam(name = "staffIds", required=false) List<Long> staffIds,
			@RequestParam("customerId") Long customerId) {
		ModelAndView mav = new ModelAndView("redirect:/admin/customer-list");
		customerService.assignCustomer(staffIds, customerId);
		return mav;
	}
	
	@PostMapping("/transaction-add")
	public ModelAndView assignBuilding(@ModelAttribute("model") TransactionRequest dto) {
		dto.setStaffId(SecurityUtils.getPrincipal().getId());
		customerService.addTransaction(dto);
		ModelAndView mav = new ModelAndView("redirect:/admin/customer-update?id=" + dto.getCustomerId());
		return mav;
	}
}
