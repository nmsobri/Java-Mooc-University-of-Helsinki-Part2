/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author slier
 */
public class Employees {

	private List<Person> employees;

	public Employees() {
		this.employees = new ArrayList<Person>();
	}

	public void add(Person person) {
		this.employees.add(person);
	}

	public void add(List<Person> persons) {
		Iterator<Person> pi = persons.iterator();

		while (pi.hasNext()) {
			this.employees.add(pi.next());
		}
	}

	public void print() {
		Iterator<Person> pi = this.employees.iterator();

		while (pi.hasNext()) {
			System.out.println(pi.next());
		}
	}

	public void print(Education education) {
		Iterator<Person> pi = this.employees.iterator();

		while (pi.hasNext()) {
			Person p = pi.next();

			if (p.getEducation() == education) {
				System.out.println(p);
			}
		}
	}

	public void fire(Education education) {
		Iterator<Person> pi = this.employees.iterator();

		while (pi.hasNext()) {
			Person p = pi.next();

			if (p.getEducation() == education) {
				pi.remove();
			}
		}
	}

}
