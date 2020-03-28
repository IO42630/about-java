package basics;

public class StaticAbout {

    static void staticM() {}
    void instanceM() {}

    static void staticCallsX(StaticAbout instance) {
        // static -> instance
        instance.instanceM();
        // instanceM();                 // C-Error
        new StaticAbout().instanceM();

        // static -> static
        instance.staticM();
        staticM();
    }

    void instanceCallsX(StaticAbout instance) {
        // instance -> static
        StaticAbout.staticM();
        staticM();
        // instance -> instance
        instance.instanceM();
        instanceM();
    }







    public static void main(String... args) {

        staticCallsX(new StaticAbout());
        new StaticAbout().instanceCallsX(new StaticAbout());


    }


}
