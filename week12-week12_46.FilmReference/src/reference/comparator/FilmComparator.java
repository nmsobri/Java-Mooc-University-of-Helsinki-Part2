/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

/**
 *
 * @author slier
 */
public class FilmComparator implements Comparator<Film> {

	private Map<Film, List<Rating>> ratings;

	public FilmComparator(Map<Film, List<Rating>> ratings) {
		this.ratings = ratings;
	}

	@Override
	public int compare(Film o1, Film o2) {
		if (this.ratings.get(o1) == this.ratings.get(o2)) {
			return 0;
		}

		double o1Rating = this.getRating(this.ratings.get(o1));
		double o2Rating = this.getRating(this.ratings.get(o2));

		if (o1Rating > o2Rating) {
			return -1;
		} else {
			return 1;
		}
	}

	private double getRating(List<Rating> ratings) {
		double rating = 0;

		for (Rating r : ratings) {
			rating += r.getValue();
		}

		return rating / ratings.size();
	}
}
