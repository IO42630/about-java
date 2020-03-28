package basics;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Lambdas {


    public static void main(String[] args) {
        // list of animals

        Animal[] init = {new Animal("fish", false, true),
                         new Animal("kangaroo", true, false),
                         new Animal("turtle", false, true)};
        List<Animal> animals = new ArrayList<>(Arrays.asList(init));

        // pass class that does check
        print(animals, new CheckIfHopper());
        // lambda


        // infers from siganture of .print() that second parameter conforms to interface CheckTrait
        // infers from interface that boolean .test(Animal a) is called
        // infers that Animal has .canHop() method,
        // returns output of said method.
        print(animals, a -> a.canHop());


        print(animals, (Animal a) -> {return a.canHop();});
        foo(new Object(), s -> {});


        ConsumerDemo.run();


    }


    private static void print(List<Animal> animals, CheckTrait checker) {
        for (Animal animal : animals) {
            if (checker.test(animal)) System.out.println(animal);
        }
    }


    private static void foo(Object obj, VoidL voidL) {


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


interface SupplierCopy<T> {
    // Copy of Functional Interface java.util.function.Supplier
    T get();
}

class SupplierDemo {

    static void run() {
        Supplier<Integer> supplier = () -> 42;
        int i = supplier.get(); // call directly
        i = indirectGet(supplier);
    }

    static int indirectGet(Supplier<Integer> supplier) {
        return supplier.get();
    }
}


interface ComparatorCopy<T>{
    // Copy of Functional Interface java.util.function.Comparator
    int compare(T o1, T o2);
}


class ComparatorDemo {

    static void run(){
        Comparator<Integer> comparator = (i1, i2) -> i1-i2;
        int i = comparator.compare(1,2);
    }

}



class LambdaAPIs{


    static void run(){
        List<String> list = new ArrayList<>();
        list.add("foo");
        list.add("bar");
        list.removeIf(s-> s.charAt(0)=='f'); // removes foo
        list.sort((a,b)-> a.compareTo(b));
        list.forEach(a -> a= a+"a");

        Map<Integer,String> map = new HashMap<>();
        map.keySet().forEach(a -> a++); // .forEach() is applied to a Set
        map.values().forEach(a -> a=a+"a");

        map.forEach((a,b)-> b= b+a); // uses the BiConsumer Functional Interface

    }


}

class Animal {
    private String species;
    private boolean canHop, canSwim;

    public Animal(String speciesName, boolean hopper, boolean swimmer) {
        species = speciesName;
        canHop = hopper;
        canSwim = swimmer;
    }

    public boolean canHop() { return canHop; }

    public boolean canSwim() { return canSwim; }

    public String toString() { return species; }


}


interface CheckTrait {
    boolean test(Animal a);
}


interface VoidL {
    void test(Object obj);
}

class CheckIfHopper implements CheckTrait {
    public boolean test(Animal a) {
        return a.canHop();
    }
}

