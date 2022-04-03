package collections;

import java.util.Collection;
import java.util.Iterator;

public class ToDo {

    public static void editList(Collection<String> l1, Collection<String> l2) {
        //goes through list
        Iterator<String> it = l1.iterator();
        while (it.hasNext()) {
            if (l2.contains(it.next())) {
                it.remove();
            }
        }
    }
}
