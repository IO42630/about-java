package com.olexyn.about.java.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * switch,
 */
public class Logic {
    private static final int i = 2;

    static boolean b;
    static boolean b1;
    static boolean b2;

    /*
     * &&	AND
     * ||	OR
     * !(true)	NOT
     * !=		NEQ
     * ==		EQ
     * <=,>=	LEQ, GEQ
     *
     * with (true || false) or (false && true) the second "false/true" is never checked
     *
     */
    public static void main(String[] args) {

        ifTest();
        switchTest();

    }


    static void ifTest() {
        if (1 == 2) {

        } else if (2 != 1) {

        } else {

        }


        // one line allowed without braces.
        // whitespace is ignored in Java.
        if (true)


            b = false;


        else if (true) b = true;
        else b = false;

        if (true) {} else {int i = 1; }
    }





    static void unperformedSide() {
        int i = 0;
        if (i > 0) {
            i++;
        } else {
            i--;
        }
        // i == -1

        i = i > 0 ? i-- : i++; // the i-- is ignored

    }

    static void labelTest() {


        List<String> list = new ArrayList<>();
        optionalLabel:
        for (String entry : list) {
            for (String foo : list) {
                break optionalLabel;
            }
        }
    }

}



