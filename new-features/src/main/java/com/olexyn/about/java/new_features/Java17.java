package com.olexyn.about.java.new_features;


public class Java17 {

    void jepXX(){
        Object o = "a";
//        if( o instanceof String str) {
//            str.toLowerCase();
//        }
        // str scoped inside the block

    }


    void jepXZ(){
//        final StringWrapper o = new StringWrapper();
//        String s = "";
//        switch (s) {
//            case String x && s.length() > 0 && !(s.contains("#") || s.contains("@")) -> Double.parseDouble(s);
//            default -> { }
//        };

    }

    class  StringWrapper {
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }





}
