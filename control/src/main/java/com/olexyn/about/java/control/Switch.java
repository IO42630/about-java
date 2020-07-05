package com.olexyn.about.java.control;

import java.util.Random;

public class Switch {



    public Switch(){

    }

    int set(){
        return 1;
    }


    static void switchTest() {


        final int one;
        one = 1; // must be declared & initialized on the same line
        final int two = 2; // must be final
        final int rng = new Random().nextInt();

        for (int i = 0; i < 4; i++) {

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

            System.out.println("-------");
        }


    }

    static void switchEnum(){



    }




    public static void main(String... args){

        Caps c = null;
        c = Caps.A;


        switch (c){
            case A:
                System.out.println("f");
                break;
            case C:
                break;
        }

    }

    enum Caps{A,B,C,D}
}
