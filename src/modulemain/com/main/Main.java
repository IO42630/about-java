package com.main;

import com.transit.Transit;

public class Main {

    public void mainSaysHi(){
        System.out.println("Main says Hi!");
    }



    public static void main(String[] args){
        new Main().mainSaysHi();
        new Transit().transitSaysHi();

    }
}
