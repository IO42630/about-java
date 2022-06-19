package com.olexyn.about.java.classes.classes;

public class Constructors {}


class A {
    A(int a) {}
}

// class B extends  A{}  // cErr, because compiler will insert super(), however A has no default constructor

class B extends A {
    B() { super(1); }
}

class C extends B {
    C(){

    }

    C(int i){
        super();
        //this(); // cErr , must be first statement, thus only one may be present

    }
}

