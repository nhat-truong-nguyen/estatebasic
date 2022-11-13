package com.buildingmanager.repository.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.buildingmanager.entity.BuildingEntity;
import com.buildingmanager.mapper.Impl.BuildingEntityMapper;
import com.buildingmanager.repository.BuildingRepository;

@Repository
public class BuildingRepositoryImpl extends BaseRepositoryImpl<BuildingEntity> implements BuildingRepository {

	public List<BuildingEntity> findBuildings(Map<String, String> params, List<String> rentTypes) {
		StringBuilder sql = new StringBuilder("SELECT building.* FROM building ");
		List<BuildingEntity> results = null;

		if (!params.get("name").isEmpty()) {
			sql.append("WHERE name like ?");
			results = query(sql.toString(), new BuildingEntityMapper(), '%' + params.get("name") + '%');
		}
		
		else if (!params.get("floorArea").isEmpty()) {
			sql.append("WHERE floorarea = ?");
			results = query(sql.toString(), new BuildingEntityMapper(), Integer.valueOf(params.get("floorArea")));
		}
		
		else if (!params.get("districtId").isEmpty()) {
			sql.append("WHERE districtid = ?");
			results = query(sql.toString(), new BuildingEntityMapper(), Integer.valueOf(params.get("districtId")));
		} 
		
		else if (!params.get("ward").isEmpty()) {
			sql.append("WHERE ward like ?");
			results = query(sql.toString(), new BuildingEntityMapper(), '%' + params.get("ward") + '%');
		} 
		
		else if (!params.get("street").isEmpty()) {
			sql.append("WHERE street like ?");
			results = query(sql.toString(), new BuildingEntityMapper(), '%' + params.get("street") + '%');
		} 
		else if (!params.get("numberOfBasement").isEmpty()) {
			sql.append("WHERE numberofbasement = ?");
			results = query(sql.toString(), new BuildingEntityMapper(), Integer.valueOf(params.get("numberOfBasement")));
		} 
		
		else if (!params.get("direction").isEmpty()) {
			sql.append("WHERE direction like ?");
			results = query(sql.toString(), new BuildingEntityMapper(), '%' + params.get("direction") + '%');
		} 
		
		else if (!params.get("level").isEmpty()) {
			sql.append("WHERE level = ?");
			results = query(sql.toString(), new BuildingEntityMapper(), params.get("level"));
		} 
		
		else if (!params.get("rentPriceFrom").isEmpty() && !params.get("rentPriceTo").isEmpty()) {
			sql.append("WHERE rentprice >= ? AND rentprice <= ?");
			results = query(sql.toString(), new BuildingEntityMapper(), Integer.valueOf(params.get("rentPriceFrom")), Integer.valueOf(params.get("rentPriceTo")));
		} 
		
		else if (!params.get("rentPriceFrom").isEmpty()) {
			sql.append("WHERE rentprice >= ?");
			results = query(sql.toString(), new BuildingEntityMapper(), Integer.valueOf(params.get("rentPriceFrom")));
		} 
		else if (!params.get("rentPriceTo").isEmpty()) {
			sql.append("WHERE rentprice <= ?");
			results = query(sql.toString(), new BuildingEntityMapper(), Integer.valueOf(params.get("rentPriceTo")));
		} 
		
		else if (!params.get("rentAreaFrom").isEmpty() && !params.get("rentAreaTo").isEmpty()) {
			sql.append("JOIN rentarea ON rentarea.buildingid = building.id ");
			sql.append("WHERE rentarea.value >= ? AND rentarea.value <= ? GROUP BY building.id");
			
			results = query(sql.toString(), new BuildingEntityMapper(), Integer.valueOf(params.get("rentAreaFrom")), Integer.valueOf(params.get("rentAreaTo")));
		}
		
		else if (!params.get("rentAreaFrom").isEmpty()) {
			sql.append("JOIN rentarea ON rentarea.buildingid = building.id ");
			sql.append("WHERE rentarea.value >= ? GROUP BY building.id");
			results = query(sql.toString(), new BuildingEntityMapper(),  Integer.valueOf(params.get("rentAreaFrom")));
		} 
		
		else if (!params.get("rentAreaTo").isEmpty()) {
			sql.append("JOIN rentarea ON rentarea.buildingid = building.id ");
			sql.append("WHERE rentarea.value <= ? GROUP BY building.id");
			results = query(sql.toString(), new BuildingEntityMapper(),  Integer.valueOf(params.get("rentAreaTo")));
		} 
		
		else if (!params.get("rentType").isEmpty()) {
			String bindParams = "";

			for (int i = 0; i < rentTypes.size(); i++) {
				bindParams += "?, ";
			}

			bindParams = bindParams.substring(0, bindParams.length() - 2);
			
			sql.append("WHERE building.id ");
			sql.append("IN (SELECT buildingrenttype.buildingid FROM buildingrenttype ");
			sql.append("JOIN renttype on buildingrenttype.renttypeid = renttype.id ");
			sql.append(String.format("WHERE renttype.code IN(%s))", bindParams));
			
			results = query(sql.toString(), new BuildingEntityMapper(), rentTypes);
		}

		return results;
	}

}
