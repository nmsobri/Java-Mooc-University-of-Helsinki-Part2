
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author slier
 */
public class DecreaseValue implements ActionListener {

	private JTextField textField1;
	private JTextField textField2;
	private JButton buttonReset;

	public DecreaseValue(JTextField t1, JTextField t2, JButton buttonReset) {
		this.textField1 = t1;
		this.textField2 = t2;
		this.buttonReset = buttonReset;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			int value1 = Integer.parseInt(this.textField1.getText());
			int value2 = Integer.parseInt(this.textField2.getText());
			int result = value1 - value2;

			if (result != 0) {
				this.buttonReset.setEnabled(true);
			}

			this.textField1.setText(String.valueOf(result));
			this.textField2.setText("");

		} catch (Exception ex) {
			this.textField2.setText("");
		}
	}

}
