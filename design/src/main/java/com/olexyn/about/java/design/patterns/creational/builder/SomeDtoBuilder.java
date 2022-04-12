package com.olexyn.about.java.design.patterns.creational.builder;

import com.olexyn.about.java.design.standards.SomeDto;

/*
 * Builder.
 * Separate the construction of a complex object from its representation
 * so that the same construction process can create different representations.
 */
public class SomeDtoBuilder implements Builder<SomeDto> {

    private SomeDto someDto;

    public SomeDtoBuilder() {
        reset();
    }

    @Override
    public SomeDtoBuilder reset() {
        someDto = new SomeDto();
        return this;
    }

    public SomeDtoBuilder setS1(String s1) {
        someDto.setS1(s1);
        return this;
    }

    public SomeDtoBuilder setS2(String s2) {
        someDto.setS2(s2);
        return this;
    }

    @Override
    public SomeDto build() {
        return someDto;
    }


    public static void main(String... args) {
        var someDto = new SomeDtoBuilder().setS1("S1").setS2("S2").build();
    }

}
