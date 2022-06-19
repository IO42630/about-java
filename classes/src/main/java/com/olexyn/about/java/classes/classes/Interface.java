package com.olexyn.about.java.classes.classes;

public abstract interface Interface {

    // All members of Interface are public (the public access modifer can be omitted).
    // meant to be used as type
    // class can implement multiple interfaces

    // static variables are shared among all instances of a class
    public static final int fin = 7; // allowed


    String toString();


    static String staticMethod() { return null; }


}


interface Test {

    public abstract void foo();        // pubic, abstract are added, unless specified otherwise.

    public static final int INT = 0;   // pubic, static, final are added, unless specified otherwise.

    default void bar8() {} // since Java 8
    static void baz8() {} // since Java 8

    private void bar9() {} // since Java 9
    private static void baz9() {} // since Java 9

}


interface ParentOne {
    String foo();
}


interface ParentTwo {
    CharSequence foo();
}


class ChildSuper implements ParentTwo, ParentOne {

    public String foo() { return null; } // dummy
    //public CharSequence foo() { return ""; } // cErr because of using Super


}

class ChildSub implements ParentOne, ParentTwo {

    public String foo() { return ""; }
}
