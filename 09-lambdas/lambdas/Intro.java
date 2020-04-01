package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Start here if you forgot Lambdas.
 */
public class Intro {

    private static void print(List<XNumber> xNumbers, PredicateCopy checker) {
        for (XNumber x : xNumbers) {
            if (checker.test(x)) System.out.println(x);
        }
    }


    public static void main(String... args) {
        List<XNumber> integers = new ArrayList<>(Arrays.asList(new XNumber(-1), new XNumber(2)));

        // Variant 1 : without Lambda
        // Implement class/method , then pass the class.
        print(integers, new CheckIfPositive());

        // Variant 2 : use Lambda
        // Skip the class/method
        // Start at Interface :
        // Has one Method : Take XNumber , return boolean
        // Omit method name,
        // Write Paramter Body of Method as Lambda
        print(integers, (XNumber a) -> {return a.isPositive;});
        // java util stuff like ArrayList aleady implements methods that take predicates as input
        // integers.printif( a -> a.isPositive)


        print(integers, a -> a.isPositive); // concise variant
    }

}


interface PredicateCopy {
    boolean test(XNumber a);
}


class CheckIfPositive implements PredicateCopy {
    public boolean test(XNumber integer) {
        return integer.isPositive;
    }
}


class XNumber {

    XNumber(Integer integer) { isPositive = integer > 0; }

    boolean isPositive;
}


