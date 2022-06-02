package com.olexyn.about.java.kotlin

// Disables the default constructor.
class Constructors1(var aString: String) {

    constructor(aNumber: Number) : this(aNumber.toString())

}

class Constructors2() {

    val a1: Number;

    init {
       a1 = 1 // primary constructor can't contain any code, place logic here
    }

    constructor(aString: String) : this()

    constructor(aNumber: Number) : this(aNumber.toString())

}

object ASingleton {
    // This is a Singleton
}


fun main() {

    val a1 = Constructors1(3);
    var s1 = a1.aString;

    val foo = Constructors2();
    val bar = ASingleton;

    val br = 1;

}