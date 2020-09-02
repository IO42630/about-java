package com.olexyn.about.java.lambda.method_reference.types;

import java.util.Arrays;

public class InstanceMethodOfArbitraryObjectReference {

    public static void main(String... args){


        String[] strArray = { "A", "E", "I", "O", "U", "a", "e", "i", "o", "u" };
        Arrays.sort(strArray, (s1, s2) -> s1.compareToIgnoreCase(s2));
        Arrays.sort(strArray, String::compareToIgnoreCase);


        otherClassUser(o -> o.function(o));
        // otherClassUser(OtherClass::function); // TODO why is this not ok?
    }



    static void otherClassUser(SelfFunction selfFunction){

    }
}



class OtherClass implements SelfFunction{

    @Override
    public void function(SelfFunction self) {    }
}

interface SelfFunction{

    void function(SelfFunction self);
}
