package classes.nesting;


public class Nesting {

    private int field = 0;

    interface Bar{}

    static class StaticNested{}

    private abstract class PrivateInnerClass {
        int defaultSuperField =0;
        private int privateSuperField = 0;
    }

    class InnerClass extends PrivateInnerClass implements Bar{

        // interface Bars{} // C-Error
        // interfaces are considered static,
        // because they are a contract of what the class, and not of what the instance does.

        void foo(){

            field++;
            defaultSuperField++;
            // privateSuperField++; // C-Error
            // can access private fields of enclosing class
            // however can't access private fields of said fields.


            class LocalInner{

            }

            Bar bar =  new Bar(){};


        }

    }

    public static void main(String... args){
        Bar innerClass = new Nesting().new InnerClass();
    }

}








