package principles.examples.level5;


import principles.examples.level5.service.ServiceA;
import principles.examples.level5.service.ServiceAImpl;
import principles.examples.level6_1.service.ServiceABImpl;
import principles.examples.level6_1.service.ServiceB;

public class ConsumerImpl implements Consumer {

    @Override
    public int consume() {
        ServiceA serviceA = new ServiceAImpl();
        ServiceB serviceB = new ServiceABImpl();

        return serviceA.featureA() + serviceB.featureB();
    }

}
