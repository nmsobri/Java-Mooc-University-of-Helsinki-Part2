/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;
import reference.comparator.FilmComparator;

/**
 *
 * @author slier
 */
public class Reference {

	private RatingRegister ratingRegister;

	public Reference(RatingRegister rr) {
		this.ratingRegister = rr;
	}

	public Film recommendFilm(Person person) {

		if (this.ratingRegister.getPersonalRatings(person).isEmpty()) {
			Map<Film, List<Rating>> filmRatings = this.ratingRegister.filmRatings();
			List<Film> films = this.ratingRegister.films();
			Collections.sort(films, new FilmComparator(filmRatings));
			return films.get(0);
		}

		Person selectedReviewer = this.highestFilmReviewSimiliarity(this.filmReviewSimiliarity(person));
		return this.selectedFilm(selectedReviewer, person);

	}

	private Map<Person, Integer> filmReviewSimiliarity(Person person) {
		Map<Person, Integer> fileReviewSimiliarity = new HashMap<Person, Integer>();
		Map<Film, Rating> targetPersonRating = this.ratingRegister.getPersonalRatings(person);
		List<Person> reviewers = this.ratingRegister.reviewers();

		for (Person p : reviewers) {
			if (p == person) {
				continue;
			}

			int productSum = 0;
			Map<Film, Rating> thisPersonRating = this.ratingRegister.getPersonalRatings(p);

			for (Film f : thisPersonRating.keySet()) {
				if (targetPersonRating.containsKey(f)) {
					productSum = productSum + (thisPersonRating.get(f).getValue() * targetPersonRating.get(f).getValue());
				}
			}

			fileReviewSimiliarity.put(p, productSum);
		}

		return fileReviewSimiliarity;
	}

	private Person highestFilmReviewSimiliarity(Map<Person, Integer> filmReviewSimiliarity) {
		Person p = null;

		for (Person thisPerson : filmReviewSimiliarity.keySet()) {
			if (p == null) {
				p = thisPerson;
			}

			if (filmReviewSimiliarity.get(thisPerson) > filmReviewSimiliarity.get(p)) {
				p = thisPerson;
			}
		}

		return p;
	}

	private Film selectedFilm(Person selectedReviewer, Person targetPerson) {
		Film selectedFilm = null;

		Map<Film, Rating> selectedReviewerMovies = this.ratingRegister.getPersonalRatings(selectedReviewer);
		Map<Film, Rating> targetPersonMovies = this.ratingRegister.getPersonalRatings(targetPerson);

		for (Film f : selectedReviewerMovies.keySet()) {
			if (targetPersonMovies.containsKey(f)) {
				continue;
			}

			if (selectedFilm == null) {
				selectedFilm = f;
			}

			if (selectedReviewerMovies.get(f).getValue() > selectedReviewerMovies.get(selectedFilm).getValue()) {
				selectedFilm = f;
			}
		}

		return selectedFilm;
	}
}
