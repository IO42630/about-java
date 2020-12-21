package com.olexyn.about.java.classes.polymorphism;

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

        //instanceOf();
        casting();


        com.olexyn.about.java.classes.classes.examples.inheritance.parentpackage.parentpackage.Parent parent = new com.olexyn.about.java.classes.classes.examples.inheritance.parentpackage.parentpackage.Parent();
        com.olexyn.about.java.classes.classes.examples.inheritance.childpackage.Child child = new com.olexyn.about.java.classes.classes.examples.inheritance.childpackage.Child();

        com.olexyn.about.java.classes.classes.examples.inheritance.parentpackage.parentpackage.Parent childAsParent = child;


        // i = childAsParent.privateInt;
        i = childAsParent.publicInt;

        i = childAsParent.pubicMethod();

        i = childAsParent.foo;
       // i = child.foo;


        com.olexyn.about.java.classes.classes.examples.inheritance.childpackage.Child parentAsChild = (com.olexyn.about.java.classes.classes.examples.inheritance.childpackage.Child) new com.olexyn.about.java.classes.classes.examples.inheritance.parentpackage.parentpackage.Parent();

        int br=0;


    }




    static void casting(){

        com.olexyn.about.java.classes.classes.examples.inheritance.parentpackage.parentpackage.Parent childAsParent = new com.olexyn.about.java.classes.classes.examples.inheritance.childpackage.Child();   // Implicit Cast, (Parent) is inserted during compilation.
        com.olexyn.about.java.classes.classes.examples.inheritance.childpackage.Child child = (com.olexyn.about.java.classes.classes.examples.inheritance.childpackage.Child) childAsParent;  // Explicit Cast, C-Error if (Child) is omitted.


        if (new com.olexyn.about.java.classes.classes.examples.inheritance.parentpackage.parentpackage.Parent() instanceof com.olexyn.about.java.classes.classes.examples.inheritance.childpackage.Child) { com.olexyn.about.java.classes.classes.examples.inheritance.childpackage.Child parentAsChild = (com.olexyn.about.java.classes.classes.examples.inheritance.childpackage.Child) new com.olexyn.about.java.classes.classes.examples.inheritance.parentpackage.parentpackage.Parent(); }// ClassCastException




       //String s = (String) new Integer(1);         // C-Error (can't cast between unrelated types
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
}




class Child extends com.olexyn.about.java.classes.classes.examples.inheritance.parentpackage.parentpackage.Parent {
    static int i;
    public int publicInt =3;
    private int privateInt = 3;

    public int pubicMethod(){return 3;}
    private int privateMethod(){return 3;}
}
