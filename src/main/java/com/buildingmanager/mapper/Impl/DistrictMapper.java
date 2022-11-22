package com.buildingmanager.mapper.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.buildingmanager.entity.DistrictEntity;
import com.buildingmanager.mapper.RowMapper;

public class DistrictMapper implements RowMapper<DistrictEntity>{

	@Override
	public DistrictEntity rowMapper(ResultSet resultSet) {
		DistrictEntity district = new DistrictEntity();
		try {
			district.setId(resultSet.getInt("id"));
			district.setCode(resultSet.getString("code"));
			district.setName(resultSet.getString("name"));
			return district;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}	
}
