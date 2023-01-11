package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.converter.CustomerConverter;
import com.laptrinhjavaweb.converter.TransactionConverter;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.entity.TransactionEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.model.request.CustomerSearchRequest;
import com.laptrinhjavaweb.model.request.TransactionRequest;
import com.laptrinhjavaweb.model.response.CustomerSearchResponse;
import com.laptrinhjavaweb.repository.CustomerRepository;
import com.laptrinhjavaweb.repository.TransactionRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.repository.custom.CustomerRepositoryCustom;
import com.laptrinhjavaweb.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerRepositoryCustom customerRepositoryCustom;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private CustomerConverter customerConverter;
	
	@Autowired
	private TransactionConverter transactionConverter;
	
	@Override
	public List<TransactionDTO> findTransactionsByTypeAndCustomer_Id(String type, Long customerId) {
		return transactionConverter.converToDTO(transactionRepository.findTransactionsByTypeAndCustomer_Id(type, customerId));
	}
	
	@Override
	public List<CustomerSearchResponse> findCustomers(CustomerSearchRequest searchModel) {
		return customerConverter.toListCustomerSearchResponse(customerRepositoryCustom.findCustomers(searchModel));
	}
	
	@Override
	public List<CustomerSearchResponse> findAll() {
		return customerConverter.toListCustomerSearchResponse(customerRepository.findAll());
	}
	
	@Override
	public void saveOrUpdate(CustomerDTO dto) {
		CustomerEntity entity = customerConverter.convertToEntity(dto);
		
		if (entity.getId() != null) {
			entity.setUsers(userRepository.findStaffsByCustomers_Id(entity.getId()));
		}
		
		customerRepository.save(entity);
	}
	
	@Override
	@Transactional
	public void delete(Long[] ids) {
		customerRepository.deleteByIdIn(ids);
	}
	
	@Override
	public CustomerDTO findById(Long id) {
		return customerConverter.convertToDto(customerRepository.findOne(id));
	}
	
	@Override
	@Transactional
	public void assignCustomer(List<Long> staffIds, Long customerId) {
		CustomerEntity customer = customerRepository.findOne(customerId);
		
		List<UserEntity> staffs = new ArrayList<>();
		if (staffIds != null) {
			staffs = userRepository.findByIdIn(staffIds);	
		}
			
		customer.setUsers(staffs);
		
		customerRepository.save(customer);
	}
	
	@Override
	@Transactional
	public void addTransaction(TransactionRequest dto) {
		TransactionEntity entity = transactionConverter.convertToEntity(dto);
		transactionRepository.save(entity);
	}
}
