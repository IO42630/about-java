package com.olexyn.about.java.design.patterns.behavioural;
/*
 * Iterator.
 * Provide a way to access the elements of an aggregate object sequentially
 * without exposing its underlying representation.
 */

// Iterator - - - - - - - - - -
interface Iterator {
    public Object next();

    public boolean isDone();
}

class ConcreteIterator implements Iterator {
    private int position = 0;
    ConcreteAggregate aggregate;

    ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public Object next() {
        if (!this.isDone()) return aggregate.array[position++];
        else return null;
    }

    @Override
    public boolean isDone() {
        if (position < aggregate.array.length) return false;
        else return true;
    }

}

// Aggregate - - - - -
interface Aggregate {
    Iterator createIterator();
}

class ConcreteAggregate implements Aggregate {
    public Object[] array = {1,
                             "a",
                             3,
                             4,
                             5,
                             6};

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }
}

// MAIN ----------
public class IteratorDemo {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        Iterator iterator = aggregate.createIterator();

        while (!iterator.isDone()) {
            System.out.print(iterator.next() + ", ");
        }
    }
}
