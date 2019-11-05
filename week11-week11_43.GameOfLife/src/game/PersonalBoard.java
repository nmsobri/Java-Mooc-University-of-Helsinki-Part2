/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

/**
 *
 * @author slier
 */
public class PersonalBoard extends GameOfLifeBoard {

	public PersonalBoard(int width, int height) {
		super(width, height);
	}

	@Override
	public void initiateRandomCells(double d) {
		for (int i = 0; i < this.getHeight(); i++) {
			for (int j = 0; j < this.getWidth(); j++) {

				double probability = new Random().nextDouble();

				if (d >= probability) {
					this.getBoard()[j][i] = true;
				} else {
					this.getBoard()[j][i] = false;
				}
			}
		}
	}

	@Override
	public boolean isAlive(int x, int y) {
		if (x < 0 || x >= this.getWidth()) {
			return false;
		}

		if (y < 0 || y >= this.getHeight()) {
			return false;
		}

		return this.getBoard()[x][y];
	}

	@Override
	public void turnToLiving(int x, int y) {
		if (x < 0 || x >= this.getWidth()) {
			return;
		}

		if (y < 0 || y >= this.getHeight()) {
			return;
		}

		this.getBoard()[x][y] = true;
	}

	@Override
	public void turnToDead(int x, int y) {
		if (x < 0 || x >= this.getWidth()) {
			return;
		}

		if (y < 0 || y >= this.getHeight()) {
			return;
		}

		this.getBoard()[x][y] = false;
	}

	@Override
	public int getNumberOfLivingNeighbours(int i, int i1) {
		int numberOfLiving = 0;

		numberOfLiving += this.leftRightNeighbour(i, i1);
		numberOfLiving += this.topAllNeighbour(i, i1);
		numberOfLiving += this.bottomAllNeighbour(i, i1);

		return numberOfLiving;
	}

	@Override
	public void manageCell(int x, int y, int livingNeighbours) {
		boolean[][] livings = this.getBoard();

		if (livings[x][y]) {
			if (livingNeighbours < 2 || livingNeighbours > 3) {
				livings[x][y] = false;
			} else if ((livingNeighbours > 1 && livingNeighbours < 4)) {
				livings[x][y] = true;
			}
		} else {
			if (livingNeighbours == 3) {
				livings[x][y] = true;
			}
		}
	}

	private int leftRightNeighbour(int x, int y) {
		int live = 0;

		if (x - 1 >= 0) {
			if (this.isAlive(x - 1, y)) {
				live++;
			}
		}

		if (x + 1 < this.getWidth()) {
			if (this.isAlive(x + 1, y)) {
				live++;
			}
		}

		return live;
	}

	private int topAllNeighbour(int x, int y) {
		int live = 0;

		if (!(y - 1 >= 0)) {
			return live;
		}

		if (this.isAlive(x, y - 1)) {
			live++;
		}

		if (x - 1 >= 0) {
			if (this.isAlive(x - 1, y - 1)) {
				live++;
			}
		}

		if (x + 1 < this.getWidth()) {
			if (this.isAlive(x + 1, y - 1)) {
				live++;
			}
		}

		return live;
	}

	private int bottomAllNeighbour(int x, int y) {
		int live = 0;

		if (!(y + 1 < this.getHeight())) {
			return live;
		}

		if (this.isAlive(x, y + 1)) {
			live++;
		}

		if (x - 1 >= 0) {
			if (this.isAlive(x - 1, y + 1)) {
				live++;
			}
		}

		if (x + 1 < this.getWidth()) {
			if (this.isAlive(x + 1, y + 1)) {
				live++;
			}
		}

		return live;
	}

}
