package com.olexyn.about.java.classes.classes.examples.inheritance;

import classes.examples.inheritance.childpackage.Child;
import classes.examples.inheritance.parentpackage.parentpackage.Parent;
import com.olexyn.about.java.classes.classes.examples.inheritance.childpackage.Child;

public class Main {


    // "new" calls constructor

    static boolean b;
    static String s;

    public static void main(String[] args) {

        polymorphism();

        new Child().classVar = 3; // OK to modify a static variable from a not-static environment

        //new ConstructorError(); // C-Error , there is no default Constructor
    }


    static void polymorphism() {


        s = ((com.olexyn.about.java.classes.classes.examples.inheritance.parentpackage.parentpackage.Parent) new Child()).toString(); // Child


        Child child = new Child();
        com.olexyn.about.java.classes.classes.examples.inheritance.parentpackage.parentpackage.Parent parent = child;

        String castToParent = compareMember(parent, child);

        parent = new Child();
        child = (Child) parent;

        String castToParentCastToChild = compareMember(parent, child);

        // both cases instanceVar is evaluated from parent after (casting)


    }


    static String compareMember(com.olexyn.about.java.classes.classes.examples.inheritance.parentpackage.parentpackage.Parent parent, Child child) {
        boolean instanceVarEqual = parent.instanceVar == child.instanceVar;
        boolean classVarEqual = parent.classVar == child.classVar;
        boolean instanceMethodEqual = parent.toString().equals(child.toString());
        boolean staticMethodEqual = parent.staticMethod().equals(child.staticMethod());
        String out = "instanceVarEqual : " + instanceVarEqual + "\n";
        out += "classVarEqual : " + classVarEqual + "\n";
        out += "instanceMethodEqual : " + instanceMethodEqual + "\n";
        out += "staticMethodEqual : " + staticMethodEqual + "\n";
        return out;
    }
}


