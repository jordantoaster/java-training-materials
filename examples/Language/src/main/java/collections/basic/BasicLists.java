package collections.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BasicLists {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("ab");
        list.add("cd");
        list.add("ef");
        list.add("gh");
        list.add("ij");
        list.add("kl");
        list.add("mn");

        listContents(list);

        List<String> extra = new LinkedList<String>();
        extra.add("op");
        extra.add("qr");
        extra.add("st");
        extra.add("uv");
        extra.add("wx");
        extra.add("yz");

        list.addAll(extra);

        listContents(list);

        list.remove("ab");
        list.removeAll(extra);
        listContents(list);

        list.add("cd");
        listContents(list);
    }

    private static void listContents(List<String> list) {
        System.out.println("\nFirst item is: " + list.get(0));
        System.out.println("Last item is: " + list.get(list.size() - 1));
        ListIterator<String> iter = list.listIterator();
        System.out.println("\nContents Going forwards:");
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println("\nContents Going backwards:");
        while (iter.hasPrevious()) {
            System.out.println(iter.previous());
        }
    }
}
