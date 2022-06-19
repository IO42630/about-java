package com.olexyn.about.java.classes.enums;

import java.util.Arrays;



 enum SomeEnum {
     A("a") {
         public void abstractPrint() { System.out.println(instanceString); }
         public void print() {
             System.out.println(this.equals(SomeEnum.A)); // -> true
             SomeEnum.A.privateString = "foo";
             // this.privateString = "bar"; // cErr
             boolean b2 = SomeEnum.A.staticString.equals(SomeEnum.B.staticString);
             boolean b3 = SomeEnum.staticString.equals(SomeEnum.C.staticString);
             SomeEnum.B.privateString = "bar"; // can access B's privateString
         }
     },
    B("b"){ public void abstractPrint(){ System.out.println(instanceString); } },
    C{ public void abstractPrint(){ System.out.println(instanceString); } },
    D{ public void abstractPrint(){ System.out.println(instanceString); } };
    // ; after all constants have been listed

    static String staticString;
    String instanceString;
    private String privateString;
    SomeEnum(){}; // default constructor

    private SomeEnum(String instanceString){ this.instanceString = instanceString; } // must be private
    public abstract void abstractPrint(); // must be overridden
    public void print() { System.out.println(instanceString); }  // may be overridden
}

/**
 *
 */
public class Enum {

     public static void main(String... args){

         boolean b = SomeEnum.A.toString().equals(SomeEnum.A.name());

         SomeEnum s = SomeEnum.A;
         // SomeEnum foo = new SomeEnum(); // -> cErr

         SomeEnum[] sa = s.values();
         System.out.println(sa);
         System.out.println(Arrays.deepToString(sa));
         System.out.println(Arrays.deepToString(SomeEnum.values()));
         System.out.println(SomeEnum.A);
         System.out.println(s.ordinal());


         SomeEnum someEnum = SomeEnum.A;  // prints ABCD


         SomeEnum.A.print();

     }
}
