package principles.examples.level6_3;

import principles.examples.level6_3.service.ServiceA;
import principles.examples.level6_3.service.ServiceB;

public interface Consumer {

    void setServiceA(ServiceA serviceA);

    void setServiceB(ServiceB serviceB);


    int consume();
}
