package decoupling.levels.level6_1;


import decoupling.levels.level6_1.service.ServiceA;
import decoupling.levels.level6_1.service.ServiceB;

public class ConsumerImpl implements Consumer {

    ServiceA serviceA;
    ServiceB serviceB;

    public ConsumerImpl(ServiceA serviceA, ServiceB serviceB){
        this.serviceA = serviceA;
        this.serviceB = serviceB;
    }


    @Override
    public int consume() {
        return serviceA.featureA()+ serviceB.featureB();
    }

}
