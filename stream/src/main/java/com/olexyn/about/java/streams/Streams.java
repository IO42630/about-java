package com.olexyn.about.java.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streams {


    void createStream() {

        Stream<Integer> stream;
        stream = Stream.of(1, 2, 3, 4);
        stream = Stream.of(new Integer[]{1,
                                         2,
                                         3,
                                         4});
        // stream = Stream.of(new int[]{1,2,3,4}); -> C-Error


        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 100; i++) myList.add(i);

        //sequential stream
        Stream<Integer> sequentialStream = myList.stream();

        //parallel stream
        Stream<Integer> parallelStream = myList.parallelStream();


        Stream<String> stream1 = Stream.generate(() -> {return "abc";});
        Stream<String> stream2 = Stream.iterate("abc", (i) -> i);

        LongStream is = Arrays.stream(new long[]{1,
                                                 2,
                                                 3,
                                                 4});
        IntStream is2 = "abc".chars();
    }


    void collectStream(){

        Stream<Integer> intStream = Stream.of(1,2,3,4);
        List<Integer> intList = intStream.collect(Collectors.toList());
        System.out.println(intList); //prints [1, 2, 3, 4]

        intStream = Stream.of(1,2,3,4); //stream is closed, so we need to create it again
        Map<Integer,Integer> intMap = intStream.collect(Collectors.toMap(i -> i, i -> i + 10));
        System.out.println(intMap); //prints {1=11, 2=12, 3=13, 4=14}

    }


    void modifySteam(){

        List<Integer> myList = new ArrayList<>();
        for(int i=0; i<100; i++) myList.add(i);
        Stream<Integer> sequentialStream = myList.stream();

        Stream<Integer> highNums = sequentialStream.filter(p -> p > 90); //filter numbers greater than 90
        System.out.print("High Nums greater than 90=");
        highNums.forEach(p -> System.out.print(p+" "));
//prints "High Nums greater than 90=91 92 93 94 95 96 97 98 99 "



        Stream<String> names = Stream.of("aBc", "d", "ef");
        System.out.println(names.map(s -> {
            return s.toUpperCase();
        }).collect(Collectors.toList()));
//prints [ABC, D, EF]


        Stream<String> names2 = Stream.of("aBc", "d", "ef", "123456");
        List<String> reverseSorted = names2.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(reverseSorted); // [ef, d, aBc, 123456]

        Stream<String> names3 = Stream.of("aBc", "d", "ef", "123456");
        List<String> naturalSorted = names3.sorted().collect(Collectors.toList());
        System.out.println(naturalSorted); //[123456, aBc, d, ef]


        Stream<List<String>> namesOriginalList = Stream.of(
                Arrays.asList("Pankaj"),
                Arrays.asList("David", "Lisa"),
                Arrays.asList("Amit"));
//flat the stream from List<String> to String stream
        Stream<String> flatStream = namesOriginalList
                .flatMap(strList -> strList.stream());

        flatStream.forEach(System.out::println);

    }
}
