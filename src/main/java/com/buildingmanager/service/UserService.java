package com.buildingmanager.service;

import java.util.List;

import com.buildingmanager.dto.UserDTO;

public interface UserService {
	List<UserDTO> findAllStaff();
	List<UserDTO> findStaffsByBuildingId(Long buildingId);
	UserDTO doAuthentication();
}
