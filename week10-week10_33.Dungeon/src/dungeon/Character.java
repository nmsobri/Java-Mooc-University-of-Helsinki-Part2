/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author slier
 */
public abstract class Character {

	protected int x;
	protected int y;
	protected int length;
	protected int height;

	public Character(int x, int y, int length, int height) {
		this.x = x;
		this.y = y;
		this.length = length;
		this.height = height;
	}

	public abstract void move();

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

}
