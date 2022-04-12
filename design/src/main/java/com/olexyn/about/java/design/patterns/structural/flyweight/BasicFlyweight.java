package com.olexyn.about.java.design.patterns.structural.flyweight;

interface LargeField { }

class HeavyObject {

    Integer smallField;
    LargeField largeField;

}

/**
 * Variant 1 : reference by inheritance.
 */
class Flyweight extends HeavyObject {

    Flyweight(Integer smallField, HeavyObject particle) {
        this.smallField = smallField;
        this.largeField = particle.largeField;
    }

}

/**
 * Variant 2 : reference by field.
 */
class FlyweightAlt  {

    Integer smallField;
    HeavyObject heavyObject;

    FlyweightAlt(Integer smallField, HeavyObject heavyObject) {
        this.smallField = smallField;
        this.heavyObject = heavyObject;
    }

}


public class BasicFlyweight {

    public static void main(String... args){
        var heavyObject = new HeavyObject();
        var flyweight = new Flyweight(0, heavyObject);
        var flyweightAlt = new FlyweightAlt(0, heavyObject);

        var is1 = heavyObject.largeField == flyweight.largeField; // true
        var is2 = heavyObject.largeField == flyweightAlt.heavyObject.largeField; // true

    }

}