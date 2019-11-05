/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author slier
 */
public class Thermometer implements Sensor {

	private boolean isOn;

	public Thermometer() {
		this.isOn = false;
	}

	@Override
	public boolean isOn() {
		return this.isOn;
	}

	@Override
	public void on() {
		this.isOn = true;
	}

	@Override
	public void off() {
		this.isOn = false;
	}

	@Override
	public int measure() {
		if (this.isOn == false) {
			throw new IllegalStateException("Thermometer is off");
		}

		int min = -30;
		int max = 30;

		Random r = new Random();
		int result = r.nextInt(max - min + 1) + min;
		return result;
	}

}
