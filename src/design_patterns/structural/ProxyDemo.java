package design_patterns.structural;

/*
 * Proxy. 
 * Provide a placeholder for another object to control access to it.
 */

interface Image {
	public void print();
}

class Real implements Image {
	public void print() {
		System.out.println(this);
	}
	private void write() {
	}
}

class Proxy implements Image {
	public void print() {
		(new Real()).print();
	}
}

public class ProxyDemo {
	public static void main(String[] args) {
		(new Proxy()).print();
	}
}