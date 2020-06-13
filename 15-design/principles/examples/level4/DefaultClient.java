package principles.examples.level4;


public class DefaultClient implements Client {

    @Override
    public int consume() {
        Service service = new DefaultService();

        return service.featureA() + service.featureB();
    }

}
