package com.buildingmanager.mapper.Impl;

import java.sql.ResultSet;

import com.buildingmanager.entity.BuildingEntity;
import com.buildingmanager.mapper.RowMapper;

public class BuildingEntityMapper implements RowMapper<BuildingEntity> {

	@Override
	public BuildingEntity rowMapper(ResultSet result) {
		try {
			BuildingEntity building = new BuildingEntity();
			building.setId(result.getLong("id"));
			building.setName(result.getString("name"));
			building.setStreet(result.getString("street"));
			building.setWard(result.getString("ward"));
			building.setDistrictId(result.getLong("districtid"));
			building.setStructure(result.getString("structure"));
			building.setNumberOfBasement(result.getInt("numberofbasement"));
			building.setFloorArea(result.getInt("floorarea"));
			building.setDirection(result.getString("direction"));
			building.setLevel(result.getString("level"));
			building.setRentPrice(result.getInt("rentprice"));
			building.setRentPriceDescription(result.getString("rentpricedescription"));
			building.setServiceFee(result.getString("servicefee"));
			building.setCarFee(result.getString("carfee"));
			building.setMotorbikeFee(result.getString("motorbikefee"));
			building.setOvertimeFee(result.getString("overtimefee"));
			building.setWaterFee(result.getString("waterfee"));
			building.setElectricityFee(result.getString("electricityfee"));
			building.setDeposit(result.getString("deposit"));
			building.setPayment(result.getString("payment"));
			building.setRenttime(result.getString("renttime"));
			building.setDecorationTime(result.getString("decorationtime"));
			building.setBrokerageFee(result.getDouble("brokeragefee"));
			building.setNote(result.getString("note"));
			building.setLinkOfBuilding(result.getString("linkofbuilding"));
			building.setMap(result.getString("map"));
			building.setImage(result.getString("image"));
			building.setManagerName(result.getString("managername"));
			building.setManagerPhone(result.getString("managerPhone"));
			building.setCreatedDate(result.getTimestamp("createddate"));
			building.setModifiedDate(result.getTimestamp("modifieddate"));
			building.setCreatedBy(result.getString("createdby"));
			building.setModifiedBy(result.getString("modifiedby"));
			return building;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
