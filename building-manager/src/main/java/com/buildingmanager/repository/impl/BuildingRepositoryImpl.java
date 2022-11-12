package com.buildingmanager.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.buildingmanager.entity.BuildingEntity;
import com.buildingmanager.mapper.Impl.BuildingEntityMapper;
import com.buildingmanager.repository.BuildingRepository;

@Repository
public class BuildingRepositoryImpl extends BaseRepositoryImpl<BuildingEntity> implements BuildingRepository {
	
	@Override
	public List<BuildingEntity> findByName(String name) {
		String sql = "SELECT * FROM building WHERE name like ?";
		name = "%" + name + "%";
		return query(sql, new BuildingEntityMapper(), name);
	}

	@Override
	public List<BuildingEntity> findByFloorArea(Integer floorArea) {
		String sql = "SELECT * FROM building WHERE floorarea = ?";
		return query(sql, new BuildingEntityMapper(), floorArea);
	}

	@Override
	public List<BuildingEntity> findByDistrictId(Integer districtId) {
		String sql = "SELECT * FROM building WHERE districtid = ?";
		return query(sql, new BuildingEntityMapper(), districtId);
	}

	@Override
	public List<BuildingEntity> findByWard(String ward) {
		String sql = "SELECT * FROM building WHERE ward like ?";
		ward = "%" + ward + "%";
		return query(sql, new BuildingEntityMapper(), ward);
	}

	@Override
	public List<BuildingEntity> findByStreet(String street) {
		String sql = "SELECT * FROM building WHERE street like ?";
		street = "%" + street + "%";
		return query(sql, new BuildingEntityMapper(), street);
	}

	@Override
	public List<BuildingEntity> findByNumberOfBasement(Integer numberOfBasement) {
		String sql = "SELECT * FROM building WHERE numberofbasement = ?";
		return query(sql, new BuildingEntityMapper(), numberOfBasement);
	}

	@Override
	public List<BuildingEntity> findByDirection(String direction) {
		String sql = "SELECT * FROM building WHERE direction like ?";
		direction = "%" + direction + "%";
		return query(sql, new BuildingEntityMapper(), direction);
	}

	@Override
	public List<BuildingEntity> findByLevel(String level) {
		String sql = "SELECT * FROM building WHERE level like ?";
		level = "%" + level + "%";
		return query(sql, new BuildingEntityMapper(), level);
	}

	@Override
	public List<BuildingEntity> findByRentPriceFrom(Integer rentPriceFrom) {
		String sql = "SELECT * FROM building WHERE rentprice >= ?";
		return query(sql, new BuildingEntityMapper(), rentPriceFrom);
	}

	@Override
	public List<BuildingEntity> findByRentPriceTo(Integer rentPriceTo) {
		String sql = "SELECT * FROM building WHERE rentprice <= ?";
		return query(sql, new BuildingEntityMapper(), rentPriceTo);
	}

	@Override
	public List<BuildingEntity> findByRentPriceFromTo(Integer rentPriceFrom, Integer rentPriceTo) {
		String sql = "SELECT * FROM building WHERE rentprice >= ? AND rentprice <= ?";
		return query(sql, new BuildingEntityMapper(), rentPriceFrom, rentPriceTo);
	}

}
