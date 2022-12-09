package com.buildingmanager.repository.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.buildingmanager.entity.BuildingEntity;
import com.buildingmanager.util.ValidationUtil;

@Repository
public class BuildingRepositoryImpl {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<BuildingEntity> findBuildings(Map<String, String> params, List<String> types) {
		StringBuilder finalQuery = new StringBuilder("SELECT b FROM BuildingEntity b");

		StringBuilder whereQuery = new StringBuilder();
		StringBuilder joinQuery = new StringBuilder();

		buildQueryWithJoin(params, whereQuery, joinQuery);
		buildQueryWithoutJoin(params, types, whereQuery);

		finalQuery.append(joinQuery);
		finalQuery.append("\nWHERE 1 = 1");
		finalQuery.append(whereQuery);
		finalQuery.append("\nGROUP BY b.id");
		Query query = entityManager.createQuery(finalQuery.toString(), BuildingEntity.class);

		return query.getResultList();
	}

	private void buildQueryWithoutJoin(Map<String, String> params, List<String> types, StringBuilder whereQuery) {
		String name = params.getOrDefault("name", null);
		String floorArea = params.getOrDefault("floorArea", null);
		String ward = params.getOrDefault("ward", null);
		String street = params.getOrDefault("street", null);
		String districtCode = params.getOrDefault("districtCode", null);
		String numberOfBasement = params.getOrDefault("numberOfBasement", null);
		String direction = params.getOrDefault("direction", null);
		String level = params.getOrDefault("level", null);
		String rentPriceFrom = params.getOrDefault("rentPriceFrom", null);
		String rentPriceTo = params.getOrDefault("rentPriceTo", null);
		String managerName = params.getOrDefault("managerName", null);
		String managerPhone = params.getOrDefault("managerPhone", null);

		if (ValidationUtil.isNotBlank(name)) {
			whereQuery.append("\nAND b.name LIKE '%").append(name).append("%'");
		}

		if (ValidationUtil.isNotBlank(floorArea)) {
			whereQuery.append("\nAND b.floorArea = ").append(floorArea);
		}

		if (ValidationUtil.isNotBlank(ward)) {
			whereQuery.append("\nAND b.ward LIKE '%").append(ward).append("%'");
		}

		if (ValidationUtil.isNotBlank(street)) {
			whereQuery.append("\nAND b.street LIKE '%").append(street).append("%'");
		}

		if (ValidationUtil.isNotBlank(numberOfBasement)) {
			whereQuery.append("\nAND b.numberOfBasement = ").append(numberOfBasement);
		}

		if (ValidationUtil.isNotBlank(direction)) {
			whereQuery.append("\nAND b.direction LIKE '%").append(direction).append("%'");
		}

		if (ValidationUtil.isNotBlank(level)) {
			whereQuery.append("\nAND b.level LIKE ").append("'%").append(level).append("%'");
		}

		if (ValidationUtil.isNotBlank(rentPriceFrom)) {
			whereQuery.append("\nAND b.rentPrice >= ").append(rentPriceFrom);
		}

		if (ValidationUtil.isNotBlank(rentPriceTo)) {
			whereQuery.append("\nAND b.rentPrice <= ").append(rentPriceTo);
		}

		if (ValidationUtil.isNotBlank(managerName)) {
			whereQuery.append("\nAND b.managerName LIKE '%").append(managerName).append("%'");
		}

		if (ValidationUtil.isNotBlank(managerPhone)) {
			whereQuery.append("\nAND b.managerPhone LIKE '%").append(managerPhone).append("%'");
		}

		if (ValidationUtil.isNotBlank(districtCode)) {
			whereQuery.append("\nAND b.district = '").append(districtCode).append("'");
		}

		types.removeIf((type) -> ValidationUtil.isBlank(type));
		if (types.size() > 0) {
			whereQuery.append("\nAND (b.type LIKE\t");
			types.replaceAll((type) -> ("'%" + type + "%'"));
			whereQuery.append(String.join("\nOR b.type LIKE\t", types)).append(")");
		}

	}

	public void buildQueryWithJoin(Map<String, String> params, StringBuilder whereQuery, StringBuilder joinQuery) {

		String rentAreaFrom = params.getOrDefault("rentAreaFrom", null);
		String rentAreaTo = params.getOrDefault("rentAreaTo", null);
		String staffId = params.getOrDefault("staffId", null);

		if (ValidationUtil.isNotBlank(rentAreaFrom) || ValidationUtil.isNotBlank(rentAreaTo)) {
			joinQuery.append("\nJOIN b.rentAreas ra");
		}

		if (ValidationUtil.isNotBlank(rentAreaFrom)) {
			whereQuery.append("\nAND ra.value >= ").append(rentAreaFrom);
		}

		if (ValidationUtil.isNotBlank(rentAreaTo)) {
			whereQuery.append("\nAND ra.value <= ").append(rentAreaTo);
		}

		if (ValidationUtil.isNotBlank(staffId)) {
			joinQuery.append("\nJOIN b.assignmentBuildings ab").append("\nJOIN ab.staff u");
			whereQuery.append("\nAND u.id = ").append(staffId);
		}
	}
}
