package com.buildingmanager.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.buildingmanager.dto.UserDTO;
import com.buildingmanager.entity.UserEntity;

@Component
public class UserConverter {
	@Autowired
	private ModelMapper modelMapper;
	
	public UserDTO toUserDTO(UserEntity entity) {
		UserDTO dto = modelMapper.map(entity, UserDTO.class);
		return dto;
	}
	
	public UserEntity toUserEntity(UserDTO dto) {
		UserEntity entity = modelMapper.map(dto, UserEntity.class);
		return entity;
	}
	
	public List<UserDTO> toListBuildingDTO(List<UserEntity> listUserEntity) {
		List<UserDTO> listUsers = new ArrayList<UserDTO>();
		
		listUsers = listUserEntity.stream().map(entity -> this.toUserDTO(entity))
		                  .collect(Collectors.toList());

		return listUsers;
	}
}
