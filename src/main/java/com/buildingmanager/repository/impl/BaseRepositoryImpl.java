package com.buildingmanager.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
	public List<T> query(String sql, RowMapper<T> objectMapper, Object... params) {
		List<T> results = null;
		Connection c = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (c != null) {
			try {
				results = new ArrayList<>();
				statement = c.prepareStatement(sql);
				setParams(statement, params);
				resultSet = statement.executeQuery();
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

	public void setParams(PreparedStatement statement, Object... params) {
		if (params.length == 0) {
			return;
		}

		for (int i = 0; i < params.length; i++) {
			try {
				if (params[i] instanceof Integer) {
					statement.setInt(i + 1, (int) params[i]);
				} else if (params[i] instanceof Byte) {
					statement.setByte(i + 1, (byte) params[i]);
				} else if (params[i] instanceof Long) {
					statement.setLong(i + 1, (long) params[i]);
				} else if (params[i] instanceof Double) {
					statement.setDouble(i + 1, (double) params[i]);
				} else if (params[i] instanceof String) {
					statement.setString(i + 1, (String) params[i]);
				} else if (params[i] instanceof Timestamp) {
					statement.setTimestamp(i + 1, (Timestamp) params[i]);
				} else if (params[i] instanceof Boolean) {
					statement.setBoolean(i + 1, (Boolean) params[i]);
				} else if (params[i] instanceof Integer[]) {
					Integer[] items = (Integer[]) params[i];
					for (int j = 0; j < items.length; j++) {
						statement.setInt(j + i + 1, items[j]);
					}
				} else if (params[i] instanceof ArrayList) {
					@SuppressWarnings("unchecked")
					ArrayList<Object> items =  (ArrayList<Object>) params[i];
					for (int j = 0; j < items.size(); j++) {
						statement.setObject(j + i + 1, items.get(j));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
