package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

	private int width;
	private int height;
	private boolean continues;
	private Updatable updatable;
	private JFrame frame;
	private Worm worm;
	private Apple apple;

	public WormGame(int width, int height) {
		super(1000, null);

		this.width = width;
		this.height = height;
		this.continues = true;

		addActionListener(this);
		setInitialDelay(2000);

		this.worm = new Worm(width / 2, height / 2, Direction.DOWN);
		this.apple = this.apple();

		while (this.worm.runsInto(apple)) {
			this.apple = this.apple();
		}
	}

	public boolean continues() {
		return continues;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void setUpdatable(Updatable updatable) {
		this.updatable = updatable;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (!continues) {
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			return;
		}

		this.worm.move();

		if (this.worm.runsInto(this.apple)) {
			this.worm.grow();
			this.apple = this.apple();
		}

		if (this.worm.runsIntoItself()) {
			this.continues = false;
		}

		if (this.worm.wormHead().getX() >= this.width || this.worm.wormHead().getX() < 0) {
			this.continues = false;
		}

		if (this.worm.wormHead().getY() >= this.height || this.worm.wormHead().getY() < 0) {
			this.continues = false;
		}

		this.updatable.update();
		this.setDelay(1000 / this.worm.getLength());

	}

	public Worm getWorm() {
		return this.worm;
	}

	public void setWorm(Worm worm) {
		this.worm = worm;
	}

	public Apple getApple() {
		return this.apple;
	}

	public void setApple(Apple apple) {
		this.apple = apple;
	}

	private Apple apple() {
		Random rnd = new Random();
		return new Apple(rnd.nextInt(this.width), rnd.nextInt(height));
	}

}
