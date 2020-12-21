package com.olexyn.about.java;

import java.util.Optional;

/**
 * Hello world!
 *
 */
public class Optionals
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Optional<String> empty = Optional.empty();
        boolean foo = empty.isPresent();

        Optional<String> full = Optional.of("bar");
        boolean bar = full.isPresent();

        Optional<String> nulled  = Optional.ofNullable(null);
        boolean baz = nulled.isPresent();

        int br = 0;
    }
}
