
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author slier
 */
public class Hand implements Comparable<Hand> {

	private List<Card> cards;

	public Hand() {
		this.cards = new ArrayList<Card>();
	}

	public void add(Card card) {
		this.cards.add(card);
	}

	public void print() {
		for (Card c : this.cards) {
			System.out.println(c);
		}
	}

	public void sort() {
		Collections.sort(this.cards);
	}

	public int value() {
		int value = 0;
		for (Card c : this.cards) {
			value += c.getValue();
		}

		return value;
	}

	public void sortAgainstSuit() {
		Collections.sort(this.cards, new SortAgainstSuitAndValue());
	}

	@Override
	public int compareTo(Hand o) {
		return this.value() - o.value();
	}
}
