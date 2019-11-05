
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
public class Box implements ToBeStored {

	private ArrayList<ToBeStored> items;
	private double maxWeight;

	public Box(double maxWeight) {
		this.items = new ArrayList<ToBeStored>();
		this.maxWeight = maxWeight;
	}

	public void add(ToBeStored item) {
		double currentWeight = this.weight();

		if (currentWeight + item.weight() < this.maxWeight) {
			this.items.add(item);
		}
	}

	@Override
	public double weight() {
		double currentWeight = 0;

		for (ToBeStored i : this.items) {
			currentWeight += i.weight();
		}

		return currentWeight;
	}

	@Override
	public String toString() {
		return "Box: " + this.items.size() + " things, total weight " + this.weight() + " kg";
	}
}
