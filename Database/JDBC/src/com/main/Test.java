package com.main;

// TODO: Auto-generated Javadoc
/**
 * The Class Test.
 * 
 * @author Danny
 */
public class Test {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		DBConnection db = new DBConnection();
		int id = 5;
		Film film = db.requestFilmBy(id);
		System.out.println(film.toString());
	}
}
