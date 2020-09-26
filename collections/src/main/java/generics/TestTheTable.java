package generics;

import java.util.List;

public class TestTheTable {}






class ClassWithT<T>{

    T bar;



    T methodReturningT(){
        T local;
        return bar;
    }





}


class ClassWithUpperBoundT<T extends Number>{}


class ClassWithoutT{



    List<?> bar;
    List<? extends Number> asf;
    List<? super Number> asdfs;

    <T extends Number> void methodWithT(List<? super Number> foo){

        T local;
        List<?> asdfsa;
        List<? super Number> asefa;

        var asdf = 12;

    }

    void wildMethod2(){}




}
