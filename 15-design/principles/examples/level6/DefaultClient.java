package principles.examples.level6;


public class DefaultClient implements Client {

    ServiceA serviceA;
    ServiceB serviceB;

    public DefaultClient(ServiceA serviceA, ServiceB serviceB){
        this.serviceA = serviceA;
        this.serviceB = serviceB;
    }


    @Override
    public int consume() {
        return serviceA.featureA()+ serviceB.featureB();
    }

}
