package principles.examples.level4;



public class Main {

    public static void main(String... args) {
        Consumer consumer = new ConsumerImpl();
        System.out.println(consumer.consume());
    }

}
