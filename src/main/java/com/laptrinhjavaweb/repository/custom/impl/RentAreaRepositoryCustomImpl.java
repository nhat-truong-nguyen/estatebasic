package com.laptrinhjavaweb.repository.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.repository.custom.RentAreaRepositoryCustom;

@Repository
public class RentAreaRepositoryCustomImpl implements RentAreaRepositoryCustom {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void deleteByBuildingId(Long buildingId) {
		StringBuilder sql = new StringBuilder("DELETE FROM rentarea WHERE buildingid = ").append(buildingId);
		entityManager.createNativeQuery(sql.toString()).executeUpdate();
	}

}
