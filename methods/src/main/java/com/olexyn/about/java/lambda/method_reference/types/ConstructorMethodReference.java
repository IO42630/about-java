package com.olexyn.about.java.lambda.method_reference.types;

public class ConstructorMethodReference {


    public static void main(String... args) {

        CopyFunction copyFunction1 = () -> new Cell().copy();
        CopyFunction copyFunction2 = Cell::new;


        Cell cell1 = (Cell) copyFunction1.copy();
        Cell cell2 = (Cell) copyFunction2.copy();
    }
}


class Cell implements CopyFunction {

    @Override
    public CopyFunction copy() { return this; }
}


@FunctionalInterface
interface CopyFunction {

    CopyFunction copy();
}
