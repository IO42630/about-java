package about;


// Interface - - - - - - - - - - - - - -
interface Interface {
    // meant to be used as type
    // class can implement multiple interfaces

    public static final int fin = 7; // allowed

    public void show();

}


// Parent - - - - - - - - - - - - - - - - - -
class Parent implements Interface {
    public int n; // instance var can be used by instance methods but not by static methods.
    public static int s; // class var, can be used by all methods, same in all instances of a class.
    private int priv = 2; // can't be accessed by child

    public Parent() {
        // default constructor, can be omitted,
        // unless a custom constructor is defined.
        // in that case it must be written, else error.
        this(43);
    }

    public Parent(int n) {
        this.n = n; // instance variable = locale variable
        System.out.println("" + this + " n=" + n);
        // sometimes better to use ust vars in constructor, and omit methods.

    }

    @Override
    public void show() {
        System.out.println("" + this + ".show() n=" + n);
    }
}


// Child - - - - - - - - - - - - - - - - - -
class Child extends Parent {
    // internal class => encapsulation

    public Child() {
        this(23);
    }

    public Child(int n) {
        super(n);
    }

    @Override
    public void show() {

        super.show();
    }


}


public class Class {
    // classes and instances are objects


    public static void main(String[] args) {


        Child a = new Child(); // "new" calls constructor
        a.show();
        System.out.println();

        Parent b = new Parent();
        b.show();
        System.out.println();

        System.out.println("\n+ + + + + + +\n");

        a.s = 3; // you can modify a static variable from a not-static environment

        System.out.println("c.s=" + b.s);

        //
        System.out.println(b);
        b = (Parent) a; // a = (Child) b; -> error
        System.out.println(b);


        System.out.println("\n+ + + + + + +\n");

        Parent[] arrayP = {a,
                           b};// polymorphism?
        for (Parent p : arrayP) {
            p.show();
            if (p instanceof Parent) {
                System.out.println("instance of Parent");
            }
            if (p instanceof Child) {
                System.out.println("instance of Child");
            }
            System.out.println();
        }

        System.out.println(b.toString());// inherited form Object

    }


}


class Default {

    private class Foo {

    }

    protected class Bar {

    }

}