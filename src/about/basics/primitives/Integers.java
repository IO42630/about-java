package basics.primitives;

public class Integers {

    static int i = 0;
    static Integer integer = 0;
    static Integer integer1;
    static Integer integer2;
    static long l = 0;
    static Long aLong = 0L; // the L is not optional here.
    static boolean b;

    int octal = 011; // 9
    int hexadecimal = 0xF; // 16
    int binary = 0b11; // 3

    int fine = 1_000_000; // legal
    // double not_fine = 1_._0_; // very illegal


    public static void main(String[] args){

        comparison();




        i = (int) 4.4f; // must be cast


        // OVERFLOW / UNDERFLOW //
        // OVERFLOW : if one climbs beyond the upper boundary, the pointer jumps to the lower boundary and continues climbing
        // UNDERFLOW : if one drops below the lower boundary, the pointer jumps to the upper boundary and contunues dropping
        int lower = -2147483648;
        int upper = 2147483647;
        System.out.println(upper+1 == lower);
        System.out.println(lower - 1 == upper);




    }





    private static void aboutLong(){

        long large = 9999L; // L indicates number is a long (prevents the overflow behaviour)
        long small = 0; // L is optional with smaller numbers
        long bar = 1L;
    }


    static void comparison(){

        integer1 = 0;
        integer2 = 0;
        b = integer1==integer2; // true
        integer2 = new Integer(0);
        b = integer1==integer2; // false (seems to be similar to Strings)


    }


    static void methods(){

        integer.toString();


    }


    static void basicOperators(){

        i = +3;
        i = -4;
        i = +i; // does nothing, still a == -4
        i = -i; // inverts, a == 4

        i = -5/2; // -2
        i = (-5)/2; // -2

    }

    //
}
