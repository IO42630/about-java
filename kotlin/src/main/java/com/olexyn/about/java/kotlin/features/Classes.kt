package com.olexyn.about.java.kotlin.features

class Classes {

    companion object {
        // corresponds to java static
    }

    init {
        mutableListOf<String>().forEach { println(it) }
    }
}

class Properties {
    // Kotlin assumes getter/setter by default. They can be overridden via get()/set().
    // Object.property calls the assumed getter/setter.

    var strings0 = mutableListOf<String>() // "property", not a "field". the actual "backing field" is hidden.
        get() = field                      // the backing field can be called via the "field" keyword.
        set(eg) {
            field = eg
        }

    private val _strings1 = mutableListOf<String>() // "backing property"

    val strings1: List<String> // "property" (that is exposed) read-only in this case.
        get() = _strings1

}
