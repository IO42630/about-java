# Chapter 5 : Core Java APIs
### Strings
* see `about/Strings` .
* implements _CharSequence_ .
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
    * onece a String object is created, it cannot be changed
       
       
### StringBuilder
* see `about/StringBuilder`

### Equality
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


### String Pool
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


### Arrays
An array is a reference type (even if it is an array of primitives)


    int[] n1 = new int[3];
    int[] n2 = new int[]{1,5,7};
    int[] n3 = {1,5,7}; // anonymous array, type and size are deduced
    
    int []n;
    int [] n;
    int n [];
    int n []; // are all legal
    
    
    int[] a, b; // two int arrays
    int a[], b; // a is array , b is just int , deal with it.
    
     String[] strings = { "stringValue" };
     Object[] objects = strings;
     String[] againStrings = (String[]) objects;
     againStrings[0] = new StringBuilder(); // DOES NOT COMPILE
     objects[0] = new StringBuilder(); // careful! runteime error loading sb into string


int[] arr = new int[4];
int i = arr.length; // not a method


##### Sorting

importArrays
importjava.util.*;
java.util.Arrays;
// import whole package including
// import just Arrays


print either with for or with Arrays.tostring(array)


        Arrays.sort(stringArray);
        sorts alphabetically  numbers before a before A
        [10 , 100, 9]

### Binary search 
* only sorted arrays
* found - return index ou match
* not found - return (negative value of index where searched would need to be inserted) - 1 
* unsorted - unpredictable output

        int[] nym = {2,4,6,8};
        Arrays.binarySearch(num,2); // 0
        Arrays.binarySearch(num,1); // -1
        Arrays.binarySearch(num,3); // -2

### Comparing
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

### N-Dim Arrays
* Array can hold Objects,
* thus can hold Arrays.

### ArrayList

        Arraylist<String> list = new ArrayList<>();

        var strings = new ArrayList<String>();
        strings.add("a");
        for (String s: strings) { }
        
        var strings = new ArrayList<>(); // assumes var has type List<Object>
        strings.add("a");
        for (String s: strings) { } // DOES NOT COMPILE

        Arrays.toString(a2D);
        Arrays.deepToString(a2D);
        Arrays.asList(new String[]{"foo"};
        
* List is an Interface, so
    * List<String> = new ArrayList<>(); is OK
    * ArrayList<String> = new ArrayList<>(); is OK
    * ArrayList<String> = new List<String>(); is not OK
    
##### add()

boolean add(E element)
void add(int index, E element)

##### remove()
boolean remove(Object obj) // removes first matching element // boolean tells if something was removed.
E remove (int index) // removes & returns element at index.

##### set 
replaces element
E set (int index , E element)


int size() same as .length() strings for arrrays (remember arrays have .length without method)
boolean isEmpty() // same as is size()==0
void clear() // remove all elements

boolean contains(Object obj) // calls equals() on each element in the list.
* ArrayList has a own .equals() implememtation
* [a].equals([b]) true
* [a,b].equals([b,a]) false

### Wrapper Classes
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
    * Care: `new List<Integer>().remove(0)` is not autoboxed (.
* Unboxing `int i = integer;`
    * NullPointerException: `int i = new Integer(null)`


##### Conv between Array and List
* fixed-size lists
    * backed (changes are synchronized between original array and list)
        * `list = Arrays.asList(array)`.
    * immutable (values of list are immutable)
        * `list = List.of(array)`.

#### Using Varargs to Create a List
    List<String> list1 = Arrays.asList("one", "two");
    List<String> list2 = List.of("one", "two");

### Summary
Conversions | toArray() | Arrays.asList() | List.of()
---|---|---|---
Types| List -> Array | Array/varargs -> List | Array/varargs -> List  
OK to remove() from new obj | No | No | NO
OK to set() in new obj | Yes |  YES | NO
Sync | NO | YES | N/A
    
    List<String> fixedSizeList = Arrays.asList("a", "b", "c");
    List<String> expandableList = new ArrayList<>(fixedSizeList);

#### Sorting 
* `Collections.sort(list)`

## Sets and Maps
####Sets
* Are not ordered
* Can't contain duplicates
* See `Sets.java`.
#### Maps
* See `Maps.java`.

## Math