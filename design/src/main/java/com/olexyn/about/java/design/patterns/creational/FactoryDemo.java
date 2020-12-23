package com.olexyn.about.java.design.patterns.creational;

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

interface Product {}

class ProductAA implements Product {}

class ProductAB implements Product {}

class ProductBA implements Product {}

class ProductBB implements Product {}


// - - - - - - - - - - - - - - - - - - - - - - - - -

interface Factory {
    public abstract Product createProduct(String foo);
}


class FactoryA implements Factory { // (2)
    @Override
    public Product createProduct(String foo) {
        switch (foo) {
            case "a":
                return new ProductAA();
            case "b":
                return new ProductAB();
            default:
                return null;
        }
    }
}

class FactoryB implements Factory { // (2)
    @Override
    public Product createProduct(String foo) {
        switch (foo) {
            case "a":
                return new ProductBA();
            case "b":
                return new ProductBB();
            default:
                return null;
        }
    }
}


// - - - - - - - - - - - - - - - - - - - - - - - - -
public class FactoryDemo {
    public static void main(String args[]) {

        Factory factory = new FactoryA();
        Product productAA = factory.createProduct("a");
        Product productBB = new FactoryB().createProduct("b");
    }
}
