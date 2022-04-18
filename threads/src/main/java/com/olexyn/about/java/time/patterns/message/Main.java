package com.olexyn.about.java.time.patterns.message;

import java.time.Duration;

/**
 * Example of "sending a message" <br>
 * _ A creates Message, releases monitor (of Message), waits to get monitor back. <br>
 * _ B locks monitor, releases it. <br>
 * _ A locks monitor (gets it back).
 */
public class Main {

    public static void main(String... args) {
        var medium = new Medium();
        var consumer = new Consumer("CONSUMER", medium);
        var producer = new Producer("PRODUCER", medium);

        consumer.start("CONSUMER", Duration.ofSeconds(10));
        producer.start("PRODUCER", 3);
    }
}
