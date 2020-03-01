package about.basics;

public class Maths {

    static int i;
    static long l;
    static float f;
    static double d;

    public static void main(String[] args){

        // available for int/long/float/double
        i = Math.min(1,2); //1
        i = Math.max(1,2); //2


        // available for  float/double
        i = Math.round(2.50f); // 3
        l = Math.round(-2.50); // -2

        d = Math.pow(2.0, 2.1);





        // no type
        d = Math.random();
        int br = 0;

    }
}
