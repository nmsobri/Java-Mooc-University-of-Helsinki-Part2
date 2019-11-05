package greeter.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable {

	private JFrame frame;

	@Override
	public void run() {
		this.frame = new JFrame("Swing on");
		this.frame.setPreferredSize(new Dimension(400, 200));
		this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		createComponents(frame.getContentPane());

		this.frame.pack();
		this.frame.setVisible(true);
	}

	private void createComponents(Container container) {
		BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
		container.setLayout(layout);

		container.add(new JLabel("Choose meat or fish:"));

		JRadioButton meat = new JRadioButton("Meat");
		JRadioButton fish = new JRadioButton("Fish");

//		ButtonGroup buttonGroup = new ButtonGroup();
//		buttonGroup.add(meat);
//		buttonGroup.add(fish);

		container.add(meat);
		container.add(fish);
	}

	public JFrame getFrame() {
		return frame;
	}
}
