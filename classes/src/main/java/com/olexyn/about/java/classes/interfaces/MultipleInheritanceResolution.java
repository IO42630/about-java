package com.olexyn.about.java.classes.interfaces;

interface A {
    default void foo() {}
}

interface B extends A {}

interface C extends A {}

interface Bplus extends A {
    default void foo() {}
}

interface Cplus extends A{
    default void foo(){}
}

class D implements B,C{

}


class Dplus implements Bplus,Cplus{

    public void foo(){
        Bplus.super.foo();
        Cplus.super.foo();}


}


public class MultipleInheritanceResolution {

    public static void main(String... args){

        D d = new D();
        d.foo(); // calls A.foo()

        Dplus dplus = new Dplus();
        dplus.foo();

    }


}
