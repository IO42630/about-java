# Chapter 6 : Lambdas and Functional Interfaces
* Lambdas work with interfaces that have only one abstract method



* see `about.basics.lambdas.Intro`
* Interface with one Method
    * Instead of implementing in a Class
    * Skip Class, Skip Method
    * Write just parameter and method body
* parentheses can be omitted if there is a single parameter and its type is not explicitly stated
* there isn't a rule that says you must use all declared parameters



    <parameter name> -> <body>
    a -> a.foo()
    (a,b,c) -> { int d = a+b; int e = d+c; return e;};
    
* IF one parmaeter omit ()
* IF one statement, omit { return ;}


* _functional interface_ : interface with one abstract method
    * optional anotation `@FunctionalInterface` to signal intent.
    
    
#### Predefined Funtional Interfaces

    
   
Interface | # Param | Return Type
---|---|---
`Comparator<T> { int compare(T o1, T o2); }`|2|int
`Consumer<T> { void accept(T t); }`| 1| void
`Predicate<T> { boolean test(T t); }` | 1 | boolean
`Supplier<T> { T get(); }` | 0 | any

* var can be used in Lambda parameters
* Lambda body may contain:
    * Lambda parameters
    * any class/instance variables
    * effectively final parameters/local variables
        * A variable is _effectively final_ if adding final before it would not cause an C-Error



     01:  public void variables(int d) {
     02:  int b = 1;
     03:  d++
     04:  Predicate<Integer> p1 = a -> {
     05:  int b = 0;          // C-Error : b aleady taken
     06:  int c = 0;
     07:  c = d;             // C-Error : not effectively final
     08:  return b == c;}    // C-Error : ; after } missing
     09:  }



 #### Calling APIs with Lambdas
 * See `Lambdas.java/LambdaAPIs`.
 * List and Set implement methods, that take Lambdas as parameters
     * .removeIf(Predicate)
     * .sort(Comparator)
     * .forEach(Consumer)