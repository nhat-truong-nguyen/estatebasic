package com.buildingmanager.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.buildingmanager.entity.BuildingEntity;
import com.buildingmanager.mapper.Impl.BuildingEntityMapper;
import com.buildingmanager.repository.BuildingRepository;

@Repository
public class BuildingRepositoryImpl extends BaseRepositoryImpl<BuildingEntity> implements BuildingRepository {

	@SuppressWarnings("unchecked")
	public List<BuildingEntity> findBuildings(Map<String, String> requestParams, List<String> rentTypes) {
		Map<String, Object> params = new HashMap<>();

		params.put("name", requestParams.get("name").isEmpty() ? null : "%" + requestParams.get("name") + "%");
		params.put("floorArea",
				requestParams.get("floorArea").isEmpty() ? null : Integer.valueOf(requestParams.get("floorArea")));
		params.put("districtId",
				requestParams.get("districtId").isEmpty() ? null : Integer.valueOf(requestParams.get("districtId")));
		params.put("ward", requestParams.get("ward").isEmpty() ? null : "%" + requestParams.get("ward") + "%");
		params.put("street", requestParams.get("street").isEmpty() ? null : "%" + requestParams.get("street") + "%");
		params.put("numberOfBasement", requestParams.get("numberOfBasement").isEmpty() ? null
				: Integer.valueOf(requestParams.get("numberOfBasement")));
		params.put("direction",
				requestParams.get("direction").isEmpty() ? null : "%" + requestParams.get("direction") + "%");
		params.put("level", requestParams.get("level").isEmpty() ? null : requestParams.get("level"));
		params.put("rentPriceFrom", requestParams.get("rentPriceFrom").isEmpty() ? null
				: Integer.valueOf(requestParams.get("rentPriceFrom")));
		params.put("rentPriceTo",
				requestParams.get("rentPriceTo").isEmpty() ? null : Integer.valueOf(requestParams.get("rentPriceTo")));
		params.put("rentAreaFrom", requestParams.get("rentAreaFrom").isEmpty() ? null
				: Integer.valueOf(requestParams.get("rentAreaFrom")));
		params.put("rentAreaTo",
				requestParams.get("rentAreaTo").isEmpty() ? null : Integer.valueOf(requestParams.get("rentAreaTo")));
		params.put("rentTypes", rentTypes);


		String bindParams = "";
		int numberEmptyTypesRequest = 0;

		for (int i = 0; i < rentTypes.size(); i++) {
				bindParams += "?, ";
				if (rentTypes.get(i).isBlank()) {
					numberEmptyTypesRequest++;
				}
		}

		bindParams = bindParams.substring(0, bindParams.length() - 2);
		params.put("bindParams", numberEmptyTypesRequest == rentTypes.size() ? null : bindParams);

		boolean isFullCondition = true;
		for (Map.Entry<String, Object> item : params.entrySet()) {
			if (item.getValue() == null) {
				isFullCondition = false;
				break;
			}
		}
		

		StringBuilder sql = new StringBuilder("SELECT building.* FROM building ");

		if (isFullCondition) {
			return findByFullCondition(params);
		}

		if (params.get("name") != null) {
			sql.append("WHERE name like ?");
			return query(sql.toString(), new BuildingEntityMapper(), params.get("name"));
		}

		if (params.get("floorArea") != null) {
			sql.append("WHERE floorarea = ?");
			return query(sql.toString(), new BuildingEntityMapper(), params.get("floorArea"));
		}

		if (params.get("districtId") != null) {
			sql.append("WHERE districtid = ?");
			return query(sql.toString(), new BuildingEntityMapper(), params.get("districtId"));
		}

		if (params.get("ward") != null) {
			sql.append("WHERE ward like ?");
			return query(sql.toString(), new BuildingEntityMapper(), params.get("ward"));
		}

		if (params.get("street") != null) {
			sql.append("WHERE street like ?");
			return query(sql.toString(), new BuildingEntityMapper(), params.get("street"));
		}

		if (params.get("numberOfBasement") != null) {
			sql.append("WHERE numberofbasement = ?");
			return query(sql.toString(), new BuildingEntityMapper(), params.get("numberOfBasement"));
		}

		if (params.get("direction") != null) {
			sql.append("WHERE direction like ?");
			return query(sql.toString(), new BuildingEntityMapper(), params.get("direction"));
		}

		if (params.get("level") != null) {
			sql.append("WHERE level = ?");
			return query(sql.toString(), new BuildingEntityMapper(), params.get("level"));
		}

		if (params.get("rentPriceFrom") != null || params.get("rentPriceTo") != null) {
			return findByRentPrice((Integer) params.get("rentPriceFrom"), (Integer) params.get("rentPriceTo"));
		}

		if (params.get("rentAreaFrom") != null || params.get("rentAreaTo") != null) {
			return findByRentArea((Integer) params.get("rentAreaFrom"), (Integer) params.get("rentAreaTo"));
		}

		if (params.get("bindParams") != null) {
			return findByRentType( (List<String>) params.get("rentTypes"), (String) params.get("bindParams"));
		}

		return null;
	}

