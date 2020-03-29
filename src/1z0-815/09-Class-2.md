## Chapter 9 : Advanced Class Design

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

