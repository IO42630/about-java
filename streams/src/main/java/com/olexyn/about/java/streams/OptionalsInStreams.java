package com.olexyn.about.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalsInStreams {

    public static void main(String... args) throws Exception {

        List<SomeBean> beanList = new ArrayList<>();
        beanList.add(new SomeBean("X1", "Y1"));
        beanList.add(new SomeBean("X2", null));
        beanList.add(new SomeBean(null, "Y3"));

        List<SomeBean> emptyBeanList = new ArrayList<>();

        // what i want to do
        // check if steam empty
        // if yes -> do nothing
        // if no -> get
        emptyBeanList.stream().findFirst().orElseThrow();
        // SomeBean bean = emptyBeanList.stream().findFirst().get();

        beanList.stream().findFirst().orElseThrow(() -> new Exception());

    }


}










class SomeBean{
    String x;
    String y;

    SomeBean(String x, String y){
        setX(x);
        setY(y);
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }
}
