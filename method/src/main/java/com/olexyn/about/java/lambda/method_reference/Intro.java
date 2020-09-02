package com.olexyn.about.java.lambda.method_reference;

import java.util.function.Predicate;

public class Intro {


    public static void main(String... args) {

        // We can store methods in functional interfaces.

        Predicate<Integer> p = x -> x > 0;

        // Sometimes we call other functions in our lambdas.

        TwoIntFunction twoIntFunction = (a, b) -> new Tools().add(a, b);

        // Then we can use a shorter notation:

        TwoIntFunction add = new Tools()::add;
        TwoIntFunction subtract = new Tools()::subtract;

        // However it is still cumbersome to use:

        Integer integer1 = add.twoIntFunction(1, 3);
        Integer integer2 = subtract.twoIntFunction(1, 3);

        // And writing dedicated classes/functions that implement a functional interface - still defeats the purpose of lambdas.

        Predicate<Integer> p2 = x -> new PredicateImpl<Integer>().test(x);

        Predicate<Integer> p3 = new PredicateImpl<Integer>()::test;

    }
}


class PredicateImpl<T> implements Predicate<T> {

    @Override
    public boolean test(T t) { return false; }

}


interface TwoIntFunction {
    Integer twoIntFunction(Integer a, Integer b);
}


class Tools {
    public Integer add(Integer a, Integer b) { return a + b; }

    public Integer subtract(Integer a, Integer b) {return a - b;}
}
