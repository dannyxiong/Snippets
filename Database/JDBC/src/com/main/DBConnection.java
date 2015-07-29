package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class DBConnection.
 *
 * @author Danny
 */
public class DBConnection {
	
	/** The connection. */
	private static Connection connection = null;
	
	/** The Constant URL. */
	private final static String URL = "jdbc:mysql://localhost:3306/sakila";
	
	/** The Constant USER. */
	private final static String USER = "root";
	
	/** The Constant PASSWORD. */
	private final static String PASSWORD = "admin";
	
	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(DBConnection.class);

	/**
	 * Connect to db.
	 */
	private static void connectToDB() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("Failed MySql Connection. ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			LOG.error("Class for driver not found. ");
		}

	}

	/**
	 * Disconnect db.
	 */
	private static void disconnectDB() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("Failed closing db connection. ");
		}
	}

	/**
	 * Request film by.
	 *
	 * @param id the id
	 * @return the film
	 */
	public Film requestFilmBy(int id){
		Film fi = new Film();
		connectToDB();
		try {
			String query = "SELECT * FROM film WHERE film_id = " + id + ";";
			ResultSet r = connection.createStatement().executeQuery(query);
			while (r.next()) {
				fi.setId(r.getInt("film_id"));
				fi.setTitle(r.getString("title"));
				fi.setDescription(r.getString("description"));
				fi.setRentalRate(r.getDouble("rental_rate"));
				fi.setRating(r.getString("rating"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("Fail to request film by id = " + id);
		} 
		disconnectDB();
		return fi;
		
	}
}
