//package com.buildingmanager.repository.impl;
//
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import com.buildingmanager.entity.DistrictEntityCustom;
//import com.buildingmanager.mapper.Impl.DistrictMapper;
//import com.buildingmanager.repository.DistrictRepository;
//
//@Repository
//public class DistrictRepositoryImpl extends BaseRepositoryImpl<DistrictEntityCustom>implements DistrictRepository {
//
//	@Override
//	public DistrictEntityCustom findDistrictById(Long id) {
//		StringBuilder query = new StringBuilder("SELECT * FROM district WHERE id = ");
//		query.append(id);
//		List<DistrictEntityCustom> results = query(query.toString(), new DistrictMapper());
//		return results == null ? null : results.get(0);
//	}
//
//}
