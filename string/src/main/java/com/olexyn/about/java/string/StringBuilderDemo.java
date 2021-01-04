package com.olexyn.about.java.string;

import java.util.ArrayList;
import java.util.List;

/**
 * StringBuilder is mutable
 * Avoids creation of new Object each loop iteration.
 */
public class StringBuilderDemo {
    static boolean b;
    static String string;
    static List<String> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();

    public static void main(String[] args) {





        sb1 = sb2.append("foo"); // .append() returns a reference to the sb
        // this is called method chaining
        b = sb1 == sb2; // true

        // similar to substing insert will always insert before the char which was referenced by the index
        sb = new StringBuilder("foo");
        sb.insert(0, "-").insert(4, "-"); // "-foo-"

        sb.delete(0, 1).deleteCharAt(3); // "foo"
        // sb.deleteCharAt(100); // exception
        sb.delete(1, 100); // OK

        sb = new StringBuilder("foo");
        sb.replace(2, 100, ""); // "fo"

        sb.reverse(); // "of
        sb.toString();

        sb.substring(0,1); // does not change the value of StringBuilder
    }


    static void initialization() {
        sb1 = new StringBuilder("foo");
        sb2 = new StringBuilder(1000); // reserve space for 1k characters
    }
}
