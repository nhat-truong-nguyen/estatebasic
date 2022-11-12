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
		String sql = "SELECT * FROM building WHERE level = ?";
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

	@Override
	public List<BuildingEntity> findByRentAreaFrom(Integer rentAreaFrom) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT building.* FROM building ");
		sql.append("JOIN rentarea ON rentarea.buildingid = building.id ");
		sql.append("WHERE rentarea.value >= ? GROUP BY building.id");
		return query(sql.toString(), new BuildingEntityMapper(), rentAreaFrom);
	}

	@Override
	public List<BuildingEntity> findByRentAreaTo(Integer rentAreaTo) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT building.* FROM building ");
		sql.append("JOIN rentarea ON rentarea.buildingid = building.id ");
		sql.append("WHERE rentarea.value <= ? GROUP BY building.id");
		return query(sql.toString(), new BuildingEntityMapper());
	}

	@Override
	public List<BuildingEntity> findByRentAreaFromTo(Integer rentAreaFrom, Integer rentAreaTo) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT building.* FROM building ");
		sql.append("JOIN rentarea ON rentarea.buildingid = building.id ");
		sql.append("WHERE rentarea.value >= ? AND rentarea.value <= ? GROUP BY building.id");
		return query(sql.toString(), new BuildingEntityMapper(), rentAreaFrom, rentAreaTo);
	}

	@Override
	public List<BuildingEntity> findByRentTypeId(Integer[] rentTypeIds) {
		String bindParams = "";

		for (int i = 0; i < rentTypeIds.length; i++) {
			bindParams += "?, ";
		}

		bindParams = bindParams.substring(0, bindParams.length() - 2);

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM building ");
		sql.append("WHERE building.id ");
		sql.append("IN (SELECT buildingrenttype.buildingid FROM buildingrenttype ");
		sql.append(String.format("WHERE buildingrenttype.renttypeid IN(%s))", bindParams));
		return query(sql.toString(), new BuildingEntityMapper(), (Object) rentTypeIds);
	}

	@Override
	public List<BuildingEntity> findByFullCondition(String name, Integer floorArea, Integer districtId, String ward,
			String street, Integer numberOfBasement, String direction, String level, Integer rentPriceFrom,
			Integer rentPriceTo, Integer rentAreaFrom, Integer rentAreaTo, Integer[] rentTypeIds) {

		String bindParams = "";

		for (int i = 0; i < rentTypeIds.length; i++) {
			bindParams += "?, ";
		}
		
		bindParams = bindParams.substring(0, bindParams.length() - 2);

		name = "%" + name + "%";
		ward = "%" + ward + "%";
		street = "%" + street + "%";
		direction = "%" + direction + "%";
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM building ");
		sql.append("JOIN rentarea on building.id = rentarea.buildingid ");
		sql.append("WHERE building.name LIKE ? AND building.floorarea = ? ");
		sql.append("AND building.districtid = ? AND building.ward LIKE ? ");
		sql.append("AND building.street LIKE ? AND building.numberofbasement= ? ");
		sql.append("AND building.direction LIKE ? AND building.level = ? ");
		sql.append("AND building.rentprice >= ? AND building.rentprice <= ? ");
		sql.append("AND rentarea.value >= ? AND rentarea.value <= ? ");
		sql.append("AND building.id IN(SELECT buildingrenttype.buildingid FROM buildingrenttype ");
		sql.append(String.format("WHERE buildingrenttype.renttypeid IN(%s)) ", bindParams));
		sql.append("GROUP BY building.id");
		
		return query(sql.toString(), new BuildingEntityMapper(), name, floorArea, districtId, ward, street,
				numberOfBasement, direction, level, rentPriceFrom, rentPriceTo, rentAreaFrom, rentAreaTo,
				(Object) rentTypeIds);
	}

}
