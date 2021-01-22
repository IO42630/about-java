package com.olexyn.about.java.lambda.method_reference.types;

public class ConstructorMethodReference {

    public static void main(String... args) {

        CopyFunction copyFunction1 = () -> new Cell().copy();
        CopyFunction copyFunction2 = Cell::new; // implies .copy() since Cell implements a functional interface.


        Cell cell1 = (Cell) copyFunction1.copy();
        Cell cell2 = (Cell) copyFunction2.copy();
    }
}

/**
 * 
 */
class Cell implements CopyFunction {

    @Override
    public CopyFunction copy() { return this; }
}

/**
 * A function that returns a copy of itself.
 */
@FunctionalInterface
interface CopyFunction {

    CopyFunction copy();
}
