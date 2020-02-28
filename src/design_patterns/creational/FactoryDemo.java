package design_patterns.creational;

/*
 * Abstract Factory. 
 * Provide an interface for creating families of objects 
 * without specifying their concrete classes.
 * "use abstract classes"
 *
 * FactoryMethod. 
 * Define an interface(1) for creating an object, 
 * but let subclasses(2) decide which class to instantiate. 
 * Factory Method lets a class defer instantiation(3) to subclasses.
 * "avoid new Product()"
 * Suppose you want to create multiple instances of similar kind
and want to achieve loose coupling then you can go for Factory pattern.
A class implementing factory design pattern works as a bridge between multiple classes.
Consider an example of using multiple database servers like SQL Server and Oracle.
If you are developing an application using SQL Server database as back end,
but in future need to change database to oracle, you will need to modify all your code,
so as factory design patterns maintain loose coupling and easy implementation we should
go for factory for achieving loose coupling and creation of similar kind of object.
 */

abstract class Product {
}

class cProduct extends Product {
    cProduct() {
        System.out.println(this);
    }
}

// - - - - - - - - - - - - - - - - - - - - - - - - -

abstract class Factory {
    public abstract Product createProduct();
}

class cFactory extends Factory { // (2)
    @Override
    public Product createProduct() {
        return new cProduct(); // (3)
    }
}

// - - - - - - - - - - - - - - - - - - - - - - - - -
public class FactoryDemo {
    public static void main(String args[]) {
        new cFactory().createProduct();
    }
}
