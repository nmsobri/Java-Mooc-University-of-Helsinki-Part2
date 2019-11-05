/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author slier
 */
public class Dungeon {

	private int moves;
	private int length;
	private int height;
	private Scanner scanner;
	private int vampireCount;
	private boolean vampireMove;
	private Player player;
	private List<Vampire> vampires;

	public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
		this.length = length;
		this.height = height;
		this.vampireCount = vampires;
		this.moves = moves;
		this.vampireMove = vampiresMove;
		this.scanner = new Scanner(System.in);
		this.player = new Player(length, height);
		this.initVampires();
	}

	public void run() {
		while (this.moves > 0) {
			this.printPlayerMove();
			this.printPlayers();
			this.printDungeon();

			this.player.move();
			this.checkCollision();

			this.vampireMove();
			this.checkCollision();
			this.moves--;

			if (this.vampires.size() == 0) {
				break;
			}
		}

		if (this.moves <= 0) {
			System.out.println("YOU LOSE");
		} else {
			System.out.println("YOU WIN");
		}
	}

	private void printDungeon() {
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.length; j++) {
				if (this.player.getX() == j && this.player.getY() == i) {
					System.out.print("@");
				} else {
					boolean isFound = false;

					for (Vampire vampire : this.vampires) {
						if (vampire.getX() == j && vampire.getY() == i) {
							System.out.print("v");
							isFound = true;
						}
					}
					if (!isFound) {
						System.out.print(".");
					}
				}
			}

			System.out.println();
		}
	}

	private void printPlayers() {
		System.out.println("@ " + this.player.getX() + " " + this.player.getY());

		for (Vampire vampire : this.vampires) {
			System.out.println("v " + vampire.getX() + " " + vampire.getY());
		}

		System.out.println();
	}

	private void printPlayerMove() {
		System.out.println(this.moves);
		System.out.println();
	}

	private void initVampires() {
		this.vampires = new ArrayList<Vampire>();

		for (int i = 0; i < this.vampireCount; i++) {
			this.vampires.add(new Vampire(this.length, this.height, this.vampireMove));
		}
	}

	private void vampireMove() {
		for (Vampire v : this.vampires) {
			v.move();
		}
	}

	private void checkCollision() {
		List<Character> toBeRemoved = new ArrayList<Character>();

		for (Vampire v : this.vampires) {

			if (v.getX() == this.player.getX() && v.getY() == this.player.getY()) {
				toBeRemoved.add(v);
			}
		}

		this.vampires.removeAll(toBeRemoved);
	}
}
