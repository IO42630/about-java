package principles.examples.level7;


import principles.examples.level7.injector.Injector;
import principles.examples.level7.injector.ServiceABInjector;

public class Main {

    public static void main(String... args) {

        Injector injector = new ServiceABInjector();

        Consumer consumer = injector.getConsumer();

        System.out.println(consumer.consume());
    }

}
