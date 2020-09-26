package decoupling.levels.level7;


import decoupling.levels.level7.service.ServiceA;
import decoupling.levels.level7.service.ServiceB;

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
