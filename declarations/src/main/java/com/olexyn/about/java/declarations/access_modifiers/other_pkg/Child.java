package com.olexyn.about.java.declarations.access_modifiers.other_pkg;

import com.olexyn.about.java.declarations.access_modifiers.Parent;

public class Child  extends Parent{

    public static void main(String... args){
        int foo = new Child().i;
        // foo = new Parent().i; -> cErr
    }
}
