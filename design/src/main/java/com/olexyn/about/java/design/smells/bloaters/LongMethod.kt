package com.olexyn.about.java.design.smells.bloaters

import com.olexyn.about.java.design.refactorings.Solution
import com.olexyn.about.java.design.smells.Smell
import com.olexyn.about.java.design.refactorings.composingmethods.ExtractMethod

class LongMethod : Smell {
    override fun solution(): Solution {
        return ExtractMethod()
    }
}