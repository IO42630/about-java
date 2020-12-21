package com.olexyn.about.java.classes.classes.examples.inheritance.parentpackage.parentpackage;

import classes.Interface;
import classes.examples.inheritance.AbstractClass;
import com.olexyn.about.java.classes.classes.*;
import com.olexyn.about.java.classes.classes.examples.inheritance.*;


public class Parent extends AbstractClass implements Interface {
    public int instanceVar =1; // instance var can be used by instance methods but not by static methods.
    public static int classVar; // class var, can be used by all methods, same in all instances of a class.
    private int priv = 2; // can't be accessed by child
    protected Integer protectedInteger = 0;
    private int n;



    public void abstractMethod(){
            int i =0;
    }

    /**
     * default constructor,
     * > can be omitted,
     *   > unless a custom constructor is defined.
     *   > in that case it must be written, else error.
     */
    public Parent() {
        this(0);
        classVar = 0;
    }

    public static CharSequence hiddenMethod(){
        return "";
    }

    public Parent(int n) {
        this.n = n; // instance variable = locale variable
        // sometimes better to use just vars in constructor, and omit methods.

    }

    @Override
    public String toString() {
        String out = super.toString();

        if(false) out = "";
        //     out = this.toString(); // StackOverflowError : circular reference
        return "Parent";
    }


    public static String staticMethod(){return "Parent";};

    /**
     * OK to loosen access modifer when overriding.
     * Overriding protected with
     *   public is OK
     *   private is OK
     */
    public void packagePrivateAccess(){

    }




}
