# Chapter 7 : Methods and Encapsulation
* Method declaration:

access modifier | specifier | return type | method name | (list of param)| exception | {method body}
---|---|---|---|---|--- |---
optional | optional | |   | empty-able | optional | empty-able
pubic | final | void | foo | () | throws Exception | {int i=0;}
    
* "signature of a method" = method name and parameter list (type and order).
    * the name itself is not unique.
    
#### Access Modifiers
* private : only same class
    * not other class in same file. e.g. encapsulating class
* default : private + any class in same package 
    * (if access modifier is omitted)
    * C-Error: if keyword is used.
* protected
    * default + may be accessed in/through an instance of the child class
* public : anywhere

#### Specifiers
* static
* abstract
* final : method may not be overridden
* synchronized : for multithreading
* native : for C++ compat.
* strictfp : makes float operations portable.


## Varargs
* Varargs : e.g. `int...`
    * similar to `int[]` for array
    * may take `1,2` in addition the data `int[]` can take.
* only one `...` allowed per paramter list
* may only be used with the last prameter in parameter list.

#### apply static 
SKIP
### passing data 
SKIP
### Overloading
* _method name_ must stay the same.
* _parameter list_ must change.
    * changing `int[]` to `int...` does not count, -> C-Error. 
* other parts of the declaration are irrelevant.

### Autoboxing
SKIP


### Encapsulating
* make field private
* make getter (accessor method) / setter (mutator method) with guards
* naming conventions
    * `boolean` : `.isFoo()` : `.setFoo()`
    * not `boolean` : `.getFoo()` : `.setFoo()`
    