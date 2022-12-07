//package com.buildingmanager.repository.impl;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.stereotype.Repository;
//
//import com.buildingmanager.entity.BuildingEntityCustom;
//import com.buildingmanager.mapper.Impl.BuildingEntityMapper;
//import com.buildingmanager.repository.BuildingRepository;
//import com.buildingmanager.util.ValidationUtil;
//
//@Repository
//public class BuildingRepositoryImpl extends BaseRepositoryImpl<BuildingEntityCustom> implements BuildingRepository {
//
//	public List<BuildingEntityCustom> findBuildings(Map<String, String> params, List<String> types) {
//		StringBuilder finalQuery = new StringBuilder("SELECT b.* FROM building as b");
//		
//		StringBuilder whereQuery = new StringBuilder();
//		StringBuilder joinQuery = new StringBuilder();
//		
//		buildQueryWithJoin(params, types, whereQuery, joinQuery);
//		buildQueryWithoutJoin(params, whereQuery);
//		
//		finalQuery.append(joinQuery);
//		finalQuery.append("\nWHERE 1 = 1");
//		finalQuery.append(whereQuery);
//		finalQuery.append("\nGROUP BY b.id");
//
//		return query(finalQuery.toString(), new BuildingEntityMapper());
//	}
//
//	private void buildQueryWithoutJoin(Map<String, String> params, StringBuilder whereQuery) {
//		String name = params.getOrDefault("name", null);
//		String floorArea = params.getOrDefault("floorArea", null);
//		String ward = params.getOrDefault("ward", null);
//		String street = params.getOrDefault("street", null);
//		String numberOfBasement = params.getOrDefault("numberOfBasement", null);
//		String direction = params.getOrDefault("direction", null);
//		String level = params.getOrDefault("level", null);
//		String rentPriceFrom = params.getOrDefault("rentPriceFrom", null);
//		String rentPriceTo = params.getOrDefault("rentPriceTo", null);
//		String managerName = params.getOrDefault("managerName", null);
//		String managerPhone = params.getOrDefault("managerPhone", null);
//
//		if (ValidationUtil.isNotBlank(name)) {
//			whereQuery.append("\nAND b.name LIKE '%").append(name).append("%'");
//		}
//
//		if (ValidationUtil.isNotBlank(floorArea)) {
//			whereQuery.append("\nAND b.floorarea = ").append(floorArea);
//		}
//
//		if (ValidationUtil.isNotBlank(ward)) {
//			whereQuery.append("\nAND b.ward LIKE '%").append(ward).append("%'");
//		}
//
//		if (ValidationUtil.isNotBlank(street)) {
//			whereQuery.append("\nAND b.street LIKE '%").append(street).append("%'");
//		}
//
//		if (ValidationUtil.isNotBlank(numberOfBasement)) {
//			whereQuery.append("\nAND b.numberofbasement = ").append(numberOfBasement);
//		}
//
//		if (ValidationUtil.isNotBlank(direction)) {
//			whereQuery.append("\nAND b.direction LIKE '%").append(direction).append("%'");
//		}
//
//		if (ValidationUtil.isNotBlank(level)) {
//			whereQuery.append(String.format("\nAND b.level = '%s'", level));
//		}
//
//		if (ValidationUtil.isNotBlank(rentPriceFrom)) {
//			whereQuery.append("\nAND b.rentprice >= ").append(rentPriceFrom);
//		}
//
//		if (ValidationUtil.isNotBlank(rentPriceTo)) {
//			whereQuery.append("\nAND b.rentprice <= ").append(rentPriceTo);
//		}
//		
//		if (ValidationUtil.isNotBlank(managerName)) {
//			whereQuery.append("\nAND b.managername LIKE '%").append(managerName).append("%'");
//		}
//		
//		if (ValidationUtil.isNotBlank(managerPhone)) {
//			whereQuery.append("\nAND b.managerphone LIKE '%").append(managerPhone).append("%'");
//		}
//	}
//
//	public void buildQueryWithJoin(Map<String, String> params, List<String> types, StringBuilder whereQuery,
//			StringBuilder joinQuery) {
//
//		String districtCode = params.getOrDefault("districtCode", null);
//		String rentAreaFrom = params.getOrDefault("rentAreaFrom", null);
//		String rentAreaTo = params.getOrDefault("rentAreaTo", null);
//		String staffId = params.getOrDefault("staffId", null);
//
//		if (ValidationUtil.isNotBlank(districtCode)) {
//			joinQuery.append("\nJOIN district on b.districtid = district.id");
//			whereQuery.append("\nAND district.code = ").append(String.format("'%s'", districtCode));
//		}
//
//		if (ValidationUtil.isNotBlank(rentAreaFrom) || ValidationUtil.isNotBlank(rentAreaTo)) {
//			joinQuery.append("\nJOIN rentarea on b.id = rentarea.buildingid");
//		}
//		
//
//		if (ValidationUtil.isNotBlank(rentAreaFrom)) {
//			whereQuery.append("\nAND rentarea.value >= ").append(rentAreaFrom);
//		}
//
//		if (ValidationUtil.isNotBlank(rentAreaTo)) {
//			whereQuery.append("\nAND rentarea.value <= ").append(rentAreaTo);
//		}
//
//		types.removeIf((str) -> ValidationUtil.isBlank(str));
//		if (types.size() > 0) {
//			joinQuery.append("\nJOIN buildingrenttype on b.id = buildingrenttype.buildingid")
//					.append("\nJOIN renttype on buildingrenttype.renttypeid = renttype.id");
//			types.replaceAll((str) -> String.format("'%s'", str));		
//			whereQuery.append(String.format("\nAND renttype.code IN(%s)", String.join(", ", types)));
//		}
//
//		if (ValidationUtil.isNotBlank(staffId)) {
//			joinQuery.append("\nJOIN assignmentbuilding on b.id = assignmentbuilding.buildingid")
//					.append("\nJOIN users on users.id = assignmentbuilding.staffid");
//			whereQuery.append("\nAND users.id = ").append(staffId);
//		}
//	}
//}
