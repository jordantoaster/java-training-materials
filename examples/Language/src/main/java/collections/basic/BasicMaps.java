package collections.basic;

import java.util.*;

public class BasicMaps {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Kill Bill", "Tarantino");
        map.put("Resevoir Dogs", "Tarantino");
        map.put("Pulp Fiction", "Tarantino");
        map.put("Mission Impossible II", "Ang Lee");
        map.put("Sense and Sensability", "Ang Lee");
        map.put("Star Wars", "George Lucas");
        map.put("Return of the Jedi", "George Lucas");

        printKeys(map);
        printValues(map);
        printContents(map);

        map.put("Return of the Jedi", "Dave Gorman");

        printContents(map);

        map.remove("Kill Bill");

        printContents(map);
    }

    private static void printKeys(Map<String, String> map) {
        Set<String> keys = map.keySet();
        System.out.println("\nKeys are:");
        Iterator<String> iter = keys.iterator();
        while (iter.hasNext()) {
            System.out.println("\t" + iter.next());
        }
    }

    private static void printValues(Map<String, String> map) {
        Collection<String> values = map.values();
        System.out.println("\nValues are:");
        Iterator<String> iter = values.iterator();
        while (iter.hasNext()) {
            System.out.println("\t" + iter.next());
        }
    }

    private static void printContents(Map<String, String> map) {
        Set<Map.Entry<String, String>> entries = map.entrySet();
        System.out.println("\nMap Contents are:");
        Iterator<Map.Entry<String, String>> iter = entries.iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            System.out.println("\t" + entry.getKey() + " indexes " + entry.getValue());
        }
    }
}
