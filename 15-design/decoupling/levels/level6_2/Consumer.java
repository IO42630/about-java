package decoupling.levels.level6_2;

import decoupling.levels.level6_2.service.ServiceA;
import decoupling.levels.level6_2.service.ServiceB;

public interface Consumer {

    int consume(ServiceA serviceA, ServiceB serviceB);
}
