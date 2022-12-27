package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.model.request.BuildingSearchRequest;
import com.laptrinhjavaweb.model.response.BuildingSearchResponse;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;
import com.laptrinhjavaweb.repository.custom.RentAreaRepositoryCustom;
import com.laptrinhjavaweb.repository.custom.UserRepositoryCustom;
import com.laptrinhjavaweb.service.IBuildingService;

@Service
public class BuildingService implements IBuildingService {
	@Autowired
	RentAreaRepository rentAreaRepository;

	@Autowired
	RentAreaRepositoryCustom rentAreaRepositoryCustom;

	@Autowired
	BuildingRepository buildingRepository;

	@Autowired
	BuildingRepositoryCustom buildingRepositoryCustom;

	@Autowired
	BuildingConverter buildingConverter;
	
	@Autowired
	UserRepositoryCustom userRepositoryCustom;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<BuildingSearchResponse> findBuildings(BuildingSearchRequest searchModel) {
		List<BuildingSearchResponse> list = buildingConverter
				.toListBuildingDTO(buildingRepositoryCustom.findBuildings(searchModel));
		return list;
	}
	
	@Override
	public BuildingDTO findById(Long id) {
		return buildingConverter.toBuildingDTORequest(buildingRepository.findOne(id));
	}
	
	@Override
	public List<BuildingSearchResponse> findAll() {
		List<BuildingEntity> list = buildingRepository.findAll();
		return buildingConverter.toListBuildingDTO(list);
	}

	@Override
	@Transactional
	public void saveOrUpdate(BuildingDTO dto) {
		BuildingEntity buildingEntity = buildingConverter.toBuildingEntity(dto);
		
		if (buildingEntity.getId() != null) {
			List<UserEntity> users = userRepositoryCustom.findStaffsByBuildingId(buildingEntity.getId());
			buildingEntity.setUsers(users);
		}
		
		buildingRepository.save(buildingEntity);
	}

	@Override
	@Transactional
	public void delete(Long[] ids) {
		buildingRepository.deleteByIdIn(ids);
	}

	@Override
	@Transactional
	public void assignBuilding(List<Long> staffIds, Long buildingId) {
		BuildingEntity building = buildingRepository.findById(buildingId);
		
		List<UserEntity> staffs = new ArrayList<>();
		if (staffIds != null) {
			staffs = userRepository.findByIdIn(staffIds);	
		}
			
		building.setUsers(staffs);
		
		buildingRepository.save(building);
	}
}
