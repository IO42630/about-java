package collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Maps {

    static Map<Integer,String> hashMap = new HashMap<>();
    static String s;
    static boolean b;

    public static void main(String args[]){


        // A Map consists of Entires.
        // Entries are Key/Value pairs.
        methods();
    }


    static void methods(){

        s = hashMap.put(1,"a"); // Adds/replaces Entry. Returns previous Value or null
        s = hashMap.get(1); // Returns value mapped to Key or null.
        s = hashMap.getOrDefault(1, "none"); // Returns value mapped to Key or default value
        s = hashMap.remove(1); // Removes and returns the Value mapped to Key, or null if None.
        b = hashMap.containsKey(1);
        b = hashMap.containsValue("a");
        Set<Integer> keySet = hashMap.keySet(); // Set of all Keys.
        Collection<String> valueCollection = hashMap.values();

        hashMap.isEmpty();



    }





}
