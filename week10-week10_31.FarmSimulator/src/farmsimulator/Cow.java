/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Random;

/**
 *
 * @author slier
 */
public class Cow implements Milkable, Alive {

	private String name;
	private double milkAmount;
	private int udderCapacity;

	private static final String[] NAMES = new String[]{
		"Anu", "Arpa", "Essi", "Heluna", "Hely",
		"Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
		"Jaana", "Jami", "Jatta", "Laku", "Liekki",
		"Mainikki", "Mella", "Mimmi", "Naatti",
		"Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
		"Rima", "Soma", "Sylkki", "Valpu", "Virpi"
	};

	public Cow() {
		this(Cow.NAMES[new Random().nextInt(Cow.NAMES.length - 1)]);
	}

	public Cow(String name) {
		this.name = name;
		this.milkAmount = 0;
		this.udderCapacity = 15 + new Random().nextInt(26);
	}

	public String getName() {
		return this.name;
	}

	public double getCapacity() {
		return this.udderCapacity;
	}

	public double getAmount() {
		return this.milkAmount;
	}

	@Override
	public String toString() {
		return this.name + " " + Math.ceil(this.milkAmount) + "/" + Math.ceil(this.udderCapacity);
	}

	@Override
	public double milk() {
		double milk = this.milkAmount;
		this.milkAmount = 0;
		return milk;
	}

	@Override
	public void liveHour() {
		Random rnd = new Random();
		double amount = 0.7 + ((2 - 0.7) * rnd.nextDouble());

		this.milkAmount += amount;

		if (this.milkAmount > this.udderCapacity) {
			this.milkAmount = this.udderCapacity;
		}
	}

}
