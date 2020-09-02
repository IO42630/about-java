package polymorphism.polymorphism.errors;

class Parent {}

class ChildA extends Parent {}

class ChildB extends Parent {}

public class CastingAcrossChildren {

    public static void main() {
        Parent childAasParent = new ChildA();
        if (childAasParent instanceof ChildB) {
            ChildB childB = (ChildB) childAasParent; // -> R-Error (ClassCastException)
        }
    }
}



