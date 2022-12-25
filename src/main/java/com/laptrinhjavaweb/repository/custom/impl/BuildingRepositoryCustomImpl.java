package com.laptrinhjavaweb.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.model.request.BuildingSearchRequest;
import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;
import com.laptrinhjavaweb.repository.custom.RentAreaRepositoryCustom;
import com.laptrinhjavaweb.utils.ValidationUtil;

@Repository
public class BuildingRepositoryCustomImpl implements BuildingRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private RentAreaRepository rentAreaRepository;

	@Autowired
	private RentAreaRepositoryCustom rentAreaRepositoryCustom;

	@SuppressWarnings("unchecked")
	@Override
	public List<BuildingEntity> findBuildings(BuildingSearchRequest searchModel) {
		StringBuilder finalQuery = new StringBuilder("SELECT b FROM BuildingEntity b");

		StringBuilder whereQuery = new StringBuilder();
		StringBuilder joinQuery = new StringBuilder();

		buildQueryWithJoin(searchModel, whereQuery, joinQuery);
		buildQueryWithoutJoin(searchModel, whereQuery);

		finalQuery.append(joinQuery);
		finalQuery.append("\nWHERE 1 = 1");
		finalQuery.append(whereQuery);
		finalQuery.append("\nGROUP BY b.id");
		
		Query query = entityManager.createQuery(finalQuery.toString(), BuildingEntity.class);
		return query.getResultList();
	}

	private void buildQueryWithoutJoin(BuildingSearchRequest searchModel, StringBuilder whereQuery) {

		if (ValidationUtil.isNotBlank(searchModel.getName())) {
			whereQuery.append("\nAND b.name LIKE '%").append(searchModel.getName()).append("%'");
		}

		if (searchModel.getFloorArea() != null) {
			whereQuery.append("\nAND b.floorArea = ").append(searchModel.getFloorArea());
		}

		if (ValidationUtil.isNotBlank(searchModel.getWard())) {
			whereQuery.append("\nAND b.ward LIKE '%").append(searchModel.getWard()).append("%'");
		}

		if (ValidationUtil.isNotBlank(searchModel.getStreet())) {
			whereQuery.append("\nAND b.street LIKE '%").append(searchModel.getStreet()).append("%'");
		}

		if (searchModel.getNumberOfBasement() != null) {
			whereQuery.append("\nAND b.numberOfBasement = ").append(searchModel.getNumberOfBasement());
		}

		if (ValidationUtil.isNotBlank(searchModel.getDirection())) {
			whereQuery.append("\nAND b.direction LIKE '%").append(searchModel.getDirection()).append("%'");
		}

		if (ValidationUtil.isNotBlank(searchModel.getLevel())) {
			whereQuery.append("\nAND b.level LIKE ").append("'%").append(searchModel.getLevel()).append("%'");
		}

		if (searchModel.getRentPriceFrom() != null) {
			whereQuery.append("\nAND b.rentPrice >= ").append(searchModel.getRentPriceFrom());
		}

		if (searchModel.getRentPriceTo() != null) {
			whereQuery.append("\nAND b.rentPrice <= ").append(searchModel.getRentPriceTo());
		}

		if (ValidationUtil.isNotBlank(searchModel.getManagerName())) {
			whereQuery.append("\nAND b.managerName LIKE '%").append(searchModel.getManagerName()).append("%'");
		}

		if (ValidationUtil.isNotBlank(searchModel.getManagerPhone())) {
			whereQuery.append("\nAND b.managerPhone LIKE '%").append(searchModel.getManagerPhone()).append("%'");
		}

		if (ValidationUtil.isNotBlank(searchModel.getDistrict())) {
			whereQuery.append("\nAND b.district = '").append(searchModel.getDistrict()).append("'");
		}

		if (searchModel.getRentType() != null) {
			whereQuery.append("\nAND (b.type LIKE\t");
			searchModel.getRentType().replaceAll((type) -> ("'%" + type + "%'"));
			whereQuery.append(String.join("\nOR b.type LIKE\t", searchModel.getRentType())).append(")");
		}
	}

	public void buildQueryWithJoin(BuildingSearchRequest searchModel, StringBuilder whereQuery, StringBuilder joinQuery) {
		if (searchModel.getRentAreaFrom() != null || searchModel.getRentAreaTo() != null) {
			joinQuery.append("\nJOIN b.rentAreas ra");
		}

		if (searchModel.getRentAreaFrom() != null) {
			whereQuery.append("\nAND ra.value >= ").append(searchModel.getRentAreaFrom());
		}

		if (searchModel.getRentAreaTo() != null) {
			whereQuery.append("\nAND ra.value <= ").append(searchModel.getRentAreaTo());
		}

		if (searchModel.getStaffId() != null) {
			joinQuery.append("\nJOIN b.assignmentBuildings ab").append("\nJOIN ab.staff u");
			whereQuery.append("\nAND u.id = ").append(searchModel.getStaffId());
		}
	}

	@Override
	@Transactional
	public void update(BuildingEntity buildingEntity) {
		entityManager.merge(buildingEntity);
		deleteRowFromTable("rentarea", "buildingid", buildingEntity.getId());
		rentAreaRepository.save(buildingEntity.getRentAreas());
	}

	@Override
	@Transactional
	public void delete(Long[] ids) {
		deleteRowFromTable("rentarea", "buildingid", ids);
		deleteRowFromTable("assignmentbuilding", "buildingid", ids);
		deleteRowFromTable("building", "id", ids);
	}

	@Override
	@Transactional
	public void deleteBuildingAssignment(Long id) {
		deleteRowFromTable("assignmentbuilding", "buildingid", id);
	}

	@Override
	@Transactional
	public void saveAssignmentBuilding(Long[] staffIds, Long buildingId) {
		StringBuilder sql = new StringBuilder("INSERT INTO assignmentbuilding(buildingid, staffid)").append("\nVALUES");

		for (int i = 0; i < staffIds.length; i++) {
			sql.append("(").append(buildingId).append(",").append(staffIds[i]).append(")");

			if (i != staffIds.length - 1) {
				sql.append(",");
			}
		}

		entityManager.createNativeQuery(sql.toString()).executeUpdate();

	}

	private <T> void deleteRowFromTable(String tableName, String column, Long... ids) {
		StringBuilder params = new StringBuilder();

		if (ids != null) {
			for (int i = 0; i < ids.length; i++) {
				params.append(ids[i]);
				if (i < ids.length - 1) {
					params.append(",");
				}
			}
		}

		StringBuilder sql = new StringBuilder("DELETE FROM\n").append(tableName).append("\nWHERE\n").append(column)
				.append("\nIN(").append(params.toString()).append(")");

		entityManager.createNativeQuery(sql.toString()).executeUpdate();
	}
}
