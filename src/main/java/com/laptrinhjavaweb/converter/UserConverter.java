package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO convertToDto (UserEntity entity){
        UserDTO result = modelMapper.map(entity, UserDTO.class);
        return result;
    }

    public UserEntity convertToEntity (UserDTO dto){
        UserEntity result = modelMapper.map(dto, UserEntity.class);
        return result;
    }
    
	public List<UserDTO> toListBuildingDTO(List<UserEntity> listUserEntity) {
		List<UserDTO> listUsers = new ArrayList<UserDTO>();
		
		listUsers = listUserEntity.stream().map(entity -> this.convertToDto(entity))
		                  .collect(Collectors.toList());

		return listUsers;
	}
}
