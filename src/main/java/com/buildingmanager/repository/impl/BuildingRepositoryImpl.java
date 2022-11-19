package com.buildingmanager.repository.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.buildingmanager.entity.BuildingEntity;
import com.buildingmanager.mapper.Impl.BuildingEntityMapper;
import com.buildingmanager.repository.BuildingRepository;
import com.buildingmanager.util.ValidationUtil;

@Repository
public class BuildingRepositoryImpl extends BaseRepositoryImpl<BuildingEntity> implements BuildingRepository {

	public List<BuildingEntity> findBuildings(Map<String, String> params, List<String> types) {
		String sql = buildFinalQuery(params, types);
		return query(sql, new BuildingEntityMapper());
	}
	
	private String buildFinalQuery(Map<String, String> params, List<String> types) {
		StringBuilder finalQuery = new StringBuilder("SELECT * FROM building");
		buildQueryWithJoin(params, types, finalQuery);
		finalQuery.append("\nWHERE 1 = 1");
		buildQueryWithoutJoin(params, types, finalQuery);
		finalQuery.append("\nGROUP BY building.id");
		return finalQuery.toString();
	}
	
	private StringBuilder buildQueryWithoutJoin(Map<String, String> params, List<String> types, StringBuilder whereQuery) {

		String name = params.getOrDefault("name", null);
		String floorArea = params.getOrDefault("floorArea", null);
		String districtId = params.getOrDefault("districtId", null);
		String ward = params.getOrDefault("ward", null);
		String street = params.getOrDefault("street", null);
		String numberOfBasement = params.getOrDefault("numberOfBasement", null);
		String direction = params.getOrDefault("direction", null);
		String level = params.getOrDefault("level", null);
		String rentPriceFrom = params.getOrDefault("rentPriceFrom", null);
		String rentPriceTo = params.getOrDefault("rentPriceTo", null);
		String rentAreaFrom = params.getOrDefault("rentAreaFrom", null);
		String rentAreaTo = params.getOrDefault("rentAreaTo", null);
		
		if (ValidationUtil.isNotBlank(name)) {
			whereQuery.append("\nAND building.name LIKE '%").append(name).append("%'");
		}

		if (ValidationUtil.isNotBlank(floorArea)) {
			whereQuery.append("\nAND building.floorarea = ").append(floorArea);
		}

		if (ValidationUtil.isNotBlank(districtId)) {
			whereQuery.append("\nAND building.districtid = ").append(districtId);
		}

		if (ValidationUtil.isNotBlank(ward)) {
			whereQuery.append("\nAND building.ward LIKE '%").append(ward).append("%'");
		}

		if (ValidationUtil.isNotBlank(street)) {
			whereQuery.append("\nAND building.street LIKE '%").append(street).append("%'");
		}

		if (ValidationUtil.isNotBlank(numberOfBasement)) {
			whereQuery.append("\nAND building.numberofbasement = ").append(numberOfBasement);
		}

		if (ValidationUtil.isNotBlank(direction)) {
			whereQuery.append("\nAND building.direction LIKE '%").append(direction).append("%'");
		}

		if (ValidationUtil.isNotBlank(level)) {
			whereQuery.append(String.format("\nAND building.level = '%s'", level));
		}

		if (ValidationUtil.isNotBlank(rentPriceFrom)) {
			whereQuery.append("\nAND building.rentprice >= ").append(rentPriceFrom);
		}

		if (ValidationUtil.isNotBlank(rentPriceTo)) {
			whereQuery.append("\nAND building.rentprice <= ").append(rentPriceTo);
		}
		
		if (ValidationUtil.isNotBlank(rentAreaFrom)) {
			whereQuery.append("\nAND rentarea.value >= ")
					 .append(rentAreaFrom);
		}
		
		if (ValidationUtil.isNotBlank(rentAreaTo)) {
			whereQuery.append("\nAND rentarea.value <= ")
			 .append(rentAreaTo);
		}
				
		
		int countEmptyValue = 0;
		for (int i = 0; i < types.size(); i++) {			
			types.set(i, String.format("'%s'", types.get(i)));
			if (ValidationUtil.isNotBlank(types.get(i))) {
				countEmptyValue++;
			} 
		}
		
		if (countEmptyValue < types.size()) {
			whereQuery.append(String.format("\nAND renttype.code IN(%s)", String.join(", ", types)));
		}		
		
		return whereQuery;
	}

	public StringBuilder buildQueryWithJoin(Map<String, String> params, List<String> types,
			StringBuilder joinQuery) {

		String rentAreaFrom = params.getOrDefault("rentAreaFrom", null);
		String rentAreaTo = params.getOrDefault("rentAreaTo", null);

		if (ValidationUtil.isNotBlank(rentAreaFrom) || ValidationUtil.isNotBlank(rentAreaTo)) {
			joinQuery.append("\nJOIN rentarea on building.id = rentarea.buildingid");
		}

		for (String type : types) {
			if (ValidationUtil.isNotBlank(type)) {
				joinQuery.append("\nJOIN buildingrenttype on building.id = buildingrenttype.buildingid")
					     .append("\nJOIN renttype on buildingrenttype.renttypeid = renttype.id");
				break;
			}
		}

		return joinQuery;
	}
}
