package decoupling.levels.level2;

public class Consumer {


    public int consume() {
        Service serviceA = new ServiceA();
        Service serviceB = new ServiceB();

        return serviceA.feature() + serviceB.feature();
    }


}
