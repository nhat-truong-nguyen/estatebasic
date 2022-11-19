package com.buildingmanager.repository;

import java.util.List;

import com.buildingmanager.mapper.RowMapper;

public interface BaseRepository<T> {
	List<T> query(String sql, RowMapper<T> objectMapper);
}
