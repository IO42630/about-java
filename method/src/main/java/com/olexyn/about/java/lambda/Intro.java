package com.olexyn.about.java.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * A functional interface has only one method.
 */
@FunctionalInterface
interface PredicateCopy<T> extends Predicate<T> {}


class IsPositive<T> implements PredicateCopy<T> {

    @Override
    public boolean test(Object o) {
        if (o instanceof Integer) return (Integer) o > 0;
        else return false;
    }
}


/**
 * Start here if you forgot Lambdas. <br>
 * <p>
 * > First, we have a functional interface PredicateCopy. <br>
 * > It may be implemented as Class IsPositive and Method evaluate(). <br>
 * > Or we can write it as a Lambda (inline method).
 */
public class Intro {

    static void evaluateListEntries(List<Integer> integerList, PredicateCopy<Integer> predicate) {
        for (Integer x : integerList)
            if (predicate.test(x)) System.out.println(x + " is true.");
            else System.out.println(x + " is false.");
    }


    public static void main(String... args) {

        List<Integer> integerList = new ArrayList<>(Arrays.asList(-1, 2));

        // Variant 1 : Without Lambdas
        //     Implement the IsPositive class, then declare/pass it.
        PredicateCopy<Integer> predicate = new IsPositive<>();
        evaluateListEntries(integerList, predicate);

        // Variant 2 : With Lambdas
        //     Start at the functional interface PredicateCopy.
        //     The interfaces is sufficient to bind the parameter and return types.
        //     Write parameter and method body as lambda.

        evaluateListEntries(integerList, (Integer a) -> {return a > 0;});

        //     Since the parameter and return types are bound, a more concise version is possible.

        evaluateListEntries(integerList, a -> a > 0);
    }
}







