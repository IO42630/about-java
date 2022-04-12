package com.olexyn.about.java.design.patterns.creational.prototype;

public interface Prototype<T> {

    T copy() throws CloneNotSupportedException;

}
