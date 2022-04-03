package com.olexyn.about.java.testing;

import java.util.List;

public class ToBeTested {






    public int increment(int i){
        return ++i;
    }


    public Integer sum(List<Integer> list){
        int integer = 0;
        for (int i : list){
            integer = integer + i;

        }
        return integer;
    }

}
