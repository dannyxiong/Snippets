package com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hibernate.Actor;
import com.hibernate.Film;
import com.hibernate.FilmActor;
/**
 * 
 * @author Danny Xiong
 *
 */
public class HibernateConnection {
	private static Session session = null;
	private static Transaction t = null;
	private static SessionFactory sessionFactory = null;
	private static final Logger LOG = LoggerFactory.getLogger(HibernateConnection.class);
	/**
	 * Establishes a connection to the database.
	 */
	public void connectToDatabase() {
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
		t = session.beginTransaction();

	}

	/**
	 * Closes connection from session and session factory.
	 */
	public void disconnectFromDatabase() {
		t.commit();
		session.close();
		sessionFactory.close();
	}

	/**
	 * Queries using HQL to obtain all Actors in database.
	 * 
	 * @return the list of actors which was queried.
	 */
	public List<Actor> getAllActors() {

		Query q = session.createQuery("from Actor");
		List<Actor> actors = q.list();

		return actors;
	}

	/**
	 * Get three random films in the database.
	 * 
	 * @return the list of three random films.
	 */
	public List<Film> getThreeRandomFilms() {

		List<Film> filmList = new ArrayList<>(3);
		Random rand = new Random();

		for (int i = 0; i < 3; i++) {
			short filmID = (short) (rand.nextInt(1000 - 1) + 1);
			Query q = session.createQuery("from Film where filmId = :filmID");
			q.setParameter("filmID", filmID);
			Film film = (Film) q.list().get(0);
			filmList.add(film);
		}
		return filmList;
	}

	/**
	 * Queries the database based of the Actor's first name.
	 * 
	 * @param firstName 
	 * @return the matched actor
	 */
	public Actor getActorBy(String firstName) {
		Query q = session
				.createQuery("from Actor where firstName = :firstname");
		q.setParameter("firstname", firstName);
		Actor actor = (Actor) q.list().get(0);
		return actor;
	}

	/**
	 * 
	 * @param actor
	 */
	public void addNew(Actor actor) {
		Query q = session
				.createQuery("from Actor where firstName = :firstname and lastName = :lastname");
		q.setParameter("firstname", actor.getFirstName());
		q.setParameter("lastname", actor.getLastName());
		List<Actor> actorList = q.list();

		// Is there any other duplicate actors?
		// If not then add me to db
		if (actorList.isEmpty())
			LOG.info("New Actor added to DB.");
			session.save(actor);
	}

	/**
	 * 
	 * @param filmA
	 */
	public void addFilmActor(FilmActor filmA) {
		Query q = session
				.createQuery("from FilmActor as fa where fa.actor.actorId = :actorId and fa.film.filmId = :filmID");
		q.setParameter("actorId", filmA.getId().getActorId());
		q.setParameter("filmID", filmA.getId().getFilmId());
		List<FilmActor> faList = q.list();

		// if the actor is not in the film
		// then add to the db.
		if (faList.isEmpty()){
			LOG.info("Saving film actor to DB.");
			session.save(filmA);
		}
	}
}
