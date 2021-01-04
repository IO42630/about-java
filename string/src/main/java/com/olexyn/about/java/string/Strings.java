package com.olexyn.about.java.string;

import java.util.ArrayList;
import java.util.List;

/**
 * String is immutable.
 * String is a reference type.
 *      * - it is compared with .equals not ==
 *      * - each modification creates a new instance of String,
 *      *   which would be expensive, so we use StringBuilder.
 *      String implements the CharSequence Interface
 *     // Other Types implementing this interface are StringBuilder and StringBuffer
 */
public class Strings {

    static String s;
    static String s1 = "1";
    static String s2 = "2";
    static boolean b = false;
    static int i;


    public static void main(String args[]) {

        stringPool();
        methods();
        concatenation();
        comparison();
    }

    static void concatenation() {

        s1 += s2; // equiv to next line
        s1 = new StringBuilder().append(s1).append(s2).toString();

        s1 = s1.concat(s2); // simply makes a new String object with contents of s1 and s2

        s1 = null;
        s1 += s2; // s1 is "null2"

        s1 = null;
        try {
            s1 = s1.concat(s2); // Runtime Exception NullPointer
        } catch (Exception ignored) { }
    }


    static void methods() {
        s = s + 1;  // OK
        s = 1 + s;  // OK
        //s = 1;    // NO

        int i = Integer.parseInt("1");

        s = String.format("s=%s", s);
        s = s.format("t=%d", 5);

        s = "foo";
        // position count starts at 0
        s.length(); // 3 ~ total number of chars , getter method
        s.charAt(0); // f
        try {s.charAt(3);} catch (Exception e) {} // exception

        s1 = s.substring(0, 3); // includes first, excludes last , thus "foo"
        s1 = s.substring(3, 3); // ""
        // s1 = s.substring(3,2); // exception

        s1 = s.toUpperCase();
        s2 = s.toLowerCase();
        s1.equalsIgnoreCase(s2);

        b = s.startsWith("a");
        b = s.endsWith("b");

        s = s.replace('a', 'a');
        s = s.replace("foo", "foo");

        s.contains("foo"); // ~ s.indexOf("foo") != -1
    }


    static void stringPool() {

        b = "foo" == "foo";                      //  true , since java reuses string from pool, since they are equal at compile-time
        b = "foo" == " foo ".trim();             // false , since they are made equal only at runtime
        b = "foo" == "fo" + "o";                 //  true , since equal at compile-time
        b = "foo" == new String("foo");          // false , simply forces creation of new String in the pool
        String f = "f";
        b = "foo" == (f += "oo");                // false , += is like a method, so it is only equal at runtime
        //intern is always == to the first string literal of said content
        b = "foo" == "foo".intern();             // true  , returns value from string pool if it is there, otherwise it adds the value to the string pool.
        b = new String("foo") == "foo".intern(); // false

        b = "foo".equals(new String("foo"));     // true
    }

    static void comparison(){
        // b = "a" > "a"; -> C-Error
        b = "a".compareTo("a") == 0;
        i = "a".compareTo("A") ;
        i = "a".compareTo("ABCD") ;
        int br = 0;
    }


}







