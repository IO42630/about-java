public class Casting {


    /**
     * from specific to broad
      */
    static void implicit(){
        short s = 0;
        int i = s;
    }


    /**
     * from broad to specific
     */
    static void explicit(){
        int i = 0;
        short s = (short) i;
        i = 1_000_000;
        s = (short) i; // overflow?
    }
}



