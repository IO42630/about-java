package about.basics;

public class Methods {


    public static void main(String[] args) {

        varargsDemo(new int[2]);
        varargsDemo(new int[]{1,2});
        varargsDemo(1,2);
        varargsDemo(); // creates new int[0]


    }




    static int[] varargsDemo(int... varint) { return varint; }


    public int hello() {

        return 1;
        // return for all except void type
    }


}
