package about.basics.classes.childpackage;

import about.basics.classes.parentpackage.Parent;


public class Child extends Parent {

    public int instanceVar =0;
    private int n;
    public static int classVar;

    public Child() {
        this(0);
        int n = 1;
        this.n = n;
        classVar =1;


    }

    public Child(int n) {
        super(n);
        this.n = n;


    }

    @Override
    public String toString() {
        return "Child";
    }

    public static String staticMethod(){return "Child";};

    void protectedTest(){
        int i = protectedInteger;
        i = new Child().protectedInteger;
        //i = new Parent().protectedInteger; // C-Error


    }


}