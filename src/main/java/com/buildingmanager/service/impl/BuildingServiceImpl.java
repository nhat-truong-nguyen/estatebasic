package com.buildingmanager.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buildingmanager.converter.BuildingConverter;
import com.buildingmanager.dto.BuildingDTO;
import com.buildingmanager.entity.AssignmentBuildingEntity;
import com.buildingmanager.entity.BuildingEntity;
import com.buildingmanager.entity.RentAreaEntity;
import com.buildingmanager.entity.UserEntity;
import com.buildingmanager.model.response.BuildingSearchResponse;
import com.buildingmanager.repository.AssignmentBuildingRepository;
import com.buildingmanager.repository.BuildingRepository;
import com.buildingmanager.repository.RentAreaRepository;
import com.buildingmanager.repository.custom.BuildingRepositoryCustom;
import com.buildingmanager.repository.custom.RentAreaRepositoryCustom;
import com.buildingmanager.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	RentAreaRepository rentAreaRepository;
	
	@Autowired 
	RentAreaRepositoryCustom rentAreaRepositoryCustom;
	
	@Autowired
	AssignmentBuildingRepository assignmentBuildingRepository;

	@Autowired
	BuildingRepository buildingRepository;
	
	@Autowired
	BuildingRepositoryCustom buildingRepositoryCustom;

	@Autowired
	BuildingConverter buildingConverter;

	@Override
	public List<BuildingSearchResponse> findBuildings(Map<String, String> params, List<String> rentTypes) {
		List<BuildingSearchResponse> list = buildingConverter
				.toListBuildingDTO(buildingRepositoryCustom.findBuildings(params, rentTypes));
		return list;
	}

	@Override
	public BuildingEntity save(BuildingEntity buildingEntity) {
		BuildingEntity newBuilding = buildingRepository.save(buildingEntity);

		for (RentAreaEntity rentAreaEntity : buildingEntity.getRentAreas()) {
			rentAreaEntity.setBuilding(newBuilding);
		}

		rentAreaRepository.saveAll(buildingEntity.getRentAreas());

		return buildingEntity;
	}

	@Override
	public void delete(Long[] ids) {
		buildingRepositoryCustom.delete(ids);
	}

	@Override
	public void update(BuildingDTO dto) {
		BuildingEntity buildingEntity = buildingConverter.toBuildingEntity(dto);
		buildingRepositoryCustom.update(buildingEntity);
	}

	@Override
	public List<BuildingSearchResponse> findAll() {
		List<BuildingEntity> list = buildingRepository.findAll();
		return buildingConverter.toListBuildingDTO(list);
	}

	@Override
	public void assignBuilding(Long[] staffIds, Long buildingId) {
		buildingRepositoryCustom.deleteBuildingAssignment(buildingId);
		
		BuildingEntity b = new BuildingEntity();
		b.setId(buildingId);
		
		for (Long staffId : staffIds) {			
			UserEntity staff = new UserEntity();
			staff.setId(staffId);
			
			AssignmentBuildingEntity ab = new AssignmentBuildingEntity();
			ab.setBuilding(b);
			ab.setStaff(staff);
			
			assignmentBuildingRepository.save(ab);
		}
	}

	@Override
	public BuildingDTO findById(Long id) {
		return buildingConverter.toBuildingDTORequest(buildingRepository.findById(id).get());
	}
}
