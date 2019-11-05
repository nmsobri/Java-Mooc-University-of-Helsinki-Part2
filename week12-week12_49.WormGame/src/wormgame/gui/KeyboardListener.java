/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.gui;

import wormgame.Direction;
import wormgame.domain.Worm;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author slier
 */
public class KeyboardListener implements KeyListener {

	private Worm worm;

	public KeyboardListener(Worm w) {
		this.worm = w;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {

			case KeyEvent.VK_UP:
				this.worm.setDirection(Direction.UP);
				break;
			case KeyEvent.VK_DOWN:
				this.worm.setDirection(Direction.DOWN);
				break;
			case KeyEvent.VK_LEFT:
				this.worm.setDirection(Direction.LEFT);
				break;
			case KeyEvent.VK_RIGHT:
				this.worm.setDirection(Direction.RIGHT);
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
