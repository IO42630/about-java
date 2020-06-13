### SOLID

##### Single Responsibility Principle
* a class should have one! purpose.

##### Open / Close Principle
* open for extension, close for modification
* classic sense : inheritance - parent is not modified, but extended by child.
* modern sense: loose coupling: 
    * Interfaces are closed, may be implemented by different classes.
    * If reusing code between implementing classes is desired, use inheritance or composition.

##### Liskov Substitute
* parent should be replaceable with child dsf without breaking the application
* formal:
    * S subtype of T
    * object x of type T
    * object y of type S
    * property A()
    * if A(x) provable
        * then A(y) should be true
        
##### Interface Segregation
* Single Responsibility for Interfaces.

<br>

##### Dependency Inversion
* High-level modules should not depend on low-level modules. Both should depend on abstractions.
* Abstractions should not depend on details. Details should depend on abstractions.
