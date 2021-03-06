package decoupling.levels.level6_3;


import decoupling.levels.level6_3.service.ServiceA;
import decoupling.levels.level6_3.service.ServiceB;

public class ConsumerImpl implements Consumer {

    private ServiceA serviceA;
    private ServiceB serviceB;

    public void setServiceA(ServiceA serviceA){
        this.serviceA = serviceA;
    }

    public void setServiceB(ServiceB serviceB){
        this.serviceB = serviceB;
    }





    @Override
    public int consume() {
        return serviceA.featureA()+ serviceB.featureB();
    }

}
