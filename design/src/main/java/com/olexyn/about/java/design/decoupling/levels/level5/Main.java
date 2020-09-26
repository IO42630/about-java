package decoupling.levels.level5;


public class Main {

    public static void main(String... args) {
        Consumer consumer = new ConsumerImpl();
        System.out.println(consumer.consume());
    }

}
