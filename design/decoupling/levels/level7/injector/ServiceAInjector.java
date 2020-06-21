package decoupling.levels.level7.injector;

import decoupling.levels.level7.Consumer;
import decoupling.levels.level7.ConsumerImpl;
import decoupling.levels.level7.service.ServiceAProvider;

public class ServiceAInjector implements Injector {


    @Override
    public Consumer getConsumer() {
        return new ConsumerImpl(new ServiceAProvider(), null);
    }
}
