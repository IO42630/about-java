package com.olexyn.about.java.lambda.method_reference;

import java.util.Arrays;
import java.util.function.Predicate;

public class MethodReferenceTypes implements StaticMethod, InstanceMethod {


    public static void main(String... args){

        Predicate<Object> predicate3 = x -> new MethodReferenceTypes().instanceMethod(x);
        Predicate<Object> predicate4 = new MethodReferenceTypes()::instanceMethod;




        // can't override static methods
        // want to have static functions
        // allow static methods to be declared in interfaces
        // java is dumb
        Predicate<Object> predicate1 = x -> MethodReferenceTypes.staticMethod(x);

        Predicate<Object> predicate2 = MethodReferenceTypes::staticMethod;
        Predicate<Object> predicate21 = StaticMethod::staticMethodFromInterface;




        boolean b = new String("asf")instanceof Comparable;

        int i = "asf".compareToIgnoreCase("af");

        String[] strArray = { "A", "E", "I", "O", "U", "a", "e", "i", "o", "u" };
        Arrays.sort(strArray, (s1,s2) -> s1.compareToIgnoreCase(s2));
        Arrays.sort(strArray, String::compareToIgnoreCase);


        otherClassUser(o -> o.function(o));
        // otherClassUser(OtherClass::function); // TODO why is this not ok?


    }






    static void otherClassUser(SelfFunction selfFunction){

    }





    static boolean staticMethod(Object o){
        return false;
    }


    @Override
    public boolean instanceMethod(Object o){
        return false;
    }
}


class OtherClass implements SelfFunction{

    @Override
    public void function(SelfFunction self) {    }
}

interface SelfFunction{

    void function(SelfFunction self);
}





interface StaticMethod{
    /**
     * Static methods are "attached" to class, thus can't be overridden.
     * @param o
     * @return
     */
     static boolean staticMethodFromInterface(Object o){
        return false;
    }
}

interface InstanceMethod{
    boolean instanceMethod(Object o);
}
