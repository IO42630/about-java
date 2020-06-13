package principles.examples.level5;


import principles.examples.level6.ABServiceProvider;
import principles.examples.level6.ServiceB;

public class DefaultClient implements Client {

    @Override
    public int consume() {
        ServiceA serviceA = new AServiceProvider();
        ServiceB serviceB = new ABServiceProvider();

        return serviceA.featureA() + serviceB.featureB();
    }

}
