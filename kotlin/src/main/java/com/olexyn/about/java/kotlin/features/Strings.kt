package com.olexyn.about.java.kotlin.features

class Strings {

    val a1 = "hello"
    val a2 = "world"
    val list1 = listOf(a1, a2)

    val a3 = "$a1 ${list1.get(1)}"

}