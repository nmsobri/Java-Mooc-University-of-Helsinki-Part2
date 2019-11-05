/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.ArrayList;
import java.util.List;
import wormgame.Direction;

/**
 *
 * @author slier
 */
public class Worm {

	private int x;
	private int y;
	private Direction direction;
	private List<Piece> worm;
	private boolean grow;

	public Worm(int originalX, int originalY, Direction originalDirection) {
		this.x = originalX;
		this.y = originalY;
		this.direction = originalDirection;
		this.grow = false;

		this.worm = new ArrayList<Piece>();
		this.worm.add(new Piece(originalX, originalY));
	}

	public Direction getDirection() {
		return this.direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public int getLength() {
		return this.worm.size();
	}

	public List<Piece> getPieces() {
		return this.worm;
	}

	public void move() {
		int coordinateLastPiece = this.worm.size() - 1;
		int x = this.worm.get(coordinateLastPiece).getX();
		int y = this.worm.get(coordinateLastPiece).getY();

		if (this.direction != null) {
			switch (this.direction) {
				case LEFT:
					x--;
					break;
				case RIGHT:
					x++;
					break;
				case UP:
					y--;
					break;
				case DOWN:
					y++;
					break;
				default:
					break;
			}
		}

		if (this.getLength() > 2 && !this.grow) {
			this.worm.remove(0);
		}

		this.worm.add(new Piece(x, y));
		this.grow = false;
	}

	public void grow() {
		this.grow = true;
	}

	public boolean runsInto(Piece piece) {
		for (Piece p : this.worm) {
			if (p.runsInto(piece)) {
				return true;
			}
		}

		return false;
	}

	public boolean runsIntoItself() {
		for (Piece p1 : this.worm) {
			for (Piece p2 : this.worm) {

				if (p1 == p2) {
					continue;
				}

				if (p1.runsInto(p2)) {
					return true;
				}
			}
		}

		return false;
	}

	public Piece wormHead() {
		return this.worm.get(this.worm.size() - 1);
	}

}
