package collections;

import java.util.ArrayList;
import java.util.List;

public class Lists {

    static List<Integer> integerList = new ArrayList<>();
    static Object[] objArray;
    static Integer[] integerArray;
    static Integer[] outputArray ;
    static int i;
    static boolean b;


    public static void main(String args[]){
        List<String> list = new ArrayList<>();
        list.add("foo");
        int i = list.size();

    }







    static void special(){

        integerList.add(new Integer(0));

        integerList.remove(0); // implements List.remove(int index) instead of Collection.remove(Integer element)

        integerList.remove(new Integer(0));

        integerList.set(1,1);

        integerList.clear();

    }
}
