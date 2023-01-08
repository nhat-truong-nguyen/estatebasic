package com.laptrinhjavaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.CustomerConverter;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.repository.CustomerRepository;
import com.laptrinhjavaweb.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerConverter customerConverter;
	
	@Override
	public List<CustomerDTO> findCustomersByFullnameLike(String name) {
		return customerConverter.toListCustomerDTO(customerRepository.findCustomersByFullNameLike(name));
	}
	
	@Override
	public List<CustomerDTO> findAll() {
		return customerConverter.toListCustomerDTO(customerRepository.findAll());
	}
}
