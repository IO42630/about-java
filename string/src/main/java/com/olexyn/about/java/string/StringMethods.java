package com.olexyn.about.java.string;

class StringMethods {

    static int i;
    static String s;

    static void whitespace() {

        // whitespace includes \t \n \r
        s = s.trim(); // remove whitespace at start and end
        s = s.strip(); // same as trim() , but supports unicode
        s = s.stripLeading();
        s = s.stripTrailing(); // none of this methods remove the whitespace within a String
    }


    static void indexOfTest() {
        s = "foo";
        i = s.indexOf("b", 1); //first occurence of a, starting from place 1 (returns -1 if not found)
        i = s.indexOf('o'); // first appearance ~ 1
        i = s.indexOf("fo"); // 0
        i = s.indexOf('o', 1); // search from index 1 , thus i is assigned 1
        i = s.indexOf("o", 2); // 2
        i = s.indexOf(1); // (char)1 ~ ! // since s does not contain ! , i is assigned -1
    }

}
