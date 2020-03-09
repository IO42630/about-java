package basics.classes;


public class Nesting {

    public static void main(String... args) {

        System.out.println(new OuterDefault().new InnerDefault().why);
        System.out.println(new OuterDefault().new InnerProtected().why);
        System.out.println(new OuterDefault().getInnerPrivate()); // "why" is not accessible
        System.out.println();
    }


}


class OuterDefault {

    InnerPrivate getInnerPrivate() {
        return new InnerPrivate();
    }

    public class InnerPublic {
        public int why;
    }

    class InnerDefault {
        public int why;
    }

    protected class InnerProtected {
        public int why;
    }

    // internal class => encapsulation
    private class InnerPrivate {
        public int why;
    }
}