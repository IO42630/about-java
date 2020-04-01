package structural;

// DECORATOR - - - - - - - -
interface Item {
	public int getCost();
}

class Apple implements Item {// (1) simple object implements interface
	public int getCost() {
		return 1;
	}
}

abstract class Decorator implements Item {// (2) abstract decorator, same interface
	protected Item item;

	public Decorator(Item i) {
		this.item = i;
	}

	public int getCost() {
		return item.getCost()+addCost();
	}
	
	protected int addCost(){
		return 0;
	}
}

class Pie extends Decorator {// (3) concrete decorator extends
	public Pie(Item i) {
		super(i);
	}

	@Override
	protected int addCost() {
		return 2;
	}
}

// MAIN - - - - - - - - - - - - - - - - - - - - - - - - -
public class DecoratorDemo {
	public static void main(String args[]) {
		Item applepie = new Pie(new Apple());
		System.out.println(applepie.getCost());
	}
}