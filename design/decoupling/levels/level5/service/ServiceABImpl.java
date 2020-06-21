package decoupling.levels.level5.service;

public class ServiceABImpl implements ServiceA, ServiceB {

    @Override
    public int featureA() {
        return 0;
    }

    @Override
    public int featureB() { return 1;}

}
