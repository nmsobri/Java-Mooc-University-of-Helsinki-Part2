/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author slier
 */
public class MaxWeightBox extends Box {

	private int maxWeight;
	private List<Thing> lists;

	public MaxWeightBox(int maxWeight) {
		this.maxWeight = maxWeight;
		this.lists = new ArrayList<Thing>();
	}

	private int totalWeight() {
		int totalWeight = 0;

		for (Thing t : this.lists) {
			totalWeight += t.getWeight();
		}

		return totalWeight;
	}

	@Override
	public void add(Thing thing) {

		if (this.totalWeight() + thing.getWeight() <= this.maxWeight) {
			this.lists.add(thing);
		}
	}

	@Override
	public boolean isInTheBox(Thing thing) {
		return this.lists.contains(thing);
	}

}
