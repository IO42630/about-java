package com.olexyn.about.java.kotlin.features

import java.util.*

class Functions {

    private var INSTANCE: Strings? = null
    val instance: Strings?
        get() {
            if (INSTANCE == null) {
                synchronized(Strings::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE =
                                Strings()
                    }
                }
            }
            return INSTANCE
        }


    fun String.lool(): String {
        return "lool"
    }

    init {
        val test = "test".lool()
    }

}

class ScopedFunctions {

    init {

    }
}

fun main() {
    val a1: String? = null
    val a2 = a1?.let { println("hello") }
    var a3: String
    a3 = a1?.let { a3 = "value" }.toString()
    a3 = a1 ?: "value"

    mutableListOf<String>()
            .apply { add("A") }
            .also { mutableList -> mutableList.add("B") }
            .let { it.add("C") }

    val date: Calendar? = Calendar.getInstance().apply { add(Calendar.DAY_OF_YEAR, 3) }

    val br = 0

}