package com.buildingmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buildingmanager.converter.UserConverter;
import com.buildingmanager.dto.UserDTO;
import com.buildingmanager.repository.custom.UserRepositoryCustom;
import com.buildingmanager.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepositoryCustom userRepositoryCustom;
	
	@Autowired
	private UserConverter userConverter;

	@Override
	public List<UserDTO> findAllStaff() {
		return userConverter.toListBuildingDTO(userRepositoryCustom.findAllStaffs());
	}

	@Override
	public List<UserDTO> findStaffsByBuildingId(Long buildingId) {
		return  userConverter.toListBuildingDTO(userRepositoryCustom.findStaffsByBuildingId(buildingId));
	}
}
