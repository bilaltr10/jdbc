package org.database_test_automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.*;

public class DBUtils {

	private static final Logger LOGGER = LogManager.getLogger(DBUtils.class);

	private static final String URL = ConfigManager.getProperty("db_URL");

	private static final String USER = ConfigManager.getProperty("db_username");

	private static final String PASSWORD = ConfigManager.getProperty("db_password");

	static {
		try {
			Class.forName("org.postgresql.Driver");
			LOGGER.info("PostgreSql JDBC Driver loaded");
		}
		catch (ClassNotFoundException ex) {
			LOGGER.error("PostgreSql JDBC Driver not found");
		}
	}

	public static Connection getConnection() throws SQLException {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
			// return
			// DriverManager.getConnection("jdbc:postgresql://localhost:5432/dvdrental","postgres","bilal1874")
		}
		catch (SQLException e) {
			LOGGER.error("Database connection error");
			throw new SQLException(e);
		}
	}

	public static List<HashMap<String, Object>> executeQueryForMapList(String query) throws SQLException {
		List<HashMap<String, Object>> resultList = new ArrayList<>();
		try (ResultSet rs = getConnection().prepareStatement(query).executeQuery()) {
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			while (rs.next()) {
				HashMap<String, Object> map = new HashMap<>();
				for (int i = 1; i <= columnCount; i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i));
				}
				resultList.add(map);
			}
		}
		catch (SQLException e) {
			LOGGER.error("SQL Exception during executeQueryForMapList method");
			throw new RuntimeException(e);
		}

		return resultList;
	}

	public static <T> List<T> executeQueryByGeneric(String query, RowMapper<T> rowMapper) {
		List<T> listOfObjects = new ArrayList<>();
		try (ResultSet rs = getConnection().prepareStatement(query).executeQuery()) {
			while (rs.next()) {
				listOfObjects.add(rowMapper.mapRow(rs));
			}
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		return listOfObjects;
	}

}
