package com.olexyn.about.java.new_features;

import java.util.Objects;

/**
 * <b>Records</b>
 * Private final fields for age, name, and team.
 * Canonical constructors for all fields.
 * Getters for all fields.
 * equals, hashCode, and toString for all fields.
 */
public record Java16(String s1, String s2) {

    // Explicit canonical constructor
    public Java16 {
        //Custom validation
        if (Objects.equals(s1, ""))
            throw new IllegalArgumentException("Age less than 1 is not allowed!");
        //Custom modifications
    }

    //Explicit accessor
    @Override
    public String s1() {
        return this.s1;
    }


    public static void main(String... args){
        var java16 = new Java16("s1", "s2");
        var foo = new Java16(null, null); // can pass null

        java16.s1();


    }



}
