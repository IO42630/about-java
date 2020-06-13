package principles.examples.level6;

public class ABServiceProvider implements ServiceA, ServiceB {

    @Override
    public int featureA() {
        return 0;
    }

    @Override
    public int featureB() { return 1;}

}
