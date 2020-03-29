package classes.polymorphism;

public class BadCasting {

    public static void main() {
        BCInterface bca = new BCA();
        if (bca instanceof BCB) { BCInterface bcb = (BCB) bca;} // ClassCastException (at runtime)


    }


}


interface BCInterface {}

class BCA implements BCInterface {}

class BCB implements BCInterface {}
