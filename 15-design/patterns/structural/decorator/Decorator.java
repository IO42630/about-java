package patterns.structural.decorator;

/*
 * DECORATOR<br>
 * The core functionality is provided by the AbstractDecorator.<br>
 * It <b>wraps</b> a toBeWrapped <b>by storing a reference</b> to toBeWrapped.<br>
 * It is <b>this</b> constructor that is called by the constructors of the concrete decorators.<br>
 * Note that while toBeWrapped can be a BaseClass, it also can be an ConcreteDecorator.<br>
 * This enables us to chain ConcreteDecorators.<br>
 * Effectively AbstractDecorators is the link (or anchor) that holds the chain together.
 */

interface Interface {
    void print();
}


class BaseClass implements Interface {

    public void print() {
        System.out.println("BaseClass Class");
    }
}


abstract class AbstractDecorator implements Interface {

    private final Interface wrapped;

    public AbstractDecorator(Interface toBeWrapped) {
        this.wrapped = toBeWrapped;
    }

    @Override
    public void print() {
        wrapped.print();
    }
}


class ConcreteDecorator1 extends AbstractDecorator {

    public ConcreteDecorator1(Interface toBeWrapped) {
        super(toBeWrapped);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Decorator 1");
    }


}


class ConcreteDecorator2 extends AbstractDecorator {


    public ConcreteDecorator2(Interface toBeWrapped) {
        super(toBeWrapped);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Decorator 2");
    }
}


// MAIN - - - - - - - - - - - - - - - - - - - - - - - - -
public class Decorator {
    public static void main(String args[]) {

        Interface decorated = new ConcreteDecorator2(new ConcreteDecorator1(new BaseClass()));
        // WHAT HAPPENS -> see deocrator.png
        decorated.print();
    }
}
