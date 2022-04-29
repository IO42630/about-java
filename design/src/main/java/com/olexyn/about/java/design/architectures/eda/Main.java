package com.olexyn.about.java.design.architectures.eda;

public class Main {

    public static void main(String... args){
        var router = new SomeRouter();

        var consumer1 = new SomeConsumer("Consumer 1");
        var consumer2 = new SomeConsumer("Consumer 2");

        router.register(consumer1);
        router.register(consumer2);

        var producer = new SomeProducer(router);

        router.start("ROUTER_THREAD");
        consumer1.start("CONSUMER_1_THREAD");
        consumer2.start("CONSUMER_2_THREAD");

        producer.start("PRODUCER_THREAD");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e ) {

        }
        producer.stop();
        consumer1.stop();
        consumer2.stop();
        router.stop();



    }
}
