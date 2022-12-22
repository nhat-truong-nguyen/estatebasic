package com.buildingmanager.repository.custom;

import java.util.List;

import com.buildingmanager.entity.UserEntity;

public interface UserRepositoryCustom {
	List<UserEntity> findAllStaffs();
	List<UserEntity> findStaffsByBuildingId(Long buildingId);
}
