package about;

public class SystemAbout {

    public static void main(final String[] args)
    {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
    }
}
