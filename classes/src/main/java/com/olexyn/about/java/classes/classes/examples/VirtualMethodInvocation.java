package com.olexyn.about.java.classes.classes.examples;

public class VirtualMethodInvocation {}


abstract class AbstractParent {

    abstract void hello(); // "virtual method"

    void sayHello( AbstractParent child) {
        child.hello(); // "virtual method invocation"
    }
}

class ConcreteChild extends AbstractParent {

    void hello() { }
}
