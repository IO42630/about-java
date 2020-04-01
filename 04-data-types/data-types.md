## 02 Data Types

* Java works with _objects_ that contain collections of Primitive Data Types.

#### reference vs. instance vs. object
* _variable_ whose type is a reference type
    * holds a _reference_
* _reference_
    * holds the address of an _instance_
    * always of same size (=length)
    * a reference can be held by multiple variables
    * `new Object()` creates a new reference
* _instance_
    * holds the physical address of an _object_
    * the physical address is invisible in Java.
* _object_
    * physical object in memory
    * `new Object()` causes an _object_ to be created in memory
    
    
    Object obj = null;       // obj is a variable. here it holds a referenct to null
    new Object();            // new Object() is an reference to an instance of the Object class
    obj = new Object();      // obj now holds a reference to an instance of the Object class
    
    System.out.print(obj);   // java.lang.Object@6acbcfc0
    

#### 8 Primitive Types
* Contain a pointer to a value in memory.
    * Thus have fixed size.
    * Thus upon declaring a Primitive Type, Java will directly allocate memory according to the size of the Primitive Type.
* Can't contain `null` (as they don´t contain an pointer to an _object_ in the first place).
* _mutable_.

#### Reference Type
* holds pointer to memory address of object
    * unlike other Languages, Java does not allow to know what the physical memory adress is
* a reference can be assigend to another object of the a compatible type
* _immutable_.

#### mutable vs immutable
* primitives are immutable
* String , Integer , Char etc. are immutable
* StringBuilder, List are mutable

<br>

#### Wrapper Classes
* Wrapper classes make use of some caching, somilar to the pool for String
* The ability of Wrappers to contain `null` is useful for data services.

P-Type | W-Class | .valueOf(<>) | Wrapper.parse<>()
---|---|---|---
boolean | Boolean | true
byte |
short |
int |   | | parseInt
long | | | parseLong
float | | (float) 1.0)
double | Double | 1.0
char | Character | 'c'

    int primitive = Integer.parseInt("123");
    Integer wrapper = Integer.valueOf("123"); // may throw NumberformatException



##### Autoboxing and Unboxing
* Autoboxing `Integer integer = 50;`
* Unboxing `int i = integer;`
    * NullPointerException: `int i = new Integer(null)`
