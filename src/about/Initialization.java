package about;

import java.io.File;

public class Initialization {


    static int i ;
    // static is just a "keyword"
    // <access modifier> static <return type> <method name>
    public static void main(String[] args){


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