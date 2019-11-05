/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.Random;

/**
 *
 * @author slier
 */
public class Vampire extends Character {

	private boolean move;

	public Vampire(int length, int height, boolean move) {
		super(0, 0, length, height);
		this.move = move;
		this.randomizeCoordinate();
	}

	@Override
	public void move() {
		if (this.move) {

			int x = this.y;
			int y = this.x;

			int movement = new Random().nextInt(4);

			switch (movement) {
				case 0:
					y -= 1;
					break;
				case 1:
					y += 1;
					break;
				case 2:
					x -= 1;
					break;
				case 3:
					x += 1;
					break;
				default:
					break;
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

			this.x = y;
			this.y = x;
		}
	}

	private void randomizeCoordinate() {
		Random r = new Random();
		this.x = r.nextInt(this.length);
		this.y = r.nextInt(this.height);
	}

}
