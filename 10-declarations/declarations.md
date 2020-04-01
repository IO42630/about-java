## 065 Declarations

| | | | | | | | 
---|---|---|---|---|--- |---
__access modifier__|__specifier__|__return type__|__method name__|__(list of param)__|__exception__|__{method body}__
optional | optional | |   | empty-able | optional | empty-able
public | final | void | foo | () | throws Exception | {int i=0;}
__access modifier__|__specifier__| __class__ | __class name__ |__extends__|__implements__|__{class body}__
| | optional | | | optional | optional |empty-able
public | final, abstract | class | Foo  | extends Bar| implements Zoc | {int i=0;}
    
* "signature of a method" = method name and parameter list (type and order).
    * the name itself is not unique.
    
<br>

#### Declarations
* placement:
    * before/after _access modifier_
    * before 
        * `class`
        * _return type_

| specifier| class| method |
---|---|---|
`static` | 
`abstract` | can't be instantiated | 
`final` | can't be extended | may not be overridden
synchronized | - | for multithreading
native | - |  for C++ compat.
strictfp | - |  makes float operations portable.

<br>

#### Access Modifier
* order of _access modifiers_ and _specifiers_ does not matter
* private : only same class
    * not other class in same file. e.g. encapsulating class
* default : private + any class in same package 
    * (if access modifier is omitted)
    * C-Error: if keyword is used.
* protected
    * default + may be accessed in/through an instance of the child class
* public : anywhere

Construct | `private` | default | `protected` | `public`
---|---|---|---|---
top-level type (abstract-/concrete-class, interface)| | YES | | YES
outer class |  | YES |
inner class : declared inside another class | YES | YES | YES | YES
 
<br>

#### Illegal Combinations
* `abstract` + `private` = C-Error
* `abstract` + `final` = C-Error
* `final` + `private` = OK
* `abstract` + `static` = C-Error