package about.basics.classes.parentpackage;

import about.basics.classes.Interface;

// Parent - - - - - - - - - - - - - - - - - -
public class Parent implements Interface {
    public int n; // instance var can be used by instance methods but not by static methods.
    public static int s; // class var, can be used by all methods, same in all instances of a class.
    private int priv = 2; // can't be accessed by child
    protected Integer protectedInteger = 0;


    /** default constructor, can be omitted,
     * unless a custom constructor is defined.
     * in that case it must be written, else error.
     */
    public Parent() {
        this(43);
    }

    Parent(String a){


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
