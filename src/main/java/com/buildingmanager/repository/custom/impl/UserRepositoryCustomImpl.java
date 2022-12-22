package com.buildingmanager.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.buildingmanager.entity.UserEntity;
import com.buildingmanager.repository.custom.UserRepositoryCustom;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public List<UserEntity> findAllStaffs() {
		StringBuilder jpql = new StringBuilder("SELECT u.* FROM user u")
				.append("\nJOIN user_role ur ON u.id = ur.userid")
				.append("\nJOIN role r ON ur.roleid = r.id WHERE r.code = 'staff'");
		return entityManager.createNativeQuery(jpql.toString(), UserEntity.class).getResultList();
	}


	@Override
	public List<UserEntity> findStaffsByBuildingId(Long buildingId) {
		StringBuilder jpql = new StringBuilder("SELECT u.* FROM user u")
				.append("\nJOIN assignmentbuilding ab ON u.id = ab.staffid")
				.append("\nWHERE ab.buildingid = ").append(buildingId);
		return entityManager.createNativeQuery(jpql.toString(), UserEntity.class).getResultList();
	}

}
