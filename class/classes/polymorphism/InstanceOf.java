package classes.polymorphism;


import java.util.List;

public class InstanceOf {

    static boolean b;

    void test(){

        boolean b;
        b = new Child2() instanceof Parent1;  // true
        b = new Parent1() instanceof Child2; // false // parent cant be cast to child without explicit cast
        b = new Child1() instanceof SomeInterface; // false
        b = new Child2() instanceof SomeInterface; // true
        b = new Child1() instanceof FooInterface; // true
        //b = new Child1() instanceof  Child2; // C-Error TODO

        SomeInterface ss = (SomeInterface) new Child1();
        //Child2 cc = (Child2) new Child1();
        //SomeInterface fail = (SomeInterface) new Child3();



    }


    static void instanceOf(){

        b = new Parent() instanceof Parent;         // true
        b = new Parent() instanceof Child;          // false

        b = new Child() instanceof Parent;          // true
        b = new Child() instanceof Child;           // true

        b = (Parent) new Child() instanceof Parent; // true
        b = (Parent) new Child() instanceof Child;  // true




        Number i = 4;
        b = i instanceof List; // since Number is not Final, the instance type might extend Number and implement List
        // -> OK
        Integer ii = 4;
        // b = ii instanceof List; // C-Error , since Integer is final, and compiler can be sure there is no way the instance type might implement List
    }

}




class SuperParent  implements FooInterface{}
class Parent1 extends SuperParent{}
class Child1 extends Parent1 {}
class Child2 extends Parent1 implements SomeInterface{}
final class Child3 extends Parent1{}
interface SomeInterface{}
interface FooInterface{}
