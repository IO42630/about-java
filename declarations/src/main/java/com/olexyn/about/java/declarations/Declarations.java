package com.olexyn.about.java.declarations;


/**
 * final <b>fields</b> must be initialized - either:<p>
 * > on the line they are declared<p>
 * > in an initializer<p>
 * > in the constructor<p>
 *
 * assigning <i>null</i> counts as initialization
 */
class Final {

    final static int foo;
    static {foo = 3;}

    final int first = 0;
    final int second;
    {second = 0;}
    final Integer last;

    public Final() {
        last = null;
        final int i;
    }

}


class Variables{

    static void compoundDeclaration(){

        // var foo =1,bar=2;    // var not allowed in compound declaration (cErr)

    }

        /*
        Variable names:
        methods, variables: camelCase
        classes: CamelCase
        final static variables, enums: CAPITAL_SNAKE_CASE
     */

    // static vars associated with class, not instance
    // used for e.g. constants and counters
    private final static  int constant = 0;
    private static int count = 0;

    final  int cc ;

    public Variables(){
        cc = set();
    }


     int set(){
        return  1;
    }



    static void vars(){

        int var = 3;
    }
}


/**
 * In Java only the word <b>declaration</b> is used for both declaration and definition.<br>
 * In C the two words have different meanings (see methods of this class).
 * Conceptually abstrat class declarations are the only entities in Java, that could be considered declarations in the C.
 */
class DeclarationVsDefinition{

    /**
     * a declaration introduces the name/identifier and describes it's type
     */
    void declaration(){
        abstract class foo{};
    }


    /**
     * a definition provides what the compiler needs to accept references to the name/identifier
     */
    void definition(){
        int a;
        class foo{ };
    }
}


class PrivateStealing{

    private int foo = 1;



    public static void main(String[] args) {


        PrivateStealing bar1 = new PrivateStealing();
        PrivateStealing bar2 = new PrivateStealing();
        bar1.foo = 2;


    }



}

public class Declarations{

    public static void main(String[] args) {



    }

}
