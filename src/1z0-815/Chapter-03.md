# Chapter 3 : Operators
* _operand_ : variable, literal, value
    * variable : `foo`
    * literal : `1`  ()
    * value : a series of bits in heap 
* _operator_ : special symbol that can be applied to a set of operands

### Types of Operators

* unary (one operand), binary (two operands), ternary (three operands)

### Precedence
* according to precedence
* if same precedence, then left to right
 * Precedence may be overridden with parentheses ().
    * Java does not allow brackets [].
    * Java does not allow braces {}. 

Order | Operator (by precedence DESC) | Example
--- | --- | ---
1 | post-unary | expr++, expr--
2 | pre-unary | ++expr , --expr
3 | other unary | - , ! , ~ , + , (type)
4 | mult/div/mod | * , / , %
5 | add/subtract | + , -
6 | shift   | << , >> , >>>
7 | relational | < , > , <= , >= , `instanceof`
8 | (not) equal to | == , !=
9 | logical | & , ^ , \|
10 | ternary | boolean expr ? expr1 : expr2
11 | assignment | = , += , -= , *= , /= , %= , ^= , <<= , >>=, >>>= 
 
 
 
 Operator | What it does
 --- | ---
 -expr | negates the literal or variable
 
 
 ### Binary Arithmetic Operators
 


##### Rounding
* "floor" of 4.9 is 4 (the next smalles integer value)


##### Numeric Promotion
Not at assignment, but each time an operation takes place, the following rules are applied in the following order:
1. `byte` , `short` , `char` are promoted to `int` before being used with a binary arithmetic operator.
    *  unary operators are excluded from this rule (`++short` is still `short`)
1. IF operands have different data types, 
    * IF both operands are integer, THEN promote operands to the "largest" data type.
    * IF one operand is floating-point, THEN promote integer operands to floating-point operands.
1. The result of the operation has the same data type as the promoted operands.

        short w = 14;
        float x = 13;
        double y = 30;
        var z = w *x / y;
        
        type "resolution":
        
        var = short * float / double;
        var =   int * float / double;
        var = float * float / double;
        var =         float / double;
        var =        double / double;
        var =                 double;

### Assignment Operators
Operator | What it does
 --- | ---
 a = b | assigns the value on the right to the var on the left.
 
 ##### Casting
 * See `about.basics.classes.Main.polymorphism`
 * optional from smaller to larger types.
 * mandatory from larger to smaller types
 * because casting is an unary operation, use parantheses where necessary
 * the space between operator and operand is optional.
 
        short foo  = (short)(1+2);
 
##### Compound Assignment Operators
* see `bout.basics.Operators.Assignments`
* `+=` , `/=` , `*=` , `-=`
* assignee must have been declared prior (obviously).
    * `foo *= a + b; //equiv// foo = foo * (a + b);`    
* compound assignment operators obscure casting
* an assignment operation can be used as a operand

        
        
#### Comparing Variables
  | | | primitives | reference types |
 ---|--- | --- | ---
 Sameness | `==` , `!=` | checks if same object   | checks if same reference
 Equivalence | `a.equals(b)`| - | check if same object
 

* comparing 
    1. two num or char primitive types, if different data types, then promoted
        * 5 == 5.00    becomes  5.00 == 5.00
        * remember char are promoted to int
    1. two variables/literals of type boolean
    1. two references (including `null` and references to objects of type `String`)
        * `null==null` is true.
* compareTo()
    * imagine: `a.compareTo(b) = a - b;`

### Relational Operators
* boolean
    * `>` , `>=`, `<`, `<=`
    * `obj instanceof Object`
        * may be used before Casting
        * `null instanceof Object` is always `false`
        * C-Error: `null instanceof null`
        
#### Logical Operators
* Logical
    * AND `&` , OR `|` , XOR `^`
* Short-cirquit: 
    * If first clause suffices to determine the result, the second clause is not evaluated.
    * AND `&&` , OR `||`
    * Usage: `if(list!=null && list.get(1){ }`
    
##### Unperformed Side Effects:


    int i =0;
    boolean b = (i==0 || (i=i+1)==0); // this is valid syntax
    // i remains 0 , because clause after || is never evaluated


### Ternary Operator


    int i = 0;
    String s = i<2 ? "val if true" : "val if false";
    
    Object find(int i){
        return i>0 ? new Integer(1) : "foo"; // OK to have different types
    }
    
        
 * obvious Unperformed Side Effects see `Logic.java`.
        