package about;

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
     *
     *
     * Checked Exception == MANDATORY handle or declare
     *      > handle == try/catch
     *      > declare == throw
     *
     *
     * Unchecked Exception == OPTIONAL treatment
     * |-- (a)"Error" = external i.e. hardware malfunction (java.io.IOError)
     * |-- (b)"RuntimeException" = bugs
     *
     *
     * Some 'RuntimeException' :
     * - ArithmeticException
     * - IllegalArgumentException
     * - IndexOutOfBoundsException
     * - NullPointerException
     */


    private static final int SIZE = 10;
    private static List<Integer> list = new ArrayList<>(SIZE);
    private static PrintWriter writer = null;


    public static void main(String[] args) throws Exception { // `throws` is allowed in `main`

        //multipleThrow();

        //handleCheckedE();

        handleDeclaredE();



        System.out.println("All OK.");
        if (true){
            throw new Exception();
        }else{
            throw new Error();
        }
    }


    static void handleDeclaredE() {

        try {
            declareUncheckedE();
        } catch (IndexOutOfBoundsException e) {// runtime exception
            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
        } finally {// "cleanup", always executes
            if (writer != null) {
                writer.close();
            }
        }


        try {
            manuallyThrowE();
        } catch (IndexOutOfBoundsException | NullPointerException e){// multi-catch block
            System.out.print("foo");
        }





    }


    /**
     * This syntax is called "declaring an exception".<p>
     *
     * @throws IndexOutOfBoundsException
     */
    static void declareUncheckedE() throws IndexOutOfBoundsException {// throws optional, since UE.

        if (SIZE < 0) { // possible to manually trow
            throw new IndexOutOfBoundsException();
        }

        list.get(SIZE);
        int i = 0; // Code after Exception is not executed.
    }


    /**
     * Example of how a Checked Exception would be handled.
     */
    static void handleCheckedE() {
        try {
            writer = new PrintWriter(new FileWriter("OutFile.txt"));
            System.out.println("All OK.");
        } catch (IOException e) { // the 3 ways to print an Exception
            System.out.println(e);
            System.err.println("Caught IOException: " + e.getMessage());
            e.printStackTrace();
        }
    }


    static void declareCheckedE() throws IOException {


    }


    /**
     * Exceptions may be thrown manually
     */
    static void manuallyThrowE() {
        if (true) {
            throw new NullPointerException();
        } else {
            throw new NullPointerException("foo");
        }
    }




    static void tryWithResource(){

        try(var a1 = new CanBeClosed(); var a2 = new CanBeClosed()){// ; after last declaration is optional
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
    static void multipleThrow(){
        try {
            System.out.println("this is a");
            throw new RuntimeException("a");
        }catch (RuntimeException e){
            System.out.println("this is b");
            throw new RuntimeException("b");
            // System.out.println("this is b"); // unreachable statement
        }finally {
            System.out.println("this is c");
            throw new RuntimeException("c");
        }
    }


    static void unreachableException(){ // Compile-time error
        //try{
        //    int i = 1;
        //}catch (IOException e){
        //
        //}
    }

}

class CanBeClosed implements AutoCloseable {

    @Override
    public void close() throws NullPointerException { // uE
        // do something
    }
}
























