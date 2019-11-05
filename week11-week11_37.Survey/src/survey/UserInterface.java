package survey;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UserInterface implements Runnable {

	private JFrame frame;

	@Override
	public void run() {
		this.frame = new JFrame("Survey");
		this.frame.setPreferredSize(new Dimension(300, 300));
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setComponent(this.frame.getContentPane());
		this.frame.pack();
		this.frame.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}

	private void setComponent(Container container) {
		BoxLayout bl = new BoxLayout(container, BoxLayout.Y_AXIS);
		container.setLayout(bl);

		container.add(new JLabel("Are you?"));
		container.add(new JCheckBox("Yes!"));
		container.add(new JCheckBox("No!"));
		container.add(new JLabel("Why?"));


		JRadioButton choice1 = new JRadioButton("No reason.");
		JRadioButton choice2 = new JRadioButton("Because it is fun!");

		ButtonGroup bg = new ButtonGroup();
		bg.add(choice1);
		bg.add(choice2);

		container.add(choice1);
		container.add(choice2);

		JButton button= new JButton("Done!");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Message receivedddddddddd!!!!");
			}
		});

		container.add(button);
	}
}
