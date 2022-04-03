package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Conversions {


    static List<Integer> integerList = new ArrayList<>();
    static Object[] objArray;
    static Integer[] integerArray;
    static Integer[] capturingArray;
    static int i;
    static boolean b;

    static {
        integerList.add(null);
        integerList.add(null);
    }

    public static void main(String... args){

        listToArray();
        arrayToList();


    }




    static void listToArray() {

        objArray = integerList.toArray(); // this is a copy, changes to the list do not affect the objArray


        capturingArray = new Integer[1];
        integerArray = integerList.toArray(capturingArray); // if outputArray < list, create new a Array Object
        b = capturingArray.equals(integerArray); // false

        capturingArray = new Integer[10];
        integerArray = integerList.toArray(capturingArray); // if outputArray >= list, load list into outputArray
        b = capturingArray.equals(integerArray); // true
    }


    /**
     * FIXED-SIZE List : can't .add() , .remove()
     */
    static void arrayToList(){

        // backed (changes are synchronized between original array and list)
        integerList = Arrays.asList(new Integer[]{ 0, 1});
        integerList = Arrays.asList(0,1); // accepts varargs
        integerList.set(0,1);             // OK

        // immutable (values of list are immutable)
        integerList = List.of(new Integer[]{0,1});
        integerList = List.of(0,1); // accepts varargs
        // integerList.set(0,0);    // R-Error
    }



}
