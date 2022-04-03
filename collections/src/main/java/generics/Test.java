package generics;


import java.util.List;

public interface Test{}



class Bar<E extends Parent > {}




class Parent{}

class Child extends Parent{




    void bar(List<? extends List> list){}
}
