package principles.examples.level6_2;


import principles.examples.level6_2.service.ServiceA;
import principles.examples.level6_2.service.ServiceB;

public class ConsumerImpl implements Consumer {



    @Override
    public int consume(ServiceA serviceA, ServiceB serviceB) {
        return serviceA.featureA()+ serviceB.featureB();
    }

}
