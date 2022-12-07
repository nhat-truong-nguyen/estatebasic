//package com.buildingmanager.mapper.Impl;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import com.buildingmanager.entity.DistrictEntityCustom;
//import com.buildingmanager.mapper.RowMapper;
//
//public class DistrictMapper implements RowMapper<DistrictEntityCustom>{
//
//	@Override
//	public DistrictEntityCustom rowMapper(ResultSet resultSet) {
//		DistrictEntityCustom district = new DistrictEntityCustom();
//		try {
//			district.setId(resultSet.getInt("id"));
//			district.setCode(resultSet.getString("code"));
//			district.setName(resultSet.getString("name"));
//			return district;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return null;
//	}	
//}
