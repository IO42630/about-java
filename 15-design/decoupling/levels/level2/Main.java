package decoupling.levels.level2;

public class Main {

    public static void main(String... args) {
        Consumer consumer = new Consumer();
        System.out.println(consumer.consume());
    }

}
