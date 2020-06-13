package patterns.structural.dependency_injection;

/**
 * Returns Consumer with Instance of AServiceProvider.<br>
 * Thus Consumer(new AServiceProvider()).<br>
 * Question:<br>
 * If Consumer (=Plugin) requests another AServiceProvider (=an additional Class from Server Framework).<br>
 * How does the Injector know to add this additional AServiceProvider to the Constructor of the Consumer (=Plugin)
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
