package com.olexyn.about.java.design.patterns.creational.factory;

interface Product {}

class ProductAA implements Product {}

class ProductAB implements Product {}

class ProductBA implements Product {}

class ProductBB implements Product {}


// - - - - - - - - - - - - - - - - - - - - - - - - -

interface Factory {
    Product createProduct(String foo);
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


/**
 * <b>Abstract Factory</b> : "use abstract classes"<br>
 * Provide an interface for creating families of objects<br>
 * without specifying their concrete classes.<br>
 * <br>
 * <br>
 * <b>FactoryMethod</b> : "avoid new Product()"<br>
 * Define an interface(1) for creating an object,<br>
 * but let subclasses(2) decide which class to instantiate.<br>
 * Factory Method lets a class defer instantiation(3) to subclasses.<br>
 * <br>
 * Suppose you want to create multiple instances of similar kind<br>
 * and want to achieve loose coupling then you can go for Factory pattern.<br>
 * A class implementing factory design pattern works as a bridge between multiple classes.<br>
 * Consider an example of using multiple database servers like SQL Server and Oracle.<br>
 * If you are developing an application using SQL Server database as back end,<br>
 * but in future need to change database to oracle, you will need to modify all your code,<br>
 * so as factory design patterns maintain loose coupling and easy implementation we should<br>
 * go for factory for achieving loose coupling and creation of similar kind of object.
 */
public class FactoryDemo {
    public static void main(String args[]) {

        Factory factoryA = new FactoryA();
        Factory factoryB = new FactoryB();
        Product productAA = factoryA.createProduct("a");
        Product productBB = factoryB.createProduct("b");
    }
}
