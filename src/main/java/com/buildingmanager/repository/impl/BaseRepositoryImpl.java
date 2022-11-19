package com.buildingmanager.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.buildingmanager.mapper.RowMapper;
import com.buildingmanager.repository.BaseRepository;

@Repository
public class BaseRepositoryImpl<T> implements BaseRepository<T> {
	private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	private final String DB_USER = "root";
	private final String DB_PASS = "123456";

	private Connection getConnection() {
		Connection c = null;
		try {
			Class.forName(DRIVER_NAME);
			c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		} catch (ClassNotFoundException | SQLException e) {
			c = null;
		}

		return c;
	}

	@Override
	public List<T> query(String sql, RowMapper<T> objectMapper) {
		List<T> results = null;
		Connection c = getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		if (c != null) {
			try {
				results = new ArrayList<>();
				statement = c.createStatement();
				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					results.add(objectMapper.rowMapper(resultSet));
				}

				if (results.size() == 0) {
					results = null;
				}
			} catch (SQLException e) {
				results = null;
			} finally {
				try {
					if (c != null) {
						c.close();
					}

					if (statement != null) {
						statement.close();
					}

					if (resultSet != null) {
						resultSet.close();
					}
				} catch (SQLException e) {
					results = null;
				}
			}
		}
		return results;
	}
}
