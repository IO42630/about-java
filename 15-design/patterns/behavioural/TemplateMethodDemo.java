package patterns.behavioural;

/*
 * Template Method.
 * template for algorithm(1),
 * part implemented in base class(2)
 * part deferred to subclasses(3)
 * hollywood!
 */

// Lvl1
abstract class Lvl1 {
	public void solve() {// (1) template method
		step1();
		step2();
		step3();
	}

	protected void step1() {// (2)
		System.out.println("Lvl1.step1");
	}

	abstract protected void step2(); // (3) must be overwritten

	protected void step3() {// hook (may be overwritten)
		System.out.println("Lvl1.step3");
	}
}

// Lvl2
class Lvl2 extends Lvl1 {
	protected void step2() {
		System.out.println("Lvl2.step2");
	}

	@Override
	protected void step3() {
		super.step3();
	}
}

// MAIN
public class TemplateMethodDemo {
	public static void main(String[] args) {
		new Lvl2().solve();
	}
}
