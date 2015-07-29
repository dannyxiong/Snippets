package com.main;

// TODO: Auto-generated Javadoc
/**
 * The Class Film.
 * 
 * @author Danny
 */
public class Film {
	
	/** The id. */
	private int id;
	
	/** The title. */
	private String title;
	
	/** The description. */
	private String description;
	
	/** The release year. */
	private int releaseYear;
	
	/** The rating. */
	private String rating;
	
	/** The rental rate. */
	private double rentalRate;
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Gets the release year.
	 *
	 * @return the release year
	 */
	public int getReleaseYear() {
		return releaseYear;
	}
	
	/**
	 * Sets the release year.
	 *
	 * @param releaseYear the new release year
	 */
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}
	
	/**
	 * Sets the rating.
	 *
	 * @param rating the new rating
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	/**
	 * Gets the rental rate.
	 *
	 * @return the rental rate
	 */
	public double getRentalRate() {
		return rentalRate;
	}
	
	/**
	 * Sets the rental rate.
	 *
	 * @param rentalRate the new rental rate
	 */
	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", description="
				+ description + ", releaseYear=" + releaseYear + ", rating="
				+ rating + ", rentalRate=" + rentalRate + "]";
	}
	
	
}
