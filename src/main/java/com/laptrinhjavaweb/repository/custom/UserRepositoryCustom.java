package com.laptrinhjavaweb.repository.custom;

import java.util.List;

import com.laptrinhjavaweb.entity.UserEntity;

public interface UserRepositoryCustom {
	List<UserEntity> findAllStaffs();
	List<UserEntity> findStaffsByBuildingId(Long buildingId);
}
