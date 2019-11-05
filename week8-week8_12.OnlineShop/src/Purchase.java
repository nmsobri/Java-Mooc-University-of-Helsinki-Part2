/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author slier
 */
public class Purchase {

	private String product;
	private int unitPrice;
	private int amount;

	public Purchase(String product, int amount, int unitPrice) {
		this.product = product;
		this.amount = amount;
		this.unitPrice = unitPrice;
	}

	public int price() {
		return this.unitPrice * this.amount;
	}

	public int amount() {
		return this.amount;
	}

	public void increaseAmount() {
		this.amount++;
	}

	@Override
	public String toString() {
		return "" + this.product + ": " + this.amount;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 23 * hash + (this.product != null ? this.product.hashCode() : 0);
		hash = 23 * hash + this.unitPrice;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Purchase other = (Purchase) obj;
		if (this.unitPrice != other.unitPrice) {
			return false;
		}
		if ((this.product == null) ? (other.product != null) : !this.product.equals(other.product)) {
			return false;
		}
		return true;
	}

}
