package principles.examples.level7.injector;

import principles.examples.level7.Consumer;

/**
 * Returns Consumer with Instance of ServiceAProvider.<br>
 * Thus Consumer(new ServiceAProvider()).<br>
 * Question:<br>
 * If Consumer (=Plugin) requests another ServiceAProvider (=an additional Class from Server Framework).<br>
 * How does the Injector know to add this additional ServiceAProvider to the Constructor of the Consumer (=Plugin)
 */
public interface Injector {

	Consumer getConsumer();
}


