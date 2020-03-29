public class Methods {


    public static void main(String[] args) {

        varargsDemo(new int[2]);
        varargsDemo(new int[]{1,
                              2});
        varargsDemo(1, 2);
        varargsDemo(); // creates new int[0]


    }


    static int[] varargsDemo(int... varint) { return varint; }


    public int hello() {

        return 1;
        // return for all except void type
    }


    int overload(int i) {return i; }
    int overload(int[]i){return  i[0];}
    // void overload(int i) {} // C-Error
    // static void overload(int i){}  // C-Error
}
