
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GraphicCalculator implements Runnable {

	private JFrame frame;
	private JTextField textField1;
	private JTextField textField2;

	@Override
	public void run() {
		this.frame = new JFrame("Calculator");
		this.frame.setPreferredSize(new Dimension(400, 200));
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.createComponents(this.frame.getContentPane());

		this.frame.pack();
		this.frame.setVisible(true);
	}

	private void createComponents(Container container) {
		container.setLayout(new GridLayout(3, 1));

		this.textField1 = new JTextField("0");
		this.textField1.setEnabled(false);
		this.textField2 = new JTextField("0");

		container.add(this.textField1);
		container.add(this.textField2);
		container.add(this.bottomPanel());
	}

	public JFrame getFrame() {
		return this.frame;
	}

	private JPanel bottomPanel() {
		JPanel panel = new JPanel(new GridLayout(1, 3));
		JButton buttonReset = new JButton("Z");
		buttonReset.setEnabled(false);
		buttonReset.addActionListener(new ResetValue(textField1, textField2, buttonReset));

		JButton buttonIncrease = new JButton("+");
		buttonIncrease.addActionListener(new IncreaseValue(textField1, textField2, buttonReset));

		JButton buttonDecrease = new JButton("-");
		buttonDecrease.addActionListener(new DecreaseValue(textField1, textField2, buttonReset));

		panel.add(buttonIncrease);
		panel.add(buttonDecrease);
		panel.add(buttonReset);
		return panel;
	}
}
