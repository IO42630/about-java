package about.basics.classes;

public abstract class AbstractClass implements Interface {

    // abstract class may contain concrete members
    // concrete class may NOT contain abstract members


    @Override
    public String toString() {
        return super.toString();
    }


    public static String staticMethod(){return null;};


    protected abstract void packagePrivateAccess(); // must be protected so it can be extended by Parent class.
}
