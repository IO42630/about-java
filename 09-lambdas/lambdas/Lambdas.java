package lambdas;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;





public class Lambdas {


    public static void main(String[] args) {




        ConsumerDemo.run();


    }







}


class ConsumerDemo {

    /**
     * Signature of predefined Functional Interface java.util.function.Consumer : <p>
     * public interface Consumer<T>{ void accept(T t); }
     */
    static void run() {
        Consumer<String> consumer = x -> System.out.println(x); // Elaborate the body of the .accept(T t); method
        consumer.accept("Hello"); // call directly
        indirectAccept(consumer, "Hello World"); // call through method
        indirectAccept(x -> System.out.println(x), "Hello"); // skip Consumer variable

    }

    static void indirectAccept(Consumer<String> consumer, String value) {
        consumer.accept(value);
    }

}


/**
 * Copy of Functional Interface java.util.function.Supplier
 *
 * @param <T>
 */
interface SupplierCopy<T> {
    T get();
}

class SupplierDemo {
    static {
        Supplier<Integer> supplier = () -> 42;
        int i = supplier.get();
    }
}

/**
 * Copy of Functional Interface java.util.function.Comparator
 *
 * @param <T>
 */
interface ComparatorCopy<T> {
    int compare(T o1, T o2);
}


class ComparatorDemo {
    static {
        Comparator<Integer> comparator = (i1, i2) -> i1 - i2;
        int i = comparator.compare(1, 2);
    }
}


class LambdaAPIs {

    static void run() {
        List<String> list = new ArrayList<>();
        list.add("foo");
        list.add("bar");
        list.removeIf(s -> s.charAt(0) == 'f'); // Predicate
        list.sort((a, b) -> b.compareTo(a)); // Comarator
        list.forEach(a -> a = a + "a"); // Consumer

        Map<Integer, String> map = new HashMap<>();
        map.keySet().forEach(a -> a++); // .forEach() is applied to a Set
        map.values().forEach(a -> a = a + "a");

        map.forEach((a, b) -> b = b + a); // uses the BiConsumer Functional Interface
    }


}





