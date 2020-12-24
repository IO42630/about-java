package examples;

import java.util.EmptyStackException;
import java.util.ArrayList;

/**
 * this is a dispenser, which consists of E's
 */
interface Dispenser<E> {
	public void put(E item);

	public E remove();

	public E item();

	public boolean isEmpty();
}




class DispenserPrint<E> {
	E e;

	void put(Dispenser<E> d, E BLOCK) {
		d.put(BLOCK);
		System.out.println(" " + BLOCK + "  => [  ]");
	}

	void view(Dispenser<E> d) {
		System.out.println("[" + d.item() + "]");
	}

	void checkEmpty(Dispenser<E> d) {
		if (d.isEmpty()) {
			System.out.println("YOUR DISPENSER IS EMPTY");
		} else {
			System.out.println("YOUR DISPENSER IS NOT EMPTY");
		}
	}

	void remove(Dispenser<E> d) {
		System.out.println("[  ] =>  " + d.item());
		d.remove();
	}

}

public class GenericsDemo extends DispenserPrint {

	static final int BLOCK1 = 42;
	static final String BLOCK2 = "hi";

	static <E> void main(String[] args) {

		E e;

		Dispenser<E> testMyStack = new MyStack<E>();
		Dispenser<E> testMyQueue = new MyQueue<E>();
		

		Dispenser[] Dispensers = { testMyStack, testMyQueue };

		DispenserPrint print = new DispenserPrint();

		for (Dispenser<E> d : Dispensers) {
			System.out.println("TESTING : " + d);
			try {
				print.put(d, BLOCK1);
				print.put(d, BLOCK2);
				print.view(d);
				print.remove(d);
				print.checkEmpty(d);
				print.view(d);
				print.remove(d);
				print.checkEmpty(d);
				print.remove(d);
				//
			} catch (EmptyStackException eErr) {
				System.out.println("NOTHING LEFT TO REMOVE : EXIT");
			} catch (StackOverflowError sErr) {
				System.out.println("NO SPACE LEFT : EXIT");
			}
			System.out.println(" ");
		}

	}
}

class MyQueue<E> implements Dispenser<E> {

	private final int MAX_ITEM = 100;
	private final ArrayList<E> items = new ArrayList<E>();

	public void put(E item) {
		if (items.size() - 1 >= MAX_ITEM) {
			throw new StackOverflowError();
		}
		items.add(item);
	}

	public E remove() {
		if (items.isEmpty()) {
			throw new EmptyStackException();
		}
		E oldItem = items.get(0);
		items.remove(0);
		return oldItem;
	}

	public E item() {
		if (items.isEmpty()) {
			throw new EmptyStackException();
		}
		return items.get(0);
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}

}

class MyStack<E> implements Dispenser<E> {

	private final int MAX_ITEM = 100;
	private final ArrayList<E> items = new ArrayList<E>();

	public void put(E item) {
		if (items.size() - 1 >= MAX_ITEM) {
			throw new StackOverflowError();
		}
		items.add(item);
	}

	public E remove() {
		if (items.isEmpty()) {
			throw new EmptyStackException();
		}
		E oldItem = items.get(items.size() - 1);
		items.remove(items.size() - 1);
		return oldItem;
	}

	public E item() {
		if (items.isEmpty()) {
			throw new EmptyStackException();
		}
		return items.get(items.size() - 1);
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}

}
