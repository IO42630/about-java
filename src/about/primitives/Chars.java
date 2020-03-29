package primitives;

public class Chars {



    public static void main(String[] args) {
        promotion();

        char foo = 83; // OK
        // char bar = -1; // DOES NOT COMPILE

    }






    static void promotion() {




        var test = 'c' + 12; // char is promoted to int with resulting value 111

    }
}
