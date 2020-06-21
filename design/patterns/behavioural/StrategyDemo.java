package patterns.behavioural;

/*
 * Strategy.
 * Define a family of algorithms(1), lets the clients choose the implementation (2).
 */

interface PaymentStrategy {// (1)
	public void excecute(int amount);
}

class CreditCardStrategy implements PaymentStrategy {
	@Override
	public void excecute(int amount) {
		System.out.println(amount + " paid with credit card");
	}
}

class PaypalStrategy implements PaymentStrategy {
	@Override
	public void excecute(int amount) {
		System.out.println(amount + " paid with paypal");
	}
}

class Item {
	private int price;
	public Item(int cost) {
		this.price = cost;
	}
	public void paywith(PaymentStrategy paymentMethod) { // (2)
		paymentMethod.excecute(price);
	}
}

public class StrategyDemo {
	public static void main(String[] args) {
		new Item(10).paywith(new PaypalStrategy());
		new Item(40).paywith(new CreditCardStrategy());
	}
}
