package com.olexyn.about.java.io;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.Locale;

public class UserIO {

    public static void main(String[] args) throws IOException {

    }



    static void oldWay() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = reader.readLine();
        System.out.println("You entered the following: " + userInput);
    }

    static void newWay() {

            Console console = System.console();
            if(console != null) {
                String userInput = console.readLine();
                console.writer().println ("You entered the following: "+userInput);
            }

            System.out.format("asf");

    }



    static void differentFormatMethods() {
        System.out.format("foo"); //calls from PrintStream.format()
        System.out.format(Locale.US, "foo");
        NumberFormat.getInstance(Locale.US).format(3); // different

        System.console().writer().format("foo"); // still calls from PrintStream.format()
        System.console().format("foo"); // locale is auto fetched, not overload available, must be set in other command
    }


    static void consoleDemo() {
        System.console().flush();
    }
}
