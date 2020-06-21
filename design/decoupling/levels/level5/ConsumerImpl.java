package decoupling.levels.level5;


import decoupling.levels.level5.service.ServiceA;
import decoupling.levels.level5.service.ServiceAImpl;
import decoupling.levels.level6_1.service.ServiceABImpl;
import decoupling.levels.level6_1.service.ServiceB;

public class ConsumerImpl implements Consumer {

    @Override
    public int consume() {
        ServiceA serviceA = new ServiceAImpl();
        ServiceB serviceB = new ServiceABImpl();

        return serviceA.featureA() + serviceB.featureB();
    }

}
