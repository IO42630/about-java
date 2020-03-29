# Chapter 4 : Decisions


* the target of an decision-making statement can be
    * a single statement
    * a block (of statements)
    
            if (bool){
            ? else if (bool){
            } else {
            }
            
* reminder : 0 and 1 are not boolean value in Java

##### Switch
* Goto matching case.
* If no matching case available goto default.
* Execute everything below the current statement.
    * This is why we have optional `break` statements.

            switch(varToTest) {
                case constExpr1:
                    //branch for case;
                    break; // optional
                case constExpr2:
                    // branch for case;
                    break; // optional
                default:
                    // branch for default;
            }
* `switch` does ot allow `continue` statement.
* The following data types are allowed in switch statements.
    * int and Integer
    * byte and Byte
    * short and Short
    * char and Character
    * String
    * enum values
    * var (fi the type resolves to one of the preceeding types)
    
* case statements
* the following case statements are allowed
    * compile-time constant values
        * literals
        * enum constants
        * final constant variables
            * must be initialized with a literal on the same line it is delclard
            * initialization by method does not count
            * because methods are not evaluated until runtime
* expressions are allowed, provided the value can be resolved at runtime
    * e.g. case 3+4:
    * they also must be able to fit in the switch data type without an explicit cast.
    * 

implicit vs explicit casts
* implicit:
    * from smaller to larger integer primitive types
        * e.g. `short s = 3; int i = s;`
    * from larger to smaller, as long as they fit the range
        * `int i = 3; short s = i;`
* explicit:
    * from larger to smaller, if range is exceeded
        * `int i = 1_000_000; short s = (short)i;`


*  `break;` ends the loop.
* `continue` ends the current iteration of the loop.

#### While & Do While

* `while (booleanExpression){}`    
    * booleanExpression evaluated before each iteration
* `do {} while (booleanExpression);`
    * Loop is executed once before the expression is evaluated.    
* care: C-Error unreachable statement
    * `while(false){ i=1 }`
    * `while(true){} i=1;`





#### For
* `for (initializationStatement ; booleanExpression ; updateStatement) {}`
* Order of execution:
    1. init statement executes
        * the rules for multiple-declaration do apply.
    1. Evaluate Expression (_before_ body)
    1. Body executes
    1. Execute updateStatement
    1. Return to Step 2
* each of the 3 components of the for loop are optional
    * `for( ; ; )` ~ infinite loop.

#### Enhanced For (for each)
* `for (datatype instance : collection){}`
*  _collection_ is either:
    *  array
    * X implementing `java.lang.Iterable` , e.g. `ArrayList` 


#### break
* transfers control to the next enclosing statement
    *  _label_ allows to break out of an higher-level loop


    optionalLabel : for (String entry : list){
                for (String foo :list){
                    break optionalLabel;
    }           }


#### continue
* _continue_ transfers control to the boolean expression that determines 
if the loop should continue.
* _return_ statements are somewhat similar, 
in that they allow to exit a block of code early.

#### Unreachable Code
* Any statement after a break or continue statement will lead to an 
_unrachable statemennt_ error, and will not compile.

