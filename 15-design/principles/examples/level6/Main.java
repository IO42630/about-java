package principles.examples.level6;


public class Main {

    public static void main(String... args) {
        ServiceA serviceA = new AServiceProvider();
        ServiceB serviceB = new ABServiceProvider();
        Client client = new DefaultClient(serviceA, serviceB);
        System.out.println(client.consume());
    }

}
