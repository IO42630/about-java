package decoupling.levels.level6_2;


import decoupling.levels.level6_2.service.ServiceA;
import decoupling.levels.level6_2.service.ServiceB;

public class ConsumerImpl implements Consumer {



    @Override
    public int consume(ServiceA serviceA, ServiceB serviceB) {
        return serviceA.featureA()+ serviceB.featureB();
    }

}
