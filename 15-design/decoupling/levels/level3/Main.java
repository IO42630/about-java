package decoupling.levels.level3;

public class Main {

    public static void main(String... args) {
        Consumer consumer = new Consumer();
        System.out.println(consumer.consume());
    }

}
