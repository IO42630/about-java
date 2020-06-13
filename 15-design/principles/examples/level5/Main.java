package principles.examples.level5;


public class Main {

    public static void main(String... args) {
        Client client = new DefaultClient();
        System.out.println(client.consume());
    }

}
