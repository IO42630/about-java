package com.olexyn.about.java.design.patterns.behavioural;

/*
 * The visitor-pattern outsources logic from an Element to a Visitor.
 * Thus the visitor-patterns defines a new operation on the Element, without changing the Element.
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


public class VisitorDemo {
	public static void main(String[] args) {
		new Element().accept(new Visitor());
	}
}
