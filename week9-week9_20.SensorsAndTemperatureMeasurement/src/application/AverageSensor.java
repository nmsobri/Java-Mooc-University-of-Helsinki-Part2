/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author slier
 */
public class AverageSensor implements Sensor {

	private ArrayList<Sensor> sensors;
	private ArrayList<Integer> readings;

	public AverageSensor() {
		this.sensors = new ArrayList<Sensor>();
		this.readings = new ArrayList<Integer>();
	}

	@Override
	public boolean isOn() {
		for (Sensor s : this.sensors) {
			if (!s.isOn()) {
				return false;
			}
		}

		return true;
	}

	@Override
	public void on() {
		for (Sensor s : this.sensors) {
			s.on();
		}

	}

	@Override
	public void off() {
		for (Sensor s : this.sensors) {
			s.off();
		}

	}

	@Override
	public int measure() {
		if (this.sensors.size() == 0 || this.isOn() == false) {
			throw new IllegalStateException("AverageSensor is off");
		}

		int totalTemperature = 0;

		for (Sensor s : this.sensors) {
			totalTemperature += s.measure();
		}

		int reading = totalTemperature / this.sensors.size();
		this.readings.add(reading);
		return reading;
	}

	public void addSensor(Sensor additional) {
		this.sensors.add(additional);
	}

	public List<Integer> readings() {
		return this.readings;
	}

}
