package com.olexyn.about.java.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;

public class TestX {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static int migratoryBirds(List<Integer> kupa) {
        // Write your code here


        // [ 00 , 01 , 02 ]
        // [ 10 , 11 , 12 ]
        // [ 20 , 21 , 22 ]

       Map<Integer, List<Integer>> pole = new HashMap();

        for (var kopiyka : kupa) {
            if (pole.get(kopiyka) == null) {
                pole.put(kopiyka, new ArrayList<>());
            }
            var ryad = pole.get(kopiyka);
            pole.get(kopiyka).add(kopiyka);
        }


        int maxSize = 0;
        int maxBird = -1;
        for (Entry<Integer, List<Integer>> ryad : pole.entrySet()) {

            if (ryad.getValue().size()  > maxSize) {
                maxSize = ryad.getValue().size();
                maxBird = ryad.getValue().get(0);
            }
            if (ryad.getValue().size() == maxSize) {
                if (maxBird > ryad.getValue().get(0)) {
                    maxBird = ryad.getValue().get(0);
                }
            }
        }

        return maxBird;




    }




}
