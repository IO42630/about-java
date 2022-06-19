package com.olexyn.about.java.kotlin.features

fun main() {

    // val a1: Strings = null        // cErr
    val a1: String? = null

    // val a2 = a1.length           // cErr
    var a2 = a1?.length             // "safe call", not Elvis. Assigns null to a2
    var a3 = a1!!.length            // forced NPE

    // Kt has no equivalent to the Java Elvis, instead:
    var a4 = a1 ?: "foo"

}
