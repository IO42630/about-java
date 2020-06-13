package patterns.structural;

import java.util.ArrayList;
import java.util.List;

/*
 * Compose objects into tree structures to represent part-whole hierarchies.
 * Individual objects and compositions of objects are threated uniformly.
 * "branches and leaves are both components"
 */

interface Component {}

class Leaf implements Component {
}

class Composite implements Component {
	private List<Component> children = new ArrayList<>();

	public void add(Component component) {
		children.add(component);
	}

	public void remove(Component component) {
		children.remove(component);
	}
}


public class CompositeDemo {
	public static void main(String[] args) {

		Composite root = new Composite();
		root.add(new Leaf());

		Composite branch = new Composite();
		branch.add(new Leaf());
		root.add(branch);
	}
}
