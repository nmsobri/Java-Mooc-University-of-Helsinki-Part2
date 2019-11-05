
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author slier
 */
public class Airport {

	private Scanner scanner;
	private HashMap<String, Integer> airplanes;
	private HashMap<String, ArrayList<String[]>> flights;

	public Airport() {
		this.scanner = new Scanner(System.in);
		this.airplanes = new HashMap<String, Integer>();
		this.flights = new HashMap<String, ArrayList<String[]>>();
	}

	public void start() {
		this.airportMenu();
	}

	public void airportMenu() {
		System.out.println("-------------");
		System.out.println("Airport panel");
		System.out.println("-------------");

		while (true) {
			System.out.println("Choose operation: ");
			System.out.println("[1] Add airplane");
			System.out.println("[2] Add flight");
			System.out.println("[x] Exit");
			System.out.print("> ");

			String choice = this.scanner.nextLine();

			if (choice.equalsIgnoreCase("1")) {
				this.addAirplane();
			} else if (choice.equalsIgnoreCase("2")) {
				this.addFlight();
			} else if (choice.equalsIgnoreCase("x")) {
				this.flightMenu();
				break;
			}

		}
	}

	public void flightMenu() {
		System.out.println("--------------");
		System.out.println("Flight service");
		System.out.println("--------------");

		while (true) {

			System.out.println("Choose operation: ");
			System.out.println("[1] Print planes");
			System.out.println("[2] Print flights");
			System.out.println("[3] Print plane info");
			System.out.println("[x] Quit");
			System.out.print("> ");

			String choice = this.scanner.nextLine();

			if (choice.equalsIgnoreCase("1")) {
				this.printPlanes();
			} else if (choice.equalsIgnoreCase("2")) {
				this.printFlights();
			} else if (choice.equalsIgnoreCase("3")) {
				this.printPlane();
			} else if (choice.equalsIgnoreCase("x")) {
				break;
			}
		}

	}

	public void addAirplane() {
		System.out.print("Give plane ID: ");
		String planeID = this.scanner.nextLine();
		System.out.print("Give plane capacity: ");
		int capacity = Integer.parseInt(this.scanner.nextLine());

		this.airplanes.put(planeID, capacity);

	}

	public void addFlight() {
		System.out.print("Give plane ID: ");
		String planeID = this.scanner.nextLine();

		System.out.print("Give departure airport code: ");
		String departureAirportCode = this.scanner.nextLine();

		System.out.print("Give destination airport code: ");
		String destinationAirportCode = this.scanner.nextLine();

		if (!this.flights.containsKey(planeID)) {
			ArrayList<String[]> airportCodeList = new ArrayList<String[]>();
			String[] airportCode = {departureAirportCode, destinationAirportCode};
			airportCodeList.add(airportCode);

			this.flights.put(planeID, airportCodeList);
		} else {
			ArrayList<String[]> airportCodeList = this.flights.get(planeID);
			String[] airportCode = {departureAirportCode, destinationAirportCode};
			airportCodeList.add(airportCode);
		}
	}

	private void printPlanes() {
		for (String planeID : this.airplanes.keySet()) {
			System.out.println(planeID + " (" + this.airplanes.get(planeID) + " ppl)");
		}
	}

	private void printPlane() {
		System.out.print("Give plane ID: ");
		String planeID = this.scanner.nextLine();

		if (this.airplanes.containsKey(planeID)) {
			System.out.println(planeID + " (" + this.airplanes.get(planeID) + " ppl)");
		}
	}

	private void printFlights() {
		for (String planeID : this.airplanes.keySet()) {
			ArrayList<String[]> flights = null;

			if (this.flights.containsKey(planeID)) {
				flights = this.flights.get(planeID);

				for (String[] flight : flights) {
					System.out.print(planeID + " (" + this.airplanes.get(planeID) + " ppl)");
					System.out.println(" (" + flight[0] + "-" + flight[1] + ")");
				}
			}

		}
	}

}
