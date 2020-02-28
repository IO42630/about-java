package about;

/**
 * switch,
 */
public class Logic {
    private static final int i = 2;

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

        switch (i) {
            case 2:
                System.out.println("2");
                // break; => without it case 1 is executed too
            case 1:
                System.out.println("1");
                break;
            default:
                System.out.println("default");
                break;
        }

        if (1 == 2) {

        } else if (2 != 1) {

        } else {

        }

        //switchTest();
        logicTest();

    }


    static void switchTest() {

        for (int i = 0; i < 4; i++) {

            switch (i) {
                case 0:
                    System.out.println(0);
                case 1:
                    System.out.println(1);
                default:
                    System.out.println("default");
                case 2:
                    System.out.println(2);
            }

            System.out.println("-------");
        }
    }


    static void logicTest(){
        boolean a = true;
        boolean b = true;

        a= true;
        b= false;
        System.out.println(a || (b=true));


        System.out.println(a | (b=true));


        System.out.println(a && b);


        System.out.println(a && b);
    }

}
