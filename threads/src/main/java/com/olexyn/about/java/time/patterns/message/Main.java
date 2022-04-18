package com.olexyn.about.java.time.patterns.message;

import java.time.Duration;

public class Main {

    public static void main(String... args) {
        var medium = new Medium();
        var consumer = new Consumer(medium);
        var producer = new Producer(medium);

        consumer.start("CONSUMER", Duration.ofSeconds(10));
        producer.start("PRODUCER", 3);
    }
}
