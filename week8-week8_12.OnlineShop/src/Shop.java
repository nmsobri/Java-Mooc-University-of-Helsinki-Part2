
import java.util.Scanner;

public class Shop {

	private Storehouse store;
	private Scanner reader;

	public Shop(Storehouse store, Scanner reader) {
		this.store = store;
		this.reader = reader;
	}

	// The method to deal with a customer in the shop
	public void manage(String customer) {
		ShoppingBasket basket = new ShoppingBasket();

		System.out.println("Welcome to our shop " + customer);
		System.out.println("\nBelow is our sale offer:");

		for (String product : store.products()) {
			System.out.println(product);
		}

		while (true) {
			System.out.print("\nWhat do you want to buy (press enter to pay):");
			String product = reader.nextLine();

			if (product.isEmpty()) {
				break;
			}

			if (store.product(product) && store.stock(product) > 0) {
				basket.add(product, store.price(product));
				store.take(product);
			}

			// here, you write the code to add a product to the shopping basket, if the storehouse is not empty
			// and decreases the storehouse stocks
			// do not touch the rest of the code!
		}

		System.out.println("your purchases are:");
		basket.print();
		System.out.println("basket price: " + basket.price());
	}
}
