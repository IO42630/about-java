package com.olexyn.about.java.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streams {

    private static List<Integer> integerList = new ArrayList<>();
    private static List<String> stringList = new ArrayList<>();

    private static Stream<Integer> integerStream;

    static {
        for (int i = 0; i < 10; i++) integerList.add(i);
    }

    public static void main(String... args){
        //
        evaluateStream();
        collectStream();
        modifySteam();
    }

    void createStream() {

        Stream<Integer> stream;
        stream = Stream.of(1, 2, 3, 4);
        stream = Stream.of(new Integer[]{1, 2, 3, 4});
        // stream = Stream.of(new int[]{1,2,3,4}); -> C-Error


        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 100; i++) myList.add(i);

        //sequential stream
        Stream<Integer> sequentialStream = myList.stream();

        //parallel stream
        Stream<Integer> parallelStream = myList.parallelStream();


        Stream<String> stream1 = Stream.generate(() -> {return "abc";});
        Stream<String> stream2 = Stream.iterate("abc", (i) -> i);

        LongStream is = Arrays.stream(new long[]{1, 2, 3, 4});
        IntStream is2 = "abc".chars();
    }

    static void evaluateStream() {
        integerStream = integerList.stream();
        integerStream.allMatch(x -> x > 0);
    }


    static void collectStream() {

        integerList = integerList.stream().collect(Collectors.toList());  // [1, 2, 3, 4]

        Map<Integer, Integer> intMap = integerList.stream().collect(Collectors.toMap(i -> i, i -> i + 10)); // {1=11, 2=12, 3=13, 4=14}

        integerList.stream().forEach(p -> System.out.print(p + " "));

        // consumes the stream, just like forEach - however is intermediate operation, thus not executed unless terminal operation present.

        integerList.stream().map(x -> { System.out.println("foo"); return  2* x;});
        integerStream = integerList.stream().map(x -> { System.out.println("foo"); return  2* x;});
        integerList.stream().map(x -> { System.out.println("foo"); return  2* x;}).collect(Collectors.toList());

        integerList.stream().peek(System.out::println);
        integerList.stream().peek(System.out::println).collect(Collectors.toList());
        integerList.stream().peek(System.out::println);
    }





    static void modifySteam() {

        integerStream = integerList.stream();
        integerStream = integerStream.filter(p -> p > 7); // filter numbers greater than 90

        // <R> Stream<R> map(Function<? super T, ? extends R> mapper);
        integerStream = integerStream.map(x -> x +1);


        integerStream = integerStream.sorted();
        integerStream = integerStream.sorted(Comparator.reverseOrder());
        integerStream = integerStream.sorted((x,y) -> x - y );


        List<List<Integer>> bumpyList = new ArrayList<>();
        bumpyList.add(integerList);
        bumpyList.add(integerList);

        // <R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)
        // function transfers elements of collection to a temp_stream.
        // afterwards all the temp_streams are concatenated and returned.
        bumpyList.stream().flatMap(list -> list.stream()).forEach(System.out::println);
        bumpyList.stream().flatMap(Collection::stream).forEach(System.out::println);
        bumpyList.stream().flatMap(list -> list.stream().filter(x -> x > 3)).forEach(System.out::println);

        // T reduce(T identity, BinaryOperator<T> accumulator);
        // int reduce(int identity, IntBinaryOperator op);
        // identity / initial value
        integerList.stream().reduce(0,(a,b) -> a + b);
        integerList.stream().reduce(0, Integer::sum);
    }
}
