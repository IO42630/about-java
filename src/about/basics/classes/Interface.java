package about.basics.classes;

public interface Interface {

    // All members of Interface are public (the public access modifer can be omitted).
    // meant to be used as type
    // class can implement multiple interfaces

    // static variables are shared among all instances of a class
    public static final int fin = 7; // allowed


    String toString();


    static String staticMethod() { return null; }


}
