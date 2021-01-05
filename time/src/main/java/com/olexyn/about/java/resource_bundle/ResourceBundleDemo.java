package com.olexyn.about.java.resource_bundle;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

public class ResourceBundleDemo {

    public static void main(String[] args) {
        Locale default_locale = Locale.getDefault(); // en_US on my system
        Locale us = new Locale("en", "US");
        Locale france = new Locale("fr", "FR");
        printProperties(us);
        System.out.println();
        printProperties(france);
        propertiesClassDemo(france);

        ResourceBundle rb_foo = ResourceBundle.getBundle("Hello"); // gets default bundle
        ResourceBundle rb = ResourceBundle.getBundle("com.olexyn.about.java.resource_bundle.Hello", Locale.US);
        System.out.println(rb.getObject("hello"));
        // the following code can't resolve Hello to Hello_en_US.java,
        // uses Hello_en.properties instead.
        rb = ResourceBundle.getBundle("Hello", Locale.US);
        System.out.println(rb.getObject("hello"));

        mixerDemo();

        // Variables inside RB
        ResourceBundle rb2 = ResourceBundle.getBundle("Hello", Locale.US);
        String format = rb2.getString("hello4"); // foo {0} is {1}
        String formatted = MessageFormat.format(format, "baz", "kaz"); // foo bar is kaz
    }

    public static void printProperties(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("Hello", locale);
        System.out.println(rb.getString("hello"));

        Set<String> keys = rb.keySet();
        keys.stream().map(k -> k + " " + rb.getString(k));
    }

    /**
     * @param locale
     */
    static void propertiesClassDemo(Locale locale) {

        ResourceBundle rb = ResourceBundle.getBundle("Hello", locale);
        Properties properties = new Properties();

        rb.keySet().forEach(k -> properties.put(k, rb.getString(k)));
        String foo;
        try {
            foo = properties.get("foo").toString(); // inherited -> NullpointerException
        } catch (NullPointerException ignored) {}

        foo = properties.getProperty("foo"); // null
        foo = properties.getProperty("foo", "default"); // "default"
    }

    /**
     * Java tries to find the matching properties by traversing the hierarchy
     */
    static void mixerDemo() {
        Locale locale = Locale.US;
        ResourceBundle rb = ResourceBundle.getBundle("Mixer", locale);
        String out = rb.getString("A") + " " + rb.getString("B") + " " + rb.getString("C");
        System.out.println(out);
    }
}
