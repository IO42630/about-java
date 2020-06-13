package decoupling.levels.level7;


import decoupling.levels.level7.injector.Injector;
import decoupling.levels.level7.injector.ServiceABInjector;

public class Main {

    public static void main(String... args) {

        Injector injector = new ServiceABInjector();

        Consumer consumer = injector.getConsumer();

        System.out.println(consumer.consume());
    }

}
