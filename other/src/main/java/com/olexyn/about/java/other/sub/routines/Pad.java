import java.util.ArrayList;
import java.util.List;

public class Pad {

    Integer c = 15;
    Integer d = 10;

    public static void addToInt(int x,
                                int amountToAdd) {
        x = x + amountToAdd;
    }



    public void add (Integer x, Integer b){
        x = x+ b;
    }



    public void foo (List<String> list){
        list.add("foo");
    }

    public void barlow (String bar){
        bar = bar + "llll";
    }


    public static void main(String[] args) {
        var a = 15;
        var b = 10;
        Pad.addToInt(a, b);
        System.out.println(a);

        Pad pad = new Pad();
        pad.add(pad.c,pad.d);
        System.out.println(pad.c);



        String bar = "bar";
        pad.barlow(bar);
        System.out.println(bar);



        List<String> list = new ArrayList<>();
        System.out.println(list.toString());
        pad.foo(list);
        System.out.println(list.toString());

    }
}
