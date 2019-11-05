/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author slier
 */
public class WordInspection {

	private File file;

	public WordInspection(File file) {
		this.file = file;
	}

	public int wordCount() throws Exception {
		int wordCount = 0;

		Scanner s = this.getScanner();

		while (s.hasNext()) {
			s.next();
			wordCount++;
		}

		return wordCount;
	}

	public List<String> wordsContainingZ() throws Exception {
		List<String> lists = new ArrayList<String>();

		Scanner s = this.getScanner();

		while (s.hasNext()) {
			String word = s.next();

			if (word.contains("z")) {
				lists.add(word);
			}
		}

		return lists;
	}

	public List<String> wordsEndingInL() throws Exception {
		List<String> lists = new ArrayList<String>();
		Scanner s = this.getScanner();

		while (s.hasNext()) {
			String word = s.next();

			if (word.endsWith("l")) {
				lists.add(word);
			}
		}

		return lists;
	}

	public List<String> palindromes() throws Exception {
		List<String> lists = new ArrayList<String>();
		Scanner s = this.getScanner();

		while (s.hasNext()) {

			String word = s.next();

			if (word.equals(this.reverseString(word))) {
				lists.add(word);
			}
		}

		return lists;
	}

	public List<String> wordsWhichContainAllVowels() throws Exception {
		List<String> lists = new ArrayList<String>();

		Scanner s = this.getScanner();
		String finnishVowel = "aeiouyäö";

		while (s.hasNext()) {
			String word = s.next();

			boolean found = true;
			for (int i = 0; i < finnishVowel.length(); i++) {
				if (!word.contains(finnishVowel.charAt(i) + "")) {
					found = false;
					break;
				}
			}

			if (found) {
				lists.add(word);
			}

		}

		return lists;
	}

	private String reverseString(String inputString) {
		char[] inputStringArray = inputString.toCharArray();
		String reverseString = "";

		for (int i = inputStringArray.length - 1; i >= 0; i--) {
			reverseString += inputStringArray[i];
		}

		return reverseString;
	}

	private Scanner getScanner() throws Exception {
		return new Scanner(this.file, "UTF-8");
	}

}
