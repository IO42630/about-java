package principles.examples.level6_3;


import principles.examples.level6_3.service.ServiceA;
import principles.examples.level6_3.service.ServiceABImpl;
import principles.examples.level6_3.service.ServiceAProvider;
import principles.examples.level6_3.service.ServiceB;

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
