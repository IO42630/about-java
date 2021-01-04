package com.olexyn.about.java.resource_bundle;

import java.util.ListResourceBundle;

public class Hello_en_US extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"hello", "Hello from Hello_en_US.java"},
            {"world", "World."}
        };
    }
}
