package com.olexyn.about.java.lambda.method_reference.types;


import java.util.function.Predicate;

public class InstanteAndStaticMethodReferences implements StaticMethod, InstanceMethod {


    public static void main(String... args) {

        Predicate<Object> predicate3 = x -> new InstanteAndStaticMethodReferences().instanceMethod(x);
        Predicate<Object> predicate4 = new InstanteAndStaticMethodReferences()::instanceMethod;


        // can't override static methods
        // want to have static functions
        // allow static methods to be declared in interfaces
        // java is dumb
        Predicate<Object> predicate1 = x -> InstanteAndStaticMethodReferences.staticMethod(x);

        Predicate<Object> predicate2 = InstanteAndStaticMethodReferences::staticMethod;
        Predicate<Object> predicate21 = StaticMethod::staticMethodFromInterface;
    }


    static boolean staticMethod(Object o) { return false; }


    @Override
    public boolean instanceMethod(Object o) { return false; }
}


interface StaticMethod {
    /**
     * Static methods are "attached" to class, thus can't be overridden.
     */
    static boolean staticMethodFromInterface(Object o) { return false; }
}

interface InstanceMethod {
    boolean instanceMethod(Object o);
}
