package com.olexyn.about.java.design.patterns.creational.prototype;

import com.olexyn.about.java.design.standards.SomeDto;

/**
 * <b>Prototype</b><br>
 * Move the "copy" logic to the object being copied.<br>
 * This also allows to copy protected fields, which can/should only be accessed from the object.
 */
public class SomePrototype extends SomeDto implements Prototype<SomeDto> {

    @Override
    public SomeDto copy() {
        var clone = new SomeDto();
        clone.setS1(s1);
        clone.setS2(s2);
        return clone;
    }

    public static void main(String... args) {
        var prototype = new SomePrototype();
        prototype.setS1("S1");
        var clone = prototype.copy();
    }

}
