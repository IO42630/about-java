#### About
This overview is inspired by the normalization levels in relational databases.

<br> 

#### Glossary
* feature : some functionality provided by a service.
* service : an entity providing a feature.
* consumer : an entity consuming (making use of) a feature.

<br>

#### Levels
* __Level 1__ : Single Responsibility
    * A service contains only one feature.
* __Level 2__ : Open / Close
    * Add `featureA` and `featureB` by extending `Service` in level 1.
* __Level 3__ : Liskov Substitute
    * In `ServiceB` modify `feature()` such that it behaves identically to its parent.
* __Level 4__ : Dependency Inversion
    * Create interfaces, and use them to refer to implementations.
* __Level 5__ : Interface Segregation
    * Create a separate interface for each separate feature.
* __Level 6__ : Dependency Injection
    * Do not declare services in `Client`.
    * Declare services in `main` and pass them to consumer by ..
        * _Level 6.1_ Constructor Injection
            * .. passing services as parameters to the constructor of `Client`.
        * _Level 6.2_ Method Injection
            * .. passing services as parameters to methods in `Client`.
        * _Level 6.3_ Property Injection
            * .. setting fields in `Client`. These fields hold instances of services.
* __Level 7__ : Dependency Injection with `Injector`
    * Similar to 6.1 but uses Injector (Factory-pattern) to create `Client` instances.
