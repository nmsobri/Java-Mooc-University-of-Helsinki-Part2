/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker.ui;

import clicker.applicationlogic.Calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author slier
 */
public class ClickListener implements ActionListener {

	private Calculator calc;
	private JLabel label;

	public ClickListener(Calculator calc, JLabel label) {
		this.calc = calc;
		this.label = label;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.calc.increase();
		this.label.setText(String.valueOf(this.calc.giveValue()));

	}

}
