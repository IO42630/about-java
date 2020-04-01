public class Declarations {}


class Specifiers {


}

/**
 * final <b>fields</b> must be initialized - either:<p>
 * > on the line they are declared<p>
 * > in an initializer<p>
 * > in the constructor<p>
 * initialization is optional for local final variables<p>
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

        // var foo =1,bar=2;    // var not allowed in compound declaration

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


    Variables(int declaration){
        // a declaration introduces the name/identifier and describes it's type
        abstract class foo{};
    }

    Variables(String definition){
        // a definition provides what the compiler needs to accept references to the name/identifier
        int a;
        class foo{ };

    }


    static void vars(){

        int var = 3;
    }
}