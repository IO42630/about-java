package com.olexyn.about.java.control;

import java.util.Random;

public class Switch {

    public static void main(String... args){
        switchTest();
        switchEnumTest();
    }

    static void switchTest() {

        final int one;
        one = 1; // must be declared & initialized on the same line
        final int two = 2; // must be final
        final int rng = new Random().nextInt();
        int i23 = 1;
        final int hidden_func = ++i23;
        final int not_func = 1 + 4;

        for (int i = 0; i < 4; i++) {
            System.out.println("this is i = "+ i);
            switch (i) {
                case 0:
                    System.out.println(0);
                    // break; => without it case 1 is executed too
                case 1:
                    System.out.println(1);
                default:
                    System.out.println("default");
                case two:
                    System.out.println(2);
            }
        }
    }

    enum Caps{A,B}

    static void switchEnumTest(){
        switch (Caps.A){
            case A:
                System.out.println("A");
                break;
            case B:
                break;
        }
    }
}
