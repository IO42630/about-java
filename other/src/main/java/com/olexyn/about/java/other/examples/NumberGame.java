package examples;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int r = random.nextInt(99) + 1;
        int g = 0;

        for (; r != g; ) {
            System.out.print("guess: ");
            g = scanner.nextInt();
            if (r - g == 0) {
                System.out.format("gg");
            } else if (r - g <= 2) {
                System.out.format("boom, new number, now ");
                r = random.nextInt(99) + 1;
            } else if (r - g <= 10) {
                System.out.format("hot \n");
            } else if (r - g <= 50) {
                System.out.format("warm \n");
            } else {
                System.out.format("cold \n");
            }
        }

    }
}
