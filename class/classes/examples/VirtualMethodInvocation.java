package classes.examples;

public class VirtualMethodInvocation {}


abstract class AbstractParent {

    abstract void hello(); // "virtual method"

    void sayHello() {
        hello(); // "virtual method invocation"
    }
}

class ConcreteChild extends AbstractParent {

    void hello() { }
}
