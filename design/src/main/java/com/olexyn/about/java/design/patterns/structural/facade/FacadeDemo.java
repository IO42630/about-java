package com.olexyn.about.java.design.patterns.structural.facade;

interface Window {
    void open();
}

interface Engine {
    void start();
}

class SomeWindow implements Window {
    @Override
    public void open() { /* OPEN */ }
}

class SomeEngine implements Engine {
    @Override
    public void start() { /* START */ }
}

interface CarFacade {
    void open();
    void start();
}

class SomeCarFacade implements CarFacade {
    private final Window window;
    private final Engine engine;
    SomeCarFacade(Window window, Engine engine) {
        this.window = window;
        this.engine = engine;
    }

    @Override
    public void open() { window.open(); }

    @Override
    public void start() { engine.start(); }
}

/**
 * <b>Facade</b><br>
 * Single point of contact for a set of sub-interfaces.
 */
public class FacadeDemo {

    public static void main(String... args){
        CarFacade carFacade = new SomeCarFacade(new SomeWindow(), new SomeEngine());
        carFacade.open();
        carFacade.start();
    }
}




