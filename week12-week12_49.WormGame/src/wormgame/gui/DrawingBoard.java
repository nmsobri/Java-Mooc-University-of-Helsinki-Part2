/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.game.WormGame;

/**
 *
 * @author slier
 */
public class DrawingBoard extends JPanel implements Updatable {

	private int pieceLength;
	private WormGame wormGame;

	public DrawingBoard(WormGame wg, int pieceLength) {
		this.wormGame = wg;
		this.pieceLength = pieceLength;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Worm w = this.wormGame.getWorm();
		Apple a = this.wormGame.getApple();

		g.setColor(Color.BLACK);
		for (Piece p : w.getPieces()) {
			g.fill3DRect(p.getX() * this.pieceLength, p.getY() * this.pieceLength, this.pieceLength, this.pieceLength, true);
		}

		g.setColor(Color.RED);
		g.fillOval(a.getX() * this.pieceLength, a.getY() * this.pieceLength, this.pieceLength, this.pieceLength);
	}

	@Override
	public void update() {
		this.repaint();
	}

}
