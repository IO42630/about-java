package principles.examples.level6_2;

import principles.examples.level6_2.service.ServiceA;
import principles.examples.level6_2.service.ServiceB;

public interface Consumer {

    int consume(ServiceA serviceA, ServiceB serviceB);
}
