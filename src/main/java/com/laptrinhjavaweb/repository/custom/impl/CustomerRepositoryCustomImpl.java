package com.laptrinhjavaweb.repository.custom.impl;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.model.request.CustomerSearchRequest;
import com.laptrinhjavaweb.repository.custom.CustomerRepositoryCustom;
import com.laptrinhjavaweb.utils.ValidationUtil;

@Repository
public class CustomerRepositoryCustomImpl implements CustomerRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<CustomerEntity> findCustomers(CustomerSearchRequest searchModel) {
		StringBuilder finalQuery = new StringBuilder("SELECT c FROM CustomerEntity c");

		StringBuilder whereQuery = new StringBuilder();
		StringBuilder joinQuery = new StringBuilder();

		buildQueryWithJoin(searchModel, whereQuery, joinQuery);
		buildCommonQuery(searchModel, whereQuery);

		finalQuery.append(joinQuery);
		finalQuery.append("\nWHERE 1 = 1");
		finalQuery.append(whereQuery);
		finalQuery.append("\nGROUP BY c.id");

		Query query = entityManager.createQuery(finalQuery.toString(), CustomerEntity.class);
		return query.getResultList();
	}

	private void buildQueryWithJoin(CustomerSearchRequest searchModel, StringBuilder whereQuery, StringBuilder joinQuery) {
		if (searchModel.getStaffId() != null) {
			joinQuery.append("\nJOIN c.users u");
			whereQuery.append("\nAND u.id = ").append(searchModel.getStaffId());
		}
	}
	
	private void buildCommonQuery(CustomerSearchRequest searchModel, StringBuilder whereQuery) {
		Field[] fields = searchModel.getClass().getDeclaredFields();

		for (Field field : fields) {
			field.setAccessible(true);
			String fieldName = field.getName();

			if (fieldName.equals("staffId")) {
				continue;
			}			

			try {
				Object value = field.get(searchModel);
				
				if (ValidationUtil.isNotBlank((String) value)) {
					whereQuery.append("\nAND c.").append(fieldName);
					
					if (value instanceof String) {
						whereQuery.append("\nLIKE '%").append(value.toString().trim()).append("%'");
					} else if (value instanceof Integer || value instanceof Long) {
						whereQuery.append("=").append(value.toString().trim());
					}	
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}
