package com.javafullstack.airlinereservationjdbc.jdbcutility;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcUtility {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			FileInputStream inputStream = new FileInputStream("airline.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			Class.forName(properties.getProperty("Driver"));
			conn = DriverManager.getConnection(properties.getProperty("dburl"));
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getQuery(String baseQuery) {
		String query = null;
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream("airline.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			query = properties.getProperty(baseQuery);

			return query;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
