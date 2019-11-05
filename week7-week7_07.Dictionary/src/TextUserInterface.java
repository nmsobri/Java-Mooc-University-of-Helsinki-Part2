
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
public class TextUserInterface {

	private Scanner scanner;
	private Dictionary dictionary;

	public TextUserInterface(Scanner scanner, Dictionary dictionary) {
		this.scanner = scanner;
		this.dictionary = dictionary;
	}

	public void start() {
		printMenu();
		while (true) {
			System.out.print("Statement: ");
			String statement = this.scanner.nextLine();

			if (statement.equalsIgnoreCase("quit")) {
				System.out.println("Cheers!");
				break;
			} else if (statement.equalsIgnoreCase("add")) {
				this.add();
			} else if (statement.equalsIgnoreCase("translate")) {
				this.translate();
			} else {
				System.out.println("Unknown statement");
				System.out.println();
			}
		}
	}

	private void printMenu() {
		System.out.println("Statement:");
		System.out.println("  add - adds a word pair to the dictionary");
		System.out.println("  translate - asks a word and prints its translation");
		System.out.println("  quit - quit the text user interface");
	}

	private void add() {
		System.out.print("In Finnish: ");
		String finnish = this.scanner.nextLine();
		System.out.print("Translation: ");
		String translation = this.scanner.nextLine();

		this.dictionary.add(finnish, translation);
	}

	private void translate() {
		System.out.print("Give a word:");
		String finnish = this.scanner.nextLine();

		String translation = this.dictionary.translate(finnish);
		System.out.println("Translation: " + translation);
	}
}
