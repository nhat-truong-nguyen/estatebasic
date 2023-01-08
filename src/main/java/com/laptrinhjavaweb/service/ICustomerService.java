package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.CustomerDTO;

public interface ICustomerService {

	List<CustomerDTO> findCustomersByFullnameLike(String name);

	List<CustomerDTO> findAll();

}
