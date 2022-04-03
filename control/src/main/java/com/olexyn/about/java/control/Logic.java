package com.olexyn.about.java.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
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
public class Logic {
    private static final int i = 2;

    static boolean b;

    static void ifTest() {
        if (true) { } else if (true) { } else { }

        // one line allowed without braces.
        // whitespace is ignored in Java.
        if (true)
            b = false;
        else if (true) b = true;
        else b = false;
    }

    static void unperformedSide() {
        int i = 0;
        if (i > 0) {
            i++;
        } else {
            i--;
        }
        // i == -1
        // TODO why is this noteworthy?
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
