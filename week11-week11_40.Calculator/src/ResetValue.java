
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
public class ResetValue implements ActionListener {

	private JTextField textField1;
	private JTextField textField2;
	private JButton buttonReset;

	public ResetValue(JTextField t1, JTextField t2, JButton buttonReset) {
		this.textField1 = t1;
		this.textField2 = t2;
		this.buttonReset = buttonReset;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.textField1.setText("0");
		this.textField2.setText("");
		this.buttonReset.setEnabled(false);
	}

}
