package com.laptrinhjavaweb.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.custom.UserRepositoryCustom;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public List<UserEntity> findAllStaffs() {
		StringBuilder jpql = new StringBuilder("SELECT u.* FROM users u")
				.append("\nJOIN user_role ur ON u.id = ur.user_id")
				.append("\nJOIN role r ON ur.role_id = r.id WHERE r.code = 'user'");
		return entityManager.createNativeQuery(jpql.toString(), UserEntity.class).getResultList();
	}


	@Override
	public List<UserEntity> findStaffsByBuildingId(Long buildingId) {
		StringBuilder jpql = new StringBuilder("SELECT u.* FROM users u")
				.append("\nJOIN assignmentbuilding ab ON u.id = ab.userid")
				.append("\nWHERE ab.buildingid = ").append(buildingId);
		return entityManager.createNativeQuery(jpql.toString(), UserEntity.class).getResultList();
	}

}
