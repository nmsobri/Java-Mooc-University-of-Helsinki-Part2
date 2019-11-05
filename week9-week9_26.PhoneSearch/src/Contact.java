
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author slier
 */
public class Contact {

	private Scanner scanner;
	private Map<String, Set<String>> personNumbers;
	private Map<String, String> numberPerson;
	private Map<String, String> address;

	public Contact() {
		this.scanner = new Scanner(System.in);
		this.personNumbers = new HashMap<String, Set<String>>();
		this.numberPerson = new ConcurrentHashMap<String, String>();
		this.address = new HashMap<String, String>();
	}

	public void start() {
		while (true) {
			this.displayMenu();
			System.out.print("command: ");
			String command = this.scanner.nextLine();

			if (command.equals("x")) {
				break;
			}

			this.runCommand(command);
		}
	}

	public void displayMenu() {
		System.out.println("phone search");
		System.out.println("available operations:");
		System.out.println("1 add a number");
		System.out.println("2 search for a number");
		System.out.println("3 search for a person by phone number");
		System.out.println("4 add an address");
		System.out.println("5 search for personal information");
		System.out.println("6 delete personal information");
		System.out.println("7 filtered listing");
		System.out.println("x quit");
		System.out.println();
	}

	private void runCommand(String command) {
		int choice = Integer.parseInt(command);

		if (choice == 1) {
			this.addNumber();
		} else if (choice == 2) {
			this.searchANumber();
		} else if (choice == 3) {
			this.searchByNumber();
		} else if (choice == 4) {
			this.addAddress();
		} else if (choice == 5) {
			this.searchPersonalInfo();
		} else if (choice == 6) {
			this.deletePersonalInfo();
		} else if (choice == 7) {
			this.filterListing();
		}
	}

	private void addNumber() {
		System.out.print("whose number: ");
		String name = this.scanner.nextLine();

		System.out.print("number: ");
		String phone = this.scanner.nextLine();
		System.out.println();

		if (!this.personNumbers.containsKey(name)) {
			this.personNumbers.put(name, new HashSet<String>());
		}

		this.personNumbers.get(name).add(phone);
		this.numberPerson.put(phone, name);
	}

	private void searchANumber() {
		System.out.print("whose number: ");
		String name = this.scanner.nextLine();

		Set<String> numbers = this.personNumbers.get(name);

		if (numbers != null && numbers.size() > 0) {
			for (String number : numbers) {
				System.out.println(number);
			}
		} else {
			System.out.println("not found");
		}

		System.out.println();
	}

	private void searchByNumber() {
		System.out.print("number: ");
		String phone = this.scanner.nextLine();

		if (this.numberPerson.containsKey(phone)) {
			System.out.println(this.numberPerson.get(phone));
		} else {
			System.out.println("not found");
		}

		System.out.println();
	}

	private void addAddress() {
		System.out.print("whose address: ");
		String name = this.scanner.nextLine();

		System.out.print("street: ");
		String street = this.scanner.nextLine();

		System.out.print("city: ");
		String city = this.scanner.nextLine();

		this.address.put(name, street + " " + city);

		System.out.println();
	}

	private void searchPersonalInfo() {
		System.out.print("whose information: ");
		String name = this.scanner.nextLine();

		String address = null;
		Set<String> phones = null;

		if (this.address.containsKey(name)) {
			address = this.address.get(name);
		}

		if (this.personNumbers.containsKey(name)) {
			phones = this.personNumbers.get(name);
		}

		if (address == null && phones == null) {
			System.out.println("not found");
		} else {
			if (address == null) {
				System.out.println("address unknown");
			} else {
				System.out.println("address: " + address);
			}

			if (phones != null) {
				System.out.println("phone numbers: ");
				for (String phone : phones) {
					System.out.println(phone);
				}
			} else {
				System.out.println("phone number not found");
			}
		}

		System.out.println();
	}

	private void deletePersonalInfo() {
		System.out.print("whose information: ");
		String name = this.scanner.nextLine();

		if (this.personNumbers.containsKey(name)) {
			this.personNumbers.remove(name);
		}

		if (this.address.containsKey(name)) {
			this.address.remove(name);
		}

		for (String phone : this.numberPerson.keySet()) {
			if (this.numberPerson.get(phone).equals(name)) {
				this.numberPerson.remove(phone);
			}
		}

		System.out.println();
	}

	private void filterListing() {
		System.out.print("keyword (if empty, all listed): ");
		String keyword = this.scanner.nextLine();
		Set<String> foundNames = new HashSet<String>();

		for (String person : this.address.keySet()) {
			if (person.contains(keyword)) {
				foundNames.add(person);
			}

			if (this.address.get(person).contains(keyword)) {
				foundNames.add(person);
			}
		}

		for (String person : this.personNumbers.keySet()) {
			if (person.contains(keyword)) {
				foundNames.add(person);
			}
		}

		if (foundNames.size() > 0) {
			List<String> foundNameCollection = new ArrayList<String>();
			foundNameCollection.addAll(foundNames);
			Collections.sort(foundNameCollection);

			for (String name : foundNameCollection) {
				System.out.println(name);

				if (this.address.get(name) == null) {
					System.out.println("address unknown");
				} else {
					System.out.println("address: " + this.address.get(name));
				}

				if (this.personNumbers.containsKey(name)) {
					System.out.println("phone numbers: ");

					for (String phone : this.personNumbers.get(name)) {
						System.out.println(phone);
					}
				} else {
					System.out.println("phone number not found");
				}

				System.out.println();

			}
		} else {
			System.out.println("keyword not found");
		}
	}

}
