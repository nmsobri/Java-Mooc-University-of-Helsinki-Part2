/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author slier
 */
public class DrawingBoard extends JPanel {

	private Figure figure;

	public DrawingBoard(Figure f) {
		super.setBackground(Color.WHITE);
		this.figure = f;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.figure.draw(g);

	}
}
