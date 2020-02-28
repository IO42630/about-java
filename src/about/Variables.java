package about;

public class Variables {

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

}
