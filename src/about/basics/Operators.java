package about.basics;

public class Operators {



    static int i = 1;
    static int i1;
    static int i2;
    static double d;

    public static void main(String args[]) {
        test();
    }


    static void test() {



        int z = 0b1100;    //12
        z = z >> 2;        //alle bits um 2 nach rechts, z = 0b11 = 3
        z = 0b011 & 0b001;    //bitwise and, z = 0b001 = 1


        //
        // INCREMENT / DECREMENT

        i = 0;
        i = i++; // evaluate, then update // thus i remains 0
        i = ++i; // update, then evaluate // i = 1
        // -- behaves identically
		i = 1;
		i = ++i * 2 / i--; // i = 2 * 2 / i-- // i = 2 * 2 / 2 // i = 4 / 2 // i = 2
		i = ++i * 2 / --i; // i = 2 * 2 / --i // i = 2 * 2 / 1 // i = 4 / 1 // i = 4


		int foo = (1+2)* 4;

        int a9 = 5 % 2;//modulo, dh rest a9=1;




        z += 1;// z=z+1
        z /= 1;// z=z/1
        z %= 1;// z=z%1

        i *= 3+4;  // i = i * (3+4);



		// DIVISION / MODULO

		// modulo may be applied to negative integers and floats
    }

    static void precedence(){


        d = (double)1/2;//0.5   // casting has precedence over division
        d = (double)(1/2);//0.0
    }



    static void comaring(){
        Integer integer1 = 1;
        Integer integer2 = 0;

        boolean b = 1 < 2;
        b = integer1 < integer2;
        integer1.compareTo(integer2);




    }

}
