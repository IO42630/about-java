package classes;


import java.util.Arrays;

enum Seasons{WINTER, SPRING, SUMMER, FALL}


public class Enum {


     public static void main(String... args){

         boolean b = Seasons.WINTER.toString().equals(Seasons.WINTER.name());
         int br= 0;
         Seasons s = Seasons.WINTER;

         Seasons[] sa = s.values();
         System.out.println(sa);
         System.out.println(Arrays.deepToString(sa));
         System.out.println(Arrays.deepToString(Seasons.values()));
         System.out.println(Seasons.SUMMER.n);
         System.out.println(s.ordinal());

     }
}
