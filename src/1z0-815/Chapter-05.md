## Chapter 5 : Core Java APIs
#### Strings
* see `about/Strings` .
* implements the `CharSequence` interface.
* concatenation 
    * if both opernads are numeric, + means addition.
    * if eiter operand is a String, + means concatenation.
    * evaluate from left to right.


    s = 1+2;        // 3
    s = "a"+1;      // a1
    s = 1+2+"a";    // 3a
    s = "a"+1+2;    // a12
    s+=2;           // s = s + 2 thus a122
    
* immutability
    * once a String object is created, it cannot be changed
       
       
#### StringBuilder
* see `about/StringBuilder`
* implements the `CharSequence` interface.

#### Equality
= reference equality : variable points to same object
beware when dealing with objects, e.g. arrays, 
since a new array with same contents will be a new object and thus not ==


.equals()
depends on implementation by the object
for String it compares contents, and returns true if same.
for Objects in general it checks for refeence equality just like ==
        * StringBuilder
        * Array
        
checking for reference equality of two different object types will result in a compilation error.


#### String Pool
Strings use a lot of memory.
To reuse common strings java collects them in the string pool (a.k.a. intern pool)

pool contains literal values and constants that apppear in your program

    "name" -> yes
    myObject.toString() is a string but not a literal, so it does not go into the string pool.


    String a = "foo";
    String b = "foo";
    String c = " foo".trim();
    String d = "fo"+"o";
    String e = new String("foo");
    String f = "f";
    f+="oo";
    String g = f.intern();

    a==b since java reuses string from pool, since they are equal at compile-time
    a!=c since they are made equal only at runtime
    a==d siince equal at compile-time
    e    simply forces creation of new string
    a!=f += is like a method, so it is only equal at runtime
    a==g intern is always == to the first string literal of said content

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

<br>

## Collections
* see `basics.collections`
    * for API see `InterfaceCopy` files

#### Array
* An array is a reference type (even if it is an array of primitives)
* see `about.basics.collections.Arrays`


##### Sorting
* sorts alphabetically  numbers before a before A

        java.util.Arrays;
        Arrays.sort(stringArray);
        [10 , 100, 9]

##### Binary search 
* only on sorted arrays , else unpredictable output
* found - return index ou match
* not found - return (negative value of index where searched would need to be inserted) - 1 

        int[] nym = {2,4,6,8};
        Arrays.binarySearch(num,2); // 0
        Arrays.binarySearch(num,1); // -1
        Arrays.binarySearch(num,3); // -2

##### Comparing
* `int` can be compared with operators (Ch.3)
* Objects e.g. `Integer` can be compared with
    * operators (e.g. `<`,`==`) , this will return a `boolean`.
    * `a.compareTo(b)` , this will return an `int`.
* Arrays can be compared with `Arrays.compare(a,b);` , this will return an `int`.
* Think of `a.compareTo(b)` and `compare(a,b)` as `a - b`. 


    Arrays.compare({1}, {1}); // 0
    Arrays.compare({1}, {1,1}); // -1
    Arrays.compare({2}, {1,1}); // 
        

* null is smaller than any other value
* for String : a < b if a prefix of b
* for char / String : a < b if
    * numbers < letters
    * UPPERCASE < lowercaser
    
when comparing , arrays must be of same type, else compilation error

##### mismatch()
* if arrays same, mismatch() = -1
* else mismatch return index of first index where they differ

##### varargs
main(Strings... args) // varargs , this is legal, args can be used normally

##### N-Dim Arrays
* Array can hold Objects,
* thus can hold Arrays.

#### ArrayList

        Arraylist<String> list = new ArrayList<>();

        var strings = new ArrayList<String>();
        strings.add("a");
        for (String s: strings) { }
        
        var strings = new ArrayList<>(); // assumes var has type List<Object>
        strings.add("a");
        for (String s: strings) { } // DOES NOT COMPILE

        Arrays.toString(a2D);
        Arrays.deepToString(a2D);
        
* List is an Interface, so
    * List<String> = new ArrayList<>(); is OK
    * ArrayList<String> = new ArrayList<>(); is OK
    * ArrayList<String> = new List<String>(); is not OK
    


| | |
---|---
`Collection` , `Map` | `int size()`
`String` | `int length()`
`Array` | `int length`




* `boolean contains(Object obj) // calls equals() on each element in the list`
    * ArrayList has a own .equals() implememtation
    * [a].equals([b]) true
    * [a,b].equals([b,a]) false




<br>

#### Conversions
| `about.basics.collections.Conversions` | toArray() | Arrays.asList() | List.of()
---|---|---|---
Types| List -> Array | Array/varargs -> List | Array/varargs -> List  
Collection mutable? | - | NO | NO
Entries mutable? | YES |  YES | NO
Sync | NO | YES | -
    
    List<String> fixedSizeList = Arrays.asList("a", "b", "c");
    List<String> expandableList = new ArrayList<>(fixedSizeList);

#### Sorting 
* `Collections.sort(list)`

#### Sets and Maps
* Sets
    * Are not ordered
    * Can't contain duplicates
    * See `Sets.java`.
* Maps
    * See `Maps.java`.
