

import java.io.File;

public class Initialization {


    int zero;
    int one =1;

    final int final_zero; // final fields are not initialized by default
    {final_zero =0;}

    final static int final_one;
    static {final_one = 1;}


    static int i ;
    // static is just a "keyword"
    // <access modifier> static <return type> <method name>
    public static void main(String[] args){

        Initialization init = new Initialization();
        new Foo();

    }





    static void variableInitialization(){




    }


}



class Foo extends Bar{

    int var = 0;


    // This is an instance initializer block
    {System.out.println("instance initializer block");}

    // fields and initializer blocks are run in the order in which they appear
    // constructors are executed afterwards


    Foo(){

        super();
        var = 2;
        System.out.println("constructor after super");

    }



}


class Bar {



    Bar(){
        System.out.println("super()");
    }
}


class A{
    static {System.out.print("1");}
}


class B extends A{
    static {System.out.print("2");}
    public static void main(String... args){
        System.out.print("3");
        new B();
        // prints 123
    }
}

class C{
    public static void main(String... args){
        System.out.print("3");
        new B();
        // prints 312
    }
}