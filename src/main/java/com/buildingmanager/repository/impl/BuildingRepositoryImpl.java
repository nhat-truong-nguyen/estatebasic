package com.buildingmanager.repository.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.buildingmanager.entity.BuildingEntity;
import com.buildingmanager.mapper.Impl.BuildingEntityMapper;
import com.buildingmanager.repository.BuildingRepository;

@Repository
public class BuildingRepositoryImpl extends BaseRepositoryImpl<BuildingEntity> implements BuildingRepository {

	public List<BuildingEntity> findBuildings(Map<String, String> params, List<String> rentTypes) {
		List<BuildingEntity> results = null;
		
		String bindParams = "";
		String name = params.get("name").isEmpty() ? null : "%" + params.get("name") + "%" ;
		Integer floorArea = params.get("floorArea").isEmpty() ? null :  Integer.valueOf(params.get("floorArea"));
		Integer districtId = params.get("districtId").isEmpty() ? null : Integer.valueOf(params.get("districtId"));
		String ward = params.get("ward").isEmpty() ? null : "%" + params.get("ward") + "%";
		String street = params.get("street").isEmpty() ? null : "%" + params.get("street") + "%";
		Integer numberOfBasement = params.get("numberOfBasement").isEmpty() ? null : Integer.valueOf(params.get("numberOfBasement"));
		String direction = params.get("direction").isEmpty() ? null : "%" + params.get("direction") + "%";
		String level = params.get("level").isEmpty() ? null : params.get("level");
		Integer rentPriceFrom = params.get("rentPriceFrom").isEmpty() ? null : Integer.valueOf(params.get("rentPriceFrom"));
		Integer rentPriceTo =  params.get("rentPriceTo").isEmpty() ? null : Integer.valueOf(params.get("rentPriceTo"));
		Integer rentAreaFrom =  params.get("rentAreaFrom").isEmpty() ? null : Integer.valueOf(params.get("rentAreaFrom"));
		Integer rentAreaTo =  params.get("rentAreaTo").isEmpty() ? null : Integer.valueOf(params.get("rentAreaTo"));

		for (int i = 0; i < rentTypes.size(); i++) {
			if (!rentTypes.get(i).isEmpty()) {
				bindParams += "?, ";
			}
		}

		bindParams = bindParams.isEmpty() ? null : bindParams.substring(0, bindParams.length() - 2);
		
		StringBuilder sql = new StringBuilder("SELECT building.* FROM building ");
		
		if (name != null && floorArea != null && districtId != null && ward != null && street != null
				&& numberOfBasement != null && direction != null && level != null
				&& rentPriceFrom != null && rentPriceTo != null && rentAreaFrom != null && rentAreaTo != null && bindParams != null) {
			sql.append("JOIN rentarea on building.id = rentarea.buildingid ");
			sql.append("WHERE building.name LIKE ? AND building.floorarea = ? ");
			sql.append("AND building.districtid = ? AND building.ward LIKE ? ");
			sql.append("AND building.street LIKE ? AND building.numberofbasement= ? ");
			sql.append("AND building.direction LIKE ? AND building.level = ? ");
			sql.append("AND building.rentprice >= ? AND building.rentprice <= ? ");
			sql.append("AND rentarea.value >= ? AND rentarea.value <= ? ");
			sql.append("AND building.id IN(SELECT buildingrenttype.buildingid FROM buildingrenttype ");
			sql.append("JOIN renttype on buildingrenttype.renttypeid = renttype.id ");
			sql.append(String.format("WHERE renttype.code IN(%s)) ", bindParams));
			sql.append("GROUP BY building.id");
			
			return query(sql.toString(), new BuildingEntityMapper(), name, floorArea, districtId, ward, street,
					numberOfBasement, direction, level, rentPriceFrom, rentPriceTo, rentAreaFrom, rentAreaTo, rentTypes);
		}

		if (name != null) {
			sql.append("WHERE name like ?");
			results = query(sql.toString(), new BuildingEntityMapper(), name);
		}

		else if (floorArea != null) {
			sql.append("WHERE floorarea = ?");
			results = query(sql.toString(), new BuildingEntityMapper(), floorArea);
		}

		else if (districtId != null) {
			sql.append("WHERE districtid = ?");
			results = query(sql.toString(), new BuildingEntityMapper(), districtId);
		}

		else if (ward != null) {
			sql.append("WHERE ward like ?");
			results = query(sql.toString(), new BuildingEntityMapper(), ward);
		}

		else if (street != null) {
			sql.append("WHERE street like ?");
			results = query(sql.toString(), new BuildingEntityMapper(), street);
		} else if (numberOfBasement != null) {
			sql.append("WHERE numberofbasement = ?");
			results = query(sql.toString(), new BuildingEntityMapper(), numberOfBasement);
		}

		else if (direction != null) {
			sql.append("WHERE direction like ?");
			results = query(sql.toString(), new BuildingEntityMapper(), direction);
		}

		else if (level != null) {
			sql.append("WHERE level = ?");
			results = query(sql.toString(), new BuildingEntityMapper(), level);
		}

		else if (rentPriceFrom != null && rentPriceTo != null) {
			sql.append("WHERE rentprice >= ? AND rentprice <= ?");
			results = query(sql.toString(), new BuildingEntityMapper(), rentPriceFrom, rentPriceTo);
		}

		else if (rentPriceFrom != null) {
			sql.append("WHERE rentprice >= ?");
			results = query(sql.toString(), new BuildingEntityMapper(), rentPriceFrom);
		}
		
		else if (rentPriceTo != null) {
			sql.append("WHERE rentprice <= ?");
			results = query(sql.toString(), new BuildingEntityMapper(), rentPriceTo);
		}

		else if (rentAreaFrom != null && rentAreaTo != null) {
			sql.append("JOIN rentarea ON rentarea.buildingid = building.id ");
			sql.append("WHERE rentarea.value >= ? AND rentarea.value <= ? GROUP BY building.id");

			results = query(sql.toString(), new BuildingEntityMapper(), rentAreaFrom, rentAreaTo);
		}

		else if (rentAreaFrom != null) {
			sql.append("JOIN rentarea ON rentarea.buildingid = building.id ");
			sql.append("WHERE rentarea.value >= ? GROUP BY building.id");
			results = query(sql.toString(), new BuildingEntityMapper(), rentAreaFrom);
		}

		else if (rentAreaTo != null) {
			sql.append("JOIN rentarea ON rentarea.buildingid = building.id ");
			sql.append("WHERE rentarea.value <= ? GROUP BY building.id");
			results = query(sql.toString(), new BuildingEntityMapper(), rentAreaTo);
		}

		else if (bindParams != null) {
			sql.append("WHERE building.id ");
			sql.append("IN (SELECT buildingrenttype.buildingid FROM buildingrenttype ");
			sql.append("JOIN renttype on buildingrenttype.renttypeid = renttype.id ");
			sql.append(String.format("WHERE renttype.code IN(%s))", bindParams));

			results = query(sql.toString(), new BuildingEntityMapper(), rentTypes);
		}

		return results;
	}

}
