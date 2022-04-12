package com.olexyn.about.java.design.patterns.creational.builder;

public interface Builder<T> {

    Builder<T> reset();

    T build();

}
