package classes;

public class AbstractDemo {

    public static void main(String... args) {

        new ParentA(); // will call AbstractA constructor, will call overriding method.
    }
}


abstract class AbstractA {

    abstract void abstractMethodOne();

    abstract void abstractMethodTwo();


}


abstract class AbstractB extends AbstractA {

    AbstractB() { print(); }


    void abstractMethodOne() { /* may implement some methods */ }

    abstract void print();
}


class ParentA extends AbstractB {

    void abstractMethodTwo() { /* must implement all methods */ }

    void print() { System.out.println("foo"); }
}
