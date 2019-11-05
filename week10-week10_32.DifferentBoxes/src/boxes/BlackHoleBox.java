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
public class BlackHoleBox extends Box {

	private List<Thing> lists;

	public BlackHoleBox() {
		this.lists = new ArrayList<Thing>();
	}

	@Override
	public void add(Thing thing) {
		this.lists.add(thing);
	}

	@Override
	public boolean isInTheBox(Thing thing) {
		return false;
	}

}
