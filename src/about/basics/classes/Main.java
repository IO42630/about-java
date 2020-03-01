package about.basics.classes;

import about.basics.classes.childpackage.Child;
import about.basics.classes.parentpackage.Parent;

public class Main {



    public static void main(String[] args) {


        Child a = new Child(); // "new" calls constructor
        a.show();
        System.out.println();

        Parent b = new Parent();
        b.show();
        System.out.println();

        System.out.println("\n+ + + + + + +\n");

        a.s = 3; // you can modify a static variable from a not-static environment

        System.out.println("c.s=" + b.s);

        //
        System.out.println(b);
        b = (Parent) a; // a = (Child) b; -> error
        System.out.println(b);


        System.out.println("\n+ + + + + + +\n");

        Parent[] arrayP = {a,
                           b};// polymorphism?
        for (Parent p : arrayP) {
            p.show();
            if (p instanceof Parent) {
                System.out.println("instance of Parent");
            }
            if (p instanceof Child) {
                System.out.println("instance of Child");
            }
            System.out.println();
        }

        System.out.println(b.toString());// inherited form Object


        //new ConstructorError(); // C-Error

    }

}


class ConstructorError{

    ConstructorError(int i){}

}