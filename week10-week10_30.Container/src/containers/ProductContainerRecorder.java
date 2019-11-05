/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 *
 * @author slier
 */
public class ProductContainerRecorder extends ProductContainer {

	private ContainerHistory history;

	public ProductContainerRecorder(String productName, double capacity, double initialVolume) {
		super(productName, capacity);
		this.history = new ContainerHistory();

		this.addToTheContainer(initialVolume);
	}

	public String history() {
		return this.history.toString();
	}

	@Override
	public void addToTheContainer(double amount) {
		super.addToTheContainer(amount);
		this.history.add(this.getVolume());
	}

	@Override
	public double takeFromTheContainer(double amount) {
		double take = super.takeFromTheContainer(amount);
		this.history.add(this.getVolume());
		return take;
	}

	public void printAnalysis() {
		System.out.println("Product: " + this.getName());
		System.out.println("History: " + this.history.toString());
		System.out.println("Greatest product amount: " + this.history.maxValue());
		System.out.println("Smallest product amount: " + this.history.minValue());
		System.out.println("Average: " + this.history.average());
		System.out.println("Greatest change: " + this.history.greatestFluctuation());
		System.out.println("Variance: 39.129999999999676" + this.history.variance());
	}

}
