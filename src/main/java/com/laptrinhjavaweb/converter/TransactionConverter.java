package com.laptrinhjavaweb.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.entity.TransactionEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.model.request.TransactionRequest;

@Component
public class TransactionConverter {

    @Autowired
    private ModelMapper modelMapper;
    
    public TransactionEntity convertToEntity(TransactionRequest dto) {
    	UserEntity user = new UserEntity();
    	user.setId(dto.getStaffId());
    	
    	CustomerEntity customer = new CustomerEntity();
    	customer.setId(dto.getCustomerId());
    	
    	TransactionEntity entity = modelMapper.map(dto, TransactionEntity.class);
    	entity.setStaff(user);
    	entity.setCustomer(customer);
    	
		return entity;
    }
    
    public TransactionDTO convertToDTO(TransactionEntity entity) {
    	TransactionDTO dto = modelMapper.map(entity, TransactionDTO.class);
    	return dto;
    }
    
    public List<TransactionDTO> converToDTO(List<TransactionEntity> entities) {
    	return entities.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toList());
    }
}