	public List<BuildingEntity> findByRentPrice(Integer rentPriceFrom, Integer rentPriceTo) {
		StringBuilder sql = new StringBuilder("SELECT building.* FROM building ");

		if (rentPriceFrom != null && rentPriceTo != null) {
			sql.append("WHERE rentprice >= ? AND rentprice <= ?");
			return query(sql.toString(), new BuildingEntityMapper(), rentPriceFrom, rentPriceTo);
		}

		if (rentPriceFrom != null) {
			sql.append("WHERE rentprice >= ?");
			return query(sql.toString(), new BuildingEntityMapper(), rentPriceFrom);
		}

		sql.append("WHERE rentprice <= ?");
		return query(sql.toString(), new BuildingEntityMapper(), rentPriceTo);
	}

	public List<BuildingEntity> findByRentArea(Integer rentAreaFrom, Integer rentAreaTo) {
		StringBuilder sql = new StringBuilder("SELECT building.* FROM building ");

		sql.append("JOIN rentarea on building.id = rentarea.buildingid ");

		if (rentAreaFrom != null && rentAreaTo != null) {
			sql.append("WHERE rentarea.value >= ? AND rentarea.value <= ? GROUP BY building.id ");
			return query(sql.toString(), new BuildingEntityMapper(), rentAreaFrom, rentAreaTo);
		}

		if (rentAreaFrom != null) {
			sql.append("WHERE rentarea.value >= ? GROUP BY building.id ");
			return query(sql.toString(), new BuildingEntityMapper(), rentAreaFrom);
		}

		sql.append("WHERE rentarea.value <= ? GROUP BY building.id");
		return query(sql.toString(), new BuildingEntityMapper(), rentAreaTo);

	}

	public List<BuildingEntity> findByRentType(List<String> rentTypes, String bindParams) {

		StringBuilder sql = new StringBuilder("SELECT building.* FROM building ");

		sql.append("WHERE building.id ");
		sql.append("IN (SELECT buildingrenttype.buildingid FROM buildingrenttype ");
		sql.append("JOIN renttype on buildingrenttype.renttypeid = renttype.id ");
		sql.append(String.format("WHERE renttype.code IN(%s))", bindParams));

		return query(sql.toString(), new BuildingEntityMapper(), rentTypes);
	}

	public List<BuildingEntity> findByFullCondition(Map<String, Object> params) {
		StringBuilder sql = new StringBuilder("SELECT building.* FROM building ");
		sql.append("JOIN rentarea on building.id = rentarea.buildingid ");
		sql.append("WHERE building.name LIKE ? AND building.floorarea = ? ");
		sql.append("AND building.districtid = ? AND building.ward LIKE ? ");
		sql.append("AND building.street LIKE ? AND building.numberofbasement= ? ");
		sql.append("AND building.direction LIKE ? AND building.level = ? ");
		sql.append("AND building.rentprice >= ? AND building.rentprice <= ? ");
		sql.append("AND rentarea.value >= ? AND rentarea.value <= ? ");
		sql.append("AND building.id IN(SELECT buildingrenttype.buildingid FROM buildingrenttype ");
		sql.append("JOIN renttype on buildingrenttype.renttypeid = renttype.id ");
		sql.append(String.format("WHERE renttype.code IN(%s)) ", params.get("bindParams")));
		sql.append("GROUP BY building.id");

		return query(sql.toString(), new BuildingEntityMapper(), params.get("name"), params.get("floorArea"),
				params.get("districtId"), params.get("ward"), params.get("street"), params.get("numberOfBasement"),
				params.get("direction"), params.get("level"), params.get("rentPriceFrom"), params.get("rentPriceTo"),
				params.get("rentAreaFrom"), params.get("rentAreaTo"), params.get("rentTypes"));
	}

}
