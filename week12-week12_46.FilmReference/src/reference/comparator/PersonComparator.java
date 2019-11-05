/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.Map;
import reference.domain.Person;

/**
 *
 * @author slier
 */
public class PersonComparator implements Comparator<Person> {

	private Map<Person, Integer> persons;

	public PersonComparator(Map<Person, Integer> persons) {
		this.persons = persons;
	}

	@Override
	public int compare(Person o1, Person o2) {
		if (this.persons.get(o1) == this.persons.get(o2)) {
			return 0;
		}

		if (this.persons.get(o1) > this.persons.get(o2)) {
			return -1;
		} else {
			return 1;
		}
	}

}
