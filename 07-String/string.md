## 053 String
* see `about.string` .
* implements the `CharSequence` interface.
* concatenation 
    * if both opernads are numeric, + means addition.
    * if eiter operand is a String, + means concatenation.
    * evaluate from left to right.


    s = 1+2;        // 3
    s = "a"+1;      // a1
    s = 1+2+"a";    // 3a
    s = "a"+1+2;    // a12
    s+=2;           // s = s + 2 thus a122
    
* immutability
    * once a String object is created, it cannot be changed
       
       
#### StringBuilder
* see `about/StringBuilder`
* implements the `CharSequence` interface.

#### Equality
* reference equality : variable points to same object
    * beware when dealing with objects, e.g. arrays, 
    * since a new array with same contents will be a new object and thus not ==
    * checking for reference equality of two different types -> C-Error
* value equality : object has same properties
* `.equals()` 
    * depends on implementation by the object
    * for String it compares contents, and returns true if same.
    * for Objects in general it checks for refeence equality just like ==
        * StringBuilder
        * Array
        
#### String Pool
Strings use a lot of memory.
To reuse common strings java collects them in the string pool (a.k.a. intern pool)

* pool contains literal values and constants used by the program
    * `myObject.toString()` is a string but not a literal, so it does not go into the string pool.

<br>