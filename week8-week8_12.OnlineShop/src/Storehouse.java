
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author slier
 */
public class Storehouse {

	private Map<String, Integer> products;
	private Map<String, Integer> stocks;

	public Storehouse() {
		this.products = new HashMap<String, Integer>();
		this.stocks = new HashMap<String, Integer>();
	}

	public void addProduct(String product, int price, int stock) {
		this.products.put(product, price);
		this.stocks.put(product, stock);
	}

	public int price(String product) {
		for (String key : this.products.keySet()) {
			if (key.equalsIgnoreCase(product)) {
				return this.products.get(key);
			}
		}

		return -99;
	}

	public int stock(String product) {
		if (this.stocks.get(product) != null) {
			return this.stocks.get(product);
		}

		return 0;
	}

	public boolean take(String product) {
		for (String key : this.stocks.keySet()) {
			if (key.equalsIgnoreCase(product)) {
				int value = this.stocks.get(key);
				--value;

				if (value >= 0) {
					this.stocks.put(key, value);
					return true;
				}

			}
		}

		return false;
	}

	public Set<String> products() {
		return this.products.keySet();
	}

	public boolean product(String product) {
		return this.products.containsKey(product);
	}

}
