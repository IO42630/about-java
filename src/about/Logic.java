package about;

/**
 * switch,
 */
public class Logic {
    private static final int i = 2;

    static boolean b;

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

        ternary();
        incrementTest();
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



    static void incrementTest(){
         int i = 0;
         b= i++ == 0;
         b = (i=i+1) == 0;
         b= ++i == 0;
    }


    static Object ternary( ){
        int i = 0;
        var v = i>0? new Integer(1) : "foo";
        v = new Integer(2);
        v = "a";
        var a = 1;
        var b = new Integer(2);
        a = b;



        return i>0 ? new Integer(1) : "foo";
    }


    static void  unperformedSide(){
        int i=0;
        if (i>0){
            i++;
        }else{
            i--;
        }
        // i == -1

        i = i>0 ? i-- : i++; // the i-- is ignored

    }



    static void ifthenelse(){
        // one line allowed without braces.
        // whitespace is ignored in Java.
        if(true)


            b=false;


        else if(true) b=true;
        else b=false;
    }
}
