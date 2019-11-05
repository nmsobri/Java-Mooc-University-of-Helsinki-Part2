package clicker.ui;

import clicker.applicationlogic.Calculator;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

	private Calculator calc;

	private JFrame frame;

	public UserInterface(Calculator calc) {
		this.calc = calc;
	}

	@Override
	public void run() {
		frame = new JFrame("Click Effect");
		frame.setPreferredSize(new Dimension(300, 300));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		createComponents(frame.getContentPane());

		frame.pack();
		frame.setVisible(true);
	}

	private void createComponents(Container container) {
		container.setLayout(new BorderLayout());

		JLabel label = new JLabel("0");
		JButton button = new JButton("Click!");
		button.addActionListener(new ClickListener(this.calc, label));

		container.add(label, BorderLayout.NORTH);
		container.add(button, BorderLayout.SOUTH);
	}

	public JFrame getFrame() {
		return frame;
	}
}
