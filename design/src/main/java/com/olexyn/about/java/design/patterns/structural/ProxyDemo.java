package com.olexyn.about.java.design.patterns.structural;



interface Service {
	void print();
}

class RealService implements Service {
	public void print() {
		System.out.println(this);
	}
}

class Proxy implements Service {
	public void print() {
		(new RealService()).print();
	}
}

/**
 * <b>Proxy</b><br>
 * Placeholder for another object to control access to it.<br>
 * Popular use case is lazy access/init. Thereby semantically overlaps with Singleton.
 */
public class ProxyDemo {
	public static void main(String[] args) {
		(new Proxy()).print();
	}
}
