package about.primitives;

public class FloatingPoint {

    float f1 = 3;
    // float f2 = 3.0; // will not compile
    float f3 = 3.0f;
    float f4 = 3f; // OK

    static float f  = 123.4f;
    static double d = 123.4;// d optional


    public static void main(String [] args){
        doubleDemo();

    }



    static void floatDemo(){


    }



    static void doubleDemo(){
        d = 1.234e2;//scientific notation

        d = 1/2; // 0.0
    }
}
