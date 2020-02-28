package about;

public class Opreators {

    static int i = 1;

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


}
