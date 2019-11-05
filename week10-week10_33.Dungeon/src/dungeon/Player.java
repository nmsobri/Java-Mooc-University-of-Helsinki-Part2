/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.Scanner;

/**
 *
 * @author slier
 */
public class Player extends Character {

	private Scanner scanner;

	public Player(int length, int height) {
		super(0, 0, length, height);
		this.scanner = new Scanner(System.in);
	}

	@Override
	public void move() {
		System.out.print("Move: ");
		String move = this.scanner.nextLine();

		int x = this.x;
		int y = this.y;

		for (int i = 0; i < move.length(); i++) {
			char movement = move.charAt(i);

			switch (movement) {
				case 'w':
					y -= 1;
					break;
				case 's':
					y += 1;
					break;
				case 'a':
					x -= 1;
					break;
				case 'd':
					x += 1;
					break;
				default:
					break;
			}
		}

		if (x < 0) {
			x = 0;
		}

		if (x >= this.length) {
			x = this.length - 1;
		}

		if (y < 0) {
			y = 0;
		}

		if (y >= this.height) {
			y = this.height - 1;
		}

		this.x = x;
		this.y = y;
	}

}
