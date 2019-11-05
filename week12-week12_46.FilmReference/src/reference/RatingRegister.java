/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author slier
 */
public class RatingRegister {

	private Map<Film, List<Rating>> films;
	private Map<Person, Map<Film, Rating>> personRatings;

	public RatingRegister() {
		this.films = new HashMap<Film, List<Rating>>();
		this.personRatings = new HashMap<Person, Map<Film, Rating>>();
	}

	public void addRating(Film film, Rating rating) {
		if (!this.films.containsKey(film)) {
			this.films.put(film, new ArrayList<Rating>());
		}

		this.films.get(film).add(rating);
	}

	public List<Rating> getRatings(Film film) {
		if (this.films.containsKey(film)) {
			return this.films.get(film);
		}
		return null;
	}

	public Map<Film, List<Rating>> filmRatings() {
		return this.films;
	}

	public void addRating(Person person, Film film, Rating rating) {
		if (!this.personRatings.containsKey(person)) {
			this.personRatings.put(person, new HashMap<Film, Rating>());
		}

		this.personRatings.get(person).put(film, rating);
		this.addRating(film, rating);
	}

	public Rating getRating(Person person, Film film) {
		if (!this.personRatings.containsKey(person)) {
			return Rating.NOT_WATCHED;
		}

		if (!this.personRatings.get(person).containsKey(film)) {
			return Rating.NOT_WATCHED;
		}

		return this.personRatings.get(person).get(film);
	}

	public Map<Film, Rating> getPersonalRatings(Person person) {
		if (!this.personRatings.containsKey(person)) {
			return new HashMap<Film, Rating>();
		}

		return this.personRatings.get(person);
	}

	public List<Person> reviewers() {
		List<Person> reviewers = new ArrayList<Person>();
		for (Person p : this.personRatings.keySet()) {
			reviewers.add(p);
		}

		return reviewers;
	}

	public List<Film> films() {
		return new ArrayList<Film>(this.films.keySet());
	}

}
