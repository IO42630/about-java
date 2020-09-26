package jar.src.yes_main;

import jar.src.no_main.ClassInJar;


public class Main {
    public Main() {
    }

    public static void main(String[] var0) {


        System.out.println("Main says Hi!");
        new Helper().hi();
        new ClassInJar().hi();

    }
}
