package generics;

import java.util.Collection;

public abstract class AbstractDispenser<E> implements Dispenser<E> {

    protected final static int MAX_ITEM = 100;
    protected Collection<E> items;


    @Override
    public void print() {
        for (E e : items) {
            System.out.println(e);
        }
    }
}



