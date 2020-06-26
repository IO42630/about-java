package com.olexyn.about.java.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Start here if you forgot Lambdas. <br>
 *
 * > First, we have a functional interface PredicateCopy. <br>
 * > It may be implemented as Class IsPositive and Method evaluate(). <br>
 * > Or we can write it as a Lambda (inline method).
 */
public class Intro {

    static void evaluateListEntries(List<Integer> integerList, PredicateCopy predicate) {
        for (Integer x : integerList)
            if (predicate.evaluate(x)) System.out.println(x+" is true.");
            else System.out.println(x+ " is false.");
    }


    public static void main(String... args) {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(-1, 2));

        // Variant 1 : Without Lambdas
        //     Implement the IsPositive class, then pass it.
        evaluateListEntries(integerList, new IsPositive());

        // Variant 2 : With Lambdas
        //     Start at the functional interface PredicateCopy.
        //     The interfaces is sufficient to bind the parameter and return types.
        //     Write parameter and method body as lambda.
        evaluateListEntries(integerList, (Integer a) -> {return a > 0;});
        //     Since the parameter and return types are bound, a more concise version is possible.
        evaluateListEntries(integerList, a -> a>0);
    }
}


/**
 * A functional interface has only one method.
 */
@FunctionalInterface
interface PredicateCopy {
    boolean evaluate(Integer a);
}


class IsPositive implements PredicateCopy {
    public boolean evaluate(Integer integer) {
        return integer > 0;
    }
}




