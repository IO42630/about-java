package design_patterns.behavioural;

/*
 * Visitor. 
 * Represent an operation to be performed on the elements of an object structure. 
 * Visitor lets you define a new operation 
 * without changing the classes of the elements on which it operates.
 */

class Element {
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public void print(){
		System.out.println(this);
	}
}

class Visitor{
	public void visit(Element e) {
		e.print();
	}
}

// MAIN	- - - - - -
public class VisitorDemo {
	public static void main(String[] args) {
		new Element().accept(new Visitor());
	}
}