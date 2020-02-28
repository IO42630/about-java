package design_patterns.structural;

import java.util.ArrayList;
import java.util.List;

/*
 * Composite. 
 * Compose objects into tree structures to represent part-whole hierarchies. 
 * Composite lets clients treat individual objects and compositions of objects uniformly.
 * "knots and leaves are both components"
 */

interface Component {
	void print();
}

class Leaf implements Component {
	@Override
	public void print() {
		System.out.println(this);
	}
}

class Composite implements Component {
	private List<Component> children = new ArrayList<>();


	public void add(Component component) {
		children.add(component);
	}

	public void remove(Component component) {
		children.remove(component);
	}

	@Override
	public void print() {
		for (int i = 0; i < children.size(); i++)
			children.get(i).print();
	}
}

/** main **/
public class CompositeDemo {
	public static void main(String[] args) {

		new Leaf().print();

		Composite comp = new Composite();
		comp.add(new Leaf());
		comp.add(new Leaf());
		comp.print();
	}
}
