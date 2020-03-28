package basics.collections;

import java.util.ArrayList;
import java.util.List;

public class Lists {

    static List<Integer> list = new ArrayList<>();
    static Object[] objArray;
    static Integer[] intArray;
    static Integer[] outputArray ;
    static int i;
    static boolean b;


    public static void main(String args[]){
        List<String> list = new ArrayList<>();
        list.add("foo");
        int i = list.size();
        conversions();
    }


    static void conversions(){

        list.add(null);
        list.add(null); // add two Entries

        objArray = list.toArray(); // this is a copy, changes to the list do not affect the objArray

        list.get(1);

        outputArray = new Integer[1];
        intArray = list.toArray(outputArray); // if outputArray < list, create new a Array Object
        b = outputArray.equals(intArray); // false

        outputArray = new Integer[10];
        intArray = list.toArray(outputArray); // if outputArray >= list, load list into outputArray
        b = outputArray.equals(intArray); // true



    }
}
