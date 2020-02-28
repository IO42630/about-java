package design_patterns.structural.dependency_injection;

/**
 * Returns Consumer with Instance of Service.<p>
 * Thus Consumer(new Service()).<p>
 * Question:<p>
 * If Consumer (=Plugin) requests another Service (=an additional Class from Server Framework).<p>
 * How does the Injector know to add this additional Service to the Constructor of the Consumer (=Plugin)
 */
interface Injector {

	public Consumer getConsumer();
}

class EmailServiceInjector implements Injector {

	@Override
	public Consumer getConsumer() {
		return new Plugin(new EmailServiceImpl());
	}

}

class SMSServiceInjector implements Injector {

	/**
	 *
	 * @return
	 */
	@Override
	public Consumer getConsumer() {
		return new Plugin(new SMSServiceImpl());
	}

}