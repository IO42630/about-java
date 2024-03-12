package com.olexyn.about.java.new_features;

import javax.print.attribute.standard.NumberOfInterveningJobs;
import java.util.Random;

public class Java13 {

    /**
     * Switch Expressions
     * https://openjdk.java.net/jeps/354
     */
    void jep334() {
        var foo = "A" + new Random().nextInt();
        var result = "unknown";
        switch (foo) {
            case "MONDAY", "FRIDAY" -> System.out.println(6);
            case "TUESDAY"                -> System.out.println(7);
            default -> result = "miss";
        }
        // no break needed


    }

    /**
     * Text Blocks
     * https://openjdk.java.net/jeps/355
     */
    void jep335() {
        String query2 =
               """
               SELECT `EMP_ID`, `LAST_NAME` FROM `EMPLOYEE_TB`
               WHERE `CITY` = 'INDIANAPOLIS'
               ORDER BY `EMP_ID`, `LAST_NAME`;
               """;
    }
}
