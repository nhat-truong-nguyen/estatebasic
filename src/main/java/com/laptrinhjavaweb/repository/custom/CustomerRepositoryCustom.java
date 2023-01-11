package com.laptrinhjavaweb.repository.custom;

import java.util.List;

import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.model.request.CustomerSearchRequest;

public interface CustomerRepositoryCustom {
	List<CustomerEntity> findCustomers(CustomerSearchRequest searchRequest);
}
