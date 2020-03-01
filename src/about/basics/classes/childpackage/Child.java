package about.basics.classes.childpackage;

import about.basics.classes.parentpackage.Parent;

// Child - - - - - - - - - - - - - - - - - -
public class Child extends Parent {

    int n;

    public Child() {
        this(23);
        int n = 0;
        this.n = n;
        this.show();
        super.show();

    }

    public Child(int n) {
        super(n);
        this.n = n;


    }

    @Override
    public void show() {

        super.show();
    }

    void protectedTest(){
        int i = protectedInteger;
        i = new Child().protectedInteger;
        //i = new Parent().protectedInteger; // C-Error


    }


}