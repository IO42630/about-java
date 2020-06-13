package decoupling.levels.level6_3;

import decoupling.levels.level6_3.service.ServiceA;
import decoupling.levels.level6_3.service.ServiceB;

public interface Consumer {

    void setServiceA(ServiceA serviceA);

    void setServiceB(ServiceB serviceB);


    int consume();
}
