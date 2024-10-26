package com.laptrinhjavaweb.api.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.impl.UserService;

@RestController
public class CustomerAPI {
	@Autowired
	private UserService userService;

	@GetMapping("/api/customer-staffs")
	public List<UserDTO> findStaffByCustomerId(@RequestParam("customerId") Long customerId) {
		return userService.findStaffsByCustomerId(customerId);
	}
}
