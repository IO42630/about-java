# Chapter 8 : Class Design
### General

* _member_ : inherited component of class
    * fields, methods, nested classes, interfaces, enumerated types
    * ! consctructors (since not inherited)
* _field_ : variable declared outside of method, but inside class.
* A Java-file can have 0..1 public top-level classes.
* `this.var` references to current and iherited members
    * instance of is used do set apart instance/class variables from parameters/local variables
    * references 
* `super.var` reference to inhereted members
    * is used to call members of the Parent class from the Child class.
* `this(int i)` is used to call 

### Inheritance
* Java supports only single inheritance


* Class declaration:

access modifier | specifier | class | class name |extends|  implements| { // class body }
---|---|---|---|---|--- |---
| | optional | | | optional | optional |empty-able
pubic | final | class | Foo  | extends Bar| implements Zoc | {int i=0;}

##### Access Modifier
Construct | `private` | default | `protected` | `public`
---|---|---|---|---
top-level class| | YES | | YES
inner class : declared inside another class | YES | YES | YES | YES
 

    
##### Specifier
* abstract
* final : class cannot be extended
    
    
#### Constructors
* Match the name of the class
* may have different access modifiers, 
    * overloading rules do apply
* `var` type can not be used in parameters
* if a user-declared constructor is present, the default constructor is not declared in the background
    * thus calling the default constructor -> C-Error.
    * having a private constructor effectively disables the instantiation of the class from outside.
* `this()` and `super()` must be the first statement in the constructor
    * `Foo(){this();}` does not Compile, likewise other circular references caused by constructors. 
* if no `this()` and `super()` are present the compiler inserts a `super()` in the background
* Trivia:
    * since compiler inserts super() the parent constructor is called in every child
    * if class has private constructor
        * it can only be extended by inner classes.
* Relevant:
    * Parent has no-default constructor
    * Child has no (or no matching) constructor.
    * C-Error, since compiler will insert call to default constructor of parent.
* super() refers to most direct parent

SKIP

### Polymorphism
One object or one method call show different behavior.
##### 2 Types of Polymorphism
* Overloading (C-Time Poly) : resolved at C-Time
* Overriding (R-Time Poly) : resolved at R-Time

* non-static fields are hidden not overridden.

* type of _object_ (in memory)
    * immutable
* type of reference (data type)
    * determines api