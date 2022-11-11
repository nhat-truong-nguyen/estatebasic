package com.buildingmanager.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.buildingmanager.entity.BuildingEntity;
import com.buildingmanager.mapper.Impl.BuildingEntityMapper;
import com.buildingmanager.repository.BuildingRepository;

@Repository
public class BuildingRepositoryImpl extends BaseRepositoryImpl<BuildingEntity> implements BuildingRepository {

	@Override
	public List<BuildingEntity> findAllByName(String name) {
		String sql = "SELECT * FROM building WHERE name like ?";
		name = "%" + name + "%";
		return query(sql, new BuildingEntityMapper(), name);
	}

}
