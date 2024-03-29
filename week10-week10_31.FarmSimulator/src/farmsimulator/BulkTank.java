/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author slier
 */
public class BulkTank {

	private double capacity;
	private double volume;

	public BulkTank() {
		this(2000);
	}

	public BulkTank(double capacity) {
		this.capacity = capacity;
	}

	public double getCapacity() {
		return this.capacity;
	}

	public double getVolume() {
		return this.volume;
	}

	public double howMuchFreeSpace() {
		return this.capacity - this.volume;
	}

	public void addToTank(double amount) {
		if (this.volume + amount > this.capacity) {
			this.volume = this.capacity;
		} else {
			this.volume += amount;
		}
	}

	public double getFromTank(double amount) {
		double returnAmount = 0;

		if (amount > this.volume) {
			this.volume = 0;
			returnAmount = this.volume;
		} else {
			this.volume -= amount;
			returnAmount = amount;
		}

		return returnAmount;
	}

	@Override
	public String toString() {
		return Math.ceil(this.volume) + " / " + Math.ceil(this.capacity);
	}

}
