package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBConnection {
	private Connection connection = null;
	private final String URL =  "jdbc:mysql://localhost:3306/sakila";
	private final String USER = "rootd";
	private final String PASSWORD = "admin";
	private static final Logger LOG = LoggerFactory.getLogger(DBConnection.class);
	
	public void open(){
		try {
			LOG.info("HI");
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			//e.printStackTrace();
			LOG.error("teset "+getClass().getEnclosingClass());
		} 
	}

	public void close(){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
