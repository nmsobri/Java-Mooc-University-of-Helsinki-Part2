
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author slier
 */
public class ShoppingBasket {

	private List<Purchase> purchases;

	public ShoppingBasket() {
		this.purchases = new ArrayList<Purchase>();
	}

	public void add(String product, int price) {
		Purchase p = new Purchase(product, 1, price);

		if (this.purchases.contains(p)) {
			int indexOfPurchase = this.purchases.indexOf(p);
			this.purchases.get(indexOfPurchase).increaseAmount();
		} else {
			this.purchases.add(p);
		}
	}

	public int price() {
		int totalPrice = 0;

		for (Purchase p : this.purchases) {
			totalPrice += p.price();
		}

		return totalPrice;
	}

	public void print() {
		for (Purchase p : this.purchases) {
			System.out.println(p);
		}
	}
}
