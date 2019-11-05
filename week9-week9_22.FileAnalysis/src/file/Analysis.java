/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author slier
 */
public class Analysis {

	private File file;

	public Analysis(File file) {
		this.file = file;
	}

	public int lines() throws Exception {
		int lineCount = 0;
		Scanner scanner = new Scanner(this.file);

		while (scanner.hasNextLine()) {
			lineCount++;
			scanner.nextLine();
		}

		return lineCount;
	}

	public int characters() throws Exception {
		int charCount = 0;

		Scanner scanner = new Scanner(this.file);

		while (scanner.hasNext()) {
			String word = scanner.next();
			charCount += word.length();
			charCount++;
		}

		return charCount;
	}

}
