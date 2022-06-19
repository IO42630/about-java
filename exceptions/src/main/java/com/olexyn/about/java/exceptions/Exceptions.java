package com.olexyn.about.java.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Exceptions {// exception "e"

    /*
     *          main
     *          |
     *          v
     *          method with exception handler (catches some e)
     *          |                                                   ^ looks for handler
     *          v                                                   |
     *          method without handler (forwards e)
     *          |                                                   ^ looks for handler
     *          v                                                   |
     *          method with error (thorws e)-------------------------
     *
     */


    private static final int SIZE = 10;
    private static List<Integer> list = new ArrayList<>(SIZE);
    private static PrintWriter writer = null;


    public static void main(String[] args) throws Exception { // `throws` is allowed in `main`

        //multipleThrow();

        //handleCheckedE();

        handleDeclaredE();


        if (true) {
            throw new Exception();
        } else {
            throw new Error();
        }
    }


    static void handleDeclaredE() {

        try {
            declareUncheckedE();
        } catch (IndexOutOfBoundsException e ) {// runtime exception
            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
        } finally {// "cleanup", always executes
            if (writer != null) {
                writer.close();
            }
        }


        try {
            manuallyThrowUE();
        } catch (IndexOutOfBoundsException | NullPointerException e ) {// multi-catch block
            System.out.print("foo");
        }


    }



    static void declareUncheckedE() throws IndexOutOfBoundsException {// throws optional, since UE.

        if (SIZE < 0) { // possible to manually trow
            throw new IndexOutOfBoundsException();
            // int i =0; // cErr : unreachable
        }
        list.get(SIZE); // natural throw
        int i = 0;      // Code after Exception is not executed.
    }


    /**
     * Example of how a Checked Exception would be handled.
     */
    static void handleCE() {
        try {
            writer = new PrintWriter(new FileWriter("OutFile.txt"));
            System.out.println("All OK.");
        } catch (IOException e) { // the 3 ways to print an Exception
            System.out.println(e);
            System.err.println("Caught IOException: " + e.getMessage());
            e.printStackTrace();
        }

        try{

        }catch (NullPointerException e){}


    }





    /**
     * Exceptions may be thrown manually
     */
    static void manuallyThrowUE() { throw new NullPointerException();}


    static void tryWithResource() {

        try (var a1 = new CanBeClosed(); var a2 = new CanBeClosed()) {// ; after last declaration is optional
            // try with only guarantees the .close(); will be called.
        }


    }


    /**
     * OUTPUT:
     * this is a
     * this is b
     * this is c
     * Exception in thread "main" java.lang.RuntimeException: c
     */
    static void multipleThrow() {
        try {
            System.out.println("this is a");
            throw new RuntimeException("a");
        } catch (RuntimeException e) {
            System.out.println("this is b");
            throw new RuntimeException("b");
            // System.out.println("this is b"); // unreachable statement
        } finally {
            System.out.println("this is c");
            throw new RuntimeException("c");
        }
    }


    static void errors() {

        try { } catch (NullPointerException e) { }
        // try {} catch (IOException e) {} // cErr : unable to throw cE
        // try {} catch (RuntimeException e) {} catch (NullPointerException e) {} // cErr : Exception already caught by super
    }

}

class CanBeClosed implements AutoCloseable {

    @Override
    public void close() throws NullPointerException { // uE
        // do something
    }
}





class Helpers{
    static void declareCheckedE() throws IOException { }
}


class Finally{

    public static void main(String... args){

        int i = new Finally().goHome();
        int br = 0;
    }


    int goHome() {
        try {

            System.out.print("1");
            // Optionally throw an exception here
            return -1;
        } catch (Exception e) {
            System.out.print("2");
            return -2;
        } finally {
            System.out.print("3");
            return -3;
        }
    }


    void neverFinally(){

    }
}















