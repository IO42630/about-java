package com.olexyn.about.java

class Child : Parent() {

    fun foo(
            a: Int = 0,
            b: Int,
            c: Int = 2
    ) { }

    fun kun(
            a: Int = 0,
            b: Int = 1,
            c: () -> Unit
    ) { }

    fun bar() {
        // all the following calls are equivalent
        foo(0, 1)
        foo(b = 1) // must name 'b' to use default of 'a'
        foo(b = 1, c = 2)
    }

    fun baz() {
        kun() { print("hello") }
        kun(c = { println("hello")})
        kun { println("hello")}
    }

    fun daz(
            a: Int = 0,
            b: Int = 1,
            c: Int = 2,
            d:Int = 3
    ) { }

    fun das() {
        daz()
        daz(1)
        daz(a=1, c = 2, d = 2) // d must be named
    }

}
