package decoupling.levels.level6_3;


import decoupling.levels.level6_3.service.ServiceA;
import decoupling.levels.level6_3.service.ServiceABImpl;
import decoupling.levels.level6_3.service.ServiceAProvider;
import decoupling.levels.level6_3.service.ServiceB;

public class Main {

    public static void main(String... args) {
        ServiceA serviceA = new ServiceAProvider();
        ServiceB serviceB = new ServiceABImpl();
        Consumer consumer = new ConsumerImpl();
        consumer.setServiceA(serviceA);
        consumer.setServiceB(serviceB);
        System.out.println(consumer.consume());
    }

}
