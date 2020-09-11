package classes.nesting;


class Outer {

    private int privateField = 0;

    private interface Bar {
        public void foo();
    } // interfaces can be private

    static class StaticNested {} // [1]

    class MemberInner {} // [2]

    private abstract class PrivateInnerClass {
        int defaultPrivateInnerClassField = 0;
        private int privatePrivateInnerClassField = 0;
    }

    class InnerClass extends PrivateInnerClass implements Bar {

        //interface Bars{} // C-Error : inner classes cannot have static declarations.
        // interfaces are considered static,
        // because they are a contract of what the class, and not of what the instance does.

        public void foo() {

            privateField++;                     // can access private members of enclosing class.
            defaultPrivateInnerClassField++;    // can access members of private members of enclosing class.
            // privatePrivateInnerClassField++; // C-Error : however can't access private fields of private members of enclosing class.


            class LocalInner {} // [3]

            Bar bar = new Bar() {
                @Override
                public void foo() {

                }
            };


        }

    }

}


class A {
    private int x = 10;

    class B {
        private int x = 20;

        class C {
            private int x = 30;

            public void allTheX() {
                System.out.println(x);// 30
                System.out.println(this.x);// 30
                System.out.println(B.this.x);// 20 B.this refers to the instance of B, B.x would be a static reference which is not OK -> C-Error
                System.out.println(A.this.x);// 10
            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new B();
        A.B.C c = b.new C();
        c.allTheX();
    }
}



class Outer12{

    void foo(){

        int localVar = 1;
        //localVar++;

        class Inner12{

            int my = localVar;



            class Inner22{
                int two = localVar;
            }


                    }
    }


}




class AnonTest{

    abstract class Abs123{}
    class Class123{}
    interface Iface123{}

    public static void main(String[] args) {
        AnonTest anonTest = new AnonTest();
        Abs123 abs123 = anonTest.new Abs123(){void foo(){}};
        Class123 class123 = anonTest.new Class123(){void foo(){}};
        Iface123 iface123 = new Iface123() { void foo(){}}; // ifaces considered static? why again?
        // TODO how do anon classes work / why?
        // TODO what are anon methods?
    }
}





public class Nesting {

    public static void main(String... args) {
        Outer outerClass = new Outer();
        Outer.InnerClass innerClass = outerClass.new InnerClass();
    }

}




class StaticNestedTest{

    int reserved = 3;

    static class Nested123{
        int i=3;
        int reserved = 45;
    }

    class Inner123{
        int i=3;
        int reserved = 43;
    }


    public static void main(String[] args) {
        Nested123 nested123 = new Nested123();
        int foo = nested123.i;
        Inner123 inner123 = new StaticNestedTest().new Inner123();
        int bar = inner123.i;
    }
}



