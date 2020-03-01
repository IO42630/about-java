# Chapter 6 : Lambdas and Functional Interfaces
* Lambdas work with interfaces that have only one abstract method
Since that interface’s method takes an Animal, that means the lambda
parameter has to be an Animal. And since that interface’s method returns a
boolean, we know the lambda returns a boolean.

* Example see `Lambdas.java`.
* Single parameter
* Arrow operator to separate the parameter and body
* Body calls a single methods, and returns the result
* parentheses can be omitted if there is a single parameter and its type is not explicitly stated
* there isn't a rule that says you must use all defined parameters



    <parameter name> -> <body>
    a -> a.canHop()
    
    
* Examples of Invalid Lambdas:


    a, b -> a.startsWith("test")
     Missing parentheses
    a -> { a.startsWith("test"); }
     Missing return
    a -> { return a.startsWith("test") }
     Missing semicolon

* _functional interface_ : interface with one abstract method
    * optional annotation `@FunctionalInterface` to signal intent.
    
    
#### Predefined Funtional Interfaces
* Java provides some functoinal interfaces



    public interface Predicate<T> {
        boolean test(T t);
    }

#### Consumer

    public interface Consumer<T>{
        void accept(T t);
    }
    
    
Func-Interface | # Param | Return Type
---|---|---
Comparator|2|int
Consumer| 1| void
Predicate | 1 | boolean
Supplier | 0 | any

* var can be used in Lambda parameters
* Lambda body may contain:
    * Lambda parameters
    * any class/instance variables
    * effectively final parameters/local variables



     01:  public void variables(int a, int d) {
     02:  int b = 1;
     03:  d++
     04:  Predicate<Integer> p1 = a -> {
     05:  int b = 0;
     06:  int c = 0;
     07:  c = d;
     08:  return b == c;}
     09:  }


* 4 errors
    * a is already declared
    * b is already declared
    * ; missing after end of declaration of p1 ( correct c:}; )
    * C-Error on line 07, since variables that are not effectively final can't be used in Lambdas

    
    
 #### Effectively Final
 * A variable is _effectively final_ if adding final before it would not cause an C-Error
  
  
 #### Calling APIs with Lambdas
 * See `Lambdas.java/LambdaAPIs`.
 * List and Set feature .removeIf(lambda)
 * .sort(lambda) is also available
 * .forEach(lambda)