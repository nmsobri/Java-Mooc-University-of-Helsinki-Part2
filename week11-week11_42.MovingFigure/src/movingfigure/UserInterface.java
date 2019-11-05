package movingfigure;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

	private JFrame frame;
	private Figure figure;

	public UserInterface(Figure f) {
		this.figure = f;
	}

	@Override
	public void run() {
		this.frame = new JFrame();
		this.frame.setPreferredSize(new Dimension(400, 400));

		this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		createComponents(frame.getContentPane());
		addListeners();

		this.frame.pack();
		this.frame.setVisible(true);
	}

	private void createComponents(Container container) {
		container.add(new DrawingBoard(this.figure));
	}

	private void addListeners() {
		this.frame.addKeyListener(new KeyboardListener(frame, figure));
	}

	public JFrame getFrame() {
		return this.frame;
	}
}
