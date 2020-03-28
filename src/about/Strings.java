package about;

import java.util.ArrayList;
import java.util.List;

//TODO
public class Strings {

    static String s;
    static String s1 = "1";
    static String s2 = "2";
    static boolean b = false;

    /*
     * String is a reference type.
     * - it is compared with .equals not ==
     * - each modification creates a new instance of String,
     *   which would be expensive, so we use StringBuilder.
     */


    // String implements the CharSequence Interface
    // Other Types implementing this interface are StringBuilder and StringBuffer


    public static void main(String args[]) {

        stringEquality();
        methods();
        concatenation();

        s = s + 1;  // OK
        s = 1 + s;  // OK
        //s = 1;    // NO


        int i = Integer.parseInt("1");
        i = s.length(); // getter method
        i = s.indexOf("b", 1); //first occurence of a, starting from place 1 (returns -1 if not found)

        char c = s.charAt(1);

        s = s.substring(0, 1);
        s = s.concat(s);// s=s+s
        s = s.replace('a', 'b'); // replace 'a' with 'b'
        s = s.toUpperCase();
        s = s.trim(); // remove all whitespaces
        s = s.intern(); // returns the (first) value from the string pool if it is there , otherwise, it adds the value to the string pool.

        String st = s;
        boolean bool1 = (st == s);
        boolean bool2 = (s == s.intern());

        StringBuilder sb = new StringBuilder();
        sb.append(c);
        s = sb.toString();

        s = String.format("s=%s", s);
        s = s.format("t=%d", 5);

        b = s.startsWith("def");
        b = ("abc" == "abc");//false
        b = s.equals(s);//true
        b = s.equalsIgnoreCase(s);
    }




    static void initialization() {

        s = "foo";
        s = new String("foo");


    }

    static void concatenation() {

        s1 += s2; // equiv to next line
        s1 = new StringBuilder().append(s1).append(s2).toString();

        s1.concat(s2); // simply makes a new String object with contents of s1 and s2

        s1 = null;
        s1 += s2; // s1 is "null2"

        s1 = null;
        try {
            s1 = s1.concat(s2); // Runtime Exception NullPointer
        } catch (Exception e) {

        }
    }

    static void methods(){
        int i;
        s = "foo";
        // position count starts at 0
        s.length(); // 3 ~ total number of chars
        s.charAt(0); // f
        try {s.charAt(3);} catch (Exception e){} // exception


        i = s.indexOf('o'); // first appearance ~ 1
        i = s.indexOf("fo"); // 0
        i = s.indexOf('o',1); // search from index 1 , thus i is assigned 1
        i = s.indexOf("o",2); // 2
        i = s.indexOf(1); // (char)1 ~ ! // since s does not contain ! , i is assigned -1

        s1 = s.substring(0,3); // includes first, excludes last , thus "foo"
        s1 = s.substring(3,3); // ""
        // s1 = s.substring(3,2); // exception


        s1 = s.toUpperCase();
        s2 = s.toLowerCase();

        System.out.println(s2.equals(s));
        System.out.println(s1 == s);
        System.out.println(s2 == s);

        s1.equals(s2);
        s1.equalsIgnoreCase(s2);

        s.startsWith("a");
        s.endsWith("b");

        s.replace('a', 'a');
        s1 = s.replace("foo", "foo");

        b = s ==s1;

        s.contains("foo"); // ~ s.indexOf("foo") != -1

        // whitespace includes \t \n \r
        s.trim(); // remove whitespace at start and end
        s.strip(); // same as trim() , but supports unicode
        s.stripLeading();
        s.stripTrailing(); // none of this methods remove the whitespace within a String

        s.intern(); // returns value from string pool if it is there, otherwise it adds the value to the string pool.

        // Chaining
        "foo".intern(); // can be used directly




    }


    static void stringEquality(){
        String s1 = "foo";
        String s2 = "foo";
        String s3 = new String("foo"); // forces new string to be created in the string pool

        String s4 = s1.intern();
        String s5 = s2.intern();


        boolean b1 = (s1 == s2);// true
        boolean b13 = (s1 == s3); // false
        boolean b2 = (s1 == s4); // true
        boolean b3 = (s4 == s5); // true


        int br = 0;
    }


}






class StringBuilderS{
    static boolean b ;
    static String string;
    static List<String> list = new ArrayList<>();
    static StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();

    public static void main(String[]args){

        for (String entry : list){
            string += "a"; // creates a new object (each time with an 'a' more) each time the loop is iterated
        }

        StringBuilder sb = new StringBuilder();
        for (String entry : list){
            sb.append("a");
            sb.append(1); // appends a 1
        }

        sb1 = sb2.append("foo"); // returns a reference to the sb
        b = sb1 ==sb2; // true

        // similar to substing insert will always insert before the char which was referenced by the index
        sb = new StringBuilder("foo");
        sb.insert(0, "-").insert(4, "-"); // "-foo-"

        sb.delete(0,1).deleteCharAt(3); // "foo"
        // sb.deleteCharAt(100); // exception
        sb.delete(1,100); // OK

        sb = new StringBuilder("foo");
        sb.replace(2,100, ""); // "fo"

        sb.reverse(); // "of
        sb.toString();


        // StringBuilder is mutable
    }


    static void initialization(){
        sb1 = new StringBuilder("foo");
        sb2 = new StringBuilder(1000); // reserve space for 1k characters
    }
}











