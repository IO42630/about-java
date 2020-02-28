package design_patterns.creational;

//Singleton => one instance + global acess to it - - - - -
public class SingletonDemo {

	private static SingletonDemo instance = null;

	private SingletonDemo() {// avoids instantiation
	}

	public static SingletonDemo getInstance() {
		if (instance == null)
			instance = new SingletonDemo();
		return instance;
	}

}
