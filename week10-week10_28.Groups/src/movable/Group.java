/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author slier
 */
public class Group implements Movable {

	private List<Movable> movables;

	public Group() {
		this.movables = new ArrayList<Movable>();
	}

	public void addToGroup(Movable movable) {
		this.movables.add(movable);
	}

	@Override

	public String toString() {
		String result = "";

		for (Movable m : this.movables) {
			result += m.toString() + "\n";
		}

		return result;
	}

	@Override
	public void move(int dx, int dy) {

		for (Movable m : this.movables) {
			m.move(dx, dy);
		}
	}

}
