package com.laptrinhjavaweb.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.model.response.BuildingSearchResponse;
import com.laptrinhjavaweb.repository.AssignmentBuildingRepository;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;
import com.laptrinhjavaweb.repository.custom.RentAreaRepositoryCustom;
import com.laptrinhjavaweb.service.IBuildingService;

@Service
public class BuildingService implements IBuildingService {
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
	public void saveOrUpdate(BuildingDTO dto) {
		BuildingEntity buildingEntity = buildingConverter.toBuildingEntity(dto);

		if (dto.getId() == null) {
			buildingEntity = buildingRepository.save(buildingConverter.toBuildingEntity(dto));

			for (RentAreaEntity rentAreaEntity : buildingEntity.getRentAreas()) {
				rentAreaEntity.setBuilding(buildingEntity);
			}
		} else {
			buildingRepositoryCustom.update(buildingEntity);
			rentAreaRepositoryCustom.deleteByBuildingId(buildingEntity.getId());
		}

		rentAreaRepository.save(buildingEntity.getRentAreas());
	}

	@Override
	public void delete(Long[] ids) {
		buildingRepositoryCustom.delete(ids);
	}

	@Override
	public List<BuildingSearchResponse> findAll() {
		List<BuildingEntity> list = buildingRepository.findAll();
		return buildingConverter.toListBuildingDTO(list);
	}

	@Override
	public void assignBuilding(Long[] staffIds, Long buildingId) {
		buildingRepositoryCustom.deleteBuildingAssignment(buildingId);
		buildingRepositoryCustom.saveAssignmentBuilding(staffIds, buildingId);
	}

	@Override
	public BuildingDTO findById(Long id) {
		return buildingConverter.toBuildingDTORequest(buildingRepository.findOne(id));
	}
}
