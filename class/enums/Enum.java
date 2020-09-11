package enums;


import java.util.Arrays;



 enum SomeEnum {
    A("a"){
        public void absPrint(){ System.out.println(string); } // mandatory override of abstract method
        public void print(){ // optional override
            System.out.println(this.equals(SomeEnum.A)); // -> true
            SomeEnum.A.privateString = "foo";
            // this.privateString = "bar"; // C-Error
            boolean b2 = SomeEnum.A.badf.equals(SomeEnum.B.badf);
            boolean b3 = SomeEnum.badf.equals(SomeEnum.C.badf);
            String asfd = SomeEnum.B.privateString;
    }   },
    B("b"){ public void absPrint(){ System.out.println(string); } },
    C{ public void absPrint(){ System.out.println(string); } },
    D{ public void absPrint(){ System.out.println(string); } };
    //
    static String badf;
    String string;
    private String privateString;
    SomeEnum(){}; // default constructor
    private SomeEnum(String string){ this.string = string; } // must be private
    public abstract void absPrint();
    public void print() { System.out.println(string); }
}


public class Enum {


     public static void main(String... args){

         boolean b = SomeEnum.A.toString().equals(SomeEnum.A.name());

         SomeEnum s = SomeEnum.A;
         // SomeEnum foo = new SomeEnum(); // -> C-Error

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
