package classes.polymorphism;

import java.util.List;

/**
 * * Java an instance of a class may be accessed with reference type:
 *     * of class
 *     * of superclass of class
 *     * of interface implemented by class or superclass
 * * Cast is not required if instance of class is assigned to supertype or interface
 */
public class Polymorphism {

    static int i;
    static boolean b;

    public static void main(String... args){

        instanceOf();
        casting();


        Parent parent = new Parent();
        Child child = new Child();

        Parent childAsParent = child;


        //i = childAsParent.privateInt;
        i = childAsParent.publicInt;

        i = childAsParent.pubicMethod();

        i = childAsParent.foo;
       // i = child.foo;


        Child parentAsChild = (Child) new Parent();

        int br=0;


    }




    static void casting(){

        Parent childAsParent = new Child();   // Implicit Cast, (Parent) is inserted during compilation.
        Child child = (Child) childAsParent;  // Explicit Cast, C-Error if (Child) is omitted.


        if (new Parent() instanceof Child) { Child parentAsChild = (Child) new Parent(); }// ClassCastException
        // ClassCastException does not apply to Interfaces

        // if (new Integer(1) instanceof String){// C-Error
        //   s = (String) new Integer(1);         // C-Error
        // }


        int br = 0;


    }








}



class Parent{

private int privateInt=0;
public int publicInt =0;

public int pubicMethod(){return 0;}
private int privateMethod(){return 0;}

      void finalMethod(int i){}

      private int wierd =0;

 int foo=0;

    //private int privateInParent =0;

}







class Child extends Parent{

    static int i;
public int publicInt =3;
private int privateInt = 3;

public int pubicMethod(){return 3;}
private int privateMethod(){return 3;}


    static void finalMethod(){}


    private int foo =3;
    public int weird = 3;

    public int privateInParent =3;


    public static void main(String... args){
        Parent parent = new Parent();
        Child child = new Child();

        Parent childAsParent = child;

        //i = childAsParent.privateInt;
        i = childAsParent.publicInt;

        i = childAsParent.pubicMethod();


        // since cuts down interface
        //i = childAsParent.privateInParent;

        i = childAsParent.foo;
        i = child.foo;
        int br=0;
    }
}
