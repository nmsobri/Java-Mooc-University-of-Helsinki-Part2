/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

import java.util.ArrayList;

/**
 *
 * @author slier
 */
public class Box implements Thing {

	private int maxVolume;
	private ArrayList<Thing> things;

	public Box(int maxVolume) {
		this.maxVolume = maxVolume;
		this.things = new ArrayList<Thing>();
	}

	public boolean addThing(Thing t) {
		if (this.currentTotalVolume() + t.getVolume() <= this.maxVolume) {
			this.things.add(t);
			return true;
		}

		return false;
	}

	private int currentTotalVolume() {
		int currentTotalVolume = 0;

		for (Thing i : this.things) {
			Item item = (Item) i;
			currentTotalVolume += item.getVolume();
		}

		return currentTotalVolume;
	}

	@Override
	public int getVolume() {
		return this.currentTotalVolume();
	}

}
