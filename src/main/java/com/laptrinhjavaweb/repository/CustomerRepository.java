package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{
	List<CustomerEntity> findCustomersByFullNameLike(String name);
	void deleteByIdIn(Long[] ids);
	List<CustomerEntity> findCustomersByUsers_Id(Long id);
}
