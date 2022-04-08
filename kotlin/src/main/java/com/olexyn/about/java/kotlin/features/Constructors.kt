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


object Constructors3 {
    // This is a Singleton
}