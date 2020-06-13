package principles.examples.level4;


public class ConsumerImpl implements Consumer {

    @Override
    public int consume() {
        Service service = new ServiceImpl();

        return service.featureA() + service.featureB();
    }

}
