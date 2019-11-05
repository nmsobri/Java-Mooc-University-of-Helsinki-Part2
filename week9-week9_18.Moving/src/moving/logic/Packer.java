/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.logic;

import java.util.ArrayList;
import java.util.List;
import moving.domain.Box;
import moving.domain.Thing;

/**
 *
 * @author slier
 */
public class Packer {

	private int boxesVolume;

	public Packer(int boxesVolume) {
		this.boxesVolume = boxesVolume;
	}

	public List<Box> packThings(List<Thing> things) {
		ArrayList<Box> boxes = new ArrayList<Box>();

		Box b = new Box(this.boxesVolume);

		for (Thing t : things) {
			if (!b.addThing(t)) {
				boxes.add(b);
				b = new Box(this.boxesVolume);
				b.addThing(t);
			}
		}

		boxes.add(b);

		return boxes;
	}
}
