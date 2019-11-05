/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author slier
 */
public class Farm {

	private String name;
	private Barn barn;
	private List<Cow> cows;

	public Farm(String name, Barn barn) {
		this.name = name;
		this.barn = barn;
		this.cows = new ArrayList<Cow>();
	}

	public String getOwner() {
		return this.name;
	}

	public void addCow(Cow c) {
		this.cows.add(c);
	}

	public void liveHour() {
		for (Cow c : this.cows) {
			c.liveHour();
		}
	}

	public void installMilkingRobot(MilkingRobot robot) {
		this.barn.installMilkingRobot(robot);
	}

	public void manageCows() {
		this.barn.takeCareOf(this.cows);
	}

	@Override
	public String toString() {
		String farmSummary = "";

		farmSummary += "Farm owner: " + this.name + "\n";
		farmSummary += "Barn bulk tank: " + this.barn.toString() + "\n";

		if (this.cows.size() > 0) {
			farmSummary += "Animals: \n";
			for (Cow c : this.cows) {
				farmSummary += c.toString() + "\n";
			}
		} else {
			farmSummary += "No cows.";
		}

		return farmSummary;
	}

}
