package com.olexyn.about.java.spring.boot.controller.model;

import java.util.Objects;

public class FruitDto {

    private Long pk;
    private String name;
    private String color;

    public Long getPk() {
        return pk;
    }

    public FruitDto setPk(Long pk) {
        this.pk = pk;
        return this;
    }

    public String getName() {
        return name;
    }

    public FruitDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getColor() {
        return color;
    }

    public FruitDto setColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        FruitDto fruitDto = (FruitDto) o;
        return pk.equals(fruitDto.pk) && name.equals(fruitDto.name) && color.equals(fruitDto.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, name, color);
    }

}
