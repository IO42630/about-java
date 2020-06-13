package decoupling.levels.level6_1;


import decoupling.levels.level6_1.service.ServiceA;
import decoupling.levels.level6_1.service.ServiceABImpl;
import decoupling.levels.level6_1.service.ServiceAImpl;
import decoupling.levels.level6_1.service.ServiceB;

public class Main {

    public static void main(String... args) {
        ServiceA serviceA = new ServiceAImpl();
        ServiceB serviceB = new ServiceABImpl();

        Consumer consumer = new ConsumerImpl(serviceA, serviceB);

        System.out.println(consumer.consume());
    }

}
