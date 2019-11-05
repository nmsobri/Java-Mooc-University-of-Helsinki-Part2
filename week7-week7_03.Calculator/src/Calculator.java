/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author slier
 */
public class Calculator {

	private Reader reader;
	private int calculationCounter;

	public Calculator() {
		this.reader = new Reader();
		this.calculationCounter = 0;
	}

	public void start() {
		while (true) {
			System.out.print("command: ");
			String command = reader.readString();

			if (command.equals("end")) {
				break;
			}

			if (command.equals("sum")) {
				sum();
			} else if (command.equals("difference")) {
				difference();
			} else if (command.equals("product")) {
				product();
			}
		}

		statistics();
	}

	private void sum() {
		int[] input = this.askInput();
		System.out.println("sum of the values: " + (input[0] + input[1]));
		this.calculationCounter++;

	}

	private void difference() {
		int[] input = this.askInput();
		System.out.println("difference of the values: " + (input[0] - input[1]));
		this.calculationCounter++;
	}

	private void product() {
		int[] input = this.askInput();
		System.out.println("product of the values: " + (input[0] * input[1]));
		this.calculationCounter++;
	}

	private void statistics() {
		System.out.println("Calculations done " + this.calculationCounter);
	}

	private int[] askInput() {
		int[] input = new int[2];

		System.out.print("value 1: ");
		input[0] = this.reader.readInteger();

		System.out.print("value 2: ");
		input[1] = this.reader.readInteger();

		return input;
	}

}
