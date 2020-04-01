## 06 Lambdas
* see `about.basics.lambdas.Intro`
* Lambdas work with `functional` interfaces (interfaces that have only one `abstract` method)
    * optional annotation `@FunctionalInterface` to signal intent.
* Instead of implementing class/method
    * write just parameter and method body
* parentheses can be omitted if there is a single parameter and its type is not explicitly stated
* there isn't a rule that says you must use all declared parameters
* `<parameter name> -> <body>`
* `a -> a.foo()`
* `(a,b,c) -> { int d = a+b; int e = d+c; return e;};`
* IF one parmaeter omit ()
* IF one statement, omit { return ;}
* var can be used in Lambda parameters
* Lambda body may contain:
    * any Lambda parameters (the ones before `->`)
    * any class/instance variables (of the surrounding class)
    * `effectively final` parameters/local variables (of the surrounding method)
        * A variable is _effectively final_ if adding final before it would not cause an C-Error

<br>
    
#### Predefined Funtional Interfaces

| | 
|---|
|`Comparator<T> { int compare(T o1, T o2); }`
|`Consumer<T>      { void accept(T t); }`
|`Predicate<T>   { boolean test(T t); }` 
|`Supplier<T>   { T get(); }`    


 #### Calling APIs with Lambdas
 * See `Lambdas.java/LambdaAPIs`.
 * List and Set implement methods, that take Lambdas as parameters
     * `.removeIf(Predicate)`
     * `.sort(Comparator)`
     * `.forEach(Consumer)`