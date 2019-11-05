/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author slier
 */
public class MindfulDictionary {

	private Map<String, String> words;
	private String fileName;

	public MindfulDictionary() {
		this.words = new HashMap<String, String>();
		this.fileName = null;
	}

	public MindfulDictionary(String fileName) {
		this.words = new HashMap<String, String>();
		this.fileName = fileName;
	}

	public boolean load() {
		try {
			Scanner scanner = new Scanner(new File(this.fileName));
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] parts = line.split(":");
				this.words.put(parts[0], parts[1]);

			}

		} catch (FileNotFoundException e) {
			return false;
		}

		return true;
	}

	public boolean save() {
		try {
			FileWriter fw = new FileWriter(this.fileName);

			for (String key : this.words.keySet()) {
				fw.write(key + ":" + this.words.get(key) + "\n");
			}

			fw.close();
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public void add(String word, String translation) {
		if (!this.words.containsKey(word)) {
			this.words.put(word, translation);
		}
	}

	public String translate(String word) {
		for (String key : this.words.keySet()) {
			if (key.equals(word)) {
				return this.words.get(key);
			} else if (this.words.get(key).contains(word)) {
				return key;
			}
		}

		return null;
	}

	public void remove(String word) {
		List<String> toBeRemoved = new ArrayList<String>();

		for (String key : this.words.keySet()) {
			if (key.equals(word)) {
				toBeRemoved.add(key);
			} else if (this.words.get(key).contains(word)) {
				toBeRemoved.add(key);
			}
		}

		for (String key : toBeRemoved) {
			this.words.remove(key);
		}

	}
}
