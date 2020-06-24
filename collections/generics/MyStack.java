package generics;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

class MyStack<E>  extends  AbstractDispenser<E> implements Dispenser<E> {


	public MyStack(){
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
		int last = items.size()-1;
		List<E> queueItems = (List<E>) items;
		return queueItems.remove(last);
	}







}
