import java.io.IOError;
import java.io.IOException;

public class OverridingExceptions {}





class Parent{


    void foo() throws RuntimeException{



    }
}





class Child extends Parent{

    void foo() throws Error {}
}
