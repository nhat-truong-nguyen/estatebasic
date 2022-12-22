package com.buildingmanager.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.buildingmanager.dto.BuildingDTO;
import com.buildingmanager.entity.BuildingEntity;
import com.buildingmanager.entity.RentAreaEntity;
import com.buildingmanager.enums.DistrictEnum;
import com.buildingmanager.model.response.BuildingSearchResponse;
import com.buildingmanager.util.ValidationUtil;

@Component
public class BuildingConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public BuildingSearchResponse toBuildingDTO(BuildingEntity entity) {
		BuildingSearchResponse dto = modelMapper.map(entity, BuildingSearchResponse.class);
		dto.setAddress(entity.getStreet() +", "+ entity.getWard() +", "+DistrictEnum.valueOf(entity.getDistrict()).getName()  );
		return dto;
	}
	
	public BuildingDTO toBuildingDTORequest(BuildingEntity entity) {
		BuildingDTO dto = modelMapper.map(entity, BuildingDTO.class);
		
		List<RentAreaEntity> listRentAreas = entity.getRentAreas();
		StringBuilder rentAreas = new StringBuilder();
		for (int i = 0; i < listRentAreas.size(); i++) {
			rentAreas.append(listRentAreas.get(i).getValue());
			
			if (i < listRentAreas.size() - 1) {
				rentAreas.append(",");
			}
		}
		dto.setRentAreas(rentAreas.toString()); 
		return dto;
	}
	
	public BuildingEntity toBuildingEntity(BuildingSearchResponse dto) {
		BuildingEntity entity = modelMapper.map(dto, BuildingEntity.class);
		return entity;
	}
	
	public BuildingEntity toBuildingEntity(BuildingDTO dto) {
		BuildingEntity entity = modelMapper.map(dto, BuildingEntity.class);
		
		String[] rentAreas = dto.getRentAreas().split(",");
		
		for (String rentArea : rentAreas) {
			if (ValidationUtil.isNotBlank(rentArea)) {
				RentAreaEntity rentAreaEntity = new RentAreaEntity();
				rentAreaEntity.setValue(Integer.valueOf(rentArea));
				rentAreaEntity.setBuilding(entity);
				entity.getRentAreas().add(rentAreaEntity);	
			}
		}
		
		return entity;
	}

	public List<BuildingSearchResponse> toListBuildingDTO(List<BuildingEntity> listBuildingEntity) {
		List<BuildingSearchResponse> listBuilding = new ArrayList<BuildingSearchResponse>();
		
		listBuilding = listBuildingEntity.stream().map(building -> this.toBuildingDTO(building))
		                  .collect(Collectors.toList());

		return listBuilding;
	}
}
