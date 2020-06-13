package principles.examples.level7.injector;

import principles.examples.level7.Consumer;
import principles.examples.level7.ConsumerImpl;
import principles.examples.level7.service.ServiceABImpl;
import principles.examples.level7.service.ServiceAProvider;

public class ServiceABInjector implements Injector {


    @Override
    public Consumer getConsumer() {
        return new ConsumerImpl(new ServiceAProvider(), new ServiceABImpl());
    }
}
