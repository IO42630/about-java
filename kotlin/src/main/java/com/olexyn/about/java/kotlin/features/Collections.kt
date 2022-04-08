package com.olexyn.about.java.kotlin.features

class Collections {

    ///                 Size        Contents        Comment
    // Array ->         fixed       mutable         uses Java array optimizations
    // List ->          fixed       fixed
    // MutableList ->   mutable     mutable

    val mutableList0: MutableList<String> = ArrayList()
    val mutableList1 = ArrayList<String>() // default to MutableList

    // generally preferred to use utility fun
    val array1: Array<String> = arrayOf()

    val list: List<String> = listOf("one", "two")

    init {
        val br = 0
        mutableList0.add("one")
    }

}