package com.laptrinhjavaweb.repository.custom.impl;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		buildCommonQuery(searchModel, whereQuery);
		buildSpecialQuery(searchModel, whereQuery);

		finalQuery.append(joinQuery);
		finalQuery.append("\nWHERE 1 = 1");
		finalQuery.append(whereQuery);
		finalQuery.append("\nGROUP BY b.id");

		Query query = entityManager.createQuery(finalQuery.toString(), BuildingEntity.class);
		return query.getResultList();
	}

	private void buildCommonQuery(BuildingSearchRequest searchModel,StringBuilder whereQuery) {
		Field[] fields = BuildingSearchRequest.class.getDeclaredFields();

		for (Field field : fields) {
			field.setAccessible(true);
			String fieldName = field.getName();

			if (fieldName.equals("staffId")
				|| fieldName.equals("rentPriceFrom")
				|| fieldName.equals("rentPriceTo")
				|| fieldName.equals("rentAreaFrom")
				|| fieldName.equals("rentAreaTo")
				|| fieldName.equals("rentType")
				) {
				continue;
			}			

			try {
				Object value = field.get(searchModel);
				
				if (ValidationUtil.isNotBlank((String) value)) {
					whereQuery.append("\nAND b.").append(fieldName);
					
					if (value instanceof String) {
						whereQuery.append("\nLIKE '%").append(value.toString().trim()).append("%'");
					} else if (value instanceof Integer) {
						whereQuery.append("=").append(value.toString().trim());
					}	
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}

		}

	}
	
	private void buildSpecialQuery(BuildingSearchRequest searchModel,StringBuilder whereQuery) {
		if (searchModel.getRentPriceFrom() != null) {
			whereQuery.append("\nAND b.rentPrice >= ").append(searchModel.getRentPriceFrom());
		}

		if (searchModel.getRentPriceTo() != null) {
			whereQuery.append("\nAND b.rentPrice <= ").append(searchModel.getRentPriceTo());
		}


		if (searchModel.getRentType() != null) {
			whereQuery.append("\nAND (b.type LIKE\t");
			searchModel.getRentType().replaceAll((type) -> ("'%" + type + "%'"));
			whereQuery.append(String.join("\nOR b.type LIKE\t", searchModel.getRentType())).append(")");
		}
	}

	public void buildQueryWithJoin(BuildingSearchRequest searchModel, StringBuilder whereQuery,
			StringBuilder joinQuery) {
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
			joinQuery.append("\nJOIN b.users u");
			whereQuery.append("\nAND u.id = ").append(searchModel.getStaffId());
		}
	}
}
