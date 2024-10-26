package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.model.request.CustomerSearchRequest;
import com.laptrinhjavaweb.model.request.TransactionRequest;
import com.laptrinhjavaweb.model.response.CustomerSearchResponse;

public interface ICustomerService {

	List<CustomerSearchResponse> findAll();

	void saveOrUpdate(CustomerDTO dto);

	CustomerDTO findById(Long id);

	void delete(Long[] ids);

	void assignCustomer(List<Long> staffIds, Long customerId);

	List<CustomerSearchResponse> findCustomers(CustomerSearchRequest searchModel);

	void addTransaction(TransactionRequest dto);

	List<TransactionDTO> findTransactionsByTypeAndCustomer_Id(String type, Long userId);

	List<CustomerSearchResponse> findCustomersByUser_Id(Long id);
}
