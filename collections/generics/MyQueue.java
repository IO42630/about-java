package generics;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

class MyQueue<E> extends AbstractDispenser<E> implements Dispenser<E>  {



	public MyQueue(){
		super.items = new ArrayList<>();
	}



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
		int first = 0;
		List<E> queueItems = (List<E>) items;
		return queueItems.remove(first);
	}








}
