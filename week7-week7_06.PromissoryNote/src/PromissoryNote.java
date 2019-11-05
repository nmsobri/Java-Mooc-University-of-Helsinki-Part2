
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author slier
 */
public class PromissoryNote {

	private HashMap<String, Double> loans;

	public PromissoryNote() {
		this.loans = new HashMap<String, Double>();
	}

	public void setLoan(String name, double amount) {
		this.loans.put(name, amount);
	}

	public double howMuchIsTheDebt(String name) {
		if (this.loans.containsKey(name)) {
			return this.loans.get(name);
		}

		return 0;
	}

}
