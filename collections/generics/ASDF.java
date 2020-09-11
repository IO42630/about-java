package generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ASDF {


    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        List<?> objectList = stringList;

        String[] strings = {"ff"};
        Object[] objects = strings;
    }
}
