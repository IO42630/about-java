package com.olexyn.about.java.exceptions;

public class SuppressedExceptions {

    public static void main(String[] args) {

        try (SomeResource resource = new SomeResource()) {

        }catch (IllegalStateException e){
            // TODO

        }




    }


}

class SomeResource implements AutoCloseable{

    @Override
    public void close() throws IllegalStateException {
        throw new IllegalStateException("can't close");
    }
}
