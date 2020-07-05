package classes.nesting;


/**
 * The instance of the private inner class can be returned by the getter. <br>
 * However the members of the private inner class can not be accessed.
 */
public class Encapsulation {
    public static void main(String... args) {

        System.out.println(new OuterDefault().new InnerDefault().why);
        System.out.println(new OuterDefault().getInnerPrivate()); // "why" is not accessible
        System.out.println();
    }
}


class OuterDefault {

    InnerPrivate getInnerPrivate() { return new InnerPrivate(); }

    class InnerDefault {
        public int why;
    }

    private class InnerPrivate {
        public int why;
    }
}
