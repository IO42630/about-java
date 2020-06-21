Creational design patterns are all about class instantiation or object creation. 
These patterns can be further categorized into Class-creational patterns and object-creational patterns. 
While class-creation patterns use inheritance effectively in the instantiation process, object-creation patterns use delegation effectively to get the job done.
* Factory Method
* Abstract Factory
* Builder
* Singleton
* Object Pool
* Prototype.

Use case of creational design pattern-
1) Suppose a developer wants to create a simple DBConnection class to connect to a 
database and wants to access the database at multiple locations from code, 
generally what developer will do is create an instance of DBConnection class 
and use it for doing database operations wherever required. 
Which results in creating multiple connections from the database as each instance of 
DBConnection class will have a separate connection to the database. 
In order to deal with it, we create DBConnection class as a singleton class, 
so that only one instance of DBConnection is created and a single connection is established. 
Because we can manage DB Connection via one instance so we can control load balance, unnecessary connections, etc.

2) 