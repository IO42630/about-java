# Chapter 8 : Class Design
### General

* member : inherited component of class
    * fields, methods, nested classes, interfaces, enumerated types
    * ! consctructors (since not inherited)
* field : variable defined outside of method, but inside class. is a member of the class.
* A Java-file can have 0..1 public top level classes.
* `this.var` references to current and iherited members
    * instance of is used do set apart instance/class variables from parameters/local variables
    * references 
* `super.var` reference to inhereted members
    * is used to call members of the Parent class from the Child class.
* `this(int i)` is used to call 

### Inheritance
* Java supports only single inheritance


* Class declaration:

access modifier | specifier | class | class name || extends | { // class body }
---|---|---|---|---|--- |---
optional | optional | |   | optional | empty-able
pubic | final | class | Foo  | extends Bar| {int i=0;}

##### Access Modifier
* top-level class : is not defined inside another class
    * pubic or default
* innner class : defined inside another class
    * public, protected, default or private

    
##### Specifier
    * abstract
    * final : class cannot be extended
    
    
#### Constructors
* Match the name of the class
* may have different access modifiers, 
    * overloading rules do apply
* `var` type can not be used in parameters
* if a user-defined constructor is present, the default constructor is not defined in the background
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