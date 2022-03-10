package collections.basic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class BasicSets {

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("ab");
        set.add("cd");
        set.add("ef");
        set.add("gh");
        set.add("ij");
        set.add("kl");
        set.add("mn");

        listContents(set);

        Set<String> extra = new TreeSet<String>();
        extra.add("op");
        extra.add("qr");
        extra.add("st");
        extra.add("uv");
        extra.add("wx");
        extra.add("yz");

        set.addAll(extra);

        listContents(set);

        set.remove("ab");
        set.removeAll(extra);
        listContents(set);

        if (!set.add("cd")) {
            System.out.println("\nString cd already in set");
        }
    }

    private static void listContents(Set<String> set) {
        System.out.println("\nSize is: " + set.size());
        Iterator<String> iter = set.iterator();
        System.out.println("\nContents Are:");
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
