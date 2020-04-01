package collections;

import java.util.HashSet;
import java.util.Set;

public class Sets
{

    static boolean b ;
    static Set<Character> hashSet = new HashSet<>();


    public static void main(String[] args){
         methods();

         int br = 0;

    }


    static void methods(){

        b = hashSet.add('a'); // true
        b = hashSet.add('a'); // false, can't be added because Set already contains 'a'.
        b = hashSet.remove('a'); // true
        b = hashSet.remove('a'); // false , Set does not contain 'a'.
    }

}
