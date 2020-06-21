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


    static void switchTest() {


        final int one;
        one = 1; // must be declared & initialized on the same line
        final int two = 2; // must be final
        final int rng = new Random().nextInt();

        for (int i = 0; i < 4; i++) {

            switch (i) {
                case 0:
                    System.out.println(0);
                    // break; => without it case 1 is executed too
                case 1:
                    System.out.println(1);
                default:
                    System.out.println("default");
                case two:
                    System.out.println(2);

            }

            System.out.println("-------");
        }


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



