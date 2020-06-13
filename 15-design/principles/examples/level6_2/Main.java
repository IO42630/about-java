package principles.examples.level6_2;


import principles.examples.level6_2.service.ServiceA;
import principles.examples.level6_2.service.ServiceABImpl;
import principles.examples.level6_2.service.ServiceAImpl;
import principles.examples.level6_2.service.ServiceB;

public class Main {

    public static void main(String... args) {
        ServiceA serviceA = new ServiceAImpl();
        ServiceB serviceB = new ServiceABImpl();
        Consumer consumer = new ConsumerImpl();
        System.out.println(consumer.consume(serviceA, serviceB));
    }

}
