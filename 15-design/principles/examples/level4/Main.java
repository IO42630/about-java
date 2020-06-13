package principles.examples.level4;



public class Main {

    public static void main(String... args) {
        Client client = new DefaultClient();
        System.out.println(client.consume());
    }

}
