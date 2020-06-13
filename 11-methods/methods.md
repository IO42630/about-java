## 07 Methods and Encapsulation

#### varargs
* Varargs : e.g. `int...`
    * similar to `int[]` for array
    * may additionally take `1,2`
* only one `...` allowed per paramter list
    * may only be used with the last prameter in parameter list.
* a method with a `int[]` parameter won't accept `1,2`
 * must have an `int...` parameter to accept `1,2`

#### static 
* Purpose
    * Helper methods, that don't require any object state.
    * State that is shared by all instances of a class.


    System.out.print(0);
    Store st = new Store(0); // stores 0
    int i = st.get();        // static method get() returns stored value
    st = null;
    i = st.get();           // st.get() is still 0

* `static initializers` : `static {i=1;}`
#### static vs instance
* See `about.StaticAbout` .

| | |
---|---
Instance Variable | one copy per object
Method (static and instance) | one copy
Method parameter & local variable (static and instance)| one copy per call


* static imports

    
    import java.util.Arrays;
    import static java.util.Arrays.asList;
    import static java.util.Arrays.*;
    
    import static java.util.Arrays;  // Error
    import java.util.Arrays.asList;  // Error

#### final
* Can't assign other Object to reference
* `final` fields are not initialized by default
    * `final int i=0;  // OK`
    * `final int i;    // C-Error` 

#### passing data
    {
        int i=0;
        foo(i);
    }
    void foo(int j){j=1;}
     
* Java is "pass-by-value"
    * the parameter is created as a new local variable
    * the parameter `j` holds the  same value as the original variable `i`
    * with mutable values 
        * modifying the parameter will cause a modification of the original variable
        * mutable reference type (`StringBuilder`)
    * with immutable values this is not a problem
        * primitive type (`int`)
        * immutable referene type (`Integer`)      
    * "pass-by-value" also happens on `return`.
* "pass-by-reference"
    * the physical address of the __variable__ is passed
    * `j` would point to the same physical address as `i`
    


#### Overloading
* _method name_ must stay the same.
* _parameter list_ must change.
    * changing `int[]` to `int...` (varargs) does not count, -> C-Error. 
* other parts of the declaration are irrelevant
    * only changing `return` type or `static` modifier `-> C-Error`
* see `about.basics.Methods`
* Autoboxing
    * defining both `foo(int i)` and `foo(Integer i)` -> OK
    * Java will use the primitive variant whenever possible
    * and autobox if the primitive variant is not present
* Reference types
    * defining both `foo(String s)` and `foo(Object obj)`
    * `foo(1)` will Autobox to Integer
    * `foo(new Integer(1))` will match with `foo(Object obj)` 
* Primitive types
    * defining both `foo(int i)` and `foo(long l)`
    * `foo(1)` will match int
    * `foo(1L)` will match long
* Generics
    * _type erasure_ generics are used only at compile time
    * `foo(List<String> a)` and `foo(List<Integer> a)`
    * both are compiled to `foo(List a)` `-> C-Error`
* Arrays 
    * don't have _type erasure_
    * `foo(String[] a)` and `foo(Integer[] a)` is a valid overload.
##### Order when Overloading
1. Exact match by type
1. Larger primitive type
1. Autoboxed type
1. Varargs
    
    
    void play(Long a){}
    play(4) // C-Error
    // int autobox Integer , can't cast from Integer to Long
    // int convert long, autobox from long to Long
    
    void play(Object a){}
    play(4) // OK can autobox from int to Integer, 
    
    void play (long a){}
    play(4) // OK can convert from int to long
    
    
* can't convert twice
    * from int to Integer
    * from Integer to Long
    
    TODO learn about conversions first
    
<br>

#### Encapsulation
* make field private
* make getter (accessor method) / setter (mutator method) with guards
* naming conventions
    * `boolean` : `.isFoo()` : `.setFoo()`
    * not `boolean` : `.getFoo()` : `.setFoo()`