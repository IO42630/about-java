package basics.classes;

import about.basics.classes.childpackage.Child;
import about.basics.classes.parentpackage.Parent;

public class Main {


    // "new" calls constructor

    static boolean b;
    static String s;

    public static void main(String[] args) {

        polymorphism();

        new Child().classVar = 3; // OK to modify a static variable from a not-static environment

        //new ConstructorError(); // C-Error , there is no default Constructor
    }


    static void polymorphism() {

        b = new Child() instanceof Parent;  // true

        b = new Parent() instanceof Parent; // true
        b = new Parent() instanceof Child;  // false
        b = (Parent)new Child() instanceof Child;
        b = (Parent) new Child() instanceof Parent;

        Parent parent = new Child();   // Implicit Cast, (Parent) is inserted during compilation.
        Child child = (Child) parent;  // Explicit Cast, C-Error if (Child) is omitted.


        if (new Parent() instanceof Child) { child = (Child) new Parent(); }// ClassCastException
        // ClassCastException does not apply to Interfaces

        // if (new Integer(1) instanceof String){// C-Error
        //   s = (String) new Integer(1);         // C-Error
        // }

        s = ((Parent) new Child()).toString(); // Child


        child = new Child();
        parent = child;

        String castToParent = compareMember(parent,child);

        parent = new Child();
        child = (Child) parent;

        String castToParentCastToChild = compareMember(parent,child);

        // both cases instanceVar is evaluated from parent after (casting)

        int br = 0;



    }

    static String compareMember(Parent parent , Child child){
        boolean instanceVarEqual = parent.instanceVar == child.instanceVar;
        boolean classVarEqual = parent.classVar == child.classVar;
        boolean instanceMethodEqual = parent.toString().equals(child.toString());
        boolean staticMethodEqual = parent.staticMethod().equals(child.staticMethod());
        String out = "instanceVarEqual : " + instanceVarEqual + "\n";
        out += "classVarEqual : " + classVarEqual + "\n";
        out += "instanceMethodEqual : " + instanceMethodEqual + "\n";
        out += "staticMethodEqual : " + staticMethodEqual + "\n";
        return out;
    }
}


class ConstructorError {

    ConstructorError(int i) {}

}