## Control


* the target of an decision-making statement can be a
    * single statement
    * block            
* reminder : 0 and 1 are not boolean value in Java

#### switch
* see `control.Logic.switchTest()` 
1. goto matching case
1. IF no matching case available, THEN  goto default
1. execute everything below the current statement
    * this is why optional `break` statements are used 
* `switch` does ot allow `continue` statement.
* allowed `switch` types:
    * `short` , `Short` , `int` , `Integer`
    * `byte` , `Byte` , `char` , `Character`
    * `String`
    * enum values
    * `var` (type resolves to one of the above)
##### case expressions
* no declarations allowed 
* be, or consist of, `C-time constant` expressions
    * literals
    * enum constants
    * `final` _constant_ variables
        * _constant_ ~ initialized when declared
        * _constant_ ~ not initialized by method (happens at runtime)
* match the `switch` type without an explicit cast (see `about.Castig`)

<br>

#### while & do while

* `while (booleanExpression){}`    
    * booleanExpression evaluated before each iteration
* `do {} while (booleanExpression);`
    * Loop is executed once before the expression is evaluated.    
* care: C-Error unreachable statement
    * `while(false){ i=1 }`
    * `while(true){} i=1;`

<br>

#### for
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

#### enhanced for (for each)
* `for (datatype instance : collection){}`
*  _collection_ is either:
    *  array
    * X implementing `java.lang.Iterable` , e.g. `ArrayList` 

<br>

#### break & continue
* `break`transfers control to the next enclosing statement
    *  _label_ allows to break out of an higher-level loop
* `continue` transfers control to the expression that determines if the loop should continue.
* any statement after `break` , `continue` is unreachable -> C-Error