package com.olexyn.about.java.classes.polymorphism.instance_of;

import java.util.List;

public class InstanceOf {

    public static void main(String... args){

        //Child3Interface ci = (Child3Interface) new SuperParent();


        // ClassCastException does not apply to Interfaces
        Child3Interface c3 = new Child3();
        SuperParentInterface sp = (SuperParentInterface) c3;

        SuperParentInterface sp2 = new SuperParent();
        Child3Interface c32 = (Child3Interface) sp2;

    }

    static boolean b;

    void test(){

        boolean b;
        b = new Child3() instanceof com.olexyn.about.java.classes.classes.examples.inheritance.parentpackage.Parent;  // true
        b = new com.olexyn.about.java.classes.classes.examples.inheritance.parentpackage.Parent() instanceof Child3; // false // parent cant be cast to child without explicit cast
        b = new Child1() instanceof Child3Interface; // false
        b = new Child3() instanceof Child3Interface; // true
        b = new Child1() instanceof SuperParentInterface; // true
        //b = new Child() instanceof  Child3; // cErr TODO

        Child3Interface ss = (Child3Interface) new Child1();
        //Child3 cc = (Child3) new Child();
        //Child3Interface fail = (Child3Interface) new Child3();



    }


    static void instanceOf(){
        // TODO uncomment and fix this
        // b = new Parent() instanceof Parent;         // true
        // b = new Parent() instanceof Child;          // false
        //
        // b = new Child() instanceof Parent;          // true
        // b = new Child() instanceof Child;           // true
        //
        // b = (Parent) new Child() instanceof Parent; // true
        // b = (Parent) new Child() instanceof Child;  // true




        Number i = 4;
        b = i instanceof List; // since Number is not Final, the instance type might extend Number and implement List
        // -> OK
        Integer ii = 4;
        // b = ii instanceof List; // cErr , since Integer is final, and compiler can be sure there is no way the instance type might implement List
    }

}




class SuperParent implements SuperParentInterface {
    public void superParentMethod(){};
}

class Parent extends SuperParent implements ParentInterface{}
class Child1 extends com.olexyn.about.java.classes.classes.examples.inheritance.parentpackage.Parent {}
final class Child2 extends com.olexyn.about.java.classes.classes.examples.inheritance.parentpackage.Parent {}
class Child3 extends com.olexyn.about.java.classes.classes.examples.inheritance.parentpackage.Parent implements Child3Interface {
    public void child3Method(){}
}

interface Child3Interface {
    void child3Method();
}
interface SuperParentInterface {
    void superParentMethod();
}
interface ParentInterface{}
