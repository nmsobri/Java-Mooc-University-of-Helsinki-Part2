/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author slier
 */
public class ContainerHistory {

	private List<Double> history;

	public ContainerHistory() {
		this.history = new ArrayList<Double>();
	}

	public void add(double situation) {
		this.history.add(situation);
	}

	public void reset() {
		this.history.clear();
	}

	@Override
	public String toString() {
		return this.history.toString();
	}

	public double maxValue() {
		double value = 0;

		for (double v : this.history) {
			if (v > value) {
				value = v;
			}
		}

		return value;
	}

	public double minValue() {
		double value = this.history.get(0);

		for (double v : this.history) {
			if (v < value) {
				value = v;
			}
		}

		return value;
	}

	public double average() {
		double value = 0;

		for (double v : this.history) {
			value += v;
		}

		return value / this.history.size();

	}

	public double greatestFluctuation() {
		double greatestFluctuation = 0;

		for (int i = 0; i < this.history.size() - 1; i++) {
			double result = this.history.get(i) - this.history.get(i + 1);

			if (Math.abs(result) > greatestFluctuation) {
				greatestFluctuation = Math.abs(result);
			}
		}

		return greatestFluctuation;
	}

	public double variance() {
		double total = 0;
		double variance = 0;

		for (double val : this.history) {
			total += val;
		}

		double average = total / this.history.size();

		for (double val : this.history) {
			variance += Math.pow(val - average, 2);
		}

		return variance / (this.history.size() - 1);
	}

}
