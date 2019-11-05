package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class ActionEventListener implements ActionListener {

	private JTextField textArea;
	private JLabel label;

	public ActionEventListener(JTextField textArea, JLabel label) {
		this.textArea = textArea;
		this.label = label;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = this.textArea.getText();
		this.textArea.setText("");
		this.label.setText(text);
	}

}

public class NoticeBoard implements Runnable {

	private JFrame frame;

	@Override
	public void run() {
		this.frame = new JFrame("Notice Board");
		this.frame.setPreferredSize(new Dimension(500, 500));
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.createComponents(this.frame.getContentPane());

		this.frame.pack();
		this.frame.setVisible(true);
	}

	private void createComponents(Container container) {

		GridLayout gl = new GridLayout(3, 1);
		container.setLayout(gl);

		JTextField textField = new JTextField();
		JButton button = new JButton("Copy!");
		JLabel label = new JLabel();

		button.addActionListener(new ActionEventListener(textField, label));

		container.add(textField);
		container.add(button);
		container.add(label);
	}
}
