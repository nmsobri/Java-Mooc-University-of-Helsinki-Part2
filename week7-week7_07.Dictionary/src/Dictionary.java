
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author slier
 */
public class Dictionary {

	private HashMap<String, String> translation;

	public Dictionary() {
		this.translation = new HashMap<String, String>();
	}

	public String translate(String word) {
		if (this.translation.containsKey(word)) {
			return this.translation.get(word);
		}
		return null;
	}

	public void add(String word, String translation) {
		this.translation.put(word, translation);
	}

	public int amountOfWords() {
		return this.translation.size();
	}

	public ArrayList<String> translationList() {
		ArrayList<String> list = new ArrayList<String>();

		for (String key : this.translation.keySet()) {
			String temp = key + " = " + this.translation.get(key);
			list.add(temp);
		}

		return list;
	}
}
