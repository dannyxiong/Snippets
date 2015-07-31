package com.main;

import java.util.ArrayList;
import java.util.List;

import com.hibernate.Actor;
import com.hibernate.Film;
import com.hibernate.FilmActor;

public class Test {
	public static void main(String[] args) {
		HibernateConnection hc = new HibernateConnection();
		List<Actor> actors = new ArrayList<>();
		List<Film> films = new ArrayList<>();

		hc.connectToDatabase();

//		films = hc.getThreeRandomFilms();

//		Actor d = new Actor();
//		d.setFirstName("SNOWFLOWER");
//		d.setLastName("YANG");
//		d.setLastUpdate(new Date());
//		hc.addNew(d);

		Actor snow = hc.getActorBy("SNOWFLOWER");
//		for (Film f : films) {
//			FilmActor fa = new FilmActor();
//			FilmActorId faid = new FilmActorId();
//			faid.setActorId(snow.getActorId());
//			faid.setFilmId(f.getFilmId());
//
//			fa.setId(faid);
//			fa.setActor(snow);
//			fa.setFilm(f);
//			fa.setLastUpdate(new Date());
//			hc.addFilmActor(fa);
//		}

		actors = hc.getAllActors();
		
		//put this in hibernate connection
		for (Actor a : actors) {
			
				System.out.println(a.getFirstName() + " " + a.getLastName());

				for (FilmActor fa : a.getFilmActors())
					System.out.println("\t" + fa.getFilm().getTitle());
			
		}

		hc.disconnectFromDatabase();
	}

}
