package com.olexyn.about.java.method;

import java.util.ArrayList;
import java.util.List;

public class PassByDemo {

    public static void main(String... args){

        List<String> list = new ArrayList<>();
        foo(list);
        list.stream().forEach(System.out::println); // will print foo bar

    }




    static List<String> foo(List<String> param){

        param.add("foo");
        List<String> bar = param;
        bar.add("bar"); // still the same list

        return param;
    }
}
