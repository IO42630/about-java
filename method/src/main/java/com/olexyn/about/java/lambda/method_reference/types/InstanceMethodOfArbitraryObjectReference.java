package com.olexyn.about.java.lambda.method_reference.types;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class InstanceMethodOfArbitraryObjectReference {

    public static void main(String... args){


        String[] strArray = { "A", "E" };
        Arrays.sort(strArray, (s1, s2) -> s1.compareToIgnoreCase(s2));
        Arrays.sort(strArray, String::compareToIgnoreCase);


        otherClassUser(o -> o.function(o));
        otherClassUser(o -> o.function(o));
        // otherClassUser(OtherClass::function); // TODO why is this not ok?



        foo( a -> {});
        foo( a -> new BarConsumer().accept(a));
        //foo( a -> new BarConsumer()::accept);

        faz( () -> new Object());
        faz( () -> new BarSupplier().get());
        //faz(  () -> new BarSupplier()::get);
    }



    static void otherClassUser(SelfFunction selfFunction){

    }

    static void foo(Consumer consumer){

    }

    static void faz(Supplier supplier){

    }
}



class OtherClass implements SelfFunction{

    @Override
    public void function(SelfFunction self) {    }
}

interface SelfFunction{

    void function(SelfFunction self);
}




class BarConsumer implements Consumer {

    @Override
    public void accept(Object o) {    }
}



class BarSupplier implements Supplier {


    @Override
    public Object get() {
        return new Object();
    }
}

