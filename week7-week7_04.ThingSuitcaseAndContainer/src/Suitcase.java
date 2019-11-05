
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
public class Suitcase {

	private ArrayList<Thing> things;
	private int maxWeight;

	public Suitcase(int maxWeight) {
		this.things = new ArrayList<Thing>();
		this.maxWeight = maxWeight;
	}

	public void addThing(Thing thing) {
		if (this.totalWeight() + thing.getWeight() <= this.maxWeight) {
			this.things.add(thing);
		}
	}

	public void printThings() {
		for (Thing t : this.things) {
			System.out.println(t);
		}
	}

	public int totalWeight() {
		int currentWeight = 0;

		for (Thing thing : this.things) {
			currentWeight += thing.getWeight();
		}
		return currentWeight;
	}

	public Thing heaviestThing() {
		Thing heaviest = null;

		for (Thing t : this.things) {
			if (heaviest == null) {
				heaviest = t;
			}

			if (t.getWeight() > heaviest.getWeight()) {
				heaviest = t;
			}
		}

		return heaviest;
	}

	@Override
	public String toString() {

		String thingStr = "thing";

		if (this.things.size() > 1) {
			thingStr += "s";
		}

		if (this.things.size() > 0) {
			return "" + this.things.size() + " " + thingStr + " (" + this.totalWeight() + " kg)";
		} else {
			return "empty (" + this.totalWeight() + " kg)";
		}
	}
}
