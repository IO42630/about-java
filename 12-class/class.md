## 08 Class

#### General

* `.java` file can have 0 or 1 public top-level classes.
    * `C-Error` if filename does not match name of public class.
* `this.var` references current and inherited members
    * sed do set apart instance/class variables from parameters/local variables
* `super.var` reference to inherited members
    * used to call members of the Parent class from the Child class.
* `this(int i)` is used to call overloaded Constructor.
* Java supports only single inheritance

<br>

#### Ordering of Elements
Element|Example|Required|Placement
---|---|---|---
Package declaration | `package foo;`|NO | First line in the file
Import statements | `import bar.*;`|NO | After the package
Class declaration | `public class C`| YES | After import
Field declarations | `int i;`| NO | Any top-level element in class
Method declarations | `void method()` | NO |  Any top-level element in class

<br>

#### Constructors
* The purpose of a _constructor_ is to initialize fields.
* Match the name of the class
* may have different access modifiers, 
    * overloading rules do apply
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

<br>

##### `final` with Constructors
* final can be assigned values
    * in the line in which they are declared 
    * in an instance initializer 
    * constructor
 * `final` local variable may be assigned a value
 * `final` field not assigned after constructor `-> C-Error`
    * assigning `null` counts as an assignment
 
 <br>
 
 #### Order of Initialization
 * aka _class loading_
 * a `class` is initialized either when
    * program starts
    * static member of the class is referenced
    * shortly before instance of class is created
    
 ##### Order
1. `static`
    1. init `super` first (start with highest)
    2. `static` var declarations (in order of appearance)
    3. `static` initializers (in order of appearance)
1. `instance`
    1. init `super` first
    2. instance var declaration (in order of appearance)
    3. instance initializers (in order of appearance)
    4. Initialize the constructor including any overloaded constructors referenced with `this()`.
        1. `this()` or `super()` if present
        2. default `super()`
1. what ever instance method is called




<br>

#### Reviewing Constructor Rules SKIP

<br>

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
* type of _object_ (in memory)
    * immutable
* type of reference (data type)
    * determines api
* ??? is casting nothing more than reclaiming the full api of the child class


<br><br><br><br>



#### Abstract Classes
* see `basics.classes.AbastractClass`
* may contain abstract methods
    * without body: `abstract void foo();`
    * does not define an implementation upon declaration
    * must be overridden in first _concrete class_
        * overriding rules _DO_ apply
* `abstract` classes may contain anything an concrete class contains
    * not true vice-versa


#### Constructors in Abstract
* main difference:
    * can only be called by instantiating subclass
* see `about.basics.classes.AbstractDemo`
    
   

#### Interfaces
* may be public or default
* may include:
    * abstract methods
    * constant variables
* all members of an interface are assumed to be public
* since Java 8 may include
    * static methods
    * default methods (concrete, has body)
* since Java 9 may include 
    * private
    * private static methods
    * added for code-reuse with interface, cannot be called from outside.
* `interface` provides implicit modifiers
    * thes must be written explicitly in class implementing interface
* call may implement multiple interfaces, separated by comma
    * class must implement all of the abstract methods contained in 
    the interfaces.
    * if 1+ interface contain identical methods
        * imlementing class overrides them all at once.
* `interface` may extend multiple interfaces (spearated by comma)
    * ok, since no Constructors / concrete instance members present
    * some rules of class declarations apply
        * .java file may have at most one public top-level interface, must match name
* abstract type inheriting from interface is not required to implement or declare inherited methods
* interface cant extend class
    * nothing can implement class
##### overriding two interfaces
* if declarations in both interfaces are compatible
    * just override them
* if signatures of both declarations are different
    * it's an overload
* if signatures are same
    * overriding rules apply
    
    
#### Enums
* out of scope for 815.
 
### Poly and Ifaces
* when using abstract reference (e.g. inface) for concrete class
    * wish to access memeber which exist in concrete class only
    * explicit cast from e.g. infterface to class
        * mus be compatible
* `instanceof`
    * if reference type is final compiler will detect 
    * if reference type is abstract it might be extended to become an instance of
        * thus compiler can't check  
    
#### Inner Classes / Interfaces
* member of a class
* can have all 4 access modifiers ( top-level classes/interfaces can only be public/default)
* can't contain static methods