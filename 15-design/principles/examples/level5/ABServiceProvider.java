package principles.examples.level5;

public class ABServiceProvider implements ServiceA, ServiceB {

    @Override
    public int featureA() {
        return 0;
    }

    @Override
    public int featureB() { return 1;}

}
