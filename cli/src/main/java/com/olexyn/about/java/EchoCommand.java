package com.olexyn.about.java;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "echo", mixinStandardHelpOptions = true, version = "1.0",
    description = "Prints, converts to uppercase or converts to lowercase the specified input, or sets or gets a system property.")
public class EchoCommand implements Runnable {

    @Parameters(description = "The input to be echoed, converted to uppercase or converted to lowercase.")
    private String input;

    @Command(name = "upper", description = "Converts the input to uppercase.")
    public void toUppercase() {
        System.out.println(input.toUpperCase());
    }

    @Command(name = "lower", description = "Converts the input to lowercase.")
    public void toLowercase() {
        System.out.println(input.toLowerCase());
    }

    @Command(name = "get", description = "Gets the value of a system property.")
    public void getProperty(@Option(names = {"-p", "--property"}, required = true, description = "The name of the system property.") String propertyName) {
        String propertyValue = System.getProperty(propertyName);
        if (propertyValue != null) {
            System.out.println(propertyValue);
        } else {
            System.out.println("System property not found: " + propertyName);
        }
    }

    @Command(name = "set", description = "Sets the value of a system property.")
    public void setProperty(@Option(names = {"-p", "--property"}, required = true, description = "The name of the system property.") String propertyName,
        @Option(names = {"-v", "--value"}, required = true, description = "The value to set the system property to.") String propertyValue) {
        System.setProperty(propertyName, propertyValue);
        System.out.println("System property set: " + propertyName + " = " + propertyValue);
    }

    public static void main(String[] args) {
        new CommandLine(new EchoCommand()).execute(args);
    }

    @Override
    public void run() {
        System.out.println(input);
    }
}
