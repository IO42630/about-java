package generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class Test {







    public static void main(String... args){
        String str;
        Object obj;
        Object obj2;
        List<Object> objectList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();

        // objectList = stringList; // -> cErr

        obj = objectList;
        obj2 = stringList;
        obj = obj2;



        // upper bound wildcard (Object (= the root of the tree) being at the top).
        //





        List<? extends String> strL = new ArrayList<>();

        List<? extends Object> bar = strL;

    }





    class SomeClass<E extends Number>{

    }


    public  static <E extends Number> void sum(List<? extends E > list){


    }
}
