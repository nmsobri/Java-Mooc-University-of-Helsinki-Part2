
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author slier
 */
public class Container {

	private int maxWeight;
	private ArrayList<Suitcase> suitcases;

	public Container(int maxWeight) {
		this.maxWeight = maxWeight;
		this.suitcases = new ArrayList<Suitcase>();
	}

	public void addSuitcase(Suitcase s) {
		if (this.totalWeight() + s.totalWeight() <= this.maxWeight) {
			this.suitcases.add(s);
		}
	}

	public int totalWeight() {
		int currentWeight = 0;

		for (Suitcase s : this.suitcases) {
			currentWeight += s.totalWeight();
		}

		return currentWeight;
	}

	public void printThings() {
		for (Suitcase s : this.suitcases) {
			s.printThings();
		}
	}

	@Override
	public String toString() {
		return "" + this.suitcases.size() + " suitcases (" + this.totalWeight() + "kg)";
	}
}
