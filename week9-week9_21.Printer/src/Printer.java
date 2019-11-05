
import java.io.File;
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
public class Printer {

	private Scanner scanner;
	private String fileName;

	public Printer(String fileName) throws Exception {
		this.fileName = fileName;
		this.scanner = new Scanner(new File(fileName));
	}

	public void printLinesWhichContain(String word) throws Exception {

		while (this.scanner.hasNextLine()) {

			String line = this.scanner.nextLine();

			if (word == null || word.isEmpty()) {
				System.out.println(line);
			} else if (line.contains(word)) {
				System.out.println(line);
			}
		}

		this.scanner.close();
		this.scanner = new Scanner(new File(this.fileName));

	}
}
