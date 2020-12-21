package com.olexyn.about.java.classes.polymorphism.errors;

class Parent {}

class ChildA extends com.olexyn.about.java.classes.classes.examples.inheritance.parentpackage.parentpackage.Parent {}

class ChildB extends com.olexyn.about.java.classes.classes.examples.inheritance.parentpackage.parentpackage.Parent {}

public class CastingAcrossChildren {

    public static void main() {
        com.olexyn.about.java.classes.classes.examples.inheritance.parentpackage.parentpackage.Parent childAasParent = new ChildA();
        if (childAasParent instanceof ChildB) {
            ChildB childB = (ChildB) childAasParent; // -> R-Error (ClassCastException)
        }
    }
}



