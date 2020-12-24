package com.olexyn.about.java.classes.classes.examples.inheritance.childpackage;


import com.olexyn.about.java.classes.classes.examples.inheritance.parentpackage.Parent;


public class Child extends Parent {

    public int instanceVar =0;
    private int n;
    public static int classVar;

    public Child() {
        this(0);
        int n = 1;
        this.n = n;
        classVar =1;


    }

    public Child(int n) {
        super(n);
        this.n = n;


    }


    public static String hiddenMethod(){
        return null;
    }

    @Override
    public String toString() {
        return "Child";
    }

    public static String staticMethod(){return "Child";};

    /**
     * protectedInteger is declared in Parent.
     *
     */
    void protectedTest(){
        int i = protectedInteger;            // declared in parent
        i = new Child().protectedInteger;
        //i = new Parent().protectedInteger; // C-Error, since this is a different package


    }


}
