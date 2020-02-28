package intermediate;

import java.util.*;

public class Collections {

    public static void main(String[] args) {

        String[] things = {"eggs", "lasers", "hats", "pie", "bacon"};
        String[] morethings = {"lasers", "hats"};

        List<String> list1 = makeList(things);
        List<String> list2 = makeList(morethings);

        printList(list1);

        editList(list1, list2);

        printList(list1);
        
        //6,7
        
        LinkedList<String> llist1 = makeLList(things);
        LinkedList<String> llist2 = makeLList(morethings);
        
        llist1.addAll(llist2);
        llist2=null;
        
        //printMe(llist2);
        //removeStuff(llist1,2,5);
        //printMe(llist1);
        //reverseMe(llist1);

    }

    public static void printList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s ", list.get(i));
        }
        System.out.println();
    }

    public static List<String> makeList(String[] t) {
        List<String> list = new ArrayList<>();
        for (String i : t) {
            list.add(i);
        }
        return list;
    }

    public static LinkedList<String> makeLList(String[] t) {
        LinkedList<String> llist = new LinkedList<>();
        for (String i : t) {
            llist.add(i);
        }
        return llist;
    }

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
