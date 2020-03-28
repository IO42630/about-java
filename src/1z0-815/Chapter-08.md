## Chapter 8 : Class Design
#### General


* A Java-file can have 0..1 public top-level classes.
* `this.var` references to current and iherited members
    * instance of is used do set apart instance/class variables from parameters/local variables
    * references 
* `super.var` reference to inherited members
    * is used to call members of the Parent class from the Child class.
* `this(int i)` is used to call overloaded Constructor.
* Java supports only single inheritance

#### Class declaration:

access modifier | specifier | class | class name |extends|  implements| { // class body }
---|---|---|---|---|--- |---
| | optional | | | optional | optional |empty-able
pubic | final, abstract | class | Foo  | extends Bar| implements Zoc | {int i=0;}

#### Access Modifier
Construct | `private` | default | `protected` | `public`
---|---|---|---|---
top-level type (abstract-/concrete-class, interface)| | YES | | YES
outer class |  | YES |
inner class : declared inside another class | YES | YES | YES | YES
 

    
#### Specifier
* placement:
    * before/after _access modifier_
    * before `class` (or _return type_ in methods)
* `abstract` : can't be instantiated
* `final` : class cannot be extended

#### Illegal Combinations
* `abstract` + `private` = C-Error
* `abstract` + `final` = C-Error
* `final` + `private` = OK
* `abstract` + `static` = C-Error
    
    
#### Constructors
* The purpose of a _constructor_ is to initialize fields.
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
* see `about.basics.classes.Constructors`

#### Final with Constructors
 final can be assigned values in the line in which they are declared or in an instance initializer or constructor.
 local linal may be assigned a value
 field fimal must be assigned a vvalue or c error  
 * assigning `null` counts as an assignment
 
 #### Order of Initialization with Inheritance (class loading)
 * a `class` is initialized either when
    * program starts
    * static member of the class is referenced
    * shortly before instance of class is created
 #####Order
1. `static` (starting with highes superclass)
    1. If exists superclass Y of X, then init Y first.
    2. Process all `static` var declarations in order of appearance
    3. Process all `static` initializers in the order of appearance
1. `instance`
    1. If exists superclass Y of Z, then init Y first.
    2. Process all instance var declaration in order of appearance
    3. Process all instance initializers in order of appearance
    4. Initialize the constructor including any overloaded constructors referenced with `this()`.

#### Reviewing Constructor Rules SKIP

#### Inheriting Members
* same _signature_ and compatible return type
    * thus same name, parameters and return type
    * `super` allows to reference parent method
    * `this` references the child method
* Checks performed when overridng a method
1. child method must havve same signature as parent method
2. child method must be at least as accessible as parent method
    * `Child` contains `private foo()` , `Parent` contains `pubic foo()`
    *  `Parent parent = new Child();`
    * reference type is `Parent` , instance is of type `Child`
    * `parent.foo()` -> Error
    * to avoid this, hild acess modifiers must be _wider_
3. child method may not declare a checked exception that is new or 
    broader then those in the parent method
    * child exceptions must be _narrower_
    * if reference type is narrower than instance type this might cause problems
4. if method returns a value, it must be same or a subtype of the method
    in parent method
    * aka _covariant return types_
    * again, something going `parent <- child`
    * must be narrower in child
    * `void` is only covariant with `void`
5. `static` methods can't be overridden with `instance` methods and vice versa.
    * if signature differs `static` and `instance` method wit same name may coexist.
    * however this blocks one overload each.
    * static methods are hidden, not inherited
    
#### Subtype and Supertype
* if X subtype of Y , then
    * X, Y class -> X subclass of Y
    * X, Y interface -> X subinterface of Y
    * X class, Y interface -> X implements Y (directly or through superclass)
#### Overload vs Override vs Hide vs Redeclare
|   | member | modifier |name |parameters | return type|
---|---|---|---|---|---
Overload | instance method | | same | __different__ | __any__
Override | instance method | |  same | __same__ | __covariant__
Hiding | instance/static field, static method | | same | same | covariant
Redeclaring | | (both) private  | same | same | !covariant
Illegal | | !private | same | same | !covariant
* Overriding : replaces the parent method.
* Hiding : replaces the member only if a Child reference type is used.
* Redeclaring : is always ok, since accessing the member from outside the class is prohibited anyways.

#### Overriding with Generics
* due to `type erasure` can't overload `foo(List<Integer>)` with `foo(List<String>)`
* thus overriding `foo(List<Integer>)` with `foo(List<String>)` would be seen as an illegal overload
* instead it's ok to override `foo(List<Integer>)` with `foo(List<Integer>)`
* `Parent.foo(List<Integer>)` with `Child.foo(ArrayList<Integer>)` will cause an OK overload.
* for 816
    * wildcard for generics is `<?>` 
        * `<? super String>` and `<? extends String>` is ok too
* generic return types 
    * generic must be exactly same
    * return type of overriding method may be coviant
        *  Parent `List<String> foo()` Child `ArrayList<String> foo()`
* final methods
    * can't be overridden or hidden
    * still could be redeclared (if private in parent)
* special
    * Parent : `pubic int i=0;`
    * Child : `private int i=3;`
    * 3 reference paths : new Parent(), new Child(), Parent childAsParent = new Child())
    * we are executing main from child
    * parent.i == 0
    * child.i ==3 // thus hiding works
    * childAsParent == 0 // hiding still works // just __beware__ accessing private from outside of class
    
    
#### Polymorphism
* See `about.basics.classes.Polymorphism`


#### Interfaces
* `interface`
    * can define `abstract` methods
    * a `class` can implement many `interfaces`
    * class implements interface by overriding the inherited abstract methods

* One object or one method call show different behavior.
#### 2 Types of Polymorphism
* Overloading (C-Time Poly) : resolved at C-Time
* Overriding (R-Time Poly) : resolved at R-Time

* non-static fields are hidden not overridden.

* type of _object_ (in memory)
    * immutable
* type of reference (data type)
    * determines api
    
* ??? is castA good body with a dull brain is as cheap as life itself.ing nothing more than reclaiming the full api of the child class